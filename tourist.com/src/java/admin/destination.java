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
import tourist.entities.Destination;
import tourist.entities.ListDestination;
import tourist.business.DestinationService;
import tourist.business.NationService;
import tourist.business.TownService;
import tourist.business.Utility;
import tourist.entities.ListNation;
import tourist.entities.ListTown;
import tourist.entities.Nation;
import tourist.entities.Town;

/**
 *
 * @author VANGANH
 */
@WebServlet(name="destination", urlPatterns={"/destination"})
public class destination extends HttpServlet {
   
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

    private void actionGetList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String strpage=request.getParameter("page");
        Integer currpage=1;
        if(strpage!=null)
           currpage =Integer.valueOf(strpage);
        Long totalrecord=Long.valueOf(0);
        ListDestination listdestination=DestinationService.getListDestination(currpage, Utility.pagesizeadmin, totalrecord);
        ListTown listtown=null;
        if(listdestination!=null){
            listtown=TownService.getListTown(listdestination);
        }
        request.setAttribute("listdestination", listdestination);
        request.setAttribute("listtown", listtown);

        String url="./admin/destination/destination.jsp";
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }

    private void actionEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String strid=request.getParameter("id");
        Integer id=0;
        if(strid!=null)
           id =Integer.valueOf(strid);
        Destination destination=DestinationService.getDestination(id);
        ListNation listnation=null;
        Town town=null;
        ListTown listtown=null;
        if(destination!=null){
            listnation=NationService.getListNation();
            town=TownService.getTown(destination.getTownId());
            listtown=TownService.getListTown(town.getNationId());
        }

        request.setAttribute("destination", destination);
        request.setAttribute("listnation", listnation);        
        request.setAttribute("listtown", listtown);

        String url="./admin/destination/edit.jsp";
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }

    private void actionPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        ListNation listnation=NationService.getListNation();
        request.setAttribute("listnation", listnation);
        
        String url="./admin/destination/post.jsp";
        RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
        reqdisparcher.forward(request, response);
    }

    private void actionAdd(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        Destination destination=new Destination();
        try{
            String messageinfo="";
            if(this.checkInfo(destination, request, messageinfo)==true){
                if(DestinationService.addDestination(destination)==true){
                    ListNation listnation=null;
                    Town town=null;
                    ListTown listtown=null;
                    listnation=NationService.getListNation();
                    town=TownService.getTown(destination.getTownId());
                    listtown=TownService.getListTown(town.getNationId());

                    request.setAttribute("message", "success");
                    request.setAttribute("messageinfo", "Thêm thành công");
                    request.setAttribute("destination", destination);
                    request.setAttribute("listnation", listnation);
                    request.setAttribute("listtown", listtown);
                    
                    String url="./admin/destination/edit.jsp";
                    RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
                    reqdisparcher.forward(request, response);
                }else{
                    response.sendRedirect(request.getContextPath()+"/destination");
                }
            }else{
                request.setAttribute("message", "error");
                request.setAttribute("messageinfo", messageinfo);
                this.actionPost(request,response);
            }
        }catch(Exception exp){
            response.sendRedirect(request.getContextPath()+"/destination");
        }
    }

    private void actionUpdate(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        Destination destination=new Destination();
        try{
            String messageinfo="";
            destination.setDestinationId(Integer.valueOf(request.getParameter("id")));
            if(destination.getDestinationId()!=null){
                if(this.checkInfo(destination, request, messageinfo)==true){
                    if(DestinationService.updateDestination(destination)==true){
                        request.setAttribute("message", "success");
                        request.setAttribute("messageinfo", "Cập nhật thành công");
                    }else{
                        request.setAttribute("message", "error");
                        request.setAttribute("messageinfo", "Cập nhật thất bại! Hãy thử lại sau");
                    }
                    ListNation listnation=null;
                    Town town=null;
                    ListTown listtown=null;
                    listnation=NationService.getListNation();
                    town=TownService.getTown(destination.getTownId());
                    listtown=TownService.getListTown(town.getNationId());
                    
                    request.setAttribute("destination", destination);
                    request.setAttribute("listnation", listnation);
                    request.setAttribute("listtown", listtown);

                    String url="./admin/destination/edit.jsp";
                    RequestDispatcher reqdisparcher=request.getRequestDispatcher(url);
                    reqdisparcher.forward(request, response);
                }else{
                    request.setAttribute("message", "error");
                    request.setAttribute("messageinfo", messageinfo);
                    this.actionEdit(request,response);
                }
            }else
                response.sendRedirect(request.getContextPath()+"/destination");
        }catch(Exception exp){
            response.sendRedirect(request.getContextPath()+"/destination");
        }
    }

    private void actionRemove(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        String strid=request.getParameter("id");
        Integer id=Integer.valueOf(0);
        if(strid!=null){
            id=Integer.valueOf(strid);
        }
        if(DestinationService.removeDestination(id)){
            request.setAttribute("message","success");
            request.setAttribute("messageinfo","Xóa thành công");
        }else{
            request.setAttribute("message","error");
            request.setAttribute("messageinfo","Xóa thất bại");
        }
        this.actionGetList(request, response);
    }

    private boolean checkInfo(Destination destination,HttpServletRequest request,String message){
        try{
            destination.setDestinationName(request.getParameter("title"));
        }catch(Exception exp){
            message="Tên không đúng định dạng ";
            return false;
        }
        try{
            destination.setTownId(Integer.valueOf(request.getParameter("town")));
        }catch(Exception exp){
            message="";
            return false;
        }
        try{
            destination.setDestinationImage("");
        }catch(Exception exp){
            message="";
            return false;
        }        
        return true;
    }
}
