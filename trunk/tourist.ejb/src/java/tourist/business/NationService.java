/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.business;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import tourist.entities.Nation;
import tourist.entities.ListNation;
import tourist.data.NationDAO;
/**
 *
 * @author VANGANH
 */
@Stateless
@LocalBean
public class NationService {
    
    /*
     * Get data
     */
    public static Nation getNation(Integer nation_id){
        Nation nation=null;
        NationDAO nationdao=NationDAO.getInstance();
        nation=nationdao.getNation(nation_id);
        if(nation==null)
            nation=new Nation();
        return nation;
    }

    public static ListNation getListNation(){
        NationDAO nationdao=NationDAO.getInstance();
        return nationdao.getListNation();
    }

    /*
     * Add data
     */
    public static boolean addNation(Nation nation){
        NationDAO nationdao=NationDAO.getInstance();
        nationdao.setNation(nation);
        if(nation.getNationId()!=0)
            return true;
        return false;
    }

    /*
     * Remove data
     */
    public static boolean removeNation(Integer nation_id){
        NationDAO nationdao=NationDAO.getInstance();
        return nationdao.delNation(nation_id);
    }

    /*
     * Update data
     */
    public static boolean updateNation(Nation nation){
        NationDAO nationdao=NationDAO.getInstance();
        return nationdao.updateNation(nation);
    }
 
}
