<%-- 
    Document   : leftsidebar
    Created on : Jun 22, 2011, 12:23:37 PM
    Author     : Dung Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div id="left-sidebar">
    <div class="moduletable heading">
        <h3>TƯ VẤN TRỰC TUYẾN</h3>
        <p>
            <a href="ymsgr:sendIM?tuandunguit">
                <img border="0" src="<%= request.getContextPath()%>/style/image/icon_yahoo.gif"/>
            </a>
            <br/>
            Dịch vụ tour du lịch
            <br/>
            <a href="ymsgr:sendIM?vanganhit">
                <img border="0" src="<%= request.getContextPath()%>/style/image/icon_yahoo.gif"/>
            </a>
            <br/>
            Dịch vụ tour du lịch
            <br/>
            <a href="ymsgr:sendIM?tuandunguit">
                <img border="0" src="<%= request.getContextPath()%>/style/image/icon_yahoo.gif"/>
            </a>
            <br/>
            Đặt phòng khách sạn
            <br/>
            <a href="ymsgr:sendIM?vanganhit">
                <img border="0" src="<%= request.getContextPath()%>/style/image/icon_yahoo.gif"/>
            </a>
            <br/>
            Dịch vụ vé máy bay - visa
            <br/>
        </p>
    </div>

    <div class="moduletable heading">
        <h3>TOUR DU LỊCH</h3>
        <ul class="menu">
            <li class="first item5">
                <a href="/index.php/tour-trong-nuoc.html"><span>Tour trong nước</span></a>
            </li>
            <li class="item6">
                <a href="/index.php/tour-nuoc-ngoai.html"><span>Tour nước ngoài</span></a>
            </li>
            <li class="last item19">
                <a href="/index.php/lich-khoi-hanh-tour.html"><span>Lịch khởi hành Tour</span></a>
            </li>
        </ul>
    </div>

    <div class="moduletable_menu heading">
        <h3>DỊCH VỤ DU LỊCH</h3>
        <ul class="menu">
            <li class="first item8">
                <a href="/index.php/ve-may-bay.html"><span>Vé máy bay</span></a>
            </li>
            <li class="item9">
                <a href="/index.php/visa-passport.html"><span>Visa - Passport</span></a>
            </li>
            <li class="last item10"><a href="/index.php/xe-du-lich.html"><span>Xe du lịch</span></a>
            </li>
        </ul>
    </div>

    <div class="moduletable heading">
        <h3>KHÁCH SẠN</h3>
        <ul class="menu">
            <li class="first item12">
                <a href="/index.php/trong-nuoc.html"><span>Trong nước</span></a>
            </li>            
            <li class="last item13">                
                <a href="/index.php/ngoai-nuoc.html"><span>Ngoài nước</span></a>
            </li>        
        </ul>	
    </div>


    <div class="moduletable heading">
        <h3>HÌNH ẢNH DU LỊCH</h3>
        <marquee behavior="scroll" direction="down" onmouseout="this.start();" onmouseover="this.stop();" 
                 scrolldelay="1" scrollamount="1" style="width:200px;height:400px">
            <img style="margin-top:10px" src="<%= request.getContextPath()%>/style/image/pic/0.jpg"/><br/>
            <img style="margin-top:10px" src="<%= request.getContextPath()%>/style/image/pic/1.jpg"/><br/>
            <img style="margin-top:10px" src="<%= request.getContextPath()%>/style/image/pic/2.jpg"><br/>
            <img style="margin-top:10px" src="<%= request.getContextPath()%>/style/image/pic/3.jpg"/><br/>
            <img style="margin-top:10px" src="<%= request.getContextPath()%>/style/image/pic/4.jpg"/><br/>
            <img style="margin-top:10px" src="<%= request.getContextPath()%>/style/image/pic/5.jpg"/><br/>
            <img style="margin-top:10px" src="<%= request.getContextPath()%>/style/image/pic/6.jpg"/><br/>
            <img style="margin-top:10px" src="<%= request.getContextPath()%>/style/image/pic/7.jpg"/><br/>
            <img style="margin-top:10px" src="<%= request.getContextPath()%>/style/image/pic/8.jpg"/><br/>
            <img style="margin-top:10px" src="<%= request.getContextPath()%>/style/image/pic/9.jpg"/><br/>
        </marquee>		
    </div>
</div>