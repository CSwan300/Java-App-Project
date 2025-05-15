package daos;

import java.util.List;

import model.Anniversary;
import model.Place;

/**
 * An abstract Data Access Object class
 * which specifies the functionality required
 * to interact with a data store and implemented
 * in concrete subclasses
 */
public abstract class DAO {

    /**
     * A Data Access Object needs to be able to fulfill an
     * addAnniversary() request
     */
    public abstract void addAnniversary(Anniversary anniversary);

    /**
     * A Data Access Object needs to be able to fulfill an
     * addPlace() request
     */
    public abstract void addPlace(Place place);

    /**
     * A Data Access Object needs to be able to fulfill a
     * getAnniversary() request when supplied with a anniversary id
     */
    public abstract Anniversary getAnniversary(int anniversaryId);

    /**
     * A Data Access Object needs to be able to fulfill a
     * getAnniversaries() request and return a List of Anniversary objects
     */
    public abstract List<Anniversary> getAnniversaries();
}