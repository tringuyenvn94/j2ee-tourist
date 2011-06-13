/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.data;

/**
 *
 * @author VANGANH
 */
import tourist.entities.Nation;
import tourist.entities.ListNation;
import java.sql.*;

public class NationDAO {

    private static NationDAO _instance;
    private Connector _conn;

    /*
     * Contructor
     */
    private NationDAO(){
        this._conn=Connector.getInstance();
    }
    public static NationDAO getInstance(){
        if(_instance==null){
            _instance=new NationDAO();
        }
        return _instance;
    }

    /*
     * Initial data
     */
    private Nation initNation(ResultSet rs){
        Nation nation=new Nation();
        try{
            nation.setNationId(rs.getInt(Nation.NationId));
        }catch(SQLException sqle){
            nation.setNationId(0);
        }
        try{
            nation.setNationName(rs.getString(Nation.NationName));
        }catch(SQLException sqle){
            nation.setNationName("");
        }
        return nation;
    }

    /*
     * Get data
     */
    public Nation getNation(Integer nation_id) {
        Nation nation=null;

        StringBuilder output=new StringBuilder();
        output.append(Nation.NationId).append(",");
        output.append(Nation.NationName);

        StringBuilder condition=new StringBuilder();
        condition.append(Nation.NationId).append("=").append(nation_id);

        StringBuilder query=new StringBuilder();
        query.append("select ").append(output);
        query.append(" from ").append(Nation.TableName);
        query.append(" where ").append(condition);

        ResultSet rs=this._conn.executeQuery(query.toString());
        try{
            if(rs!=null&&rs.next()){
                nation=this.initNation(rs);
            }
        }catch(SQLException sqle){
            nation=null;
        }
        return nation;
    }

    public ListNation getListNation(){
        ListNation listnation=new ListNation();
        Nation nation=null;

        StringBuilder output=new StringBuilder();
        output.append(Nation.NationId).append(",");
        output.append(Nation.NationName);

        StringBuilder query=new StringBuilder();
        query.append("select ").append(output);
        query.append(" from ").append(Nation.TableName);

        ResultSet rs=this._conn.executeQuery(query.toString());
        try{
            if(rs!=null){
                while(rs.next()){
                    nation=this.initNation(rs);
                    listnation.add(nation);
                }
            }
        }catch(SQLException sqle){
            listnation.clear();
        }
        return listnation;
    }

    /*
     * Set data
     */
    public void setNation(Nation nation){
        StringBuilder input=new StringBuilder();
        input.append(Nation.NationName);

        StringBuilder value=new StringBuilder();
        value.append("'").append(nation.getNationName()).append("'");

        StringBuilder query=new StringBuilder();
        query.append("insert into ").append(Nation.TableName);
        query.append(" (").append(input).append(")");
        query.append(" values (").append(value).append(")");
        if(this._conn.executeNoneQuery(query.toString())==true){
            nation.setNationId(this._conn.getNextId().intValue());
        }else
            nation.setNationId(0);
    }

    /*
     * Delete data
     */
    public boolean delNation(Integer nation_id){
        StringBuilder condition=new StringBuilder();
        condition.append(Nation.NationId).append("=").append(nation_id);

        StringBuilder query=new StringBuilder();
        query.append("delete from ").append(Nation.TableName);
        query.append(" where ").append(condition);
        return this._conn.executeNoneQuery(query.toString());
    }

    /*
     * Update data
     */
    public boolean updateNation(Nation nation){
        StringBuilder value=new StringBuilder();
        value.append(Nation.NationName).append("='").append(nation.getNationName()).append("'");

        StringBuilder condition=new StringBuilder();
        condition.append(Nation.NationId).append("=").append(nation.getNationId());

        StringBuilder query=new StringBuilder();
        query.append("update ").append(Nation.TableName);
        query.append(" set ").append(value);
        query.append(" where ").append(condition);

        return this._conn.executeNoneQuery(query.toString());
    }
}
