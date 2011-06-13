/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.business;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import tourist.entities.Comment;
import tourist.entities.ListComment;
import tourist.data.CommentDAO;

/**
 *
 * @author VANGANH
 */
@Stateless
@LocalBean
public class CommnentService {
    
    /*
     * Get data
     */
    public static ListComment getListComment(Long tourist_id){
        CommentDAO commentdao=CommentDAO.getInstance();
        return commentdao.getListComment(tourist_id);
    }

    /*
     * Add data
     */
    public static boolean addComment(Comment comment){
       CommentDAO commentdao=CommentDAO.getInstance();
       comment.setCommentDate(Utility.parseDateToLong());
       commentdao.setComment(comment);
       if(comment.getCommentId()!=0)
            return true;
       return false;
    }

    /*
     * Remove data
     */
    public static boolean removeComment(Long comment_id){
        CommentDAO commentdao=CommentDAO.getInstance();
        return commentdao.delComment(comment_id);
    }
 
}
