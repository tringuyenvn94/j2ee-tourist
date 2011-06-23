<%-- 
    Document   : order
    Created on : Jun 23, 2011, 8:25:02 PM
    Author     : Dung Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/template/lefttemplate.jsp" %>

<div id="main-content">

    <form class="form-validate" name="josForm" id="josForm" method="post" action="">
        <table width="100%" cellspacing="0" cellpadding="0" border="0" class="contentpane">
            <tbody>
                <tr>
                    <td width="30%" height="40">
                        <label for="name" id="namemsg">
			Tên:
                        </label>
                    </td>
                    <td>
                        <input type="text" maxlength="50" class="inputbox required" value="" size="40" id="name" name="name"/> *
                    </td>
                </tr>
                <tr>
                    <td height="40">
                        <label for="username" id="usernamemsg">
			Tên thành viên:
                        </label>
                    </td>
                    <td>
                        <input type="text" maxlength="25" class="inputbox required validate-username" value="" size="40" name="username" id="username"/> *
                    </td>
                </tr>
                <tr>
                    <td height="40">
                        <label for="email" id="emailmsg">
			Email::
                        </label>
                    </td>
                    <td>
                        <input type="text" maxlength="100" class="inputbox required validate-email" value="" size="40" name="email" id="email"/> *
                    </td>
                </tr>
                <tr>
                    <td height="40">
                        <label for="password" id="pwmsg">
			Mật khẩu:
                        </label>
                    </td>
                    <td>
                        <input type="password" value="" size="40" name="password" id="password" class="inputbox required validate-password"/> *
                    </td>
                </tr>
                <tr>
                    <td height="40">
                        <label for="password2" id="pw2msg">
			Xác nhận mật khẩu:
                        </label>
                    </td>
                    <td>
                        <input type="password" value="" size="40" name="password2" id="password2" class="inputbox required validate-passverify"/> *
                    </td>
                </tr>
                <tr>
                    <td height="40" colspan="2">
                        Những phần đánh dấu (*) là bắt buộc!	
                    </td>
                </tr>
            </tbody>
        </table>
        <button type="submit" class="button validate">Đăng ký</button>
        <input type="hidden" value="register_save" name="task">
        <input type="hidden" value="0" name="id">
        <input type="hidden" value="0" name="gid">
        <input type="hidden" value="1" name="97f03a65d8d150493ae4e35b81a8f648"/>
    </form>

</div>

<%@include file="/template/rightsidebar.jsp" %>
<%@include file="/template/righttemplate.jsp" %>