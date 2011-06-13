/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.data;

/**
 *
 * @author VANGANH
 */
import tourist.entities.Comment;
import tourist.entities.ListComment;
import java.sql.*;

public class CommentDAO {

    private static CommentDAO _instance;
    private Connector _conn;

    /*
     * Contructor
     */
    private CommentDAO(){
        this._conn=Connector.getInstance();
    }
    public static CommentDAO getInstance(){
        if(_instance==null){
            _instance=new CommentDAO();
        }
        return _instance;
    }

    /*
     * Initial data
     */
    private Comment initComment(ResultSet rs){
        Comment comment=new Comment();
        try{
            comment.setCommentId(rs.getLong(Comment.CommentId));
        }catch(SQLException sqle){
            comment.setCommentId(Long.valueOf(0));
        }
        try{
            comment.setTouristId(rs.getLong(Comment.TouristId));
        }catch(SQLException sqle){
            comment.setTouristId(Long.valueOf(0));
        }
        try{
            comment.setCommentTitle(rs.getString(Comment.CommentTitle));
        }catch(SQLException sqle){
            comment.setCommentTitle("");
        }
        try{
            comment.setCommentBody(rs.getString(Comment.CommentBody));
        }catch(SQLException sqle){
            comment.setCommentBody("");
        }
        try{
            comment.setCommentDate(rs.getLong(Comment.CommentDate));
        }catch(SQLException sqle){
            comment.setCommentDate(Long.valueOf(0));
        }
        try{
            comment.setCommentUserName(rs.getString(Comment.CommentUserName));
        }catch(SQLException sqle){
            comment.setCommentUserName("");
        }
        try{
            comment.setCommentUserEmail(rs.getString(Comment.CommentUserEmail));
        }catch(SQLException sqle){
            comment.setCommentUserEmail("");
        }
        return comment;
    }

    /*
     * Get data
     */
    
    public ListComment getListComment(Long tourist_id){
        ListComment listcomment=new ListComment();
        Comment comment=null;

        StringBuilder output=new StringBuilder();
        output.append(Comment.CommentId).append(",");
        output.append(Comment.CommentTitle).append(",");
        output.append(Comment.CommentBody).append(",");
        output.append(Comment.CommentDate).append(",");
        output.append(Comment.CommentUserName).append(",");
        output.append(Comment.CommentUserEmail);

        StringBuilder condition=new StringBuilder();
        condition.append(Comment.TouristId).append("=").append(tourist_id);

        StringBuilder query=new StringBuilder();
        query.append("select ").append(output);
        query.append(" from ").append(Comment.TableName);
        query.append(" where ").append(condition);

        ResultSet rs=this._conn.executeQuery(query.toString());
        try{
            if(rs!=null){
                while(rs.next()){
                    comment=this.initComment(rs);
                    listcomment.add(comment);
                }
            }
        }catch(SQLException sqle){
            listcomment.clear();
        }
        return listcomment;
    }

    /*
     * Set data
     */
    public void setComment(Comment comment){
        StringBuilder input=new StringBuilder();
        input.append(Comment.TouristId).append(",");
        input.append(Comment.CommentTitle).append(",");
        input.append(Comment.CommentBody).append(",");
        input.append(Comment.CommentDate).append(",");
        input.append(Comment.CommentUserName).append(",");
        input.append(Comment.CommentUserEmail);

        StringBuilder value=new StringBuilder();
        value.append(comment.getTouristId()).append(",");
        value.append("'").append(comment.getCommentTitle()).append("',");
        value.append("'").append(comment.getCommentBody()).append("',");
        value.append(comment.getCommentDate()).append(",");
        value.append("'").append(comment.getCommentUserName()).append("',");
        value.append("'").append(comment.getCommentUserEmail()).append("'");

        StringBuilder query=new StringBuilder();
        query.append("insert into ").append(Comment.TableName);
        query.append(" (").append(input).append(") values (").append(value).append(")");
        if(this._conn.executeNoneQuery(query.toString())==true){
            comment.setCommentId(this._conn.getNextId());
        }else
            comment.setCommentId(Long.valueOf(0));
    }

    /*
     * Delete data
     */
    public boolean delComment(Long comment_id){
        StringBuilder condition=new StringBuilder();
        condition.append(Comment.CommentId).append("=").append(comment_id);

        StringBuilder query=new StringBuilder();
        query.append("delete from ").append(Comment.TableName);
        query.append(" where ").append(condition);
        return this._conn.executeNoneQuery(query.toString());
    }
}
