/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tourist.entities.Category;
import tourist.entities.ListCategory;
import tourist.business.CategoryService;
import tourist.business.Utility;

/**
 *
 * @author VANGANH
 */
@WebServlet(name="category", urlPatterns={"/category"})
public class category extends HttpServlet {
   
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

    private void actionGetList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ListCategory listcategory=CategoryService.getListCategory(1,0,Long.valueOf(0));
        List<String> listcategorytype=new ArrayList<String>();
        if(listcategory!=null){
            listcategorytype=CategoryService.getListCategoryType(listcategory);
        }
        request.setAttribute("listcategory", listcategory);
        request.setAttribute("listcategorytype", listcategorytype);

        String url="./admin/category/category.jsp";
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }

    private void actionEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String strid=request.getParameter("id");
        Integer id=0;
        if(strid!=null)
           id =Integer.valueOf(strid);
        Category category=CategoryService.getCategory(id);

        request.setAttribute("category", category);

        String url="./admin/category/edit.jsp";
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }

    private void actionPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String url="./admin/category/post.jsp";
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }

    private void actionAdd(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        Category category=new Category();
        try{
            String messageinfo="";
            if(this.checkInfo(category, request, messageinfo)==true){
                if(CategoryService.addCategory(category)==true){
                    request.setAttribute("message", "success");
                    request.setAttribute("messageinfo", "Thêm thành công");

                    request.setAttribute("category", category);

                    String url="./admin/category/edit.jsp";
                    RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
                    reqdisparcher.forward(request, response);
                }else{
                    response.sendRedirect(request.getContextPath()+"/category");
                }
            }else{
                request.setAttribute("message", "error");
                request.setAttribute("messageinfo", messageinfo);
                this.actionPost(request,response);
            }
        }catch(Exception exp){
            response.sendRedirect(request.getContextPath()+"/category");
        }

    }

    private void actionUpdate(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        Category category=new Category();
        try{
            String messageinfo="";
            category.setCategoryId(Integer.valueOf(request.getParameter("id")));
            if(category.getCategoryId()!=null){
                if(this.checkInfo(category, request, messageinfo)==true){
                    if(CategoryService.updateCategory(category)==true){
                        request.setAttribute("message", "success");
                        request.setAttribute("messageinfo", "Cập nhật thành công");
                    }else{
                        request.setAttribute("message", "error");
                        request.setAttribute("messageinfo", "Cập nhật thất bại! Hãy thử lại sau");
                    }
                    request.setAttribute("category", category);

                    String url="./admin/category/edit.jsp";
                    RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
                    reqdisparcher.forward(request, response);
                }else{
                    request.setAttribute("message", "error");
                    request.setAttribute("messageinfo", messageinfo);
                    this.actionEdit(request,response);
                }
            }else
                response.sendRedirect(request.getContextPath()+"/category");
        }catch(Exception exp){
            response.sendRedirect(request.getContextPath()+"/category");
        }
    }

    private void actionRemove(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String strid=request.getParameter("id");
        Integer id=Integer.valueOf(0);
        if(strid!=null)
           id =Integer.valueOf(strid);
        if(CategoryService.removeCategory(id)==true){
            request.setAttribute("message","success");
            request.setAttribute("messageinfo","Xóa thành công");
        }else{
            request.setAttribute("message","error");
            request.setAttribute("messageinfo","Xóa thất bại");
        }
        this.actionGetList(request, response);
    }

    private boolean checkInfo(Category category,HttpServletRequest request,String message){
        try{
            category.setCategoryName(request.getParameter("title"));
        }catch(Exception exp){
            message="Tên không đúng định dạng ";
            return false;
        }
        try{
            category.setCategoryOrdering(0);
        }catch(Exception exp){
            message="";
            return false;
        }
        try{
            category.setCategoryParentId(0);
        }catch(Exception exp){
            message="";
            return false;
        }
        try{
            category.setCategoryPublished(Integer.valueOf(request.getParameter("published")));
        }catch(Exception exp){
            message="Sai dữ liệu ";
            return false;
        }
        try{
            category.setCategoryType(Integer.valueOf(request.getParameter("categorytype")));
        }catch(Exception exp){
            message="Sai dữ liệu ";
            return false;
        }        
        return true;
    }
}
