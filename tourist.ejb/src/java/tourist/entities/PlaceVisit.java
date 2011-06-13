/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.entities;

/**
 *
 * @author VANGANH
 */
public class PlaceVisit {

    /*
     * Parameter
     */
    private Long _place_visit_id;
    private Long _tourist_id;
    private Integer _destination_id;    
    private Integer _place_visit_ordering;

    /*
     * Contructor
     */
    /*public static String TableName(){
        return "PlaceVisit";
    }*/

    public Long getPlaceVisitId(){
        return this._place_visit_id;
    }
    public void setPlaceVisitId(Long place_visit_id){
        this._place_visit_id=place_visit_id;
    }

    public Long getTouristId(){
        return this._tourist_id;
    }
    public void setTouristId(Long tourist_id){
        this._tourist_id=tourist_id;
    }

    public Integer getDestinationId(){
        return this._destination_id;
    }
    public void setDestinationId(Integer destination_id){
        this._destination_id=destination_id;
    }

    public Integer getPlaceVisitOrdering(){
        return this._place_visit_ordering;
    }
    public void setPlaceVisitOrdering(Integer place_visit_ordering){
        this._place_visit_ordering=place_visit_ordering;
    }

    /*
     * Field Name
     */
    public static final String TableName="tourist.PlaceVisit";
    public static final String PlaceVisitId="PlaceVisitId";
    public static final String TouristId="TouristId";
    public static final String DestinationId="DestinationId";
    public static final String PlaceVisitOrdering="PlaceVisitOrdering";
}

