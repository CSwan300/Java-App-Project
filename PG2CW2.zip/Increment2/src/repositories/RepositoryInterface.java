package repositories;

import java.util.List;

import model.Anniversary;
import model.Place;

/**
 *
 * @author mga
 */
public interface RepositoryInterface {

    /**
     * A class that implements this interface must provide this method
     * 
     * @param anniversary
     */
    void addAnniversary(Anniversary anniversary);

    /**
     * A class that implements this interface must provide this method
     * 
     * @param id
     * @return Anniversary
     */
    Anniversary getAnniversary(int id);

    /**
     * A class that implements this interface must provide this method
     * 
     * @return List of Anniversary
     */
    List<Anniversary> getAnniversaries();
    
    /**
     * A class that implements this interface must provide this method
     * 
     * @param place
     */
    void addPlace(Place place);
    
}
