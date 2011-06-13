/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.business;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import tourist.entities.Registration;
import tourist.entities.ListRegistration;
import tourist.data.RegistrationDAO;

/**
 *
 * @author VANGANH
 */
@Stateless
@LocalBean
public class RegistrationService {
    
    /*
     * Get data
     */
    public static Registration getRegistration(Long registration_id){
        Registration registration=null;
        RegistrationDAO registrationdao=RegistrationDAO.getInstance();
        registration=registrationdao.getRegistration(registration_id);
        if(registration==null)
            registration=new Registration();
        return registration;
    }

    public static ListRegistration getListRegistration(Long tourist_id,Integer currpage, Integer pagesize,Long totalrecord,Integer approved){
        StringBuilder fieldname=new StringBuilder();
        fieldname.append(Registration.TouristId).append(",");
        fieldname.append(Registration.RegistrationUserName).append(",");
        fieldname.append(Registration.RegistrationUserPhone).append(",");
        fieldname.append(Registration.RegistrationUserEmail);

        StringBuilder condition=new StringBuilder();
        condition.append(1);
        if(tourist_id>0){
            condition.append(" and ").append(Registration.TouristId).append("=").append(tourist_id);
        }
        if(approved>-1){
            condition.append(" and ").append(Registration.RegistrationApproved).append("=").append(approved);
        }

        StringBuilder order=new StringBuilder();
        order.append(Registration.RegistrationDate).append(" DESC");

        RegistrationDAO registrationdao=RegistrationDAO.getInstance();
        return registrationdao.getListRegistration(fieldname.toString(), condition.toString(), currpage, pagesize, totalrecord, order.toString());
    }

    /*
     * Add data
     */
    public static boolean addRegistration(Registration registration){
        registration.setRegistrationDate(Utility.parseDateToLong());
        RegistrationDAO registrationdao=RegistrationDAO.getInstance();
        registrationdao.setRegistration(registration);
        if(registration.getRegistrationId()!=0)
            return true;
        return false;
    }

    /*
     * Remove data
     */
    public static boolean removeRegistration(Long registration_id){
        RegistrationDAO registrationdao=RegistrationDAO.getInstance();
        return registrationdao.delRegistration(registration_id);
    }

    /*
     * Update data
     */
    public static boolean updateRegistration(Registration registration){
        RegistrationDAO registrationdao=RegistrationDAO.getInstance();
        return registrationdao.updateRegistration(registration);
    }

    public static boolean updateRegistrationApproved(Long registration_id,Integer approved){
        StringBuilder fieldname=new StringBuilder();
        fieldname.append(Registration.RegistrationApproved).append("=").append(approved);

        RegistrationDAO registrationdao=RegistrationDAO.getInstance();
        return registrationdao.updateRegistrationByField(registration_id,fieldname.toString());
    }
 
}
