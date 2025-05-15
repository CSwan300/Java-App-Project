package views;

import controllers.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import model.Anniversary;
import model.Place;

import java.util.ArrayList;

public class AddAnniversaryController {

    // FXML-injected TextField for entering the modern gift
    @FXML
    private TextField modernGiftField;

    // FXML-injected TextField for entering the traditional gift
    @FXML
    private TextField tradGiftField;

    // Reference to the main controller (acts as a bridge to the rest of the app)
    private Controller mainController;

    // Setter to inject the main controller from outside (typically from the loader)
    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }

    // Handles the form submission when the "Add Anniversary" button is clicked
    @FXML
    private void handleAddAnniversary() {
        // Get user input from the text fields
        String modernGift = modernGiftField.getText();
        String tradGift = tradGiftField.getText();

        // Create a new Anniversary object (ID set to 0 for now; assumed to be auto-generated in storage)
        Anniversary anniversary = new Anniversary(0, modernGift, tradGift, new ArrayList<Place>());

        // Add the anniversary through the main controller
        mainController.addAnniversary(anniversary);

        // Refresh the list view to show the new anniversary
        mainController.listAnniversaries();
    }
}
