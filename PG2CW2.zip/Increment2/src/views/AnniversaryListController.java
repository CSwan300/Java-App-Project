package views;

import controllers.Controller;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import viewmodels.AnniversaryView;
import viewmodels.PlaceView;

import java.util.List;
import java.util.stream.Collectors;

public class AnniversaryListController {

    // FXML-injected TableView to display a list of AnniversaryView objects
    @FXML
    private TableView<AnniversaryView> anniversaryTable;

    // FXML-injected TableColumn for anniversary ID
    @FXML
    private TableColumn<AnniversaryView, String> idColumn;

    // FXML-injected TableColumn for modern gift
    @FXML
    private TableColumn<AnniversaryView, String> modernGiftColumn;

    // FXML-injected TableColumn for traditional gift
    @FXML
    private TableColumn<AnniversaryView, String> tradGiftColumn;

    // FXML-injected TableColumn for listing visited places
    @FXML
    private TableColumn<AnniversaryView, String> placesColumn;

    // Reference to the main controller (injected by main application)
    private Controller mainController;

    // Allows main controller to be set from outside (typically during loading)
    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }

    // Button handler method for adding a new anniversary
    @FXML
    private void handleAddAnniversary() {
        // Delegate to main controller to show the add anniversary form
        mainController.showAddAnniversaryForm();
    }

    // Button handler method for adding a place visited
    @FXML
    private void handleAddPlaceVisited() {
        // Delegate to main controller to show the add place form
        mainController.showAddPlaceVisitedForm();
    }

    // List that backs the TableView
    private ObservableList<AnniversaryView> anniversaryData = FXCollections.observableArrayList();

    // Called automatically after FXML is loaded
    public void initialize() {
        // Bind each column to the corresponding property in AnniversaryView
        idColumn.setCellValueFactory(cellData -> cellData.getValue().getId());
        modernGiftColumn.setCellValueFactory(cellData -> cellData.getValue().getModernGift());
        tradGiftColumn.setCellValueFactory(cellData -> cellData.getValue().getTradGift());

        // Custom binding for placesColumn:
        // Convert a list of PlaceView into a single string with place and country
        placesColumn.setCellValueFactory(cellData -> {
            List<PlaceView> places = cellData.getValue().getPlacesVisited();
            String joined = places.stream()
                    .map(p -> p.getPlaceName().get() + " (" + p.getCountry().get() + ")")
                    .collect(Collectors.joining(", "));
            return new SimpleStringProperty(joined);
        });

        // Set the data to the TableView
        anniversaryTable.setItems(anniversaryData);
    }

    // Method to populate the table with a list of AnniversaryView objects
    public void setAnniversaries(List<AnniversaryView> anniversaryViews) {
        anniversaryData.setAll(anniversaryViews);
    }
}
