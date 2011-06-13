<%-- 
    Document   : article
    Created on : Jun 11, 2011, 11:00:24 PM
    Author     : VANGANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="admin.SignIn" %>
<%@page import="tourist.entities.ListArticle"%>
<%@page import="tourist.business.Utility"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
    if(SignIn.checkLogin(request)!=true)
        response.sendRedirect(request.getContextPath()+"/Admin/login.jsp");

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tin tức</title>
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
                                            <a class="toolbar" href="<%= request.getContextPath()%>/article?action=post">
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
                            Quản lý tin tức
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
                                 <th><a href="#">Tiêu đề</a></th>
                                 <th nowrap="nowrap" width="15%"><a href="#">Lĩnh vực</a></th>
                                 <th nowrap="nowrap" width="10%"><a href="#">Ngày đăng</a></th>
                                 <th nowrap="nowrap" width="5%"><a href="#">Công khai</a></th>
                                 <th nowrap="nowrap" width="5%"><a href="#">Mã tin</a></th>
                             </tr>
                             <%
                                ListArticle listarticle=(ListArticle)request.getAttribute("listarticle");
                                //,
                                for(int index=0;index<listarticle.size();index++){%>
                                <tr>
                                    <td align="center"><%=(index+1)%></td>
                                    <td><a href="<%= request.getContextPath()%>/article?action=edit&id=<%=listarticle.get(index).getArticleId()%>"><%=listarticle.get(index).getArticleTitle()%></a></td>
                                    <td><%=listarticle.get(index).getCategoryId()%></td>
                                    <td align="center"><%=Utility.parseDateToString(listarticle.get(index).getArticleDate(), "dd/MM/yyyy")%></td>
                                    <td align="center"><%=listarticle.get(index).getArticlePublished()%></td>
                                    <td align="center"><%=listarticle.get(index).getArticleId()%></td>
                                </tr>
                              <%} %>
                            
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
