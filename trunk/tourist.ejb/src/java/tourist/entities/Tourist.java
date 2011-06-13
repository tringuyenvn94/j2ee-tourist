/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.entities;

/**
 *
 * @author VANGANH
 */
public class Tourist {

    /*
     * Parameter
     */
    private Long _tourist_id;
    private Integer _category_id;
    private String _tourist_title;
    private String _tourist_image;
    private String _tourist_summary;
    private String _tourist_body;
    private Double _tourist_price;
    private Integer _tourist_num_day;
    private Integer _tourist_num_night;
    private Long _tourist_date;
    private Integer _tourist_published;

    /*
     * Contructor
     */
    public Tourist(){}

    /*
     * Property
     */
    public Long getTouristId(){
        return this._tourist_id;
    }
    public void setTouristId(Long tourist_id){
        this._tourist_id=tourist_id;
    }

    public Integer getCategoryId(){
        return this._category_id;
    }
    public void setCategoryId(Integer category_id){
        this._category_id=category_id;
    }

    public String getTouristTitle(){
        return this._tourist_title;
    }
    public void setTouristTitle(String tourist_title){
        this._tourist_title=tourist_title;
    }

    public String getTouristImage(){
        return this._tourist_image;
    }
    public void setTouristImage(String tourist_image){
        this._tourist_image=tourist_image;
    }

    public String getTouristSummary(){
        return this._tourist_summary;
    }
    public void setTouristSummary(String tourist_summary){
        this._tourist_summary=tourist_summary;
    }

    public String getTouristBody(){
        return this._tourist_body;
    }
    public void setTouristBody(String tourist_body){
        this._tourist_body=tourist_body;
    }

    public Double getTouristPrice(){
        return this._tourist_price;
    }
    public void setTouristPrice(Double tourist_price){
        this._tourist_price=tourist_price;
    }

    public Integer getTouristNumDay(){
        return this._tourist_num_day;
    }
    public void setTouristNumDay(Integer tourist_num_day){
        this._tourist_num_day=tourist_num_day;
    }

    public Integer getTouristNumNight(){
        return this._tourist_num_night;
    }
    public void setTouristNumNight(Integer tourist_num_night){
        this._tourist_num_night=tourist_num_night;
    }

    public Long getTouristDate(){
        return this._tourist_date;
    }
    public void setTouristDate(Long tourist_date){
        this._tourist_date=tourist_date;
    }

    public Integer getTouristPublished(){
        return this._tourist_published;
    }
    public void setTouristPublished(Integer tourist_published){
        this._tourist_published=tourist_published;
    }

    /*
     * Field Name
     */
    public static final String TableName="tourist.Tourist";
    public static final String TouristId="TouristId";
    public static final String CategoryId="CategoryId";
    public static final String TouristTitle="TouristTitle";
    public static final String TouristImage="TouristImage";
    public static final String TouristSummary="TouristSummary";
    public static final String TouristBody="TouristBody";
    public static final String TouristPrice="TouristPrice";
    public static final String TouristNumDay="TouristNumDay";
    public static final String TouristNumNight="TouristNumNight";
    public static final String TouristDate="TouristDate";
    public static final String TouristPublished="TouristPublished";
}
