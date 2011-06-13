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
