package views;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import viewmodels.AnniversaryView;
import viewmodels.PlaceView;

import java.util.List;
import java.util.stream.Collectors;

public class AnniversaryListController {

    // The TableView for displaying the list of anniversaries in the UI
    @FXML
    private TableView<AnniversaryView> anniversaryTable;

    // Columns for the table
    @FXML
    private TableColumn<AnniversaryView, String> idColumn;
    @FXML
    private TableColumn<AnniversaryView, String> modernGiftColumn;
    @FXML
    private TableColumn<AnniversaryView, String> tradGiftColumn;
    @FXML
    private TableColumn<AnniversaryView, String> placesColumn;

    // ObservableList that holds the data to be displayed in the table
    private ObservableList<AnniversaryView> anniversaryData = FXCollections.observableArrayList();

    // This method is automatically called by JavaFX when the view is initialized
    public void initialize() {
        // Set cell value factories to specify how each column gets its data from AnniversaryView
        idColumn.setCellValueFactory(cellData -> cellData.getValue().getId());
        modernGiftColumn.setCellValueFactory(cellData -> cellData.getValue().getModernGift());
        tradGiftColumn.setCellValueFactory(cellData -> cellData.getValue().getTradGift());

        // For the placesColumn, format the places into a string like "Place Name (Country)"
        placesColumn.setCellValueFactory(cellData -> {
            List<PlaceView> places = cellData.getValue().getPlacesVisited();
            String joined = places.stream()
                    .map(p -> p.getPlaceName().get() + " (" + p.getCountry().get() + ")") // Format each place
                    .collect(Collectors.joining(", ")); // Join them with commas
            return new SimpleStringProperty(joined); // Return the formatted string
        });

        // Set the ObservableList as the data source for the table
        anniversaryTable.setItems(anniversaryData);
    }

    // This method is used to update the table with a list of AnniversaryView objects
    public void setAnniversaries(List<AnniversaryView> anniversaryViews) {
        // Update the observable list with the provided data
        anniversaryData.setAll(anniversaryViews);
    }
}
