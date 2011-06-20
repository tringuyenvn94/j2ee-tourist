/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tourist.business.ArticleService;
import tourist.business.Utility;
import tourist.entities.Article;
import tourist.entities.ListArticle;
import tourist.entities.ListCategory;
import tourist.business.CategoryService;

/**
 *
 * @author VANGANH
 */
@WebServlet(name="article", urlPatterns={"/article"})
public class article extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {            
            // Check login
            if(SignIn.checkLogin(request)!=true)
                response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
            else{
                String action=request.getParameter("action");
                if(action!=null){
                    ListAction enumaction=ListAction.valueOf(action);
                    switch(enumaction){
                        case edit:
                            this.actionEdit(request,response);
                            break;
                        case post:
                            this.actionPost(request,response);
                            break;
                        case add:
                            this.actionAdd(request, response);
                            break;
                        case update:
                            this.actionUpdate(request, response);
                            break;
                        case del:
                            this.actionRemove(request, response);
                            break;
                        default:
                            this.actionGetList(request,response);
                            break;
                    }
                }
                else{
                    this.actionGetList(request,response);
                }
            }
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


    /*
     * Method
     */
    private void actionGetList(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String strpage=request.getParameter("page");
        Integer currpage=1;
        if(strpage!=null)
           currpage =Integer.valueOf(strpage);
        Long totalrecord=Long.valueOf(0);
        ListArticle listarticle=ArticleService.getListArticleByAdmin(currpage,Utility.pagesizeadmin, totalrecord,"DESC");
        ListCategory listcategory = null;
        if(listarticle!=null){            
            listcategory=CategoryService.getListCategory(listarticle);
        }
        request.setAttribute("listarticle", listarticle);
        request.setAttribute("listcategory", listcategory);

        String url="./admin/article/article.jsp";
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }

    private void actionEdit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String strid=request.getParameter("id");
        Long id=Long.valueOf(0);
        if(strid!=null)
           id =Long.valueOf(strid);
        Article article=ArticleService.getArticleByAdmin(id);
        ListCategory listcategory=CategoryService.getListCategoryByArticle(1, 0, Long.valueOf(0));

        request.setAttribute("article", article);
        request.setAttribute("listcategory", listcategory);
        
        String url="./admin/article/edit.jsp";
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }

    private void actionPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String url="./admin/article/post.jsp";
        ListCategory listcategory=CategoryService.getListCategoryByArticle(1, 0, Long.valueOf(0));
        request.setAttribute("listcategory", listcategory);
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }

    private void actionAdd(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        Article article=new Article();
        try{
            article.setArticleTitle(request.getParameter("title"));
            article.setCategoryId(Integer.valueOf(request.getParameter("category")));
            article.setArticlePublished(Integer.valueOf(request.getParameter("published")));
            article.setArticleSpecial(Integer.valueOf(request.getParameter("special")));
            article.setArticleDate(Utility.parseDateToLong(request.getParameter("date")));
            article.setArticleSummary(request.getParameter("fcksummary"));
            article.setArticleBody(request.getParameter("fckbody"));
            article.setArticleThumbnail("");
            
            if(ArticleService.addArticle(article)==true){
                request.setAttribute("message", "success");
                request.setAttribute("messageinfo", "Thêm bài viết thành công");
                ListCategory listcategory=CategoryService.getListCategoryByArticle(1, 0, Long.valueOf(0));
                request.setAttribute("listcategory", listcategory);
                request.setAttribute("article", article);

                String url="./admin/article/edit.jsp";
                RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
                reqdisparcher.forward(request, response);
            }else
                response.sendRedirect(request.getContextPath()+"/article");
        }catch(Exception exp){
            response.sendRedirect(request.getContextPath()+"/article");
        }
        
    }

    private void actionUpdate(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        Article article=new Article();
        try{
            article.setArticleId(Long.valueOf(request.getParameter("id")));
            article.setArticleTitle(request.getParameter("title"));
            article.setCategoryId(Integer.valueOf(request.getParameter("category")));
            article.setArticlePublished(Integer.valueOf(request.getParameter("published")));
            article.setArticleSpecial(Integer.valueOf(request.getParameter("special")));
            article.setArticleDate(Utility.parseDateToLong(request.getParameter("date")));
            article.setArticleSummary(request.getParameter("fcksummary"));
            article.setArticleBody(request.getParameter("fckbody"));
            article.setArticleThumbnail("");
            
            if(article.getArticleId()!=null){
                if(ArticleService.updateArticle(article)==true){
                    request.setAttribute("message", "success");
                    request.setAttribute("messageinfo", "Cập nhật thành công");                    
                } else{
                    request.setAttribute("message", "error");
                    request.setAttribute("messageinfo", "Cập nhật thất bại! Hãy thử lại sau");                    
                }
                request.setAttribute("article", article);
                ListCategory listcategory=CategoryService.getListCategoryByArticle(1, 0, Long.valueOf(0));
                request.setAttribute("listcategory", listcategory);
                String url="./admin/article/edit.jsp";
                RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
                reqdisparcher.forward(request, response);
            }else{
                response.sendRedirect(request.getContextPath()+"/article");
            }
        }catch(Exception exp){
            response.sendRedirect(request.getContextPath()+"/article");
        }
    }

    private void actionRemove(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String strid=request.getParameter("id");
        Long id=Long.valueOf(0);
        if(strid!=null)
           id =Long.valueOf(strid);
        if(ArticleService.removeArticle(id)==true){
            request.setAttribute("message","success");
            request.setAttribute("messageinfo","Xóa thành công");
        }else{
            request.setAttribute("message","error");
            request.setAttribute("messageinfo","Xóa thất bại");
        }
        this.actionGetList(request, response);
    }
}
