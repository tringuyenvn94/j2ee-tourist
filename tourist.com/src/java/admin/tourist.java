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
import tourist.entities.Tourist;
import tourist.entities.ListTourist;
import tourist.entities.ListCategory;
import tourist.business.TouristService;
import tourist.business.CategoryService;
import tourist.business.Utility;
/**
 *
 * @author VANGANH
 */
@WebServlet(name="tourist", urlPatterns={"/tourist"})
public class tourist extends HttpServlet {
   
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
        String strpage=request.getParameter("page");
        Integer currpage=1;
        if(strpage!=null)
           currpage =Integer.valueOf(strpage);
        Long totalrecord=Long.valueOf(0);

        ListTourist listtourist=new ListTourist();
        listtourist=TouristService.getListTouristByAdmin(currpage, Utility.pagesizeadmin, totalrecord, "DESC");
        ListCategory listcategory=null;
        if(listtourist!=null){
            listcategory=CategoryService.getListCategory(listtourist);
        }

        request.setAttribute("listtourist", listtourist);
        request.setAttribute("listcategory", listcategory);

        String url="./admin/tourist/tourist.jsp";
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }

    private void actionEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String strid=request.getParameter("id");
        Long id=Long.valueOf(0);
        if(strid!=null)
           id =Long.valueOf(strid);
        Tourist tourist=TouristService.getTouristByAdmin(id);
        ListCategory listcategory=CategoryService.getListCategoryByTourist(1, 0, Long.valueOf(0));

        request.setAttribute("tourist", tourist);
        request.setAttribute("listcategory", listcategory);

        String url="./admin/tourist/edit.jsp";
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }

    private void actionPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ListCategory listcategory=CategoryService.getListCategoryByTourist(1, 0, Long.valueOf(0));
        request.setAttribute("listcategory", listcategory);
        
        String url="./admin/tourist/post.jsp";
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }

    private void actionAdd(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        Tourist tourist=new Tourist();
        try{
            String messageinfo="";
            if(this.checkInfo(tourist, request, messageinfo)==true){
                if(TouristService.addTourist(tourist)==true){
                    request.setAttribute("message", "success");
                    request.setAttribute("messageinfo", "Thêm tour thành công");
                    
                    ListCategory listcategory=CategoryService.getListCategoryByTourist(1, 0, Long.valueOf(0));
                    request.setAttribute("listcategory", listcategory);
                    request.setAttribute("tourist", tourist);

                    String url="./admin/tourist/edit.jsp";
                    RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
                    reqdisparcher.forward(request, response);
                }else{
                    response.sendRedirect(request.getContextPath()+"/tourist");
                }
            }else{
                request.setAttribute("message", "error");
                request.setAttribute("messageinfo", messageinfo);
                this.actionPost(request,response);
            }
        }catch(Exception exp){
            response.sendRedirect(request.getContextPath()+"/tourist");
        }

    }

    private void actionUpdate(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        Tourist tourist=new Tourist();
        try{
            String messageinfo="";
            tourist.setTouristId(Long.valueOf(request.getParameter("id")));
            if(tourist.getTouristId()!=null){
                if(this.checkInfo(tourist, request, messageinfo)==true){
                    if(TouristService.updateTourist(tourist)==true){
                        request.setAttribute("message", "success");
                        request.setAttribute("messageinfo", "Cập nhật thành công");
                    }else{
                        request.setAttribute("message", "error");
                        request.setAttribute("messageinfo", "Cập nhật thất bại! Hãy thử lại sau");
                    }
                    ListCategory listcategory=CategoryService.getListCategoryByTourist(1, 0, Long.valueOf(0));

                    request.setAttribute("tourist", tourist);
                    request.setAttribute("listcategory", listcategory);

                    String url="./admin/tourist/edit.jsp";
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
        Long id=Long.valueOf(0);
        if(strid!=null)
           id =Long.valueOf(strid);
        if(TouristService.removeTourist(id)==true){
            request.setAttribute("message","success");
            request.setAttribute("messageinfo","Xóa thành công");
        }else{
            request.setAttribute("message","error");
            request.setAttribute("messageinfo","Xóa thất bại");
        }
        this.actionGetList(request, response);
    }

    private boolean checkInfo(Tourist tourist,HttpServletRequest request,String message){
        try{
            tourist.setCategoryId(Integer.valueOf(request.getParameter("category")));
        }catch(Exception exp){
            message="Loại tour không đúng ";
            return false;
        }
        try{
            tourist.setTouristBody(request.getParameter("fckbody"));
        }catch(Exception exp){
            message="Nội dung chi tiết không đúng ";
            return false;
        }
        try{
            tourist.setTouristDate(Utility.parseDateToLong(request.getParameter("date")));
        }catch(Exception exp){
            message="Sai dữ liệu ";
            return false;
        }
        try{
            tourist.setTouristImage("");
        }catch(Exception exp){
            message="Sai dữ liệu ";
            return false;
        }
        try{
            tourist.setTouristNumDay(Integer.valueOf(request.getParameter("numday")));
        }catch(Exception exp){
            message="Số ngày không đúng ";
            return false;
        }
        try{
            tourist.setTouristNumNight(Integer.valueOf(request.getParameter("numnight")));
        }catch(Exception exp){
            message="Số đêm không đúng ";
            return false;
        }
        try{
            tourist.setTouristPrice(Double.valueOf(request.getParameter("price")));
        }catch(Exception exp){
            message="Giá không đúng ";
            return false;
        }
        try{
            tourist.setTouristPublished(Integer.valueOf(request.getParameter("published")));
        }catch(Exception exp){
            message="Sai dữ liệu ";
            return false;
        }
        try{
            tourist.setTouristSpecial(Integer.valueOf(request.getParameter("special")));
        }catch(Exception exp){
            message="Sai dữ liệu ";
            return false;
        }
         try{
            tourist.setTouristSummary(request.getParameter("fcksummary"));
        }catch(Exception exp){
            message="Nội dung mô tả không đúng ";
            return false;
        }
        try{
            tourist.setTouristTitle(request.getParameter("title"));
        }catch(Exception exp){
            message="Tiêu đề không đúng ";
            return false;
        }
        return true;
    }
}
