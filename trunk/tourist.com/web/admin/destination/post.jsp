<%--
    Document   : post
    Created on : Jun 12, 2011, 4:46:06 PM
    Author     : VANGANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tourist.entities.ListNation" %>
<%@page import="tourist.entities.ListTown" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
    ListNation listnation=(ListNation)request.getAttribute("listnation");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm điểm du lịch</title>
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
                                      <td id="toolbar-save" class="button">
                                          <a class="toolbar" href="javascript:void(0);" onclick="postDestination('adminform')">
                                                <span title="Save" class="icon-32-save">
                                                </span>
                                                    Lưu
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
                            Thêm mới điểm du lịch
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
                         <form action="<%= request.getContextPath()%>/destination" method="post" id="adminform" name="adminform">
                             <table width="100%">
                                 <tr>
                                     <td width="7%">
                                         <label>Tên :</label>
                                     </td>
                                     <td>
                                         <input id="title" type="text" name="title" value="" size="50" maxlength="255"/>
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
                                     </td>                                     
                                 </tr>
                                 <tr>
                                     <td width="7%">
                                         <label>Tỉnh/TP :</label>
                                     </td>
                                     <td>
                                         <select id="town" name="town" style="width: 150px">
                                             <option value="0">- Chọn Tỉnh/TP -</option>
                                         </select>
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