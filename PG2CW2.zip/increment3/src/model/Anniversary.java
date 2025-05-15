package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Models Anniversary entities
 *
 * @author Martin Gallacher
 */
public class Anniversary {
    private int id;
    private String modernGift;
    private String tradGift;
    private List<Place> placesVisited;

    /**
     * The default Anniversary constructor
     */
    public Anniversary() {
        this.placesVisited = new ArrayList<>();
    }

    /**
     * A constructor which accepts modern & trad gifts values
     */
    public Anniversary(String modernGift, String tradGift) {
        this.modernGift = modernGift;
        this.tradGift = tradGift;
        this.placesVisited = new ArrayList<>();
    }

    /**
     * A constructor which accepts id, modern & trad gifts values
     */
    public Anniversary(int id, String modernGift, String tradGift) {
        this.id = id;
        this.modernGift = modernGift;
        this.tradGift = tradGift;
        this.placesVisited = new ArrayList<>();
    }

    /**
     * A constructor which accepts id, modern & trad gifts and places visited values
     */
    public Anniversary(int id, String modernGift, String tradGift, List<Place> placesVisited) {
        this.id = id;
        this.modernGift = modernGift;
        this.tradGift = tradGift;
        this.placesVisited = placesVisited;
    }

    /**
     * A getter for id values
     */
    public int getId() {
        return id;
    }

    /**
     * A setter method for id values
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * A getter for modern gift values
     */
    public String getModernGift() {
        return modernGift;
    }

    /**
     * A setter method for modern gift values
     */
    public void setModernGift(String modernGift) {
        this.modernGift = modernGift;
    }

    /**
     * A getter for trad gift values
     */
    public String getTradGift() {
        return tradGift;
    }

    /**
     * A setter method for trad gift values
     */
    public void setTradGift(String tradGift) {
        this.tradGift = tradGift;
    }

    /**
     * A getter for places visited values
     */
    public List<Place> getPlacesVisited() { return this.placesVisited;}
    
    /**
     * Adds a supplied Place object to the places visited attribute
     */
    public void addPlaceVisited(Place place) {
        this.placesVisited.add(place);
    }
    
    /**
     * Constructs and returns a String representing the state of the object
     */
    @Override
    public String toString() {
        return "ID: " + Integer.toString(id) + " Modern: " + modernGift + " Trad: " + tradGift + "\nPlaces Visited: " + placesVisited;
    }
}
