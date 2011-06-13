/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.data;

/**
 *
 * @author VANGANH
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.naming.InitialContext;

public class Connector {

    private static Connector _instance;
    private Connection _conn;

    private Connector(){
        openConnection();
    }

    public static Connector getInstance(){
        if(_instance==null){
            _instance=new Connector();
        }
        return _instance;
    }

    private void openConnection(){
        try{
            if(_conn==null)
            {
                DataSource datasource= (DataSource) new InitialContext().lookup("jdbc/tourist");
                _conn=datasource.getConnection();
            }
        }catch(Exception ex){
            _conn=null;
        }
    }

    private void closeConnection(){
        try{
            if(_conn!=null)
                _conn.close();
        }catch(Exception e){
            
        }
    }
    
    @Override
    protected void finalize(){
        try {
            super.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConnection();
    }

    public boolean executeNoneQuery(String query){
        int row=0;
        try {
            this.openConnection();
            PreparedStatement prst = this._conn.prepareStatement(query);
            row=prst.executeUpdate();
            if(row!=0)
                return true;
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }

    public ResultSet executeQuery(String query){
        try {
            this.openConnection();
            PreparedStatement prst = this._conn.prepareStatement(query);
            ResultSet rs=prst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }

    public Long getTotalRecord(String tablename,String condition){
        Long totalrecord= new Long(0);
        StringBuilder query=new StringBuilder();
        query.append("select count(*) from ");
        query.append(tablename);
        query.append(" where ");
        query.append(condition);
        ResultSet result=this.executeQuery(query.toString());
        try{
            if(result!=null && result.next()){
                totalrecord=result.getLong(1);
            }
        }catch(SQLException sqle){
            return totalrecord;
        }
        return totalrecord;
    }
    
    public Long getNextId(){
        StringBuilder query=new StringBuilder();
        query.append("select LAST_INSERT_ID()");
        ResultSet result=this.executeQuery(query.toString());
        try{
            if(result!=null && result.next()){
                return result.getLong(1);
            }
        }catch(SQLException sqle){
            return null;
        }
        return null;
    }

    public void checkPage(Integer currpage,Integer pagesize,Long totalrecord){
        if(pagesize<1)
                pagesize=1;
        if(currpage<1){
            currpage=1;
        }else{            
            Long totalpage=(totalrecord/pagesize);
            totalpage=totalpage+(totalrecord%pagesize);
            if(currpage>totalpage)
                currpage=totalpage.intValue();
        }
    }
}
