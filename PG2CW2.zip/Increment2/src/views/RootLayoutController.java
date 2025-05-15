package views;

import controllers.Controller;
import javafx.fxml.FXML;

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

    // Setter used by the main controller to inject itself into this layout controller
    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }
}
