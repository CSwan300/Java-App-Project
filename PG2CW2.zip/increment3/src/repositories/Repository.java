package repositories;

import daos.DAO;

import java.util.List;

import daos.SQLDAO;
import model.Anniversary;
import model.Place;

/**
 * Implements model management
 * and acts as an intermediary
 * to a data access object
 */
public class Repository implements RepositoryInterface {
    private final DAO dao;
	
    /**
     * The default constructor which instantiates the dao attribute as a 
     * specified type of Data Access Object
     */
    public Repository() { 
    	dao = new SQLDAO();
    }
    
    /**
     * Responds to a request from the Controller to provide a List of 
     * Anniversary objects.
     * Fulfils this request by sending a getAnniversaries() message to the
     * data access object
     */
    @Override
    public List<Anniversary> getAnniversaries() {
        return dao.getAnniversaries();
    }
    
    /**
     * Responds to a request from the Controller to add a 
     * Anniversary object.
     * Fulfils this request by sending an addAnniversary() message to the
     * data access object
     */    
    @Override
    public void addAnniversary(Anniversary anniversary) {
        dao.addAnniversary(anniversary);
    }
    
    /**
     * Responds to a request from the Controller to add a 
     * Place object.
     * Fulfils this request by sending an addPlace() message to the
     * data access object
     */     
    @Override
    public void addPlace(Place place) {
    	dao.addPlace(place);
    }    
       
    /**
     * Responds to a request from the Controller to provide a specified
     * Anniversary object.
     * Fulfils this request by sending a getAnniversary() message to the
     * data access object
     */    
    @Override
    public Anniversary getAnniversary(int id) {
        return dao.getAnniversary(id);
    }
}
