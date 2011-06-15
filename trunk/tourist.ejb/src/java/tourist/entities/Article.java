/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tourist.entities;

/**
 *
 * @author VANGANH
 */
public class Article {

    /*
     * Parameter
     */
    private Long _article_id;
    private Integer _category_id;
    private String _article_title;
    private String _article_summary;
    private String _article_body;
    private Long _article_date;
    private String _article_thumbnail;
    private Integer _article_published;
    private Integer _article_special;

    /*
     * Contructor
     */
    public Article(){}

    /*
     * Property
     */
    /*public static String TableName(){
        return "Article";
    }*/

    public Long getArticleId(){
         return this._article_id;
    }
    public void setArticleId(Long article_id){
        this._article_id=article_id;
    }

    public Integer getCategoryId(){
         return this._category_id;
    }
    public void setCategoryId(Integer category_id){
        this._category_id=category_id;
    }

    public String getArticleTitle(){
         return this._article_title;
    }
    public void setArticleTitle(String article_title){
        this._article_title=article_title;
    }

    public String getArticleSummary(){
         return this._article_summary;
    }
    public void setArticleSummary(String article_summary){
        this._article_summary=article_summary;
    }

    public String getArticleBody(){
         return this._article_body;
    }
    public void setArticleBody(String article_body){
        this._article_body=article_body;
    }

    public Long getArticleDate(){
         return this._article_date;
    }
    public void setArticleDate(Long article_date){
        this._article_date=article_date;
    }

    public String getArticleThumbnail(){
         return this._article_thumbnail;
    }
    public void setArticleThumbnail(String article_thumbnail){
        this._article_thumbnail=article_thumbnail;
    }

    public Integer getArticlePublished(){
         return this._article_published;
    }
    public void setArticlePublished(Integer article_published){
        this._article_published=article_published;
    }

    public Integer getArticleSpecial(){
         return this._article_special;
    }
    public void setArticleSpecial(Integer _article_special){
        this._article_special=_article_special;
    }

    /*
     * Field Name
     */
    public static final String TableName="tourist.Article";
    public static final String ArticleId="ArticleId";
    public static final String CategoryId="CategoryId";
    public static final String ArticleTitle="ArticleTitle";
    public static final String ArticleSummary="ArticleSummary";
    public static final String ArticleBody="ArticleBody";
    public static final String ArticleDate="ArticleDate";
    public static final String ArticleThumbnail="ArticleThumbnail";
    public static final String ArticlePublished="ArticlePublished";
    public static final String ArticleSpecial="ArticleSpecial";
}
