package views;

import controllers.Controller;
import javafx.fxml.FXML;

public class RootLayoutController {

    // This is a reference to the main controller that handles the primary functionality
    private Controller mainController;

    // Constructor for RootLayoutController, currently empty since the controller is set via FXML
    public RootLayoutController() {
    }

    // This method is called when the "Exit" menu item is clicked
    @FXML
    private void handleExit() {
        // Exits the application when the "Quit" menu item is selected
        System.exit(0);
    }

    // This method is called when the "Anniversaries List" menu item is clicked
    @FXML
    private void handleListAnniversaries() {
        // TODO: Implement the functionality for listing anniversaries
        // This method will delegate the task to the main controller
    }

    // This method is called when the "Add Anniversary" menu item is clicked
    @FXML
    private void handleAddAnniversary() {
        // TODO: Implement the functionality for showing the Add Anniversary form
        // This method will delegate the task to the main controller
    }

    // This method is used to set the reference to the main controller
    // The main controller is passed in from the application (Controller class)
    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }
}
