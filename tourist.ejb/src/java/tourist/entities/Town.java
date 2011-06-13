/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.entities;

/**
 *
 * @author VANGANH
 */
public class Town {

    /*
     * Parameter
     */
    private Integer _town_id;
    private Integer _nation_id;
    private String _town_name;

    /*
     * Contructor
     */
    public Town(){}

    /*
     * Property
     */
    /*public static String TableName(){
        return "Town";
    }*/

    public Integer getTownId(){
        return this._town_id;
    }
    public void setTownId(Integer town_id){
        this._town_id=town_id;
    }

    public Integer getNationId(){
        return this._nation_id;
    }
    public void setNationId(Integer nation_id){
        this._nation_id=nation_id;
    }

    public String getTownName(){
        return this._town_name;
    }
    public void setTownName(String town_name){
        this._town_name=town_name;
    }

    /*
     * Field Name
     */
    public static final String TableName="tourist.Town";
    public static final String TownId="TownId";
    public static final String NationId="NationId";
    public static final String TownName="TownName";
}
