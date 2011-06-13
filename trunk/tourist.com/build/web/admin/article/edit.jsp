<%--
    Document   : edit
    Created on : Jun 11, 2011, 11:00:24 PM
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
<%
    Article article=(Article)request.getAttribute("article");
    if(article==null)
        response.sendRedirect(request.getContextPath()+"/article");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=article.getArticleTitle()%></title>
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
                            Chỉnh sửa tin tức
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
                                         <label>Tiêu đề :</label> <input type="text" name="title" value="<%=article.getArticleTitle()%>" size="50" maxlength="255"/>
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
                                         <FCK:editor instanceName="fcksummary" basePath="/fckeditor/" height="300px" value="<%=article.getArticleSummary()%>" ></FCK:editor>
                                     </td>
                                 </tr>
                                 <tr>
                                     <td colspan="2">
                                         <label>Nội dung :</label>
                                     </td>
                                 </tr>
                                 <tr>
                                     <td colspan="2">
                                         <FCK:editor instanceName="fckbody" basePath="/fckeditor/" height="500px" value="<%=article.getArticleBody()%>" ></FCK:editor>
                                     </td>
                                 </tr>
                             </table>
                             <input type="hidden" value="update" name="action"/>
                             <input type="hidden" value="<%=article.getArticleId()%>" name="articleid"/>
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
