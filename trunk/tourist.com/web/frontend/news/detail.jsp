<%-- 
    Document   : detail
    Created on : Jun 23, 2011, 7:09:29 PM
    Author     : Dung Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tourist.entities.Article" %>

<%@include file="/template/lefttemplate.jsp" %>


<%
    Article article = (Article) request.getAttribute("article");
%>

<div id="main-content" style="width: 100%">
    <div class="article heading">
        <h1 class="contentheading">
            <a class="contentpagetitle" href="#">
                <%= article.getArticleTitle()%>
            </a>
        </h1>
        <div class="articlecontent">
            <ul class="meta"></ul>
            
            <p>
                <a class="img_caption left" style="float: left; width: 154px;" href="">
                    <img width="154" height="110" border="0" align="left" src="<%= article.getArticleThumbnail()%>" class="caption"/>
                </a>
            </p>
            <div style="float: left">
                <%= article.getArticleSummary() %>
            </div>
            <div style="float: left">
                <%= article.getArticleBody() %>
            </div>
        </div>
    </div>
</div>


<%@include file="/template/righttemplate.jsp" %>