<%-- 
    Document   : tour
    Created on : Jun 22, 2011, 7:53:37 PM
    Author     : Dung Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tourist.entities.ListTourist" %>

<%@include file="/template/lefttemplate.jsp" %>


<%
    ListTourist listtourist = (ListTourist) request.getAttribute("listtourist");
%>


<div id="main-content" style="width: 100%">
    <div class="blog catblog">
        <%
            if (listtourist != null) {
                for (int i = 0; i < listtourist.size(); i++) {%>
                <div class="blog_row cols1">
                    <div class="col0">
                        <div class="article article131">
                            <h2 class="contentheading">
                                <a class="contentpagetitle" href="<%= request.getContextPath()%>/tour?action=detail&id=<%= listtourist.get(i).getTouristId() %>">
                                    <%= listtourist.get(i).getTouristTitle()%>
                                </a>
                            </h2>
                            <ul class="meta"></ul>
                            <p>
                                <a class="caption" href="<%= request.getContextPath()%>/tour?action=detail&id=<%= listtourist.get(i).getTouristId() %>">                                
                                    <div class="img_caption left" style="float: left; width: 154px;">
                                        <img width="154" height="110" border="0" align="left" src="<%= listtourist.get(i).getTouristImage()%>" class="caption"/>
                                    </div>
                                </a>

                                <a target="_blank" href="" class="caption" style="float: right">
                                    <img width="70" height="24" border="0" src="<%= request.getContextPath()%>/style/image/4.jpg"/>
                                </a>

                                <span style="font-family: arial,helvetica,sans-serif; color: #000000;">&nbsp; Thời gian: &nbsp;&nbsp; 
                                    <strong>
                                        <span style="color: #ff0000;"><%= listtourist.get(i).getTouristNumDay() %></span>
                                        <span style="color: #ff0000;"> ngày </span>
                                        <span style="color: #ff0000;"><%= listtourist.get(i).getTouristNumNight() %></span>
                                        <span style="color: #ff0000;"> đêm</span>
                                    </strong>                                
                                </span>
                                <br/>
                                <span style="font-family: arial,helvetica,sans-serif;">&nbsp; Địa điểm: &nbsp;&nbsp;</span>
                                <br/>
                                <span style="font-family: arial,helvetica,sans-serif;">&nbsp; Xuất phát: &nbsp;&nbsp;</span>
                                <br/>
                                <span style="font-family: arial,helvetica,sans-serif;">&nbsp; Trở về: &nbsp;&nbsp;&nbsp;</span>
                                <br/>
                                <span style="font-family: arial,helvetica,sans-serif;">&nbsp; Giá:  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <strong><span style="color: #ff0000;"><%= listtourist.get(i).getTouristPrice() %>&nbsp;&nbsp;VND</span></strong>
                                </span>
                                <br/><br/>

                                <p class="readmore">
                                    <a class="readon" href="<%= request.getContextPath()%>/tour?action=detail&id=<%= listtourist.get(i).getTouristId() %>">
                                        Đọc thêm: <%= listtourist.get(i).getTouristTitle() %>
                                    </a>
                                </p>
                            </p>
                        </div>
                    </div>
                </div>
                <%}
            }
        %>
    </div>
</div>




<%@include file="/template/righttemplate.jsp" %>