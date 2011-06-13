<%-- 
    Document   : post
    Created on : Jun 12, 2011, 4:46:06 PM
    Author     : VANGANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="admin.SignIn" %>
<%@page import="tourist.entities.Article"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
    if(SignIn.checkLogin(request)!=true)
        response.sendRedirect(request.getContextPath()+"/Admin/login.jsp");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>"Đăng tin tức"</title>
        <%@include file="../script.jsp" %>
        <script type="text/javascript" src="../fckeditor/fckeditor.js"></script>
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
                                      <td id="toolbar-save" class="button">
                                            <a class="toolbar" href="#">
                                                <span title="Save" class="icon-32-save">
                                                </span>
                                                    Lưu
                                            </a>
                                        </td>

                                         <td id="toolbar-apply" class="button">
                                            <a class="toolbar" href="#">
                                                <span title="Apply" class="icon-32-apply">
                                                </span>
                                                    Cập nhật
                                            </a>
                                         </td>
                                        <td id="toolbar-cancel" class="button">
                                            <a class="toolbar" href="<%= request.getContextPath()%>/article">
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
                            Thêm mới tin tức
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
                         <form action="<%= request.getContextPath()%>/article" method="post" id="postarticle" name="postarticle">
                             <table width="100%">
                                 <tr>
                                     <td>
                                         <label>Tiêu đề :</label> <input type="text" name="title" value="" size="50" maxlength="255"/>
                                     </td>
                                     <td>
                                         <label>Công khai :</label>
                                         <input type="radio" value="0" name="published" /><label>Ẩn</label>
                                         <input type="radio" value="1" name="published" checked="checked"/><label>Hiện</label>
                                     </td>
                                 </tr>  
                                 <tr>
                                     <td colspan="2">
                                         <label>Sơ lược :</label>
                                     </td>                                     
                                 </tr>  
                                 <tr>
                                     <td colspan="2">
                                         <FCK:editor instanceName="fcksummary" basePath="/fckeditor/" height="300px" value="abc" ></FCK:editor>
                                     </td>                                     
                                 </tr>
                                 <tr>
                                     <td colspan="2">
                                         <label>Nội dung :</label>
                                     </td>
                                 </tr>
                                 <tr>
                                     <td colspan="2">
                                         <FCK:editor instanceName="fckbody" basePath="/fckeditor/" height="500px" ></FCK:editor>
                                     </td>
                                 </tr>
                             </table>
                             <input type="hidden" value="add" name="action"/>
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