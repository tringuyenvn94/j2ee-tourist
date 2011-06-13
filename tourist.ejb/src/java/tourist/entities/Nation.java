/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.entities;

/**
 *
 * @author VANGANH
 */

public class Nation {

    /*
     * Parameter
     */
    private Integer _nation_id;
    private String _nation_name;

    /*
     * Contructor
     */
    public Nation(){}

    /*
     * Property
     */
    /*public static String TableName(){
        return "Nation";
    }*/

    public Integer getNationId(){
        return this._nation_id;
    }
    public void setNationId(Integer nation_id){
        this._nation_id=nation_id;
    }

    public String getNationName(){
        return this._nation_name;
    }
    public void setNationName(String nation_name){
        this._nation_name=nation_name;
    }

    /*
     * Field Name
     */
    public static final String TableName="tourist.Nation";
    public static final String NationId="NationId";
    public static final String NationName="NationName";

}