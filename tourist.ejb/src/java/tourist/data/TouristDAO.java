/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.data;

/**
 *
 * @author VANGANH
 */
import tourist.entities.Tourist;
import tourist.entities.ListTourist;
import java.sql.*;

public class TouristDAO {

    private static TouristDAO _instance;
    private Connector _conn;

    /*
     * Contructor
     */
    private TouristDAO(){
        this._conn=Connector.getInstance();
    }
    public static TouristDAO getInstance(){
        if(_instance==null){
            _instance=new TouristDAO();
        }
        return _instance;
    }

    /*
     * Initial data
     */
    private Tourist initTourist(ResultSet rs){
        Tourist tourist=new Tourist();
        try{
            tourist.setTouristId(rs.getLong(Tourist.TouristId));
        }catch(SQLException sqle){
            tourist.setTouristId(Long.valueOf(0));
        }
        try{
            tourist.setCategoryId(rs.getInt(Tourist.CategoryId));
        }catch(SQLException sqle){
            tourist.setCategoryId(0);
        }
        try{
            tourist.setTouristTitle(rs.getString(Tourist.TouristTitle));
        }catch(SQLException sqle){
            tourist.setTouristTitle("");
        }
        try{
            tourist.setTouristSummary(rs.getString(Tourist.TouristSummary));
        }catch(SQLException sqle){
            tourist.setTouristSummary("");
        }
        try{
            tourist.setTouristBody(rs.getString(Tourist.TouristBody));
        }catch(SQLException sqle){
            tourist.setTouristBody("");
        }
        try{
            tourist.setTouristImage(rs.getString(Tourist.TouristImage));
        }catch(SQLException sqle){
            tourist.setTouristImage("");
        }
        try{
            tourist.setTouristPrice(rs.getDouble(Tourist.TouristPrice));
        }catch(SQLException sqle){
            tourist.setTouristPrice(Double.valueOf(0));
        }
        try{
            tourist.setTouristNumDay(rs.getInt(Tourist.TouristNumDay));
        }catch(SQLException sqle){
            tourist.setTouristNumDay(0);
        }
        try{
            tourist.setTouristNumNight(rs.getInt(Tourist.TouristNumNight));
        }catch(SQLException sqle){
            tourist.setTouristNumNight(0);
        }
        try{
            tourist.setTouristDate(rs.getLong(Tourist.TouristDate));
        }catch(SQLException sqle){
            tourist.setTouristDate(Long.valueOf(0));
        }
        try{
            tourist.setTouristPublished(rs.getInt(Tourist.TouristPublished));
        }catch(SQLException sqle){
            tourist.setTouristPublished(0);
        }
        return tourist;
    }

    /*
     * Get data
     */
    public Tourist getTourist(Long tourist_id) {
        Tourist tourist=null;

        StringBuilder output=new StringBuilder();
        output.append(Tourist.TouristId).append(",");
        output.append(Tourist.CategoryId).append(",");
        output.append(Tourist.TouristTitle).append(",");
        output.append(Tourist.TouristSummary).append(",");
        output.append(Tourist.TouristBody).append(",");
        output.append(Tourist.TouristImage).append(",");
        output.append(Tourist.TouristPrice).append(",");
        output.append(Tourist.TouristNumDay).append(",");
        output.append(Tourist.TouristNumNight).append(",");
        output.append(Tourist.TouristDate).append(",");
        output.append(Tourist.TouristPublished);

        StringBuilder condition=new StringBuilder();
        condition.append(Tourist.TouristId).append("=").append(tourist_id);

        StringBuilder query=new StringBuilder();
        query.append("select ").append(output);
        query.append(" from ").append(Tourist.TableName);
        query.append(" where ").append(condition);

        ResultSet rs=this._conn.executeQuery(query.toString());
        try{
            if(rs!=null&&rs.next()){
                tourist=this.initTourist(rs);
            }
        }catch(SQLException sqle){
            tourist=null;
        }
        return tourist;
    }

    public ListTourist getListTourist(String fieldname,String condition,Integer currpage,Integer pagesize,Long totalrecord,String order){
        ListTourist listtourist=new ListTourist();
        Tourist tourist=null;

        totalrecord=this._conn.getTotalRecord(Tourist.TableName, condition);

        StringBuilder query=new StringBuilder();
        query.append("select ").append(fieldname);
        query.append(" from ").append(Tourist.TableName);
        query.append(" where ").append(condition);
        if(order == null ? "" != null : !order.equals("")){
            query.append(" order by ").append(order);
        }
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
                    tourist=this.initTourist(rs);
                    listtourist.add(tourist);
                }
            }
        }catch(SQLException sqle){
            listtourist.clear();
        }
        return listtourist;
    }

    /*
     * Set data
     */
    public void setTourist(Tourist tourist){
        StringBuilder input=new StringBuilder();
        input.append(Tourist.CategoryId).append(",");
        input.append(Tourist.TouristTitle).append(",");
        input.append(Tourist.TouristSummary).append(",");
        input.append(Tourist.TouristBody).append(",");
        input.append(Tourist.TouristImage).append(",");
        input.append(Tourist.TouristPrice).append(",");
        input.append(Tourist.TouristNumDay).append(",");
        input.append(Tourist.TouristNumNight).append(",");
        input.append(Tourist.TouristDate).append(",");
        input.append(Tourist.TouristPublished);

        StringBuilder value=new StringBuilder();
        value.append(tourist.getCategoryId()).append(",");
        value.append("'").append(tourist.getTouristTitle()).append("',");
        value.append("'").append(tourist.getTouristSummary()).append("',");
        value.append("'").append(tourist.getTouristBody()).append("',");
        value.append("'").append(tourist.getTouristImage()).append("',");
        value.append(tourist.getTouristPrice()).append(",");
        value.append(tourist.getTouristNumDay()).append(",");
        value.append(tourist.getTouristNumNight()).append(",");
        value.append(tourist.getTouristDate()).append(",");
        value.append(tourist.getTouristPublished());

        StringBuilder query=new StringBuilder();
        query.append("insert into ").append(Tourist.TableName);
        query.append(" (").append(input).append(")");
        query.append(" values (").append(value).append(")");
        if(this._conn.executeNoneQuery(query.toString())==true){
            tourist.setTouristId(this._conn.getNextId());
        }else
            tourist.setTouristId(Long.valueOf(0));
    }

    /*
     * Delete data
     */
    public boolean delTourist(Long tourist_id){
        StringBuilder condition=new StringBuilder();
        condition.append(Tourist.TouristId).append("=").append(tourist_id);

        StringBuilder query=new StringBuilder();
        query.append("delete from ").append(Tourist.TableName);
        query.append(" where ").append(condition);
        return this._conn.executeNoneQuery(query.toString());
    }

    /*
     * Update data
     */
    public boolean updateTourist(Tourist tourist){
        StringBuilder value=new StringBuilder();
        value.append(Tourist.CategoryId).append("=").append(tourist.getCategoryId()).append(",");
        value.append(Tourist.TouristTitle).append("='").append(tourist.getTouristTitle()).append("',");
        value.append(Tourist.TouristSummary).append("='").append(tourist.getTouristSummary()).append("',");
        value.append(Tourist.TouristBody).append("='").append(tourist.getTouristBody()).append("',");
        value.append(Tourist.TouristImage).append("='").append(tourist.getTouristImage()).append("',");
        value.append(Tourist.TouristPrice).append("=").append(tourist.getTouristPrice()).append(",");
        value.append(Tourist.TouristNumDay).append("=").append(tourist.getTouristNumDay()).append(",");
        value.append(Tourist.TouristNumNight).append("=").append(tourist.getTouristNumNight()).append(",");
        value.append(Tourist.TouristPublished).append("=").append(tourist.getTouristPublished());

        StringBuilder condition=new StringBuilder();
        condition.append(Tourist.TouristId).append("=").append(tourist.getTouristId());

        StringBuilder query=new StringBuilder();
        query.append("update ").append(Tourist.TableName);
        query.append(" set ").append(value);
        query.append(" where ").append(condition);

        return this._conn.executeNoneQuery(query.toString());
    }

    public boolean updateTouristByField(Long tourist_id,String value){
     
        StringBuilder condition=new StringBuilder();
        condition.append(Tourist.TouristId).append("=").append(tourist_id);

        StringBuilder query=new StringBuilder();
        query.append("update ").append(Tourist.TableName);
        query.append(" set ").append(value);
        query.append(" where ").append(condition);

        return this._conn.executeNoneQuery(query.toString());
    }
}
