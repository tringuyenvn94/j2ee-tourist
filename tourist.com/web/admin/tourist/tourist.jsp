<%-- 
    Document   : tourist
    Created on : Jun 12, 2011, 9:49:38 AM
    Author     : VANGANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="admin.SignIn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
    if(SignIn.checkLogin(request)!=true)
        response.sendRedirect(request.getContextPath()+"/Admin/login.jsp");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chương trình tour</title>
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
                                        <td id="toolbar-new" class="button">
                                            <a class="toolbar" href="#">
                                                <span title="New" class="icon-32-new">
                                                </span>
                                                    Đăng tin
                                            </a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="header icon-48-article">
                            Quản lý tour
                        </div>
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
                         <table class="tbstyle">
                             <tr class="tbhead">
                                 <th nowrap="nowrap" width="3%">#</th>
                                 <th><a href="#">Tên chương trình</a></th>
                                 <th nowrap="nowrap" width="15%"><a href="#">Loại tour</a></th>
                                 <th nowrap="nowrap" width="10%"><a href="#">Ngày đăng</a></th>
                                 <th nowrap="nowrap" width="5%"><a href="#">Công khai</a></th>
                                 <th nowrap="nowrap" width="5%"><a href="#">Mã tour</a></th>
                             </tr>
                         </table>
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