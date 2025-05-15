package views;

import controllers.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class RootLayoutController {

    // Reference to the main application controller (injected from main Controller class)
    private Controller mainController;

    // Default constructor
    public RootLayoutController() {
    }

    // Handler for "Quit" menu item
    @FXML
    private void handleExit() {
        // Exits the entire application
        System.exit(0);
    }

    // Handler for "Anniversaries List" menu item
    @FXML
    private void handleListAnniversaries() {
        // Delegate to main controller to load and display the anniversary list view
        mainController.listAnniversaries();
    }

    // Handler for "Add Anniversary" menu item
    @FXML
    private void handleAddAnniversary() {
        // Delegate to main controller to show the add anniversary form
        mainController.showAddAnniversaryForm();
    }

    // Handler for "Add Place" menu item
    @FXML
    private void handleAddPlaceVisited() {
        // Delegate to main controller to show the add place form
        mainController.showAddPlaceVisitedForm();
    }

    // NEW: Handler for "Search by Phrase" menu item
    @FXML
    private void handleSearchByPhrase() {
        // Prompt the user to enter a search phrase
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Search by Phrase");
        dialog.setHeaderText("Enter a phrase to search for anniversaries and places:");
        dialog.setContentText("Phrase:");

        // Show the dialog and wait for the user input
        Optional<String> result = dialog.showAndWait();

        // If the user entered a phrase, perform the search
        result.ifPresent(phrase -> {
            if (!phrase.isEmpty()) {
                // Call the controller's method to search by phrase
                mainController.searchByPhrase(phrase);
            } else {
                // Show an alert if the input is empty
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No Phrase Entered");
                alert.setHeaderText("Please enter a phrase to search.");
                alert.showAndWait();
            }
        });
    }

    // Setter used by the main controller to inject itself into this layout controller
    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }
}
