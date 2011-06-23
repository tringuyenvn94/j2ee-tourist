<%-- 
    Document   : detail
    Created on : Jun 22, 2011, 11:05:18 PM
    Author     : Dung Nguyen
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tourist.entities.Tourist" %>

<%@include file="/template/lefttemplate.jsp" %>


<%
    Tourist tourist = (Tourist) request.getAttribute("tourist");
%>

<div id="main-content" style="width: 100%">
    <div class="article heading">
        <h1 class="contentheading">
            <a class="contentpagetitle" href="#">
                <%= tourist.getTouristTitle()%>
            </a>
        </h1>
        <div class="articlecontent">
            <ul class="meta"></ul>

            <p>
                <a class="img_caption left" style="float: left; width: 154px;" href="">
                    <%
                        if (tourist.getTouristImage().isEmpty() || tourist.getTouristImage().equalsIgnoreCase("")) {%>                                    
                    <img width="154" height="110" border="0" align="left" src="<%= request.getContextPath()%>/style/image/pic/image_default.jpg" class="caption"/>
                    <% } else {%>
                    <img width="154" height="110" border="0" align="left" src="<%= tourist.getTouristImage()%>" class="caption"/>
                    <%}%>
                </a>

                <a target="_blank" href="<%= request.getContextPath()%>/tour?action=order&id=<%= tourist.getTouristId()%>" class="caption" style="float: right">
                    <img width="70" height="24" border="0" src="<%= request.getContextPath()%>/style/image/4.jpg"/>
                </a>

                <span style="font-family: arial,helvetica,sans-serif; color: #000000;">&nbsp; Thời gian: &nbsp;&nbsp; 
                    <strong>
                        <span style="color: #ff0000;"><%= tourist.getTouristNumDay()%></span>
                        <span style="color: #ff0000;"> ngày </span>
                        <span style="color: #ff0000;"><%= tourist.getTouristNumNight()%></span>
                        <span style="color: #ff0000;"> đêm</span>
                    </strong>                                
                </span>
                <br/>
                <span style="font-family: arial,helvetica,sans-serif;">&nbsp; Địa điểm: &nbsp;&nbsp;</span>
                <br/>
                <span style="font-family: arial,helvetica,sans-serif;">&nbsp; Xuất phát: &nbsp;&nbsp;
                    <strong>TP.HCM</strong>
                </span>
                <br/>
                <span style="font-family: arial,helvetica,sans-serif;">&nbsp; Trở về: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <strong>TP.HCM</strong>
                </span>
                <br/>
                <span style="font-family: arial,helvetica,sans-serif;">&nbsp; Giá:  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <strong><span style="color: #ff0000;"><%= tourist.getTouristPrice()%>&nbsp;&nbsp;VND</span></strong>
                </span>
                <br/><br/>
            </p>

            <p>&nbsp;</p>


            <div>
                <%= tourist.getTouristBody()%>
            </div>
        </div>
    </div>
</div>


<%@include file="/template/righttemplate.jsp" %>