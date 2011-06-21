<%-- 
    Document   : category
    Created on : Jun 16, 2011, 4:49:41 PM
    Author     : VANGANH
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tourist.entities.ListDestination" %>
<%@page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
    ListDestination listdestination=(ListDestination)request.getAttribute("listdestination");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý điểm du lịch</title>
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
                                            <a class="toolbar" href="<%= request.getContextPath()%>/destination?action=post">
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
                            Quản lý điểm du lịch
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
                                 <th><a href="#">Tên điểm du lịch</a></th>
                                 <th nowrap="nowrap" width="30%"><a href="#">Tỉnh/Thành Phố</a></th>
                                 <th nowrap="nowrap" width="5%"><a href="#">Mã chủ đề</a></th>
                                 <th nowrap="nowrap" width="5%"><a href="#">Xóa</a></th>
                             </tr>
                             <%
                                if(listdestination!=null){// && listcategorytype!=null && listcategory.size()==listcategorytype.size()){
                                    for(int index=0;index<listdestination.size();index++){%>
                                    <tr>
                                        <td align="center"><%=index+1%></td>
                                        <td><a href="<%= request.getContextPath()%>/destination?action=edit&id=<%=listdestination.get(index).getDestinationId()%>"><%=listdestination.get(index).getDestinationName()%></a></td>
                                        <td><%=listdestination.get(index).getTownId()%></td>
                                        <td align="center"><%=listdestination.get(index).getDestinationId()%></td>
                                        <td align="center">
                                            <a href="javascript:void(0);" onclick="removeObject('adminform',<%=listdestination.get(index).getDestinationId()%>)">
                                                <img alt="Xóa"  src="<%= request.getContextPath()%>/style/image/admin/icon-32-remove.jpg" width="16" height="16" border="0"/>
                                            </a>
                                        </td>
                                    </tr>
                                    <%}
                                }
                            %>
                         </table>
                         <form action="<%= request.getContextPath()%>/destination" method="post" id="adminform" name="adminform">
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
