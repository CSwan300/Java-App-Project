package views;

import controllers.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Place;

public class AddPlaceController {

    // FXML-injected TextField for the place name input
    @FXML
    private TextField placeNameField;

    // FXML-injected TextField for the country input
    @FXML
    private TextField countryField;

    // FXML-injected TextField for the anniversary ID input
    @FXML
    private TextField anniversaryIdField;

    // Reference to the main application controller (injected from the parent controller)
    private Controller mainController;

    // Setter method to allow the main controller to be passed in
    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }

    // Handles the form submission when "Add Place" button is clicked
    @FXML
    private void handleAddPlace() {
        // Retrieve user inputs from text fields
        String name = placeNameField.getText();
        String country = countryField.getText();

        // Parse the anniversary ID from string to integer
        int anniversaryId = Integer.parseInt(anniversaryIdField.getText());

        // Create a new Place object using the input values
        Place place = new Place(name, country, anniversaryId);

        // Use the main controller to add the place to the repository
        mainController.addPlaceVisited(place);

        // Refresh the list of anniversaries to reflect the new place (optional UX improvement)
        mainController.listAnniversaries();
    }
}
