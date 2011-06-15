/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.business;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import tourist.entities.Article;
import tourist.entities.ListArticle;
import tourist.data.ArticleDAO;
/**
 *
 * @author VANGANH
 */
@Stateless
@LocalBean
public class ArticleService {
    
    /*
     * Get data
     */
    // For FrontEnd
    public static Article getArticle(Long article_id){
        StringBuilder conditon=new StringBuilder();
        conditon.append(Article.ArticleId).append("=").append(article_id);
        conditon.append(" and ").append(Article.ArticlePublished).append("=").append(1);
        Article article=null;
        ArticleDAO articledao=ArticleDAO.getInstance();
        article=articledao.getArticle(conditon.toString());
        if(article==null)
            article=new Article();
        return article;
    }

    public static ListArticle getListArticleByCategory(Integer category_id,Integer currpage,Integer pagesize,Long totalrecord){
        ArticleDAO articledao=ArticleDAO.getInstance();

        StringBuilder fieldname=new StringBuilder();
        fieldname.append(Article.ArticleId).append(",");
        fieldname.append(Article.ArticleTitle).append(",");
        fieldname.append(Article.ArticleSummary).append(",");
        fieldname.append(Article.ArticleThumbnail).append(",");
        fieldname.append(Article.ArticleDate).append(",");
        fieldname.append(Article.CategoryId);

        StringBuilder condition=new StringBuilder();
        condition.append(Article.CategoryId).append("=").append(category_id).append(" and ");
        condition.append(Article.ArticlePublished).append("=").append(1);

        StringBuilder order=new StringBuilder();
        order.append(Article.ArticleDate).append(" DESC");

        return articledao.getListArticle(fieldname.toString(),condition.toString(), currpage, pagesize,totalrecord, order.toString());
    }

    public static ListArticle getListArticleByLastest(Integer pagesize){
        ArticleDAO articledao=ArticleDAO.getInstance();

        StringBuilder fieldname=new StringBuilder();
        fieldname.append(Article.ArticleId).append(",");
        fieldname.append(Article.ArticleTitle).append(",");
        fieldname.append(Article.ArticleSummary).append(",");
        fieldname.append(Article.ArticleThumbnail);

        StringBuilder condition=new StringBuilder();
        condition.append(Article.ArticlePublished).append("=").append(1);
        condition.append(" and ").append(Article.ArticleDate).append("<=").append(Utility.parseDateToLong());

        StringBuilder order=new StringBuilder();
        order.append(Article.ArticleDate).append(" DESC");

        return articledao.getListArticle(fieldname.toString(),condition.toString(), 1, pagesize,Long.valueOf(0), order.toString());
    }

    public static ListArticle getListArticleBySpecial(Integer pagesize){
        ArticleDAO articledao=ArticleDAO.getInstance();

        StringBuilder fieldname=new StringBuilder();
        fieldname.append(Article.ArticleId).append(",");
        fieldname.append(Article.ArticleTitle).append(",");
        fieldname.append(Article.ArticleSummary).append(",");
        fieldname.append(Article.ArticleThumbnail);

        StringBuilder condition=new StringBuilder();
        condition.append(Article.ArticlePublished).append("=").append(1);
        condition.append(" and ").append(Article.ArticleSpecial).append("=").append(1);
        condition.append(" and ").append(Article.ArticleDate).append("<=").append(Utility.parseDateToLong());

        StringBuilder order=new StringBuilder();
        order.append(Article.ArticleDate).append(" DESC");

        return articledao.getListArticle(fieldname.toString(),condition.toString(), 1, pagesize,Long.valueOf(0), order.toString());
    }
    
    // For BackEnd
    public static Article getArticleByAdmin(Long article_id){
        Article article=null;
        ArticleDAO articledao=ArticleDAO.getInstance();
        article=articledao.getArticle(article_id);
        if(article==null)
            article=new Article();
        return article;
    }

    public static ListArticle getListArticleByAdmin(Integer currpage,Integer pagesize,Long totalrecord,String orderdirection){
        ArticleDAO articledao=ArticleDAO.getInstance();

        StringBuilder fieldname=new StringBuilder();
        fieldname.append(Article.ArticleId).append(",");
        fieldname.append(Article.CategoryId).append(",");
        fieldname.append(Article.ArticleTitle).append(",");
        fieldname.append(Article.ArticleSummary).append(",");
        fieldname.append(Article.ArticleThumbnail).append(",");
        fieldname.append(Article.ArticleDate).append(",");
        fieldname.append(Article.ArticlePublished).append(",");
        fieldname.append(Article.ArticleSpecial);

        StringBuilder condition=new StringBuilder();
        condition.append("1");

        StringBuilder order=new StringBuilder();
        order.append(Article.ArticleDate).append(" ").append(orderdirection);

        return articledao.getListArticle(fieldname.toString(),condition.toString(), currpage, pagesize,totalrecord, order.toString());
    }
    
    public static ListArticle getListArticle(Integer pulished,Integer currpage,Integer pagesize,Long totalrecord,String orderdirection){
        ArticleDAO articledao=ArticleDAO.getInstance();

        StringBuilder fieldname=new StringBuilder();
        fieldname.append(Article.ArticleId).append(",");
        fieldname.append(Article.ArticleTitle).append(",");
        fieldname.append(Article.ArticleSummary).append(",");
        fieldname.append(Article.ArticleThumbnail).append(",");
        fieldname.append(Article.ArticleDate).append(",");
        fieldname.append(Article.ArticlePublished).append(",");
        fieldname.append(Article.CategoryId);

        StringBuilder condition=new StringBuilder();
        condition.append(Article.ArticlePublished).append("=").append(pulished);

        StringBuilder order=new StringBuilder();
        order.append(Article.ArticleDate).append(" ").append(orderdirection);

        return articledao.getListArticle(fieldname.toString(),condition.toString(), currpage, pagesize,totalrecord, order.toString());
    }
    
    public static ListArticle getListArticleByCategoryAdmin(Integer category_id,Integer currpage,Integer pagesize,Long totalrecord,String orderdirection){
        ArticleDAO articledao=ArticleDAO.getInstance();

        StringBuilder fieldname=new StringBuilder();
        fieldname.append(Article.ArticleId).append(",");
        fieldname.append(Article.ArticleTitle).append(",");
        fieldname.append(Article.ArticleSummary).append(",");
        fieldname.append(Article.ArticleThumbnail).append(",");
        fieldname.append(Article.ArticleDate).append(",");
        fieldname.append(Article.ArticlePublished).append(",");
        fieldname.append(Article.CategoryId);

        StringBuilder condition=new StringBuilder();
        condition.append(Article.CategoryId).append("=").append(category_id).append(" and ");
        condition.append(Article.ArticlePublished).append("=").append(1);

        StringBuilder order=new StringBuilder();
        order.append(Article.ArticleDate).append(" ").append(orderdirection);

        return articledao.getListArticle(fieldname.toString(),condition.toString(), currpage, pagesize,totalrecord, order.toString());
    }
    
    public static ListArticle getListArticleByCategoryAdmin(Integer category_id,Integer published,Integer currpage,Integer pagesize,Long totalrecord,String orderdirection){
        ArticleDAO articledao=ArticleDAO.getInstance();

        StringBuilder fieldname=new StringBuilder();
        fieldname.append(Article.ArticleId).append(",");
        fieldname.append(Article.ArticleTitle).append(",");
        fieldname.append(Article.ArticleSummary).append(",");
        fieldname.append(Article.ArticleThumbnail).append(",");
        fieldname.append(Article.ArticleDate).append(",");
        fieldname.append(Article.ArticlePublished).append(",");
        fieldname.append(Article.CategoryId);

        StringBuilder condition=new StringBuilder();
        condition.append(Article.CategoryId).append("=").append(category_id).append(" and ");
        condition.append(Article.ArticlePublished).append("=").append(published);

        StringBuilder order=new StringBuilder();
        order.append(Article.ArticleDate).append(" ").append(orderdirection);

        return articledao.getListArticle(fieldname.toString(),condition.toString(), currpage, pagesize,totalrecord, order.toString());
    }
    

    /*
     * Add data
     */
    public static boolean addArticle(Article article){
        article.setArticleDate(Utility.parseDateToLong());

        ArticleDAO articledao=ArticleDAO.getInstance();
        articledao.setArticle(article);
        if(article.getArticleId()!=0)
            return true;
        return false;
    }

    /*
     * Remove data
     */
    public static boolean removeArticle(Long article_id){
        ArticleDAO articledao=ArticleDAO.getInstance();
        return articledao.delArticle(article_id);
    }

    /*
     * Update data
     */
    public static boolean updateArticle(Article article){
        ArticleDAO articledao=ArticleDAO.getInstance();
        return articledao.updateArticle(article);
    }

    public static boolean updateArticlePublished(Long article_id,Integer published){
        StringBuilder value=new StringBuilder();
        value.append(Article.ArticlePublished).append("=").append(published);
        ArticleDAO articledao=ArticleDAO.getInstance();
        return articledao.updateArticleByField(article_id,value.toString());
    }
 
}
