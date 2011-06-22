<%-- 
    Document   : rightsidebar
    Created on : Jun 22, 2011, 12:54:20 PM
    Author     : Dung Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script type="text/javascript">
    function gothere(){
        var link = document.form_wlcombo_plus.select_wlcombo_plus.options[document.form_wlcombo_plus.select_wlcombo_plus.selectedIndex].value;
        if ((link != "") && (link.search(/http:/)!=-1)) {
            window.open(link,"mywindow");
        }
    }
</script>

<div id="right-sidebar">
    <div class="module heading">
        <div>
            <h3>LIÊN KẾT WEBSITE</h3>
            <form class="weblinks_combo_plus" name="form_wlcombo_plus">
                <select onchange="gothere()" size="1" name="select_wlcombo_plus">
                    <option value="11">Click here !!!</option>
                    <option value="http://www.webdulich.com/">+ Cẩm nang du lịch</option>
                    <option value="http://naturetourist.com.vn/vietnam/index.asp">+ CTY CP DL Thiên Nhiên</option>
                    <option value="http://www.baodulich.com/">+ Báo du lịch</option>
                    <option value="http://xnc.congan.com.vn/">+ Phòng quản lý XNC</option>
                    <option value="http://www.cinet.gov.vn/">+ Bộ VH - TT &amp; DL</option>
                    <option value="http://www.dulichvn.org.vn/">+ Tin tức du lịch</option>
                    <option value="http://www.vietnamtourism.com">+ Tổng cục du lịch Việt Nam</option>
                    <option value="http://diendandulich.net/">+ Diễn đàn du lịch</option>
                    <option value="http://www.tourismthailand.org.vn/">+ Tổng cục du lịch TL tại VN</option>
                </select>
            </form>
        </div>
    </div>
    
    <div class="module heading">
        <div>
            <h3>CÁC TOUR SẮP KHỞI HÀNH</h3>
            <div style="text-align: center">
                <img border="0" src="<%= request.getContextPath()%>/style/image/tour/lao.jpg"/>
                <br/>
                <strong>Du lịch Việt - Lào - Thái</strong>
                <br/>-------------------
                <br/>
            </div>
            <div style="text-align: center">
                <img border="0" src="<%= request.getContextPath()%>/style/image/tour/ando.jpg"/>
                <br/>
                <strong>Du lịch Ấn Độ</strong>
                <br/>-------------------
                <br/>
                <img border="0" src="<%= request.getContextPath()%>/style/image/tour/nga.jpg"/>
                <br/>
                <strong>Du lịch Nga</strong>
                <br/>-------------------
                <br/>
            </div>
            <div style="text-align: center">
                <img border="0" src="<%= request.getContextPath()%>/style/image/tour/hanquoc.jpg"/>
                <br/>
                <strong>Du lịch Hàn Quốc</strong>
                <br/>-------------------
                <br/>
                <img border="0" src="<%= request.getContextPath()%>/style/image/tour/nuthantudo.jpg"/>
                <br/>
                <strong>Du lịch Hoa Kỳ</strong>
            </div>
        </div>
    </div>

</div>