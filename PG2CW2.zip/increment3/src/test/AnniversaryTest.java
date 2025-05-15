package test;

import model.Anniversary;
import model.Place;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Anniversary model class
 */
class AnniversaryTest {

    private Anniversary anniversary;

    /**
     * Set up a default Anniversary instance before each test
     * This method is executed before each test method to ensure we have a fresh instance.
     */
    @BeforeEach
    void setUp() {
        // Create a new Anniversary object with an ID of 1, Modern gift "Gold" and Traditional gift "Paper"
        anniversary = new Anniversary(1, "Gold", "Paper");
    }

    /**
     * Tests that the constructor properly sets id, modern, and traditional gifts
     * Verifies that the Anniversary object's properties are initialized correctly.
     */
    @Test
    void testConstructorAndGetters() {
        assertEquals(1, anniversary.getId()); // Check if the ID is set to 1
        assertEquals("Gold", anniversary.getModernGift()); // Check if the modern gift is "Gold"
        assertEquals("Paper", anniversary.getTradGift()); // Check if the traditional gift is "Paper"
        assertTrue(anniversary.getPlacesVisited().isEmpty()); // Initially, no places should be visited
    }

    /**
     * Tests that setters correctly update the properties of the Anniversary object
     * Verifies that the setter methods update the object's state.
     */
    @Test
    void testSetters() {
        anniversary.setId(2); // Set a new ID value
        anniversary.setModernGift("Silver"); // Set a new modern gift
        anniversary.setTradGift("Cotton"); // Set a new traditional gift

        assertEquals(2, anniversary.getId()); // Verify the ID is updated
        assertEquals("Silver", anniversary.getModernGift()); // Verify the modern gift is updated
        assertEquals("Cotton", anniversary.getTradGift()); // Verify the traditional gift is updated
    }

    /**
     * Tests the addPlaceVisited method and verifies that a Place is added to the list
     * Ensures that places visited are correctly added to the Anniversary object.
     */
    @Test
    void testAddPlaceVisited() {
        Place place = new Place("Paris", "France", 1); // Create a new Place object
        anniversary.addPlaceVisited(place); // Add the place to the anniversary's list

        assertEquals(1, anniversary.getPlacesVisited().size()); // There should be one place in the list
        assertEquals("Paris", anniversary.getPlacesVisited().get(0).getPlaceName()); // Verify the place's name
    }

    /**
     * Tests the toString method to ensure it includes expected information
     * Verifies that the toString method provides a string representation of the object.
     */
    @Test
    void testToString() {
        Place place1 = new Place("Tokyo", "Japan", 1); // Create place 1
        Place place2 = new Place("Berlin", "Germany", 1); // Create place 2

        anniversary.addPlaceVisited(place1); // Add place 1
        anniversary.addPlaceVisited(place2); // Add place 2

        String result = anniversary.toString(); // Call the toString method to get a string representation

        assertTrue(result.contains("Modern: Gold")); // Check if the modern gift is in the string
        assertTrue(result.contains("Tokyo")); // Check if place "Tokyo" is mentioned
        assertTrue(result.contains("Germany")); // Check if place "Germany" is mentioned
    }

    /**
     * Tests the constructor that accepts a pre-defined list of visited places
     * Ensures the constructor properly handles initializing with existing places.
     */
    @Test
    void testConstructorWithPlaces() {
        Place place = new Place("Rome", "Italy", 1); // Create a place object for Rome
        List<Place> places = Arrays.asList(place); // Put the place into a list

        // Create a new Anniversary object with the list of places
        Anniversary ann = new Anniversary(1, "Gold", "Paper", places);

        assertEquals(1, ann.getPlacesVisited().size()); // There should be one place in the list
        assertEquals("Rome", ann.getPlacesVisited().get(0).getPlaceName()); // Verify the place's name
    }

    // Place Model tests

    /**
     * Tests that the constructor properly sets place name, country, and anniversary ID
     * Verifies that the Place object's constructor initializes its properties correctly.
     */
    @Test
    void testConstructorAndGettersPlace() {
        Place place = new Place("Kyoto", "Japan", 1); // Create a Place object

        assertEquals("Kyoto", place.getPlaceName()); // Verify the place name
        assertEquals("Japan", place.getCountry()); // Verify the country name
        assertEquals(1, place.getAnniversaryId()); // Verify the anniversary ID
    }

    /**
     * Tests that the toString method returns a properly formatted string for Place
     * Verifies that the toString method in Place gives a correct string representation.
     */
    @Test
    void testToStringPlace() {
        Place place = new Place("Sydney", "Australia", 2); // Create a Place object for Sydney
        String result = place.toString(); // Call toString to get the string representation

        assertTrue(result.contains("Sydney")); // Check if place "Sydney" is mentioned
        assertTrue(result.contains("Australia")); // Check if country "Australia" is mentioned
        assertTrue(result.contains("2")); // Check if anniversary ID "2" is mentioned
    }
}

