<%-- 
    Document   : index
    Created on : Jun 10, 2011, 4:32:10 PM
    Author     : VANGANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tourist.com - Administration</title>
        <%@include file="script.jsp" %>
        <link href="<%= request.getContextPath()%>/style/css/admin/login.css" rel="stylesheet" type="text/css">
        <script language="javascript" type="text/javascript">
            function setFocus() {
                    document.login.username.select();
                    document.login.username.focus();
            }
        </script>
    </head>
    <body onload="javascript:setFocus()">
        <%@include file="header.jsp" %>
        <div id="content-box">
            <div class="padding">
                <div id="element-box" class="login">
                    <div class="t">
                            <div class="t">
                                    <div class="t"></div>
                            </div>
                    </div>
                    <div class="m">
                        <h1>Tourist! Administration Login</h1>
                        <dl id="system-message">
                            <!-- thong tin loi dang nhap -->
                            <%
                                String errorinfo=(String)request.getAttribute("errorinfo");
                                if(errorinfo!=null && !errorinfo.equals("")){%>
                                    <dd class="error message fade">
                                        <ul>
                                            <li><%=errorinfo%></li>
                                        </ul>
                                    </dd>
                                <%}%>
                        </dl>
                        <div id="section-box">
                            <div class="t">
                                <div class="t">
                                    <div class="t"></div>
                                </div>
                            </div>
                            <div class="m">
                                <form action="<%= request.getContextPath()%>/login" method="post" name="login" id="form-login" style="clear: both;">
                                    <p id="form-login-username">
                                        <label for="modlgn_username">Username</label>
                                        <input name="username" id="modlgn_username" class="inputbox" size="15" type="text">
                                    </p>

                                    <p id="form-login-password">
                                        <label for="modlgn_passwd">Password</label>
                                        <input name="passwd" id="modlgn_passwd" class="inputbox" size="15" type="password">
                                    </p>

                                    <p id="login-error-message"></p>

                                    <p>	</p>
                                    
                                    <div class="button_holder">
                                        <div class="button1">
                                            <div class="next">
                                                <a onclick="login.submit();">Login</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="clr"></div>
                                    <input style="border: 0pt none; padding: 0pt; margin: 0pt; width: 0px; height: 0px;" value="Login" type="submit">
                                    <input name="option" value="com_login" type="hidden">
                                    <input name="task" value="login" type="hidden">
                                    <input name="36aee3f0bc1ff8263d471fd19d26527f" value="1" type="hidden">
                                </form>
                                <div class="clr"></div>
                            </div>
                            <div class="b">
                                <div class="b">
                                    <div class="b"></div>
                                </div>
                            </div>
                        </div>
                        <p>Use a valid username and password to gain access to the Administrator Back-end.</p>
                        <p>
                            <a href="<%= request.getContextPath()%>">Return to site Home Page</a>
                        </p>
                        <div id="lock"></div>
                        <div class="clr"></div>
                    </div>
                    <div class="b">
                        <div class="b">
                            <div class="b"></div>
                        </div>
                    </div>
                </div>
                <noscript>
                        Warning! JavaScript must be enabled for proper operation of the Administrator back-end.			</noscript>
                <div class="clr"></div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
