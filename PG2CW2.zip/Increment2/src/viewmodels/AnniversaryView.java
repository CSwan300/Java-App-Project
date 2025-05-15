package viewmodels;

import java.util.List;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Anniversary;

public class AnniversaryView {
    private StringProperty id;
    private StringProperty modernGift;
    private StringProperty tradGift;
    private List<PlaceView> placesVisited;
      
    public AnniversaryView(Anniversary anniversary) {
    	this.id = new SimpleStringProperty(Integer.toString(anniversary.getId()));
    	this.modernGift = new SimpleStringProperty(anniversary.getModernGift());
    	this.tradGift = new SimpleStringProperty(anniversary.getTradGift());
    	this.placesVisited = anniversary.getPlacesVisited().stream().map(p -> new PlaceView(p)).collect(Collectors.toList());
    }

    public StringProperty getId() {
            return id;
    }

    public StringProperty getModernGift() {
            return modernGift;
    }

    public StringProperty getTradGift() {
            return tradGift;
    }

    public List<PlaceView> getPlacesVisited() {
            return placesVisited;
    }
}
