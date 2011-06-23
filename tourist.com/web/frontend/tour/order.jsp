<%-- 
    Document   : order
    Created on : Jun 24, 2011, 12:38:51 AM
    Author     : Dung Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tourist.entities.Tourist" %>

<%@include file="/template/lefttemplate.jsp" %>

<script type="text/javascript" language="javascript">
    window.addEvent('domready', function(){
        new Picker.Date('date', {
            pickerClass: 'datepicker_vista'
        });
    });

</script>


<%
    Tourist tourist = (Tourist) request.getAttribute("tourist");
%>


<div id="main-content">
    <form id="jform" name="jform" method="post" action="<%= request.getContextPath()%>/tour?action=confirm&id=<%= tourist.getTouristId() %>">
        <table width="100%" cellspacing="0" cellpadding="0" border="0">
            <tbody>                
                <tr>
                    <td>
                        <h2>Tour: <%= tourist.getTouristTitle()%></h2>
                        <br/><br/><br/>
                        <label style="float:left;width:150px;height:23px; margin-bottom: 15px" for="h148c" id="h148c_label" class="">Họ và tên<span style="color:red"> * </span></label>
                        <input style="float:left;width:223px;height:25px; margin-bottom: 15px" id="name" name="name" value="" class=""/>
                        <br clear="all"/>
                        <label style="float:left;width:150px;height:23px; margin-bottom: 15px" for="h148c" id="h148c_label" class="">Số CMND<span style="color:red"> * </span></label>
                        <input style="float:left;width:223px;height:25px; margin-bottom: 15px" id="card" name="card" value="" class=""/>
                        <br clear="all"/>
                        <label style="float:left;width:150px;height:24px; margin-bottom: 15px" for="hb348" id="hb348_label" class="">Địa chỉ</label>
                        <input style="float:left;width:223px;height:26px; margin-bottom: 15px" id="adress" name="adress" value="" class=""/>
                        <br clear="all"/>
                        <!--<label style="float:left;width:150px;height:22px; margin-bottom: 15px" for="h92f4" id="h92f4_label" class="">Điện thoại bàn</label>
                        <input style="float:left;width:223px;height:18px; margin-bottom: 15px" id="phone" name="phone" value="" class=""/>
                        <br clear="all"/>-->
                        <label style="float:left;width:150px;height:22px; margin-bottom: 15px" for="hdde0" id="hdde0_label" class="">Di động<span style="color:red"> * </span></label>
                        <input style="float:left;width:224px;height:18px; margin-bottom: 15px" id="telephone" name="telephone" value="" class=""/>
                        <br clear="all"/>
                        <label style="float:left;width:150px;height:22px; margin-bottom: 15px" for="hdffb" id="hdffb_label" class="">Email<span style="color:red"> * </span></label>
                        <input style="float:left;width:225px;height:18px; margin-bottom: 15px" id="email" name="email" value="" class=""/>
                        <br clear="all"/>
                        <label style="float:left;width:150px;height:22px; margin-bottom: 15px" for="h90e1" id="h90e1_label" class="">Số người</label>
                        <input style="float:left;width:100px;height:18px; margin-bottom: 15px" id="nummember" name="nummember" value="" class=""/>
                        <br clear="all"/>
                        <label style="float:left;width:150px;height:22px; margin-bottom: 15px" for="h90e1" id="h90e1_label" class="">Ngày bắt đầu tour</label>
                        <input id="date" type="text" name="date" value="" size="20"/>
                        <br clear="all"/>
                        <label style="float:left;width:150px;height:22px; margin-bottom: 15px" for="h90e1" id="h90e1_label" class="">Yêu cầu</label>
                        <textarea style="float:left;width:395px;height:149px; margin-bottom: 15px" id="other" name="other" class="" cols="7900" rows="6"></textarea>
                        <br clear="all"/>
                        
                        <input type="submit" style="float:left;width:70px;height:25px;" value="Gửi đi" name="h5193"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</div>
<%@include file="/template/rightsidebar.jsp" %>
<%@include file="/template/righttemplate.jsp" %>