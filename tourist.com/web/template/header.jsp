<%-- 
    Document   : header
    Created on : Jun 22, 2011, 11:24:46 AM
    Author     : Dung Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div id="top-header">
    <h1>
        <img title="Travel" alt="Travle" src="<%= request.getContextPath()%>/style/image/logo.gif"/>
    </h1>
    <ul class="menu">
        <li class="first item1" id="current"><a href="<%= request.getContextPath()%>/index"><span>TRANG CHỦ</span></a></li>
        <li class="item2"><a href="<%= request.getContextPath()%>/index?action=introduction"><span>GIỚI THIỆU</span></a></li>
        <li class="item3"><a href="<%= request.getContextPath()%>/news"><span>TIN TỨC</span></a></li>
        <li class="item16"><a href="<%= request.getContextPath()%>/index?action=rule"><span>CHÍNH SÁCH BÁN TOUR</span></a></li>
        <li class="item15"><a href="<%= request.getContextPath()%>/index?action=order"><span>ĐẶT TOUR TRỰC TUYẾN</span></a></li>
        <li class="last item14"><a href="<%= request.getContextPath()%>/index?action=contact"><span>LIÊN HỆ</span></a></li>
    </ul>
</div>

<div id="langselect">
    <p>
        <a href="#"><img width="24" height="19" border="0" src="<%= request.getContextPath()%>/style/image/vi.gif"/></a>
        <a href="#"><img width="24" border="0" src="<%= request.getContextPath()%>/style/image/en.gif"/></a>
    </p>
</div>

<div id="header">
    <div id="topmod">
        <div class="moduletable noheading">
            <div id="container40">
                <!--<img src="<%= request.getContextPath()%>/style/image/017.jpg" alt=""/>http://www.1travel.com.vn/modules/mod_ltc_image_rotator/imagerotator.swf-->

                <embed width="921" height="160" flashvars="file=<%= request.getContextPath()%>/style/image/header_image/xmldata40.xml&amp;width=921&amp;height=160&amp;screencolor=0xFFFFFF&amp;linkfromdisplay=false&amp;linktarget=_blank&amp;shownavigation=false" wmode="transparent" allowfullscreen="true" quality="high" name="rotator" id="rotator" style="" src="<%= request.getContextPath()%>/style/flash/imagerotator.swf" type="application/x-shockwave-flash"/>

            </div>
        </div>
    </div>
    <div id="image">
        <h2 id="slogan">Joomla 1.5 Template Contest</h2>
    </div>
</div>

