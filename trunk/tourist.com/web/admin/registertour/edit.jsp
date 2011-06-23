<%-- 
    Document   : edit
    Created on : Jun 22, 2011, 10:13:58 AM
    Author     : VANGANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tourist.business.Utility" %>
<%@page import="tourist.entities.Registration" %>
<%@page import="tourist.entities.Tourist" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<%
    //request.setCharacterEncoding("UTF-8");
    Registration registration=(Registration)request.getAttribute("registration");
    Tourist tourist=(Tourist)request.getAttribute("tourist");
    if(registration==null || tourist==null)
        response.sendRedirect(request.getContextPath()+"/registration");
    String message=(String)request.getAttribute("message");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=tourist.getTouristTitle()%></title>
        <%@include file="../script.jsp" %>
    </head>
    <body>
        <%@include file="../header.jsp" %>
         <div id="content-box">
             <%@include file="../menu.jsp" %>
             <div class="padding">
                 <div id="toolbar-box">
                    <div class="t">
                        <div class="t">
                            <div class="t"></div>
                        </div>
                    </div>
                    <div class="m">
                        <div id="toolbar" class="toolbar">
                            <table class="toolbar">
                                <tbody>
                                    <tr>
                                         <td id="toolbar-cancel" class="button">
                                            <a class="toolbar" href="<%= request.getContextPath()%>/registertour">
                                                <span title="Cancel" class="icon-32-cancel">
                                                </span>
                                                    Hủy
                                            </a>
                                         </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="header icon-48-article">
                            Thông tin đăng ký tour
                        </div>
                        <%if(message!=null){%>
                            <dl id="system-message">
                                <%
                                    if(!message.equals("error")){
                                %>
                                    <dd class="message message fade">
                                        <ul>
                                            <li><%=request.getAttribute("messageinfo")%></li>
                                        </ul>
                                    </dd>
                                 <%}else{%>
                                    <dd class="error message fade">
                                        <ul>
                                            <li><%=request.getAttribute("messageinfo")%></li>
                                        </ul>
                                    </dd>
                                 <%}%>
                            </dl>
                        <%}%>
                        <!---->
                        <div class="clr"></div>
                    </div>
                    <div class="b">
                        <div class="b">
                            <div class="b"></div>
                        </div>
                    </div>
                 </div>
                 <div id="element-box">
                     <div class="t">
                        <div class="t">
                            <div class="t"></div>
                        </div>
                     </div>
                     <div class="m">
                         <table width="100%">
                             <tr>
                                 <td><h3>Thông tin tour</h3></td>
                                 <td><h3>Thông tin đăng ký</h3></td>
                             </tr>
                             <tr>
                                 <td>
                                     <table>
                                         <tr>
                                             <td>
                                                 <label>Tiêu đề :</label>
                                             </td>
                                             <td>
                                                 <%=tourist.getTouristTitle()%>
                                             </td>
                                         </tr>
                                         <tr>
                                             <td>
                                                 <label>Giá :</label>
                                             </td>
                                             <td>
                                                 <%=tourist.getTouristPrice()%> VND
                                             </td>
                                         </tr>
                                         <tr>
                                             <td>
                                                 <label>Số ngày :</label>
                                             </td>
                                             <td>
                                                 <%=tourist.getTouristNumDay()%>
                                             </td>
                                         </tr>
                                         <tr>
                                             <td>
                                                 <label>Số đêm :</label>
                                             </td>
                                             <td>
                                                <%=tourist.getTouristNumNight()%>
                                             </td>
                                         </tr>
                                     </table>
                                 </td>
                                 <td>
                                     <table>
                                         <tr>
                                             <td><label>Họ tên :</label></td>
                                             <td><%=registration.getRegistrationUserName()%></td>
                                         </tr>
                                         <tr>
                                             <td><label>CMND :</label></td>
                                             <td><%=registration.getRegistrationUserCode()%></td>
                                         </tr>
                                         <tr>
                                             <td><label>Địa chỉ :</label></td>
                                             <td><%=registration.getRegistrationUserAddress()%></td>
                                         </tr>
                                         <tr>
                                             <td><label>Email :</label></td>
                                             <td><%=registration.getRegistrationUserEmail()%></td>
                                         </tr>
                                         <tr>
                                             <td><label>Số điện thoại :</label></td>
                                             <td><%=registration.getRegistrationUserPhone()%></td>
                                         </tr>
                                         <tr>
                                             <td><label>Số người :</label></td>
                                             <td><%=registration.getRegistrationNumMember()%></td>
                                         </tr>
                                         <tr>
                                             <td><label>Ngày khởi hành :</label></td>
                                             <td><%=Utility.parseDateToString(registration.getRegistrationDateStart(),"dd/MM/yyyy")%></td>
                                         </tr>
                                         <tr>
                                             <td><label>Phê duyệt :</label></td>
                                             <td>
                                                 <%if(registration.getRegistrationApproved()>0){%>
                                                 Đã duyệt
                                                 <%
                                                    }else{%>                                                    
                                                    <a class="toolbar" href="#" onclick="postRegister('adminform')">
                                                        <span title="Apply" class="icon-32-apply">
                                                        </span>
                                                            Duyệt
                                                    </a>
                                                    <%}%>
                                             </td>
                                         </tr>
                                     </table>
                                 </td>
                             </tr>
                         </table>
                         <form action="<%= request.getContextPath()%>/registertour" method="post" id="adminform" name="adminform">
                             <input id="id" name="id" type="hidden" value="<%=registration.getRegistrationId()%>"/>
                             <input name="action" type="hidden" value="update"/>
                         </form>
                     </div>
                     <div class="b">
                        <div class="b">
                            <div class="b"></div>
                        </div>
                     </div>
                 </div>
             </div>
         </div>
        <%@include file="../footer.jsp" %>
    </body>
</html>
