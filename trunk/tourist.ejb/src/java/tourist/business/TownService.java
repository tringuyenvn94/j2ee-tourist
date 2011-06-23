/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.business;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import tourist.entities.Town;
import tourist.entities.ListTown;
import tourist.data.TownDAO;
import tourist.entities.ListDestination;

/**
 *
 * @author VANGANH
 */
@Stateless
@LocalBean
public class TownService {
    
    /*
     * Get data
     */
    public static Town getTown(Integer town_id){
        Town town=null;
        TownDAO towndao=TownDAO.getInstance();
        town=towndao.getTown(town_id);
        if(town==null)
            town=new Town();
        return town;
    }

    public static ListTown getListTown(Integer nation_id){
        TownDAO towndao=TownDAO.getInstance();
        return towndao.getListTown(nation_id);
    }

    public static ListTown getListTown(ListDestination listdestination){
        ListTown listtown=new ListTown();
        TownDAO towndao=TownDAO.getInstance();
        for(int index=0;index<listdestination.size();index++){
            listtown.add(towndao.getTown(listdestination.get(index).getTownId()));
        }
        return listtown;
    }

    /*
     * Add data
     */
    public static boolean addTown(Town town){
        TownDAO towndao=TownDAO.getInstance();
        towndao.setTown(town);
        if(town.getTownId()!=0)
            return true;
        return false;
    }

    /*
     * Remove data
     */
    public static boolean removeTown(Integer town_id){
        TownDAO towndao=TownDAO.getInstance();
        return towndao.delTown(town_id);
    }

    /*
     * Update data
     */
    public static boolean updateTown(Town town){
        TownDAO towndao=TownDAO.getInstance();
        return towndao.updateTown(town);
    } 
}
