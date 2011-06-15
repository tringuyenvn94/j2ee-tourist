/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.entities;

/**
 *
 * @author VANGANH
 */
public class Category {

    /*
     * Parameter
     */
    private Integer _category_id;
    private Integer _category_parent_id;
    private String _category_name;
    private Integer _category_type;
    private Integer _category_published;
    private Integer _category_ordering;

    /*
     * Contructor
     */
    public Category(){}

    /*
     * Property
     */
    /*public static String TableName(){
        return "Category";
    }*/

    public Integer getCategoryId(){
         return this._category_id;
    }
    public void setCategoryId(Integer category_id){
        this._category_id=category_id;
    }

    public Integer getCategoryParentId(){
         return this._category_parent_id;
    }
    public void setCategoryParentId(Integer category_parent_id){
        this._category_parent_id=category_parent_id;
    }

    public String getCategoryName(){
         return this._category_name;
    }
    public void setCategoryName(String category_name){
        this._category_name=category_name;
    }

    public Integer getCategoryType(){
         return this._category_type;
    }
    public void setCategoryType(Integer category_type){
        this._category_type=category_type;
    }

    public Integer getCategoryPublished(){
         return this._category_published;
    }
    public void setCategoryPublished(Integer category_published){
        this._category_published=category_published;
    }

    public Integer getCategoryOrdering(){
         return this._category_ordering;
    }
    public void setCategoryOrdering(Integer category_ordering){
        this._category_ordering=category_ordering;
    }

    /*
     * Field Name
     */
    public static final String TableName="tourist.Category";
    public static final String CategoryId="CategoryId";
    public static final String CategoryParentId="CategoryParentId";
    public static final String CategoryName="CategoryName";
    public static final String CategoryType="CategoryType";
    public static final String CategoryOrdering="CategoryOrdering";
    public static final String CategoryPublished="CategoryPublished";
}
