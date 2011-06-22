<%-- 
    Document   : lefttemplate
    Created on : Jun 22, 2011, 6:49:56 PM
    Author     : Dung Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <%@include file="/template/script.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP template</title>
    </head>
    <body class="left-n-right-col">
        <div id="page-l">
            <div id="page-r">
                <%@include file="/template/header.jsp" %>

                <div id="content">
                    <%@include file="/template/leftsidebar.jsp" %>

                    <div id="main">
                        <div id="breadcrumb">
                            <h3 class="here">You are here:</h3>
                        </div>
                        