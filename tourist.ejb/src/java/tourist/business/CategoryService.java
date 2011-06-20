/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.business;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import tourist.entities.Category;
import tourist.entities.ListCategory;
import tourist.data.CategoryDAO;
import tourist.entities.ListArticle;
import tourist.entities.ListTourist;
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

    public static ListCategory getListCategory(Integer currpage,Integer pagesize,Long totalrecord){
        StringBuilder fieldname=new StringBuilder();
        fieldname.append(Category.CategoryId).append(",");
        fieldname.append(Category.CategoryName).append(",");
        fieldname.append(Category.CategoryParentId).append(",");
        fieldname.append(Category.CategoryPublished).append(",");
        fieldname.append(Category.CategoryType);

        StringBuilder condition=new StringBuilder();
        condition.append(1);

        CategoryDAO categorydao=CategoryDAO.getInstance();
        return categorydao.getListCategory(fieldname.toString(),condition.toString(), currpage, pagesize, totalrecord, "");
    }

    public static ListCategory getListCategory(List<Integer> listid){
        ListCategory listcategory=new ListCategory();
        CategoryDAO categorydao=CategoryDAO.getInstance();
        for(int index=0;index<listid.size();index++){
            listcategory.add(categorydao.getCategory(listid.get(index)));
        }
        return listcategory;
    }

    public static ListCategory getListCategory(ListArticle listarticle){
        ListCategory listcategory=new ListCategory();
        CategoryDAO categorydao=CategoryDAO.getInstance();
        for(int index=0;index<listarticle.size();index++){
            listcategory.add(categorydao.getCategory(listarticle.get(index).getCategoryId()));
        }
        return listcategory;
    }

    public static ListCategory getListCategory(ListTourist listtourist){
        ListCategory listcategory=new ListCategory();
        CategoryDAO categorydao=CategoryDAO.getInstance();
        for(int index=0;index<listtourist.size();index++){
            listcategory.add(categorydao.getCategory(listtourist.get(index).getCategoryId()));
        }
        return listcategory;
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

    public static List<String> getListCategoryType(ListCategory listcategory){
        List<String> listcategorytype = new ArrayList<String>();
        for(int index=0;index<listcategory.size();index++){
            if(listcategory.get(index).getCategoryType()==1){
                listcategorytype.add("Tin tức");
            }else
                listcategorytype.add("Du lịch");
        }
        return listcategorytype;
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
