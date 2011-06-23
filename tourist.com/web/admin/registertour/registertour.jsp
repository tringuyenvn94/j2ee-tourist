<%-- 
    Document   : registertour
    Created on : Jun 22, 2011, 10:13:49 AM
    Author     : VANGANH
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tourist.entities.ListRegistration" %>
<%@page import="tourist.entities.ListTourist" %>
<%@page import="tourist.business.Utility"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
    ListRegistration listregistration=(ListRegistration)request.getAttribute("listregistration");
    ListTourist listtourist=(ListTourist)request.getAttribute("listtourist");
    String message=(String)request.getAttribute("message");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý đăng ký tour</title>
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
                        <div class="header icon-48-article">
                            Quản lý điểm du lịch
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
                                 <th><a href="#">Người đăng ký</a></th>
                                 <th nowrap="nowrap" width="35%"><a href="#">Chương trình Tour</a></th>
                                 <th nowrap="nowrap" width="20%"><a href="#">Email</a></th>
                                 <th nowrap="nowrap" width="10%"><a href="#">Số điện thoại</a></th>
                                 <th nowrap="nowrap" width="10%"><a href="#">Ngày đăng</a></th>
                                 <th nowrap="nowrap" width="5%"><a href="#">Đã duyệt</a></th>
                                 <th nowrap="nowrap" width="5%"><a href="#">Xóa</a></th>
                             </tr>
                             <%
                                if(listregistration!=null && listtourist!=null && listregistration.size()==listtourist.size()){
                                    for(int index=0;index<listregistration.size();index++){%>
                                    <tr>
                                        <td align="center"><%=index+1%></td>
                                        <td><a href="<%= request.getContextPath()%>/registertour?action=edit&id=<%=listregistration.get(index).getRegistrationId()%>"><%=listregistration.get(index).getRegistrationUserName()%></a></td>
                                        <td><%=listtourist.get(index).getTouristTitle()%></td>
                                        <td><%=listregistration.get(index).getRegistrationUserEmail()%></td>
                                        <td align="center"><%=listregistration.get(index).getRegistrationUserPhone()%></td>
                                        <td align="center"><%=Utility.parseDateToString(listregistration.get(index).getRegistrationDate(),"dd/MM/yyyy")%></td>
                                        <td align="center">
                                            <%if(listregistration.get(index).getRegistrationApproved()==0){%>
                                                    <img alt="Ẩn"  src="<%= request.getContextPath()%>/style/image/admin/icon-32-unpublish.png" width="16" height="16" border="0"/>
                                                 <%}else{%>
                                                 <img alt="Hiện"  src="<%= request.getContextPath()%>/style/image/admin/icon-32-publish.png" width="16" height="16" border="0"/>
                                                <%}%>
                                        </td>
                                        <td align="center">
                                            <a href="javascript:void(0);" onclick="removeObject('adminform',<%=listregistration.get(index).getRegistrationId()%>)">
                                                <img alt="Xóa"  src="<%= request.getContextPath()%>/style/image/admin/icon-32-remove.jpg" width="16" height="16" border="0"/>
                                            </a>
                                        </td>
                                    </tr>
                                    <%}
                                }
                            %>
                         </table>
                         <form action="<%= request.getContextPath()%>/registertour" method="post" id="adminform" name="adminform">
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
