<%-- 
    Document   : category
    Created on : Jun 16, 2011, 4:49:41 PM
    Author     : VANGANH
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tourist.entities.ListCategory" %>
<%@page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
    ListCategory listcategory=(ListCategory)request.getAttribute("listcategory");
    List<String> listcategorytype=(List<String>)request.getAttribute("listcategorytype");
    String message=(String)request.getAttribute("message");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý chủ đề</title>
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
                                            <a class="toolbar" href="<%= request.getContextPath()%>/category?action=post">
                                                <span title="New" class="icon-32-new">
                                                </span>
                                                    Thêm mới
                                            </a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="header icon-48-article">
                            Quản lý chủ đề
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
                                 <th><a href="#">Tên chủ đề</a></th>
                                 <th nowrap="nowrap" width="15%"><a href="#">Loại</a></th>
                                 <th nowrap="nowrap" width="5%"><a href="#">Công khai</a></th>
                                 <th nowrap="nowrap" width="5%"><a href="#">Mã chủ đề</a></th>
                                 <th nowrap="nowrap" width="5%"><a href="#">Xóa</a></th>
                             </tr>
                             <%
                                if(listcategory!=null && listcategorytype!=null && listcategory.size()==listcategorytype.size()){
                                    for(int index=0;index<listcategory.size();index++){%>
                                    <tr>
                                        <td align="center"><%=index+1%></td>
                                        <td><a href="<%= request.getContextPath()%>/category?action=edit&id=<%=listcategory.get(index).getCategoryId()%>"><%=listcategory.get(index).getCategoryName()%></a></td>
                                        <td><%=listcategorytype.get(index)%></td>
                                        <td align="center"><%=listcategory.get(index).getCategoryPublished()%></td>
                                        <td align="center"><%=listcategory.get(index).getCategoryId()%></td>
                                        <td align="center">
                                            <a href="javascript:void(0);" onclick="removeObject('adminform',<%=listcategory.get(index).getCategoryId()%>)">
                                                <img alt="Xóa"  src="<%= request.getContextPath()%>/style/image/admin/icon-32-remove.jpg" width="16" height="16" border="0"/>
                                            </a>
                                        </td>
                                    </tr>
                                    <%}
                                }
                            %>
                         </table>
                         <form action="<%= request.getContextPath()%>/category" method="post" id="adminform" name="adminform">
                             <input id="id" name="id" type="hidden" value=""/>
                             <input name="action" type="hidden" value="del"/>
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
