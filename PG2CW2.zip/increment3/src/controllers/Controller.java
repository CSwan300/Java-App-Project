package controllers;

import app.AnniversariesApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Anniversary;
import model.Place;
import repositories.Repository;
import viewmodels.AnniversaryView;
import views.AddAnniversaryController;
import views.AddPlaceController;
import views.AnniversaryListController;
import views.RootLayoutController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private Stage primaryStage;         // Main application window
    private BorderPane rootLayout;     // Root layout for the application UI

    // Constructor that takes the primary stage from the application
    public Controller(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    // Initializes and displays the root layout of the application
    public void initRootLayout() {
        try {
            // Load RootLayout.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AnniversariesApp.class.getResource("/views/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Set the scene on the primary stage
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Pass this controller to RootLayoutController
            RootLayoutController rootLayoutController = loader.getController();
            rootLayoutController.setMainController(this);

            // Show the primary stage
            primaryStage.show();

            // Show the list of anniversaries by default
            listAnniversaries();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Loads and displays the list of anniversaries in the center of the root layout
    public void listAnniversaries() {
        try {
            // Load AnniversaryList.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AnniversariesApp.class.getResource("/views/AnniversaryList.fxml"));
            AnchorPane anniversaryListPane = loader.load();

            // Get the controller for the list and set the main controller
            AnniversaryListController controller = loader.getController();
            controller.setMainController(this);

            // Fetch anniversaries from the repository and convert them to view models
            Repository repo = new Repository();
            List<AnniversaryView> anniversaryViews = repo.getAnniversaries().stream()
                    .map(AnniversaryView::new)
                    .collect(Collectors.toList());

            // Pass the list to the controller
            controller.setAnniversaries(anniversaryViews);

            // Display the list in the center pane
            rootLayout.setCenter(anniversaryListPane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Loads the form for adding a new anniversary
    public void showAddAnniversaryForm() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AnniversariesApp.class.getResource("/views/AddAnniversary.fxml"));
            AnchorPane addAnniversaryPane = loader.load();

            // Set the main controller on the AddAnniversaryController
            AddAnniversaryController controller = loader.getController();
            controller.setMainController(this);

            // Display the form in the center pane
            rootLayout.setCenter(addAnniversaryPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Adds a new anniversary to the repository and refreshes the list
    public void addAnniversary(Anniversary anniversary) {
        Repository repo = new Repository();

        // Extract gift info and create a new Anniversary object
        String modernGift = anniversary.getModernGift();
        String tradGift = anniversary.getTradGift();

        Anniversary newAnniv = new Anniversary(0, modernGift, tradGift, new ArrayList<>());

        // Save to repository
        repo.addAnniversary(newAnniv);

        // Refresh the list
        listAnniversaries();
    }

    // Loads the form for adding a new place visited
    public void showAddPlaceVisitedForm() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AnniversariesApp.class.getResource("/views/AddPlace.fxml"));
            AnchorPane addPlacePane = loader.load();

            // Set the main controller on the AddPlaceController
            AddPlaceController controller = loader.getController();
            controller.setMainController(this);

            // Display the form in the center pane
            rootLayout.setCenter(addPlacePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Adds a new place visited to an anniversary and refreshes the list
    public void addPlaceVisited(Place place) {
        Repository repo = new Repository();

        // Extract place details and create a new Place object
        String placeName = place.getPlaceName();
        String country = place.getCountry();
        int anniversaryId = place.getAnniversaryId();

        Place newPlace = new Place(placeName, country, anniversaryId);

        // Save to repository
        repo.addPlace(newPlace);

        // Refresh the list
        listAnniversaries();
    }

    // Handles search by phrase functionality
    public void searchByPhrase(String phrase) {
        // Get all anniversaries from the repository
        Repository repo = new Repository();
        List<Anniversary> anniversaries = repo.getAnniversaries();

        // Filter anniversaries and places visited based on the phrase
        List<Anniversary> filteredAnniversaries = anniversaries.stream()
                .filter(anniversary -> anniversary.getModernGift().contains(phrase) ||
                        anniversary.getTradGift().contains(phrase) ||
                        anniversary.getPlacesVisited().stream()
                                .anyMatch(place -> place.getPlaceName().contains(phrase) || place.getCountry().contains(phrase)))
                .collect(Collectors.toList());

        // Print the matching anniversaries and places visited to the console
        System.out.println("Anniversaries and Places Visited matching phrase '" + phrase + "':");
        filteredAnniversaries.forEach(anniversary -> {
            System.out.println("Anniversary ID: " + anniversary.getId());
            System.out.println("Modern Gift: " + anniversary.getModernGift());
            System.out.println("Traditional Gift: " + anniversary.getTradGift());
            anniversary.getPlacesVisited().forEach(place -> {
                System.out.println("Place: " + place.getPlaceName() + ", Country: " + place.getCountry());
            });
            System.out.println("------------");
        });
    }
}
