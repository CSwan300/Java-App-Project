package daos;

import java.util.ArrayList;
import java.util.List;

import model.Anniversary;
import model.Place;

/**
 * A Test Data Access Object class
 * to hard code test data for
 * anniversaries and places.
 */
public class TestDAO extends DAO {
	List<Anniversary> anniversariesList;

    /**
     * Initializes and populates the anniversaries list
     * with test data.
     */
    public TestDAO() {
        anniversariesList = new ArrayList<>();
        Anniversary anniversary;
        Place place;
        anniversary = new Anniversary(1, "Clocks", "Paper");
        place = new Place("Paris", "France", 1);
        anniversary.addPlaceVisited(place);
        place = new Place("London", "England", 1);
        anniversary.addPlaceVisited(place);
        place = new Place("Manchester", "England", 1);
        anniversary.addPlaceVisited(place);
        anniversariesList.add(anniversary);
        anniversary = new Anniversary(2, "China", "Cotton");
        place = new Place("Barcelona", "Spain", 2);
        anniversary.addPlaceVisited(place);
        place = new Place("Girona", "Spain", 2);
        anniversary.addPlaceVisited(place);
        anniversariesList.add(anniversary);
        anniversary = new Anniversary(3, "Glass/Crystal", "Leather");
        place = new Place("New York", "USA", 3);
        anniversary.addPlaceVisited(place);
        anniversariesList.add(anniversary);
    }
    
    /**
     * Overrides the abstract method specified in the DAO class
     * and returns a List of Anniversary objects as requested
     */
    @Override
	public List<Anniversary> getAnniversaries() {
        return anniversariesList;
    }
    
    /**
     * Overrides the abstract method specified in the DAO class,
     * accepts an anniversary id value
     * and returns a matching Anniversary object or null as requested
     */
    @Override
	public Anniversary getAnniversary(int anniversaryId) {
        for (Anniversary anniversary : anniversariesList) {
            if (anniversary.getId() == anniversaryId) {
                return anniversary;
            }
        }    	
        return null;
    }
    
    /**
     * Overrides the abstract method specified in the DAO class,
     * accepts an anniversary object and adds it to the list
     */
    @Override
    public void addAnniversary(Anniversary anniversary) {
        int anniversaryId = anniversariesList.stream().map(Anniversary::getId).max(Integer::compare).get()+1;
        anniversary.setId(anniversaryId);
        anniversariesList.add(anniversary);
    }
    
    /**
     * Overrides the abstract method specified in the DAO class,
     * accepts a place object and updates an anniversary in the list
     */
    @Override
	public void addPlace(Place place) {
        for (Anniversary anniversary : anniversariesList) {
            if (anniversary.getId() == place.getAnniversaryId()) {
                anniversary.addPlaceVisited(place);
            }
        }    	
    }  
}
