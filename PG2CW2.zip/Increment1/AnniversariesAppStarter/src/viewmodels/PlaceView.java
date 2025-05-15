package viewmodels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Place;

public class PlaceView {
    private StringProperty placeName;
    private StringProperty country;
    private StringProperty anniversaryId;
    
    public PlaceView(Place episode) {
    	this.placeName = new SimpleStringProperty(episode.getPlaceName());
    	this.country = new SimpleStringProperty(episode.getCountry());
    	this.anniversaryId = new SimpleStringProperty(Integer.toString(episode.getAnniversaryId()));
    }
    
    public StringProperty getPlaceName() {
            return placeName;
    }    

    public StringProperty getCountry() {
            return country;
    }

    public StringProperty getAnniversaryId() {
            return anniversaryId;
    }	
}
