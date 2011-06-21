<%--
    Document   : edit
    Created on : Jun 11, 2011, 11:00:24 PM
    Author     : VANGANH
--%>

<%@page import="tourist.entities.ListTown"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tourist.entities.Destination" %>
<%@page import="tourist.entities.ListNation"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<%    
    Destination destination=(Destination)request.getAttribute("destination");
    if(destination==null)
        response.sendRedirect(request.getContextPath()+"/destination");
    ListNation listnation=(ListNation)request.getAttribute("listnation");
    ListTown listtown=(ListTown)request.getAttribute("listtown");
    String message=(String)request.getAttribute("message");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=destination.getDestinationName()%></title>
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
                                            <a class="toolbar" href="#" onclick="postDestination('adminform')">
                                                <span title="Apply" class="icon-32-apply">
                                                </span>
                                                    Cập nhật
                                            </a>
                                         </td>
                                         <td id="toolbar-cancel" class="button">
                                            <a class="toolbar" href="<%= request.getContextPath()%>/destination">
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
                            Chỉnh sửa điểm du lịch
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
                         <form action="<%= request.getContextPath()%>/destination" method="post" id="adminform" name="adminform">
                             <table width="100%">
                                 <tr>
                                     <td width="7%">
                                         <label>Tên :</label>
                                     </td>
                                     <td>
                                         <input id="title" type="text" name="title" value="<%=destination.getDestinationName()%>" size="50" maxlength="255"/>
                                     </td>
                                 </tr>
                                 <tr>
                                     <td>
                                         <label>Quốc gia :</label>
                                     </td>
                                     <td>
                                         <select id="nation" name="nation" style="width: 150px" onchange="getTown('nation')">
                                             <option value="0">- Chọn quốc gia -</option>
                                             <%
                                                if(listnation!=null){
                                                    for(int index=0;index<listnation.size();index++){%>
                                                    <option value="<%=listnation.get(index).getNationId()%>"><%=listnation.get(index).getNationName()%></option>
                                                        <%}
                                                    }
                                             %>
                                         </select>
                                         <%if(listtown!=null && listtown.size()>0){%>
                                            <script type="text/javascript">
                                                selectOption('nation',<%=listtown.get(0).getNationId()%>);
                                            </script>
                                         <%}%>
                                     </td>
                                 </tr>
                                 <tr>
                                     <td width="7%">
                                         <label>Tỉnh/TP :</label>
                                     </td>
                                     <td>
                                         <select id="town" name="town" style="width: 150px">
                                             <option value="0">- Chọn Tỉnh/TP -</option>
                                         <%if(listtown!=null){
                                             for(int index=0;index<listtown.size();index++){%>
                                             <option value="<%=listtown.get(index).getTownId()%>"><%=listtown.get(index).getTownName()%></option>
                                         <% }
                                          }%>
                                         </select>
                                         <script type="text/javascript">
                                                selectOption('town',<%=destination.getTownId()%>);
                                         </script>
                                     </td>
                                 </tr>
                             </table>
                             <input type="hidden" value="update" name="action"/>
                             <input type="hidden" value="<%=destination.getDestinationId()%>" name="id"/>
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
