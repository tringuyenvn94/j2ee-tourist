<%--
    Document   : edit
    Created on : Jun 11, 2011, 11:00:24 PM
    Author     : VANGANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tourist.entities.Category" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<%
    //request.setCharacterEncoding("UTF-8");
    Category category=(Category)request.getAttribute("category");
    if(category==null)
        response.sendRedirect(request.getContextPath()+"/category");
    String message=(String)request.getAttribute("message");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=category.getCategoryName()%></title>
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
                                        <td id="toolbar-apply" class="button">
                                            <a class="toolbar" href="#" onclick="postCategory('adminform')">
                                                <span title="Apply" class="icon-32-apply">
                                                </span>
                                                    Cập nhật
                                            </a>
                                         </td>
                                         <td id="toolbar-cancel" class="button">
                                            <a class="toolbar" href="<%= request.getContextPath()%>/category">
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
                            Chỉnh sửa chủ đề
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
                         <form action="<%= request.getContextPath()%>/category" method="post" id="adminform" name="adminform">
                             <table width="100%">
                                 <tr>
                                     <td width="7%">
                                         <label>Tiêu đề :</label>
                                     </td>
                                     <td>
                                         <input id="title" type="text" name="title" value="<%=category.getCategoryName()%>" size="50" maxlength="255"/>
                                     </td>
                                 </tr>
                                 <tr>
                                     <td>
                                         <label>Loại chủ đề :</label>
                                     </td>
                                     <td>
                                         <select id="categorytype" name="categorytype" style="width: 150px">
                                             <option value="0">- Chọn loại -</option>
                                             <option value="1">Tin tức</option>
                                             <option value="2">Du lịch</option>
                                         </select>
                                         <script type="text/javascript">
                                             selectOption('categorytype',<%=category.getCategoryType()%>);
                                         </script>

                                     </td>
                                 </tr>
                                 <tr>
                                     <td width="7%">
                                         <label>Công khai :</label>
                                     </td>
                                     <td>
                                         <input type="radio" value="0" name="published" /><label>Ẩn</label>
                                         <input type="radio" value="1" name="published" checked="checked"/><label>Hiện</label>
                                         <script type="text/javascript">
                                             selectRadio('published',<%=category.getCategoryPublished()%>);
                                         </script>
                                     </td>
                                 </tr>
                             </table>
                             <input type="hidden" value="update" name="action"/>
                             <input type="hidden" value="<%=category.getCategoryId()%>" name="id"/>
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
