/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.data;

/**
 *
 * @author VANGANH
 */
import tourist.entities.Destination;
import tourist.entities.ListDestination;
import tourist.entities.PlaceVisit;
import java.sql.*;

public class DestinationDAO {

    private static DestinationDAO _instance;
    private Connector _conn;

    /*
     * Contructor
     */
    private DestinationDAO(){
        this._conn=Connector.getInstance();
    }
    public static DestinationDAO getInstance(){
        if(_instance==null){
            _instance=new DestinationDAO();
        }
        return _instance;
    }

    /*
     * Initial data
     */
    private Destination initDestination(ResultSet rs){
        Destination destination=new Destination();
        try{
            destination.setDestinationId(rs.getInt(Destination.DestinationId));
        }catch(SQLException sqle){
            destination.setDestinationId(0);
        }
        try{
            destination.setTownId(rs.getInt(Destination.TownId));
        }catch(SQLException sqle){
            destination.setTownId(0);
        }
        try{
            destination.setDestinationName(rs.getString(Destination.DestinationName));
        }catch(SQLException sqle){
            destination.setDestinationName("");
        }
        try{
            destination.setDestinationImage(rs.getString(Destination.DestinationImage));
        }catch(SQLException sqle){
            destination.setDestinationImage("");
        }
        return destination;
    }

    /*
     * Get data
     */
    public Destination getDestination(Integer destination_id) {
        Destination destination=null;

        StringBuilder output=new StringBuilder();
        output.append(Destination.DestinationId+",");
        output.append(Destination.TownId+",");
        output.append(Destination.DestinationName+",");
        output.append(Destination.DestinationImage);

        StringBuilder condition=new StringBuilder();
        condition.append(Destination.DestinationId+"=");
        condition.append(destination_id);

        StringBuilder query=new StringBuilder();
        query.append("select ").append(output);
        query.append(" from ").append(Destination.TableName);
        query.append(" where ").append(condition);

        ResultSet rs=this._conn.executeQuery(query.toString());
        try{
            if(rs!=null&&rs.next()){
                destination=this.initDestination(rs);
            }
        }catch(SQLException sqle){
            destination=null;
        }
        return destination;
    }

    public ListDestination getListDestinationByTown(Integer town_id){
        ListDestination listdestination=new ListDestination();
        Destination destination=null;

        StringBuilder output=new StringBuilder();
        output.append(Destination.DestinationId+",");
        output.append(Destination.DestinationName+",");
        output.append(Destination.DestinationImage);

        StringBuilder condition=new StringBuilder();
        condition.append(Destination.TownId).append("=").append(town_id);

        StringBuilder query=new StringBuilder();
        query.append("select ").append(output);
        query.append(" from ").append(Destination.TableName);
        query.append(" where ").append(condition);

        ResultSet rs=this._conn.executeQuery(query.toString());
        try{
            if(rs!=null){
                while(rs.next()){
                    destination=this.initDestination(rs);
                    listdestination.add(destination);
                }
            }
        }catch(SQLException sqle){
            listdestination.clear();
        }
        return listdestination;
    }

    public ListDestination getListDestinationByTourist(Long tourist_id){
        ListDestination listdestination=new ListDestination();
        Destination destination=null;

        StringBuilder output=new StringBuilder();
        output.append(Destination.TableName).append(".").append(Destination.DestinationId+",");
        output.append(Destination.DestinationName+",");
        output.append(Destination.DestinationImage);

        StringBuilder condition=new StringBuilder();
        condition.append(PlaceVisit.TouristId).append("=").append(tourist_id);

        StringBuilder order=new StringBuilder();
        order.append(PlaceVisit.PlaceVisitOrdering).append(" ASC");

        StringBuilder query1=new StringBuilder();
        query1.append("select ").append(PlaceVisit.DestinationId);
        query1.append(" from ").append(PlaceVisit.TableName);
        query1.append(" where ").append(condition);
        query1.append(" order by ").append(order);

        StringBuilder query=new StringBuilder();
        query.append("select ").append(output);
        query.append(" from (").append(query1).append(") as T1 left join ").append(Destination.TableName);
        query.append(" on T1.").append(PlaceVisit.DestinationId).append("=");
        query.append(Destination.TableName).append(".").append(Destination.DestinationId);

        ResultSet rs=this._conn.executeQuery(query.toString());
        try{
            if(rs!=null){
                while(rs.next()){
                    destination=this.initDestination(rs);
                    listdestination.add(destination);
                }
            }
        }catch(SQLException sqle){
            listdestination.clear();
        }
        return listdestination;
    }

    public ListDestination getListDestination(String fieldname,String condition,Integer currpage,Integer pagesize,Long totalrecord,String order){
        ListDestination listdestination=new ListDestination();
        Destination destination=null;

        totalrecord=this._conn.getTotalRecord(Destination.TableName, condition);

        StringBuilder query=new StringBuilder();
        query.append("select ").append(fieldname);
        query.append(" from ").append(Destination.TableName);
        query.append(" where ").append(condition);
        if(order != null && !order.equals(""))
            query.append(" order by ").append(order);
        if(pagesize>0){
            this._conn.checkPage(currpage, pagesize, totalrecord);
            Long offset=currpage.longValue()-1;
            offset=offset*pagesize;
            query.append(" limit ").append(offset).append(",").append(pagesize);
        }


        ResultSet rs=this._conn.executeQuery(query.toString());
        try{
            if(rs!=null){
                while(rs.next()){
                    destination=this.initDestination(rs);
                    listdestination.add(destination);
                }
            }
        }catch(SQLException sqle){
            listdestination.clear();
        }
        return listdestination;
    }

    /*
     * Set data
     */
    public void setDestination(Destination destination){
        StringBuilder input=new StringBuilder();
        input.append(Destination.TownId).append(",");
        input.append(Destination.DestinationName).append(",");
        input.append(Destination.DestinationImage);

        StringBuilder value=new StringBuilder();
        value.append(destination.getTownId()).append(",");
        value.append("'").append(destination.getDestinationName()).append("',");
        value.append("'").append(destination.getDestinationImage()).append("'");

        StringBuilder query=new StringBuilder();
        query.append("insert into ").append(Destination.TableName);
        query.append(" (").append(input).append(")");
        query.append(" values (").append(value).append(")");
        if(this._conn.executeNoneQuery(query.toString())==true){
            destination.setDestinationId(this._conn.getNextId().intValue());
        }else
            destination.setDestinationId(0);
    }

    /*
     * Delete data
     */
    public boolean delDestination(Integer destination_id){
        StringBuilder condition=new StringBuilder();
        condition.append(Destination.DestinationId).append("=").append(destination_id);

        StringBuilder query=new StringBuilder();
        query.append("delete from ").append(Destination.TableName);
        query.append(" where ").append(condition);
        return this._conn.executeNoneQuery(query.toString());
    }

    /*
     * Update data
     */
    public boolean updateDestination(Destination destination){
        StringBuilder value=new StringBuilder();
        value.append(Destination.TownId).append("=").append(destination.getTownId()).append(",");
        value.append(Destination.DestinationName).append("='").append(destination.getDestinationName()).append("',");
        value.append(Destination.DestinationImage).append("='").append(destination.getDestinationImage()).append("'");

        StringBuilder condition=new StringBuilder();
        condition.append(Destination.DestinationId).append("=").append(destination.getDestinationId());

        StringBuilder query=new StringBuilder();
        query.append("update ").append(Destination.TableName);
        query.append(" set ").append(value);
        query.append(" where ").append(condition);

        return this._conn.executeNoneQuery(query.toString());
    }
}
