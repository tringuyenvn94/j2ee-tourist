<%-- 
    Document   : contact
    Created on : Jun 23, 2011, 8:24:56 PM
    Author     : Dung Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/template/lefttemplate.jsp" %>

<div id="main-content">

    <table width="100%" cellspacing="0" cellpadding="0" border="0">
        <tbody>
            <tr>
                <td width="100%">
		CÔNG TY CỔ PHẦN DU LỊCH THIÊN NHIÊN	
                </td>
            </tr>
            <tr>
                <td colspan="2">PHÒNG CHĂM SÓC KHÁCH HÀNG<br/><br/></td>
            </tr>
            <tr>
                <td>
                    <table width="100%" border="0">
                        <tbody>
                            <tr>
                                <td></td>
                                <td valign="top" align="right" rowspan="2"></td>
                            </tr>
                            <tr>
                                <td>
                                    <table width="100%" cellspacing="0" cellpadding="0" border="0">
                                        <tbody>
                                            <tr>
                                                <td width="40" valign="top" rowspan="6">
                                                    <img alt="Địa chỉ: " src="<%= request.getContextPath()%>/style/image/con_address.png"/>	
                                                </td>
                                            </tr>
                                            <tr>
                                                <td valign="top">Đường 3 Tháng 2, F2, Q11, TpHCM</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <br>
                                    <table width="100%" cellspacing="0" cellpadding="0" border="0">
                                        <tbody>
                                            <tr>
                                                <td width="40">
                                                    <img alt="Email: " src="<%= request.getContextPath()%>/style/image/emailButton.png"/>
                                                </td>
                                                <td>vanganhit@gmail.com</td>
                                            </tr>
                                            <tr>
                                                <td width="40">
                                                    <img alt="Điện thoại: " src="<%= request.getContextPath()%>/style/image/con_tel.png"/>
                                                </td>
                                                <td>(08) 6.2611.513 &ndash; (08) 6.2611.523</td>
                                            </tr>
                                            <tr>
                                                <td width="40">
                                                    <img alt=" Fax: " src="<%= request.getContextPath()%>/style/image/con_fax.png"/>
                                                </td>
                                                <td>(08) 6.2611.532</td>
                                            </tr>
                                            <tr>
                                                <td width="40">
                                                    <img alt="Điện thoại di động: " src="<%= request.getContextPath()%>/style/image/con_mobile.png"/>
                                                </td>
                                                <td>Hotline: 0973.218.103 - Mr Anh</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <br>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </td>
                <td>&nbsp;</td>
            </tr>


            <tr>
                <td colspan="2">
                    <br/><br/>
                    <form class="form-validate" id="emailForm" name="emailForm" method="post" action="">
                        <div>
                            <label for="contact_name">
                                &nbsp;Tên bạn:
                            </label>
                            <br/>
                            <input type="text" value="" class="inputbox" size="30" id="contact_name" name="name"/>
                            <br/>
                            <label for="contact_email" id="contact_emailmsg">
                                &nbsp;Địa chỉ email:
                            </label>
                            <br/>
                            <input type="text" maxlength="100" class="inputbox required validate-email" value="" size="30" name="email" id="contact_email"/>
                            <br/>
                            <label for="contact_subject">
                                &nbsp;Tiêu đề thông điệp:
                            </label>
                            <br/>
                            <input type="text" value="" class="inputbox" size="30" id="contact_subject" name="subject"/>
                            <br/><br/>
                            <label for="contact_text" id="contact_textmsg">
                                &nbsp;Nội dung thông điệp:
                            </label>
                            <br/>
                            <textarea class="inputbox required" id="contact_text" name="text" rows="10" cols="50"></textarea>
                            <br/>
                            <input type="checkbox" value="1" id="contact_email_copy" name="email_copy"/>
                            <label for="contact_email_copy">
                                Gởi một bản copy thông điệp này đến hộp email của bạn
                            </label>
                            <br/><br/>
                            <button type="submit" class="button validate">Gởi</button>
                        </div>
                    </form>
                    <br/>
                </td>
            </tr>
        </tbody>
    </table>
</div>

<%@include file="/template/rightsidebar.jsp" %>
<%@include file="/template/righttemplate.jsp" %>