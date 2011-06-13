<%-- 
    Document   : post
    Created on : Jun 11, 2011, 11:57:06 AM
    Author     : VANGANH
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="../fckeditor/fckeditor.js"></script>
       <!--<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>-->

    </head>
    <body>
        <h1>Hello World!</h1>
        <textarea name="txtnoidung" id="txtnoidung" rows="10" cols="40"></textarea>
        <script type="text/javascript" language="javascript">
            //CKEDITOR.replace( 'txtnoidung' );
        </script>
        <!---->
        <%--<ckeditor:editor editor="cfeidtor" basePath="/cfeditor/"></ckeditor:editor>--%>
        FCKEditor
        <%--<FCK:editor instanceName="fckedito" basePath="/fckeditor/"></FCK:editor>--%>
       <FCK:editor instanceName="fckedito" basePath="/fckeditor/" ></FCK:editor>
    </body>
</html>
