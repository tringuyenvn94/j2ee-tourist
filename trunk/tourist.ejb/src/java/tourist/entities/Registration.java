/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.entities;

/**
 *
 * @author VANGANH
 */
public class Registration {

    /*
     * Parameter
     */
    private Long _registration_id;
    private Long _tourist_id;
    private String _registration_user_name;
    private String _registration_user_code;
    private String _registration_user_address;
    private String _registration_user_phone;
    private String _registration_user_email;
    private Integer _registration_num_member;
    private Long _registration_date_start;
    private Long _registration_date;
    private Integer _registration_approved;

    /*
     * Contructor
     */
    public Registration(){}

    /*
     * Property
     */
    /*public static String TableName(){
        return "Registration";
    }*/

    public Long getRegistrationId(){
        return this._registration_id;
    }
    public void setRegistrationId(Long registration_id){
        this._registration_id=registration_id;
    }

    public Long getTouristId(){
        return this._tourist_id;
    }
    public void setTouristId(Long tourist_id){
        this._tourist_id=tourist_id;
    }

    public String getRegistrationUserName(){
        return this._registration_user_name;
    }
    public void setRegistrationUserName(String registration_user_name){
        this._registration_user_name=registration_user_name;
    }

    public String getRegistrationUserCode(){
        return this._registration_user_code;
    }
    public void setRegistrationUserCode(String registration_user_code){
        this._registration_user_code=registration_user_code;
    }

    public String getRegistrationUserAddress(){
        return this._registration_user_address;
    }
    public void setRegistrationUserAddress(String registration_user_address){
        this._registration_user_address=registration_user_address;
    }

    public String getRegistrationUserPhone(){
        return this._registration_user_phone;
    }
    public void setRegistrationUserPhone(String registration_user_phone){
        this._registration_user_phone=registration_user_phone;
    }

    public String getRegistrationUserEmail(){
        return this._registration_user_email;
    }
    public void setRegistrationUserEmail(String registration_user_email){
        this._registration_user_email=registration_user_email;
    }

    public Integer getRegistrationNumMember(){
        return this._registration_num_member;
    }
    public void setRegistrationNumMember(Integer registration_num_member){
        this._registration_num_member=registration_num_member;
    }

    public Long getRegistrationDateStart(){
        return this._registration_date_start;
    }
    public void setRegistrationDateStart(Long registration_date_start){
        this._registration_date_start=registration_date_start;
    }

    public Long getRegistrationDate(){
        return this._registration_date;
    }
    public void setRegistrationDate(Long registration_date){
        this._registration_date=registration_date;
    }

    public Integer getRegistrationApproved(){
        return this._registration_approved;
    }
    public void setRegistrationApproved(Integer registration_approved){
        this._registration_approved=registration_approved;
    }

    /*
     * Field Name
     */
    public static final String TableName="tourist.Registration";
    public static final String RegistrationId="RegistrationId";
    public static final String TouristId="TouristId";
    public static final String RegistrationUserName="RegistrationUserName";
    public static final String RegistrationUserCode="RegistrationUserCode";
    public static final String RegistrationUserAddress="RegistrationUserAddress";
    public static final String RegistrationUserPhone="RegistrationUserPhone";
    public static final String RegistrationUserEmail="RegistrationUserEmail";
    public static final String RegistrationNumMember="RegistrationNumMember";
    public static final String RegistrationDateStart="RegistrationDateStart";
    public static final String RegistrationDate="RegistrationDate";
    public static final String RegistrationApproved="RegistrationApproved";
}
