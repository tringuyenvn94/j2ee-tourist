/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;
import javax.servlet.http.*;
/**
 *
 * @author VANGANH
 */
public class SignIn {

    public static boolean checkLogin(HttpServletRequest req)
    {
        HttpSession session=req.getSession(true);

        String user="";
        user=(String)session.getAttribute("username");
        if(user!=null && !user.equals(""))            
            return true;
        else{
            String username="";
            username=req.getParameter("username");
            String pass="";
            pass=req.getParameter("passwd");
            if((username!=null && !username.equals("")) || (pass!=null && !pass.equals(""))){
                if("admin".equals(username) && "sedev".equals(pass)){
                    session.setAttribute("username", username);
                    //resp.sendRedirect(req.getContextPath()+"/Admin/article.jsp");
                    return true;
                }
            }
        }
        //resp.sendRedirect(req.getContextPath()+"/Admin/login.jsp");
        //return false;
        return true;
    }
}
