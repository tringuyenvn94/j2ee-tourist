/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tourist.business.ArticleService;
import tourist.business.TouristService;
import tourist.business.Utility;
import tourist.entities.Article;
import tourist.entities.ListArticle;

/**
 *
 * @author Dung Nguyen
 */
@WebServlet(name = "news", urlPatterns = {"/news"})
public class news extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String action = request.getParameter("action");
            if (action != null) {
                ListAction enumaction = ListAction.valueOf(action);
                switch (enumaction) {
                    case detail:
                        actionDetail(request, response);
                        break;
                    default:
                        actionGetList(request, response);
                        break;
                }
            } else {
                this.actionGetList(request, response);
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
    
    protected void actionGetList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strpage = request.getParameter("page");
        Integer currpage=1;
        if(strpage!=null)
            currpage=Integer.valueOf(strpage);
        ListArticle listArticle = ArticleService.getListArticle(currpage, Utility.pagesize, Long.valueOf(0));
        
        request.setAttribute("listarticle", listArticle);
        String url="./frontend/news/news.jsp";
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }
    
    protected void actionDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
                
        Article article = ArticleService.getArticle(Long.parseLong(id));
        
        request.setAttribute("article", article);
        
        String url="./frontend/news/detail.jsp";
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }
}
