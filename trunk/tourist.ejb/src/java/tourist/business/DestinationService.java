/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.business;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import tourist.entities.Destination;
import tourist.entities.ListDestination;
import tourist.data.DestinationDAO;
/**
 *
 * @author VANGANH
 */
@Stateless
@LocalBean
public class DestinationService {
    
    /*
     * Get data
     */
    public static Destination getDestination(Integer destination_id){
        Destination destination=null;
        DestinationDAO destinationdao=DestinationDAO.getInstance();
        destination=destinationdao.getDestination(destination_id);
        if(destination==null)
            destination=new Destination();
        return destination;
    }

    public static ListDestination getListDestinationByTown(Integer town_id){
        DestinationDAO destinationdao=DestinationDAO.getInstance();
        return destinationdao.getListDestinationByTown(town_id);
    }

    public static ListDestination getListDestinationByTourist(Long tourist_id){
        DestinationDAO destinationdao=DestinationDAO.getInstance();
        return destinationdao.getListDestinationByTourist(tourist_id);
    }

    /*
     * Add data
     */
    public static boolean addDestination(Destination destination){
        DestinationDAO destinationdao=DestinationDAO.getInstance();
        destinationdao.setDestination(destination);
        if(destination.getDestinationId()!=0)
            return true;
        return false;
    }

    /*
     * Remove data
     */
    public static boolean removeDestination(Integer destination_id){
        DestinationDAO destinationdao=DestinationDAO.getInstance();
        return destinationdao.delDestination(destination_id);
    }

    /*
     * Update data
     */
    public static boolean updateDestination(Destination destination){
        DestinationDAO destinationdao=DestinationDAO.getInstance();
        return destinationdao.updateDestination(destination);
    }
 
}
