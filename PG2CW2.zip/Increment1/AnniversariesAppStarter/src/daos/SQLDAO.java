package daos;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Anniversary;
import model.Place;

/**
 * A SQL Data Access Object class
 * to implement methods to access/update
 * an SQL database.
 */
public class SQLDAO extends DAO {
    static private final String userName = "root";
    static private final String password = "";
    static private final String url = "jdbc:mysql://localhost:3306/anniversaries";
    static private Connection connection = null;
        
    public SQLDAO() {
        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected to database");            
        } catch (SQLException ex) { System.out.println(ex.getMessage());}
    }

    /**
     * A method to return the anniversaries list through
     * querying the database.
     * Note the query can be hard coded but better to use a
     * stored procedure held in the database.
     */
    @Override
    public List<Anniversary> getAnniversaries() {
        List<Anniversary> anniversariesList = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            String queryString = "CALL GETANNIVERSARIES()";
            ResultSet rs = stmt.executeQuery(queryString);
            
            while (rs.next()) {
                int anniversaryid = rs.getInt("ANNIVERSARYID");
                String modernGift = rs.getString("MODERNGIFT");
                String tradGift = rs.getString("TRADGIFT");
                List<Place> placesVisitedList = getAnniversaryPlaces(anniversaryid);
                Anniversary anniversary = new Anniversary(anniversaryid, modernGift, tradGift, placesVisitedList);
                anniversariesList.add(anniversary);
            }            
        } catch (SQLException ex) { System.out.println(ex.getMessage());}
        return anniversariesList;
    }

    /**
     * A method to return the places visited list associated with
     * a specified anniversary through querying the database.
     * Note the query can be hard coded but better to use a
     * stored procedure held in the database.
     */
    private List<Place> getAnniversaryPlaces(int anniversaryId) throws SQLException {
        List<Place> placesVisitedList = new ArrayList<>();
        String queryString = "CALL GETANNIVERSARYPLACES(" + Integer.toString(anniversaryId) + ")";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(queryString);
        while (rs.next()) {
            String placeName = rs.getString("PLACENAME");
            String country = rs.getString("COUNTRY");
            Place place = new Place(placeName, country, anniversaryId);
            placesVisitedList.add(place);
        }
        return placesVisitedList;
    }

    /**
     * A method to return the specified anniversary through
     * querying the database.
     * Note the query can be hard coded but better to use a
     * stored procedure held in the database.
     */
    @Override
    public Anniversary getAnniversary(int anniversaryId) {
        try {
            Statement stmt = connection.createStatement();
            String queryString = "CALL GETANNIVERSARY(" + Integer.toString(anniversaryId) + ")";
            ResultSet rs = stmt.executeQuery(queryString);
            
            if (rs.next()) {
                String modernGift = rs.getString("MODERNGIFT");
                String tradGift = rs.getString("TRADGIFT");
                List<Place> placesVisitedList = getAnniversaryPlaces(anniversaryId);
                Anniversary anniversary = new Anniversary(anniversaryId, modernGift, tradGift, placesVisitedList);
                return anniversary;
            }
        } catch (SQLException ex) {System.out.println(ex.getMessage());}
        return null;
    }

    /**
     * A method to add the supplied anniversary to the database.
     * Note the query can be hard coded but better to use a
     * stored procedure held in the database.
     */
    @Override
    public void addAnniversary(Anniversary anniversary) {
        try {
            Statement stmt = connection.createStatement();
            String queryString = "CALL ADDANNIVERSARY('";
            queryString += anniversary.getModernGift() + "', '";
            queryString += anniversary.getTradGift() + "')";
            stmt.executeUpdate(queryString);
        } catch (SQLException ex) { System.out.println(ex.getMessage());}
    }

    /**
     * A method to add the supplied place visited to the database.
     * Note the query can be hard coded but better to use a
     * stored procedure held in the database.
     */
    @Override
    public void addPlace(Place place) {
        try {
            Statement stmt = connection.createStatement();
            String queryString = "CALL ADDPLACE('";
            queryString += place.getPlaceName() + "', '";
            queryString += place.getCountry() + "', ";
            queryString += place.getAnniversaryId() + ")";
            stmt.executeUpdate(queryString);
        } catch (SQLException ex) {System.out.println(ex.getMessage());}
	}
}	
