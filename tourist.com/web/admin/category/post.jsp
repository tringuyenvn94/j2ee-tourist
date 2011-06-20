<%--
    Document   : post
    Created on : Jun 12, 2011, 4:46:06 PM
    Author     : VANGANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tourist.entities.Category" %>
<%@page import="tourist.entities.ListCategory" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
    
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm chủ đề</title>
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
                                          <a class="toolbar" href="#" onclick="postCategory('adminform')">
                                                <span title="Save" class="icon-32-save">
                                                </span>
                                                    Lưu
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
                            Thêm mới chủ đề
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
                         <form action="<%= request.getContextPath()%>/category" method="post" id="adminform" name="adminform">
                             <table width="100%">
                                 <tr>
                                     <td width="7%">
                                         <label>Tiêu đề :</label>
                                     </td>
                                     <td>
                                         <input id="title" type="text" name="title" value="" size="50" maxlength="255"/>
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
                                     </td>                                     
                                 </tr>
                                 <tr>
                                     <td width="7%">
                                         <label>Công khai :</label>
                                     </td>
                                     <td>
                                         <input type="radio" value="0" name="published" /><label>Ẩn</label>
                                         <input type="radio" value="1" name="published" checked="checked"/><label>Hiện</label>
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