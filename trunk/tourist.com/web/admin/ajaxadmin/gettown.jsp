<%-- 
    Document   : gettown
    Created on : Jun 19, 2011, 11:18:14 PM
    Author     : VANGANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tourist.entities.ListTown" %>

<option value="0">- Chọn Tỉnh/TP -</option>
<%
    ListTown listtown=(ListTown)request.getAttribute("listtown");

    if(listtown!=null){
        for(int index=0;index<listtown.size();index++){%>
        <option value="<%=listtown.get(index).getTownId()%>"><%=listtown.get(index).getTownName()%></option>
   <%   }
    }
    %>
