/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.business;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import tourist.entities.Tourist;
import tourist.entities.ListTourist;
import tourist.data.TouristDAO;

/**
 *
 * @author VANGANH
 */
@Stateless
@LocalBean
public class TouristService {
    
    /*
     * Get data
     */
    public static Tourist getTourist(Long tourist_id){
        Tourist tourist=null;
        TouristDAO touristdao=TouristDAO.getInstance();
        tourist=touristdao.getTourist(tourist_id);
        if(tourist==null)
            tourist=new Tourist();
        return tourist;
    }

    public static ListTourist getListTouristByCategory(Integer category_id,Integer currpage,Integer pagesize,Long totalrecord){
        StringBuilder fieldname=new StringBuilder();
        fieldname.append(Tourist.TouristId).append(",");
        fieldname.append(Tourist.TouristTitle).append(",");
        fieldname.append(Tourist.TouristSummary).append(",");
        fieldname.append(Tourist.TouristImage).append(",");
        fieldname.append(Tourist.TouristNumDay).append(",");
        fieldname.append(Tourist.TouristNumNight).append(",");
        fieldname.append(Tourist.TouristPrice);

        StringBuilder condition=new StringBuilder();
        condition.append(Tourist.CategoryId).append("=").append(category_id);
        condition.append(" and ").append(Tourist.TouristPublished).append("=").append(1);

        StringBuilder order=new StringBuilder();
        order.append(Tourist.TouristDate).append(" DESC");

        TouristDAO touristdao=TouristDAO.getInstance();
        return touristdao.getListTourist(fieldname.toString(), condition.toString(), currpage, pagesize, totalrecord, order.toString());
    }

    public static ListTourist getListTouristByLastest(Integer pagesize){
        StringBuilder fieldname=new StringBuilder();
        fieldname.append(Tourist.TouristId).append(",");
        fieldname.append(Tourist.TouristTitle).append(",");
        fieldname.append(Tourist.TouristSummary).append(",");
        fieldname.append(Tourist.TouristImage).append(",");
        fieldname.append(Tourist.TouristNumDay).append(",");
        fieldname.append(Tourist.TouristNumNight).append(",");
        fieldname.append(Tourist.TouristPrice);

        StringBuilder condition=new StringBuilder();
        condition.append(Tourist.TouristPublished).append("=").append(1);

        StringBuilder order=new StringBuilder();
        order.append(Tourist.TouristDate).append(" DESC");

        TouristDAO touristdao=TouristDAO.getInstance();
        return touristdao.getListTourist(fieldname.toString(), condition.toString(), 1, pagesize, Long.valueOf(0), order.toString());
    }

    /*
     * Add data
     */
    public static boolean addTourist(Tourist tourist){
        tourist.setTouristDate(Utility.parseDateToLong());

        TouristDAO touristdao=TouristDAO.getInstance();
        touristdao.setTourist(tourist);
        if(tourist.getTouristId()!=0)
            return true;
        return false;
    }

    /*
     * Remove data
     */
    public static boolean removeTourist(Long tourist_id){
        TouristDAO touristdao=TouristDAO.getInstance();
        return touristdao.delTourist(tourist_id);
    }

    /*
     * Update data
     */
    public static boolean updateTourist(Tourist tourist){
        TouristDAO touristdao=TouristDAO.getInstance();
        return touristdao.updateTourist(tourist);
    }

    public static boolean updateTouristPublished(Long tourist_id,Integer published){
        StringBuilder value=new StringBuilder();
        value.append(Tourist.TouristPublished).append("=").append(published);
        TouristDAO touristdao=TouristDAO.getInstance();
        return touristdao.updateTouristByField(tourist_id,value.toString());
    } 
}
