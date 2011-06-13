/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.data;

/**
 *
 * @author VANGANH
 */
import tourist.entities.Article;
import tourist.entities.ListArticle;
import java.sql.*;

public class ArticleDAO {

    private static ArticleDAO _instance;
    private Connector _conn;

    /*
     * Contructor
     */
    private ArticleDAO(){
        this._conn=Connector.getInstance();
    }
    
    public static ArticleDAO getInstance(){
        if(_instance==null){
            _instance=new ArticleDAO();
        }
        return _instance;
    }

    /*
     * Initial data
     */
    private Article initArticle(ResultSet rs){
        Article article=new Article();
        try{
            article.setArticleId(rs.getLong(Article.ArticleId));
        }catch(SQLException sqle){
            article.setArticleId(Long.valueOf(0));
        }
        try{
            article.setCategoryId(rs.getInt(Article.CategoryId));
        }catch(SQLException sqle){
            article.setCategoryId(0);
        }
        try{
            article.setArticleTitle(rs.getString(Article.ArticleTitle));
        }catch(SQLException sqle){
            article.setArticleTitle("");
        }
        try{
            article.setArticleSummary(rs.getString(Article.ArticleSummary));
        }catch(SQLException sqle){
            article.setArticleSummary("");
        }
        try{
            article.setArticleBody(rs.getString(Article.ArticleBody));
        }catch(SQLException sqle){
            article.setArticleBody("");
        }
        try{
            article.setArticleThumbnail(rs.getString(Article.ArticleThumbnail));
        }catch(SQLException sqle){
            article.setArticleThumbnail("");
        }
        try{
            article.setArticleDate(rs.getLong(Article.ArticleDate));
        }catch(SQLException sqle){
            article.setArticleDate(Long.valueOf(0));
        }
        try{
            article.setArticlePublished(rs.getInt(Article.ArticlePublished));
        }catch(SQLException sqle){
            article.setArticlePublished(0);
        }
        return article;
    }

    /*
     * Get data
     */
    public Article getArticle(Long article_id) {
        Article article=null;

        StringBuilder output=new StringBuilder();
        output.append(Article.ArticleId).append(",");
        output.append(Article.CategoryId).append(",");
        output.append(Article.ArticleTitle).append(",");
        output.append(Article.ArticleSummary).append(",");
        output.append(Article.ArticleBody).append(",");
        output.append(Article.ArticleThumbnail).append(",");
        output.append(Article.ArticleDate).append(",");
        output.append(Article.ArticlePublished);

        StringBuilder condition=new StringBuilder();
        condition.append(Article.ArticleId).append("=").append(article_id);

        StringBuilder query=new StringBuilder();
        query.append("select ").append(output);
        query.append(" from ").append(Article.TableName);
        query.append(" where ").append(condition);

        ResultSet rs=this._conn.executeQuery(query.toString());
        try{
            if(rs!=null&&rs.next()){
                article=this.initArticle(rs);
            }
        }catch(SQLException sqle){
            article=null;
        }
        return article;
    }

    public ListArticle getListArticle(String fieldname,String condition,Integer currpage,Integer pagesize,Long totalrecord,String order){
        ListArticle listarticle=new ListArticle();
        Article article=null;

        totalrecord=this._conn.getTotalRecord(Article.TableName, condition);

        StringBuilder query=new StringBuilder();
        query.append("select ").append(fieldname);
        query.append(" from ").append(Article.TableName);
        query.append(" where ").append(condition);
        if(order == null ? "" != null : !order.equals("")){
            query.append(" order by ").append(order);
        }
        if(pagesize>0){
            this._conn.checkPage(currpage, pagesize, totalrecord);
            Long offset=currpage.longValue()-1;
            offset=offset*pagesize;
            query.append(" limit ").append(offset).append(",").append(pagesize);
        }
        
        ResultSet rs=this._conn.executeQuery(query.toString());
        try{
            if(rs!=null){
                while(rs.next()){
                    article=this.initArticle(rs);
                    listarticle.add(article);
                }
            }
        }catch(SQLException sqle){
            listarticle.clear();
        }
        return listarticle;
    }

    /*
     * Set data
     */
    public void setArticle(Article article){
        StringBuilder input=new StringBuilder();
        input.append(Article.CategoryId).append(",");
        input.append(Article.ArticleTitle).append(",");
        input.append(Article.ArticleSummary).append(",");
        input.append(Article.ArticleBody).append(",");
        input.append(Article.ArticleThumbnail).append(",");
        input.append(Article.ArticleDate).append(",");
        input.append(Article.ArticlePublished);
        
        StringBuilder value=new StringBuilder();
        value.append(article.getCategoryId()).append(",");
        value.append("'").append(article.getArticleTitle()).append("',");
        value.append("'").append(article.getArticleSummary()).append("',");
        value.append("'").append(article.getArticleBody()).append("',");
        value.append("'").append(article.getArticleThumbnail()).append("',");
        value.append(article.getArticleDate()).append(",");
        value.append(article.getArticlePublished());

        StringBuilder query=new StringBuilder();
        query.append("insert into ").append(Article.TableName);
        query.append(" (").append(input).append(")");
        query.append(" values (").append(value).append(")");
        if(this._conn.executeNoneQuery(query.toString())==true){
            article.setArticleId(this._conn.getNextId());
        }else
            article.setArticleId(Long.valueOf(0));
    }

    /*
     * Delete data
     */
    public boolean delArticle(Long article_id){
        StringBuilder condition=new StringBuilder();
        condition.append(Article.ArticleId).append("=").append(article_id);

        StringBuilder query=new StringBuilder();
        query.append("delete from ").append(Article.TableName);
        query.append(" where ").append(condition);
        return this._conn.executeNoneQuery(query.toString());
    }

    /*
     * Update data
     */
    public boolean updateArticle(Article article){
        StringBuilder value=new StringBuilder();
        value.append(Article.CategoryId).append("=").append(article.getCategoryId()).append(",");
        value.append(Article.ArticleTitle).append("='").append(article.getArticleTitle()).append("',");
        value.append(Article.ArticleSummary).append("='").append(article.getArticleSummary()).append("',");
        value.append(Article.ArticleBody).append("='").append(article.getArticleBody()).append("',");
        value.append(Article.ArticleThumbnail).append("='").append(article.getArticleThumbnail()).append("',");
        value.append(Article.ArticlePublished).append("=").append(article.getArticlePublished()).append(",");

        StringBuilder condition=new StringBuilder();
        condition.append(Article.ArticleId).append("=").append(article.getArticleId());

        StringBuilder query=new StringBuilder();
        query.append("update ").append(Article.TableName);
        query.append(" set ").append(value);
        query.append(" where ").append(condition);

        return this._conn.executeNoneQuery(query.toString());
    }

    public boolean updateArticleByField(Long article_id,String value){

        StringBuilder condition=new StringBuilder();
        condition.append(Article.ArticleId).append("=").append(article_id);

        StringBuilder query=new StringBuilder();
        query.append("update ").append(Article.TableName);
        query.append(" set ").append(value);
        query.append(" where ").append(condition);

        return this._conn.executeNoneQuery(query.toString());
    }
}
