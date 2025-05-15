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
import views.RootLayoutController;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    // Stage for the primary window of the application
    private Stage primaryStage;
    // Root layout (BorderPane) that holds the overall structure of the UI
    private BorderPane rootLayout;

    // Constructor to initialize the primaryStage
    public Controller(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    // Initializes the root layout and shows the main UI window
    public void initRootLayout() {
        try {
            // Load the RootLayout FXML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AnniversariesApp.class.getResource("/views/RootLayout.fxml"));
            // Load the layout into rootLayout variable
            rootLayout = (BorderPane) loader.load();

            // Create a new scene with the loaded layout and set it on the primaryStage
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Get the controller for the RootLayout and set the main controller (this class)
            RootLayoutController rootLayoutController = loader.getController();
            rootLayoutController.setMainController(this);

            // Show the primary stage (the main window of the application)
            primaryStage.show();

            // Call the method to list anniversaries initially
            listAnniversaries();
        } catch (IOException e) {
            e.printStackTrace(); // Handle potential loading issues
        }
    }

    // Loads the anniversary list and displays it in the center of the root layout
    public void listAnniversaries() {
        try {
            // Load the AnniversaryList FXML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AnniversariesApp.class.getResource("/views/AnniversaryList.fxml"));
            // Load the AnchorPane containing the list of anniversaries
            AnchorPane anniversaryListPane = loader.load();

            // Get the controller for the AnniversaryList view
            views.AnniversaryListController controller = loader.getController();

            // Create a repository instance to fetch the list of anniversaries
            Repository repo = new Repository(); // Use DAO for data interaction (inject if available)
            List<AnniversaryView> anniversaryViews = repo.getAnniversaries().stream()
                    .map(AnniversaryView::new) // Convert Anniversary objects to AnniversaryView objects
                    .collect(Collectors.toList());

            // Pass the list of AnniversaryView objects to the AnniversaryListController
            controller.setAnniversaries(anniversaryViews);

            // Set the anniversary list view as the center content of the root layout
            rootLayout.setCenter(anniversaryListPane);

        } catch (IOException e) {
            e.printStackTrace(); // Handle potential loading issues
        }
    }
}
