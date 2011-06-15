/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.business;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import tourist.entities.Category;
import tourist.entities.ListCategory;
import tourist.data.CategoryDAO;
/**
 *
 * @author VANGANH
 */
@Stateless
@LocalBean
public class CategoryService {
    
    /*
     * Get data
     */
    public static Category getCategory(Integer category_id){
        Category category=null;
        CategoryDAO categorydao=CategoryDAO.getInstance();
        category=categorydao.getCategory(category_id);
        if(category==null)
            category=new Category();
        return category;
    }

    public static ListCategory getListCategory(){
        CategoryDAO categorydao=CategoryDAO.getInstance();
        return categorydao.getListCategory();
    }

    public static ListCategory getListCategoryByArticle(Integer currpage,Integer pagesize,Long totalrecord){
        StringBuilder fieldname=new StringBuilder();
        fieldname.append(Category.CategoryId).append(",");
        fieldname.append(Category.CategoryName).append(",");
        fieldname.append(Category.CategoryParentId).append(",");
        fieldname.append(Category.CategoryPublished).append(",");
        fieldname.append(Category.CategoryType);

        StringBuilder condition=new StringBuilder();
        condition.append(Category.CategoryType).append("=").append(1);

        CategoryDAO categorydao=CategoryDAO.getInstance();
        return categorydao.getListCategory(fieldname.toString(),condition.toString(), currpage, pagesize, totalrecord, "");
    }

    public static ListCategory getListCategoryByTourist(Integer currpage,Integer pagesize,Long totalrecord){
        StringBuilder fieldname=new StringBuilder();
        fieldname.append(Category.CategoryId).append(",");
        fieldname.append(Category.CategoryName).append(",");
        fieldname.append(Category.CategoryParentId).append(",");
        fieldname.append(Category.CategoryPublished).append(",");
        fieldname.append(Category.CategoryType);

        StringBuilder condition=new StringBuilder();
        condition.append(Category.CategoryType).append("=").append(2);

        CategoryDAO categorydao=CategoryDAO.getInstance();
        return categorydao.getListCategory(fieldname.toString(),condition.toString(), currpage, pagesize, totalrecord, "");
    }

    /*
     * Add data
     */
    public static boolean addCategory(Category category){
        CategoryDAO categorydao=CategoryDAO.getInstance();
        categorydao.setCategory(category);
        if(category.getCategoryId()!=0)
            return true;
        return false;
    }

    /*
     * Remove data
     */
    public static boolean removeCategory(Integer category_id){
        CategoryDAO categorydao=CategoryDAO.getInstance();
        return categorydao.delCategory(category_id);
    }

    /*
     * Update data
     */
    public static boolean updateCategory(Category category){
        CategoryDAO categorydao=CategoryDAO.getInstance();
        return categorydao.updateCategory(category);
    }
 
}
