<%-- 
    Document   : news
    Created on : Jun 23, 2011, 6:22:32 PM
    Author     : Dung Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tourist.entities.ListArticle" %>

<%@include file="/template/lefttemplate.jsp" %>


<%
    ListArticle listarticle = (ListArticle) request.getAttribute("listarticle");
%>

<div id="main-content" style="width: 100%">
    <div class="blog catblog">
        <div class="rowsep leadingsep clear"></div>
        <%
            if (listarticle != null){
                for (int i = 0; i < listarticle.size(); i++){%>
                    <div class="blog_row cols1">
                        <div class="col0">
                            <div class="article">
                                <h2 class="contentheading">
                                    <a class="contentpagetitle" href="<%= request.getContextPath()%>/news?action=detail&id=<%= listarticle.get(i).getArticleId() %>">
                                        <%= listarticle.get(i).getArticleTitle()%>
                                    </a>
                                </h2>
                                <ul class="meta"></ul>
                                <p style="float: left">
                                    <a href="<%= request.getContextPath()%>/news?action=detail&id=<%= listarticle.get(i).getArticleId() %>">
                                    <img width="135" height="53" border="0" src="<%= listarticle.get(i).getArticleThumbnail()%>"/>
                                    </a>
                                </p>
                                <p style="text-align: justify; float: left; color: black">
                                    <%= listarticle.get(i).getArticleSummary()%>
                                </p>
                                <p style="text-align: justify;" float: left">&nbsp;</p>
                                <p class="readmore">
                                    <a class="readon" href="<%= request.getContextPath()%>/news?action=detail&id=<%= listarticle.get(i).getArticleId() %>">
                                        Đọc thêm: <%= listarticle.get(i).getArticleTitle()%> 
                                    </a>
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