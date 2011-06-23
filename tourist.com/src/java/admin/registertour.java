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
import tourist.business.RegistrationService;
import tourist.business.TouristService;
import tourist.business.Utility;
import tourist.entities.Registration;
import tourist.entities.ListRegistration;
import tourist.entities.ListTourist;
import tourist.entities.Tourist;

/**
 *
 * @author VANGANH
 */
@WebServlet(name="registertour", urlPatterns={"/registertour"})
public class registertour extends HttpServlet {
   
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
                            //this.actionPost(request,response);
                            break;
                        case add:
                            //this.actionAdd(request, response);
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

     private void actionGetList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String strpage=request.getParameter("page");
        Integer currpage=1;
        if(strpage!=null)
           currpage =Integer.valueOf(strpage);
        String strtourist_id=request.getParameter("tourist");
        Long tourist_id=Long.valueOf(0);
        if(strtourist_id!=null)
            tourist_id=Long.valueOf(strtourist_id);
        Long totalrecord=Long.valueOf(0);
        Integer aprove=-1;
        ListRegistration listregistration=RegistrationService.getListRegistration(tourist_id,currpage,Utility.pagesizeadmin, totalrecord, aprove);
        ListTourist listtourist=null;
        if(listregistration!=null){
            listtourist=TouristService.getListTouristByRegistration(listregistration);
        }

        request.setAttribute("listregistration", listregistration);
        request.setAttribute("listtourist", listtourist);

        String url="./admin/registertour/registertour.jsp";
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }

     private void actionEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String strid=request.getParameter("id");
        Long id=Long.valueOf(0);
        if(strid!=null)
           id =Long.valueOf(strid);
        Registration registration=RegistrationService.getRegistration(id);
        Tourist tourist=null;
        if(registration!=null){
            tourist=TouristService.getTourist(registration.getTouristId());
        }
        request.setAttribute("registration", registration);
        request.setAttribute("tourist", tourist);

        String url="./admin/registertour/edit.jsp";
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }

     private void actionRemove(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String strid=request.getParameter("id");
        Long id=Long.valueOf(0);
        if(strid!=null)
           id =Long.valueOf(strid);
        if(RegistrationService.removeRegistration(id)==true){
            request.setAttribute("message","success");
            request.setAttribute("messageinfo","Xóa thành công");
        }else{
            request.setAttribute("message","error");
            request.setAttribute("messageinfo","Xóa thất bại");
        }
        this.actionGetList(request, response);
    }

     private void actionUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String strid=request.getParameter("id");
        Long id=Long.valueOf(0);
        if(strid!=null)
           id =Long.valueOf(strid);
        if(RegistrationService.updateRegistrationApproved(id, 1)==true){
            request.setAttribute("message", "success");
            request.setAttribute("messageinfo", "Cập nhật thành công");
        }else{
            request.setAttribute("message", "error");
            request.setAttribute("messageinfo", "Cập nhật thất bại! Hãy thử lại sau");
        }
        this.actionGetList(request, response);
    }

}
