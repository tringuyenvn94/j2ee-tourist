/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.data;

/**
 *
 * @author VANGANH
 */
import tourist.entities.PlaceVisit;
import java.sql.*;

public class PlaceVisitDAO {

    private static PlaceVisitDAO _instance;
    private Connector _conn;

    /*
     * Contructor
     */
    private PlaceVisitDAO(){
        this._conn=Connector.getInstance();
    }
    public static PlaceVisitDAO getInstance(){
        if(_instance==null){
            _instance=new PlaceVisitDAO();
        }
        return _instance;
    }

    /*
     * Initial data
     */
    private PlaceVisit initPlaceVisit(ResultSet rs){
        PlaceVisit placevisit=new PlaceVisit();
        try{
            placevisit.setPlaceVisitId(rs.getLong(PlaceVisit.PlaceVisitId));
        }catch(SQLException sqle){
            placevisit.setPlaceVisitId(Long.valueOf(0));
        }
        try{
            placevisit.setTouristId(rs.getLong(PlaceVisit.TouristId));
        }catch(SQLException sqle){
            placevisit.setTouristId(Long.valueOf(0));
        }
        try{
            placevisit.setDestinationId(rs.getInt(PlaceVisit.DestinationId));
        }catch(SQLException sqle){
            placevisit.setDestinationId(0);
        }
        try{
            placevisit.setPlaceVisitOrdering(rs.getInt(PlaceVisit.PlaceVisitOrdering));
        }catch(SQLException sqle){
            placevisit.setPlaceVisitOrdering(0);
        }
        return placevisit;
    }

    /*
     * Get data
     */

    /*
     * Set data
     */
    public void setPlaceVisit(PlaceVisit placevisit){
        StringBuilder input=new StringBuilder();
        input.append(PlaceVisit.TouristId).append(",");
        input.append(PlaceVisit.DestinationId).append(",");
        input.append(PlaceVisit.PlaceVisitOrdering);

        StringBuilder value=new StringBuilder();
        value.append(placevisit.getTouristId()).append(",");
        value.append(placevisit.getDestinationId()).append(",");
        value.append(placevisit.getPlaceVisitOrdering());

        StringBuilder query=new StringBuilder();
        query.append("insert into ").append(PlaceVisit.TableName);
        query.append(" (").append(input).append(")");
        query.append(" values (").append(value).append(")");
        if(this._conn.executeNoneQuery(query.toString())==true){
            placevisit.setPlaceVisitId(this._conn.getNextId());
        }else
            placevisit.setPlaceVisitId(Long.valueOf(0));
    }

    /*
     * Delete data
     */
    public boolean delPlaceVisitById(Long placevisit_id){
        StringBuilder condition=new StringBuilder();
        condition.append(PlaceVisit.PlaceVisitId).append("=").append(placevisit_id);

        StringBuilder query=new StringBuilder();
        query.append("delete from ").append(PlaceVisit.TableName);
        query.append(" where ").append(condition);
        return this._conn.executeNoneQuery(query.toString());
    }
    public boolean delPlaceVisitByTourist(Long tourist_id){
        StringBuilder condition=new StringBuilder();
        condition.append(PlaceVisit.TouristId).append("=").append(tourist_id);

        StringBuilder query=new StringBuilder();
        query.append("delete from ").append(PlaceVisit.TableName);
        query.append(" where ").append(condition);
        return this._conn.executeNoneQuery(query.toString());
    }

    /*
     * Update data
     */
    public boolean updatePlaceVisit(PlaceVisit placevisit){
        StringBuilder value=new StringBuilder();
        value.append(PlaceVisit.DestinationId).append("=").append(placevisit.getDestinationId()).append(",");
         value.append(PlaceVisit.PlaceVisitOrdering).append("=").append(placevisit.getPlaceVisitOrdering());

        StringBuilder condition=new StringBuilder();
        condition.append(PlaceVisit.PlaceVisitId).append("=").append(placevisit.getPlaceVisitId());

        StringBuilder query=new StringBuilder();
        query.append("update ").append(PlaceVisit.TableName);
        query.append(" set ").append(value);
        query.append(" where ").append(condition);

        return this._conn.executeNoneQuery(query.toString());
    }
}

