/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.entities;

/**
 *
 * @author VANGANH
 */
public class Comment {

    /*
     * Parmaeter
     */
    private Long _comment_id;
    private Long _tourist_id;
    private String _comment_title;
    private String _comment_body;
    private Long _comment_date;
    private String _comment_user_name;
    private String _comment_user_email;

    /*
     * Contructor
     */
    public Comment(){}

    /*
     * Property
     */
    /*public static  String TableName(){
        return "Comment";
    }*/

    public Long getCommentId(){
        return this._comment_id;
    }
    public void setCommentId(Long comment_id){
        this._comment_id=comment_id;
    }

    public Long getTouristId(){
        return this._tourist_id;
    }
    public void setTouristId(Long tourist_id){
        this._tourist_id=tourist_id;
    }

    public String getCommentTitle(){
        return this._comment_title;
    }
    public void setCommentTitle(String comment_title){
        this._comment_title=comment_title;
    }

    public String getCommentBody(){
        return this._comment_body;
    }
    public void setCommentBody(String comment_body){
        this._comment_body=comment_body;
    }

    public Long getCommentDate(){
        return this._comment_date;
    }
    public void setCommentDate(Long comment_date){
        this._comment_date=comment_date;
    }

    public String getCommentUserName(){
        return this._comment_user_name;
    }
    public void setCommentUserName(String comment_user_name){
        this._comment_user_name=comment_user_name;
    }

    public String getCommentUserEmail(){
        return this._comment_user_email;
    }
    public void setCommentUserEmail(String comment_user_email){
        this._comment_user_email=comment_user_email;
    }

    /*
     * Field Name
     */
    public static final String TableName="tourist.Comment";
    public static final String CommentId="CommentId";
    public static final String TouristId="TouristId";
    public static final String CommentTitle="CommentTitle";
    public static final String CommentBody="CommentBody";
    public static final String CommentDate="CommentDate";
    public static final String CommentUserName="CommentUserName";
    public static final String CommentUserEmail="CommentUserEmail";
}
