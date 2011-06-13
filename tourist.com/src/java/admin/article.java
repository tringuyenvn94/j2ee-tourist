/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import java.beans.IntrospectionException;
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

/**
 *
 * @author VANGANH
 */
@WebServlet(name="article", urlPatterns={"/article"})
public class article extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String url="";
            String action=request.getParameter("action");
            if(action==null){
                actionGetList(request,response);
            }else{
                if(action.equals("edit")){
                    actionEdit(request,response);

                }else{
                    if(action.equals("post")){
                        actionPost(request,response);
                    }
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
        ListArticle listarticle=ArticleService.getListArticle(currpage,Utility.pagesizeadmin, totalrecord,"DESC");
        request.setAttribute("listarticle", listarticle);

        String url="./admin/article/article.jsp";
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }

    private void actionEdit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String strid=request.getParameter("id");
        Long id=Long.valueOf(0);
        if(strid!=null)
           id =Long.valueOf(strid);
        Article article=ArticleService.getArticle(id);
        request.setAttribute("article", article);

        String url="./admin/article/edit.jsp";
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }

    private void actionPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String url="./admin/article/post.jsp";
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }

    private void actionAdd(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String title =request.getParameter("title");
        String published=request.getParameter("published");
        String fcksummary=request.getParameter("fcksummary");
        String fckbody=request.getParameter("fckbody");

        String url="./admin/article/article.jsp";
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }
    private void actionUpdate(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String url="./admin/article/post.jsp";
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }
}
