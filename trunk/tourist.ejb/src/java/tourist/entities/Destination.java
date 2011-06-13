/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.entities;

/**
 *
 * @author VANGANH
 */
public class Destination {

    /*
     * Parameter
     */
    private Integer _destination_id;
    private Integer _town_id;
    private String _destination_name;
    private String _destination_image;
    
    /*
     * Contructor
     */
    public Destination(){}

    /*
     * Property
     */
    /*public static String TableName(){
        return "Destination";
    }*/

    public Integer getDestinationId(){
        return this._destination_id;
    }
    public void setDestinationId(Integer destination_id){
        this._destination_id=destination_id;
    }

    public Integer getTownId(){
        return this._town_id;
    }
    public void setTownId(Integer town_id){
        this._town_id=town_id;
    }

    public String getDestinationName(){
        return this._destination_name;
    }
    public void setDestinationName(String destination_name){
        this._destination_name=destination_name;
    }

    public String getDestinationImage(){
        return this._destination_image;
    }
    public void setDestinationImage(String destination_image){
        this._destination_image=destination_image;
    }

    /*
     * Field Name
     */
    public static final String TableName="tourist.Destination";
    public static final String DestinationId="DestinationId";
    public static final String TownId="TownId";
    public static final String DestinationName="DestinationName";
    public static final String DestinationImage="DestinationImage";
}
