/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.business;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import tourist.entities.PlaceVisit;
import tourist.data.PlaceVisitDAO;
/**
 *
 * @author VANGANH
 */
@Stateless
@LocalBean
public class PlaceVisitService {
    
    public static boolean addPlaceVisit(PlaceVisit placevisit){
        PlaceVisitDAO placevisitdao=PlaceVisitDAO.getInstance();
        placevisitdao.setPlaceVisit(placevisit);
        if(placevisit.getPlaceVisitId()!=0)
            return true;
        return false;
    }

    /*
     * Remove data
     */
    public static boolean removePlaceVisitById(Long placevisit_id){
        PlaceVisitDAO placevisitdao=PlaceVisitDAO.getInstance();
        return placevisitdao.delPlaceVisitById(placevisit_id);
    }
    public static boolean removePlaceVisitByTourist(Long tourist_id){
        PlaceVisitDAO placevisitdao=PlaceVisitDAO.getInstance();
        return placevisitdao.delPlaceVisitByTourist(tourist_id);
    }

    /*
     * Update data
     */
    public static boolean updatePlaceVisit(PlaceVisit placevisit){
        PlaceVisitDAO placevisitdao=PlaceVisitDAO.getInstance();
        return placevisitdao.updatePlaceVisit(placevisit);
    }
 
}
