/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.data;

/**
 *
 * @author VANGANH
 */
import tourist.entities.Category;
import tourist.entities.ListCategory;
import java.sql.*;

public class CategoryDAO {

    private static CategoryDAO _instance;
    private Connector _conn;

    /*
     * Contructor
     */
    private CategoryDAO(){
        this._conn=Connector.getInstance();
    }
    public static CategoryDAO getInstance(){
        if(_instance==null){
            _instance=new CategoryDAO();
        }
        return _instance;
    }

    /*
     * Initial data
     */
    private Category initCategory(ResultSet rs){
        Category categoty=new Category();
        try{
            categoty.setCategoryId(rs.getInt(Category.CategoryId));
        }catch(SQLException sqle){
            categoty.setCategoryId(0);
        }
        try{
            categoty.setCategoryParentId(rs.getInt(Category.CategoryParentId));
        }catch(SQLException sqle){
            categoty.setCategoryParentId(0);
        }
        try{
            categoty.setCategoryName(rs.getString(Category.CategoryName));
        }catch(SQLException sqle){
            categoty.setCategoryName("");
        }
        try{
            categoty.setCategoryType(rs.getInt(Category.CategoryType));
        }catch(SQLException sqle){
            categoty.setCategoryType(0);
        }
        try{
            categoty.setCategoryPublished(rs.getInt(Category.CategoryPublished));
        }catch(SQLException sqle){
            categoty.setCategoryPublished(0);
        }
        try{
            categoty.setCategoryOrdering(rs.getInt(Category.CategoryOrdering));
        }catch(SQLException sqle){
            categoty.setCategoryOrdering(0);
        }
        return categoty;
    }

    /*
     * Get data
     */
    public Category getCategory(Integer category_id) {
        Category category=null;

        StringBuilder output=new StringBuilder();
        output.append(Category.CategoryId).append(",");
        output.append(Category.CategoryParentId).append(",");
        output.append(Category.CategoryName).append(",");
        output.append(Category.CategoryType).append(",");
        output.append(Category.CategoryPublished).append(",");
        output.append(Category.CategoryOrdering);

        StringBuilder condition=new StringBuilder();
        condition.append(Category.CategoryId+"=").append(category_id);

        StringBuilder query=new StringBuilder();
        query.append("select ").append(output);
        query.append(" from ").append(Category.TableName);
        query.append(" where ").append(condition);

        ResultSet rs=this._conn.executeQuery(query.toString());
        try{
            if(rs!=null&&rs.next()){
                category=this.initCategory(rs);
            }
        }catch(SQLException sqle){
            category=null;
        }
        return category;
    }

    public ListCategory getListCategory(){
        ListCategory listcategory=new ListCategory();
        Category category=null;

        StringBuilder output=new StringBuilder();
        output.append(Category.CategoryId).append(",");
        output.append(Category.CategoryParentId).append(",");
        output.append(Category.CategoryName).append(",");
        output.append(Category.CategoryType);

        StringBuilder condition=new StringBuilder();
        condition.append(Category.CategoryPublished).append("=1");

        StringBuilder order=new StringBuilder();
        order.append(Category.CategoryOrdering).append("ASC");

        StringBuilder query=new StringBuilder();
        query.append("select ").append(output);
        query.append(" from ").append(Category.TableName);
        query.append(" where ").append(condition);
        query.append(" order by ").append(order);

        ResultSet rs=this._conn.executeQuery(query.toString());
        try{
            if(rs!=null){
                while(rs.next()){
                    category=this.initCategory(rs);
                    listcategory.add(category);
                }
            }
        }catch(SQLException sqle){
            listcategory.clear();
        }
        return listcategory;
    }

    public ListCategory getListCategory(String fieldname,String condition, Integer currpage,Integer pagesize,Long totalrecord, String order){
        ListCategory listcategory=new ListCategory();
        Category category=null;

        totalrecord=this._conn.getTotalRecord(Category.TableName, condition);

        StringBuilder query=new StringBuilder();
        query.append("select ").append(fieldname);
        query.append(" from ").append(Category.TableName);
        query.append(" where ").append(condition);
        if(order!=null && !order.equals("")){
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
                    category=this.initCategory(rs);
                    listcategory.add(category);
                }
            }
        }catch(SQLException sqle){
            listcategory.clear();
        }
        return listcategory;
    }
    /*
     * Set data
     */
    public void setCategory(Category category){
        StringBuilder input=new StringBuilder();
        input.append(Category.CategoryParentId).append(",");
        input.append(Category.CategoryName).append(",");
        input.append(Category.CategoryType).append(",");
        input.append(Category.CategoryPublished).append(",");
        input.append(Category.CategoryOrdering);

        StringBuilder value=new StringBuilder();
        value.append(category.getCategoryParentId()).append(",");
        value.append("'").append(category.getCategoryName()).append("',");
        value.append(category.getCategoryType()).append(",");
        value.append(category.getCategoryPublished()).append(",");
        value.append(category.getCategoryOrdering());

        StringBuilder query=new StringBuilder();
        query.append("insert into ").append(Category.TableName);
        query.append(" (").append(input).append(")");
        query.append(" values (").append(value).append(")");
        if(this._conn.executeNoneQuery(query.toString())==true){
            category.setCategoryId(this._conn.getNextId().intValue());
        }else
            category.setCategoryId(0);
    }

    /*
     * Delete data
     */
    public boolean delCategory(Integer category_id){
        StringBuilder condition=new StringBuilder();
        condition.append(Category.CategoryId).append("=").append(category_id);

        StringBuilder query=new StringBuilder();
        query.append("delete from ").append(Category.TableName);
        query.append(" where ").append(condition);
        return this._conn.executeNoneQuery(query.toString());
    }

    /*
     * Update data
     */
    public boolean updateCategory(Category category){
        StringBuilder value=new StringBuilder();
        value.append(Category.CategoryParentId).append("=").append(category.getCategoryParentId()).append(",");
        value.append(Category.CategoryName).append("='").append(category.getCategoryName()).append("',");
        value.append(Category.CategoryType).append("=").append(category.getCategoryType()).append(",");
        value.append(Category.CategoryPublished).append("=").append(category.getCategoryPublished()).append(",");
        value.append(Category.CategoryOrdering).append("=").append(category.getCategoryOrdering());

        StringBuilder condition=new StringBuilder();
        condition.append(Category.CategoryId).append("=").append(category.getCategoryId());

        StringBuilder query=new StringBuilder();
        query.append("update ").append(Category.TableName);
        query.append(" set ").append(value);
        query.append(" where ").append(condition);

        return this._conn.executeNoneQuery(query.toString());
    }
}
