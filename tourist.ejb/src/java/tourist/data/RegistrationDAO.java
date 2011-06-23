/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.data;

/**
 *
 * @author VANGANH
 */
import tourist.entities.Registration;
import tourist.entities.ListRegistration;
import java.sql.*;

public class RegistrationDAO {

    private static RegistrationDAO _instance;
    private Connector _conn;

    /*
     * Contructor
     */
    private RegistrationDAO(){
        this._conn=Connector.getInstance();
    }
    public static RegistrationDAO getInstance(){
        if(_instance==null){
            _instance=new RegistrationDAO();
        }
        return _instance;
    }

    /*
     * Initial data
     */
    private Registration initRegistration(ResultSet rs){
        Registration registration=new Registration();
        try{
            registration.setRegistrationId(rs.getLong(Registration.RegistrationId));
        }catch(SQLException sqle){
            registration.setRegistrationId(Long.valueOf(0));
        }
        try{
            registration.setTouristId(rs.getLong(Registration.TouristId));
        }catch(SQLException sqle){
            registration.setTouristId(Long.valueOf(0));
        }
        try{
            registration.setRegistrationUserName(rs.getString(Registration.RegistrationUserName));
        }catch(SQLException sqle){
            registration.setRegistrationUserName("");
        }
        try{
            registration.setRegistrationUserCode(rs.getString(Registration.RegistrationUserCode));
        }catch(SQLException sqle){
            registration.setRegistrationUserCode("");
        }
        try{
            registration.setRegistrationUserAddress(rs.getString(Registration.RegistrationUserAddress));
        }catch(SQLException sqle){
            registration.setRegistrationUserAddress("");
        }
        try{
            registration.setRegistrationUserPhone(rs.getString(Registration.RegistrationUserPhone));
        }catch(SQLException sqle){
            registration.setRegistrationUserPhone("");
        }
        try{
            registration.setRegistrationUserEmail(rs.getString(Registration.RegistrationUserEmail));
        }catch(SQLException sqle){
            registration.setRegistrationUserEmail("");
        }
        try{
            registration.setRegistrationNumMember(rs.getInt(Registration.RegistrationNumMember));
        }catch(SQLException sqle){
            registration.setRegistrationNumMember(0);
        }
        try{
            registration.setRegistrationDateStart(rs.getLong(Registration.RegistrationDateStart));
        }catch(SQLException sqle){
            registration.setRegistrationDateStart(Long.valueOf(0));
        }
        try{
            registration.setRegistrationDate(rs.getLong(Registration.RegistrationDate));
        }catch(SQLException sqle){
            registration.setRegistrationDate(Long.valueOf(0));
        }
        try{
            registration.setRegistrationApproved(rs.getInt(Registration.RegistrationApproved));
        }catch(SQLException sqle){
            registration.setRegistrationApproved(0);
        }
        return registration;
    }

    /*
     * Get data
     */
    public Registration getRegistration(Long registration_id) {
        Registration registration=null;

        StringBuilder output=new StringBuilder();
        output.append(Registration.RegistrationId).append(",");
        output.append(Registration.TouristId).append(",");
        output.append(Registration.RegistrationUserName).append(",");
        output.append(Registration.RegistrationUserCode).append(",");
        output.append(Registration.RegistrationUserAddress).append(",");
        output.append(Registration.RegistrationUserPhone).append(",");
        output.append(Registration.RegistrationUserEmail).append(",");
        output.append(Registration.RegistrationNumMember).append(",");
        output.append(Registration.RegistrationDateStart).append(",");
        output.append(Registration.RegistrationDate).append(",");
        output.append(Registration.RegistrationApproved);

        StringBuilder condition=new StringBuilder();
        condition.append(Registration.RegistrationId).append("=").append(registration_id);

        StringBuilder query=new StringBuilder();
        query.append("select ").append(output);
        query.append(" from ").append(Registration.TableName);
        query.append(" where ").append(condition);

        ResultSet rs=this._conn.executeQuery(query.toString());
        try{
            if(rs!=null&&rs.next()){
                registration=this.initRegistration(rs);
            }
        }catch(SQLException sqle){
            registration=null;
        }
        return registration;
    }

    public ListRegistration getListRegistration(String fieldname,String condition,Integer currpage,Integer pagesize,Long totalrecord, String order){
        ListRegistration listregistration=new ListRegistration();
        Registration registration=null;

        totalrecord=this._conn.getTotalRecord(Registration.TableName, condition);
        
        StringBuilder query=new StringBuilder();
        query.append("select ").append(fieldname);
        query.append(" from ").append(Registration.TableName);
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
                    registration=this.initRegistration(rs);
                    listregistration.add(registration);
                }
            }
        }catch(SQLException sqle){
            listregistration.clear();
        }
        return listregistration;
    }

    /*
     * Set data
     */
    public void setRegistration(Registration registration){
        StringBuilder input=new StringBuilder();
        input.append(Registration.TouristId).append(",");
        input.append(Registration.RegistrationUserName).append(",");
        input.append(Registration.RegistrationUserCode).append(",");
        input.append(Registration.RegistrationUserAddress).append(",");
        input.append(Registration.RegistrationUserPhone).append(",");
        input.append(Registration.RegistrationUserEmail).append(",");
        input.append(Registration.RegistrationNumMember).append(",");
        input.append(Registration.RegistrationDateStart).append(",");
        input.append(Registration.RegistrationDate);

        StringBuilder value=new StringBuilder();
        value.append(registration.getTouristId()).append(",");
        value.append("'").append(registration.getRegistrationUserName()).append("',");
        value.append("'").append(registration.getRegistrationUserCode()).append("',");
        value.append("'").append(registration.getRegistrationUserAddress()).append("',");
        value.append("'").append(registration.getRegistrationUserPhone()).append("',");
        value.append("'").append(registration.getRegistrationUserEmail()).append("',");
        value.append(registration.getRegistrationNumMember()).append(",");
        value.append(registration.getRegistrationDateStart()).append(",");
        value.append(registration.getRegistrationDate());

        StringBuilder query=new StringBuilder();
        query.append("insert into ").append(Registration.TableName);
        query.append(" (").append(input).append(")");
        query.append(" values (").append(value).append(")");
        if(this._conn.executeNoneQuery(query.toString())==true){
            registration.setRegistrationId(this._conn.getNextId());
        }else
            registration.setRegistrationId(Long.valueOf(0));
    }

    /*
     * Delete data
     */
    public boolean delRegistration(Long registration_id){
        StringBuilder condition=new StringBuilder();
        condition.append(Registration.RegistrationId).append("=").append(registration_id);

        StringBuilder query=new StringBuilder();
        query.append("delete from ").append(Registration.TableName);
        query.append(" where ").append(condition);
        return this._conn.executeNoneQuery(query.toString());
    }

    /*
     * Update data
     */
    public boolean updateRegistration(Registration registration){
        StringBuilder value=new StringBuilder();
        value.append(Registration.TouristId).append("=").append(registration.getTouristId()).append(",");
        value.append(Registration.RegistrationUserName).append("='").append(registration.getRegistrationUserName()).append("',");
        value.append(Registration.RegistrationUserCode).append("='").append(registration.getRegistrationUserCode()).append("',");
        value.append(Registration.RegistrationUserAddress).append("='").append(registration.getRegistrationUserAddress()).append("',");
        value.append(Registration.RegistrationUserPhone).append("='").append(registration.getRegistrationUserPhone()).append("',");
        value.append(Registration.RegistrationUserEmail).append("='").append(registration.getRegistrationUserEmail()).append("',");
        value.append(Registration.RegistrationNumMember).append("=").append(registration.getRegistrationNumMember()).append(",");
        value.append(Registration.RegistrationDateStart).append("=").append(registration.getRegistrationDateStart()).append(",");
        value.append(Registration.RegistrationApproved).append("=").append(registration.getRegistrationApproved());

        StringBuilder condition=new StringBuilder();
        condition.append(Registration.RegistrationId).append("=").append(registration.getRegistrationId());

        StringBuilder query=new StringBuilder();
        query.append("update ").append(Registration.TableName);
        query.append(" set ").append(value);
        query.append(" where ").append(condition);

        return this._conn.executeNoneQuery(query.toString());
    }

    public boolean updateRegistrationByField(Long registration_id,String value){

        StringBuilder condition=new StringBuilder();
        condition.append(Registration.RegistrationId).append("=").append(registration_id);

        StringBuilder query=new StringBuilder();
        query.append("update ").append(Registration.TableName);
        query.append(" set ").append(value);
        query.append(" where ").append(condition);

        return this._conn.executeNoneQuery(query.toString());
    }
}
