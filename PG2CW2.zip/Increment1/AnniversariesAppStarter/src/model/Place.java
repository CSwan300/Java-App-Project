package model;

/**
 * Models Place entities
 *
 * @author Martin Gallacher
 */
public class Place {
	
    private final String placeName;
    private final String country;
    private final int anniversaryId;

    /**
     * A constructor which accepts place name, country, and anniversary id values
     */
    public Place(String placeName, String country, int anniversaryId) {
    	this.placeName = placeName;
        this.country = country;
        this.anniversaryId = anniversaryId;
    }
      
    /**
     * A getter for place name values
     */
    public String getPlaceName() {
        return placeName;
    }

    /**
     * A getter for country values
     */
    public String getCountry() {
        return country;
    }

    /**
     * A getter for anniversary id values
     */
    public int getAnniversaryId() {
        return anniversaryId;
    }
    
    /**
     * Constructs and returns a String representing the state of the object
     */
    @Override
    public String toString() {
        return "Place Name: " + placeName + " Country: " + country + " Anniversary: " + Integer.toString(anniversaryId) + "\n";
    }
    
}
