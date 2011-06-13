/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.data;

/**
 *
 * @author VANGANH
 */
import tourist.entities.*;
import java.sql.*;

public class TownDAO {

    private static TownDAO _instance;
    private Connector _conn;

    /*
     * Contructor
     */
    private TownDAO(){
        this._conn=Connector.getInstance();
    }
    public static TownDAO getInstance(){
        if(_instance==null){
            _instance=new TownDAO();
        }
        return _instance;
    }

    /*
     * Initial data
     */
    private Town initTown(ResultSet rs){
        Town town=new Town();
        try{
            town.setTownId(rs.getInt(Town.TownId));
        }catch(SQLException sqle){
            town.setTownId(0);
        }
        try{
            town.setNationId(rs.getInt(Town.NationId));
        }catch(SQLException sqle){
            town.setNationId(0);
        }
        try{
            town.setTownName(rs.getString(Town.TownName));
        }catch(SQLException sqle){
            town.setTownName("");
        }
        return town;
    }

    /*
     * Get data
     */
    public Town getTown(Integer town_id) {
        Town town=null;
                
        StringBuilder output=new StringBuilder();
        output.append(Town.TownId+",");
        output.append(Town.NationId+",");
        output.append(Town.TownName);

        StringBuilder condition=new StringBuilder();
        condition.append(Town.TownId+"=");
        condition.append(town_id);

        StringBuilder query=new StringBuilder();
        query.append("select ").append(output);
        query.append(" from ").append(Town.TableName);
        query.append(" where ").append(condition);
        
        ResultSet rs=this._conn.executeQuery(query.toString());
        try{
            if(rs!=null&&rs.next()){
                town=this.initTown(rs);
            }
        }catch(SQLException sqle){
            town=null;
        }
        return town;
    }

    public ListTown getListTown(Integer nation_id){
        ListTown listtown=new ListTown();
        Town town=null;

        StringBuilder output=new StringBuilder();
        output.append(Town.TownId+",");
        output.append(Town.TownName);

        StringBuilder condition=new StringBuilder();
        condition.append(Town.NationId+"=").append(nation_id);

        StringBuilder query=new StringBuilder();
        query.append("select ").append(output);
        query.append(" from ").append(Town.TableName);
        query.append(" where ").append(condition);

        ResultSet rs=this._conn.executeQuery(query.toString());
        try{
            if(rs!=null){
                while(rs.next()){
                    town=this.initTown(rs);
                    listtown.add(town);
                }
            }
        }catch(SQLException sqle){
            listtown.clear();
        }
        return listtown;
    }

    /*
     * Set data
     */
    public void setTown(Town town){
        StringBuilder input=new StringBuilder();
        input.append(Town.NationId).append(",");
        input.append(Town.TownName);

        StringBuilder value=new StringBuilder();
        value.append(town.getNationId()).append(",");
        value.append("'").append(town.getTownName()).append("'");

        StringBuilder query=new StringBuilder();
        query.append("insert into ").append(Town.TableName);
        query.append(" (").append(input).append(")");
        query.append(" values (").append(value).append(")");
        if(this._conn.executeNoneQuery(query.toString())==true){
            town.setTownId(this._conn.getNextId().intValue());
        }
    }

    /*
     * Delete data
     */
    public boolean delTown(Integer town_id){
        StringBuilder condition=new StringBuilder();
        condition.append(Town.TownId).append("=").append(town_id);

        StringBuilder query=new StringBuilder();
        query.append("delete from ").append(Town.TableName);
        query.append(" where ").append(condition);
        return this._conn.executeNoneQuery(query.toString());
    }

    /*
     * Update data
     */
    public boolean updateTown(Town town){
        StringBuilder value=new StringBuilder();
        value.append(Town.NationId).append("=").append(town.getNationId()).append(",");
        value.append(Town.TownName).append("='").append(town.getTownName()).append("'");

        StringBuilder condition=new StringBuilder();
        condition.append(Town.TownId).append("=").append(town.getTownId());

        StringBuilder query=new StringBuilder();
        query.append("update ").append(Town.TableName);
        query.append(" set ").append(value);
        query.append(" where ").append(condition);

        return this._conn.executeNoneQuery(query.toString());
    }

}
