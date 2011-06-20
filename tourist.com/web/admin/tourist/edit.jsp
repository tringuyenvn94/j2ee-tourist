<%--
    Document   : edit
    Created on : Jun 11, 2011, 11:00:24 PM
    Author     : VANGANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tourist.entities.Tourist"%>
<%@page import="tourist.entities.Category" %>
<%@page import="tourist.entities.ListCategory" %>
<%@page import="tourist.business.Utility" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<%
    Tourist tourist=(Tourist)request.getAttribute("tourist");
    if(tourist==null){
        response.sendRedirect(request.getContextPath()+"/tourist");
        return;
    }
    ListCategory listcategory=(ListCategory)request.getAttribute("listcategory");
    String message=(String)request.getAttribute("message");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=tourist.getTouristTitle()%></title>
        <%@include file="../script.jsp" %>
        <script type="text/javascript" src="<%= request.getContextPath()%>/style/js/mootools-more.js"></script>
        <script type="text/javascript" src="<%= request.getContextPath()%>/style/js/pickdate/Picker.js"></script>
        <script type="text/javascript" src="<%= request.getContextPath()%>/style/js/pickdate/Picker.Attach.js"></script>
        <script type="text/javascript" src="<%= request.getContextPath()%>/style/js/pickdate/Picker.Date.js"></script>
        <script type="text/javascript" src="<%= request.getContextPath()%>/fckeditor/fckeditor.js"></script>
        <link href="<%= request.getContextPath()%>/style/css/admin/datepicker_vista.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" language="javascript">
           window.addEvent('domready', function(){
		new Picker.Date('date', {
			pickerClass: 'datepicker_vista'
		});
	});

        </script>
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
                                            <a class="toolbar" href="#" onclick="postTourist('adminform')">
                                                <span title="Apply" class="icon-32-apply">
                                                </span>
                                                    Cập nhật
                                            </a>
                                         </td>
                                         <td id="toolbar-cancel" class="button">
                                            <a class="toolbar" href="<%= request.getContextPath()%>/tourist">
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
                            Chỉnh sửa tour
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
                         <form action="<%= request.getContextPath()%>/tourist" method="post" id="adminform" name="adminform">
                             <table width="100%">
                                 <tr>
                                     <td width="7%">
                                         <label>Tiêu đề :</label>
                                     </td>
                                     <td>
                                         <input id="title" type="text" name="title" value="<%=tourist.getTouristTitle()%>" size="50" maxlength="255"/>
                                     </td>
                                     <td width="7%">
                                         <label>Giá:</label>
                                     </td>
                                     <td>
                                         <input id="price" name="price" type="text" value="<%=tourist.getTouristPrice()%>" /> (VND)
                                     </td>
                                 </tr>
                                 <tr>
                                     <td>
                                         <label>Chủ đề :</label>
                                     </td>
                                     <td>
                                         <select id="category" name="category" style="width: 150px">
                                             <option value="0">- Chọn chủ đề -</option>
                                             <%
                                                if(listcategory!=null){
                                                    for(int index=0;index<listcategory.size();index++){%>
                                                        <option value="<%=listcategory.get(index).getCategoryId()%>"><%=listcategory.get(index).getCategoryName()%></option>
                                             <%}}%>
                                         </select>
                                         <script>
                                             selectOption('category',<%=tourist.getCategoryId()%>);
                                         </script>
                                     </td>
                                     <td>
                                         <label>Số ngày :</label>
                                     </td>
                                     <td>
                                         <input id="numday" type="text" name="numday" value="<%=tourist.getTouristNumDay()%>" size="5"  maxlength="2"/> (ngày)
                                     </td>
                                 </tr>
                                 <tr>
                                     <td width="7%">
                                         <label>Công khai :</label>
                                     </td>
                                     <td>
                                         <input type="radio" value="0" name="published" /><label>Ẩn</label>
                                         <input type="radio" value="1" name="published" checked="checked"/><label>Hiện</label>
                                         <script>
                                             selectRadio('published',<%=tourist.getTouristPublished()%>);
                                         </script>
                                     </td>
                                     <td>
                                         <label>Số đêm :</label>
                                     </td>
                                     <td>
                                         <input id="numnight" type="text" name="numnight" value="<%=tourist.getTouristNumNight()%>" size="5" maxlength="2"/> (đêm)
                                     </td>
                                 </tr>
                                 <tr>
                                     <td>
                                         <label>Nổi bật :</label>
                                     </td>
                                     <td>
                                         <input type="radio" value="0" name="special" checked="checked" /><label>Không</label>
                                         <input type="radio" value="1" name="special" /><label>Có</label>
                                         <script>
                                             selectRadio('special',<%=tourist.getTouristSpecial()%>);
                                         </script>
                                     </td>
                                     <td>
                                         <label>Ngày đăng :</label>
                                     </td>
                                     <td>
                                         <input id="date" type="text" name="date" value="<%=Utility.parseDateToString(tourist.getTouristDate(),"MM/dd/yyyy")%>" size="20"/>
                                     </td>
                                 </tr>
                                 <tr>
                                     <td>
                                         <label>Sơ lược :</label>
                                     </td>
                                     <td colspan="2">
                                         <FCK:editor instanceName="fcksummary" basePath="/fckeditor/" height="300px" value="<%=tourist.getTouristSummary()%>" ></FCK:editor>
                                     </td>
                                 </tr>
                                 <tr>
                                     <td>
                                         <label>Nội dung :</label>
                                     </td>
                                     <td colspan="2">
                                         <FCK:editor instanceName="fckbody" basePath="/fckeditor/" height="500px" value="<%=tourist.getTouristBody()%>" ></FCK:editor>
                                     </td>
                                 </tr>
                             </table>
                             <input type="hidden" value="update" name="action"/>
                             <input type="hidden" value="<%=tourist.getTouristId()%>" name="id"/>
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
