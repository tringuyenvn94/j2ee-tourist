<%-- 
    Document   : Trangchu
    Created on : May 8, 2011, 1:54:19 PM
    Author     : VANGANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tourist.data.*" %>
<%@page import="tourist.entities.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chu</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            String result="fail";
            NationDAO nationdao=NationDAO.getInstance();
            Nation nation=new Nation();
            //nation.setNationId(5);
            nation.setNationName("Úc");
            //boolean flag=nationdao.updateNation(nation);
            nationdao.setNation(nation);
            //if(flag==true)
            if(nation.getNationId()!=0)
                result="success: "+nation.getNationId();
            /*ListNation listnation=nationdao.getListNation();
            int num=listnation.size();
            for(int index=0;index<num;index++){*/%>
                <%//listnation.get(index).getNationId()%>
                -<%=result%>
                <%//listnation.get(index).getNationName()%>
                <br>
            <%//}%>
    </body>
</html>
