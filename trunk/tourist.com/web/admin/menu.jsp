<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="horizmenu-surround">
    <ul class="menutop level1">
        <li class="parent root">
            <a class="daddy item">
                <span>Quản Lý Bài Viết</span>
            </a>
            <ul class="level2">
                <li class="">
                    <a href="<%= request.getContextPath()%>/article" class="daddy item">
                        <span>Tin Tức</span>
                    </a>                    
                </li>
                <li class="">
                    <a href="<%= request.getContextPath()%>/category" class="daddy item">
                        <span>Chủ đề</span>
                    </a>
                </li>
            </ul>
        </li>
        <li class="parent root">
            <a class="daddy item">
                <span>Quản lý Du Lịch</span>
            </a>
            <ul class="level2">
                <li class="item60">
                    <a href="<%= request.getContextPath()%>/tourist" class="item">
                        <span>Chương trình tour</span>
                    </a>					
                </li>                
                <li class="item61">
                    <a href="<%= request.getContextPath()%>/destination" class="item">
                        <span>Điểm du lịch</span>
                    </a>
                </li>                
            </ul>
        </li>
	<li class="parent root">
            <a href="<%= request.getContextPath()%>/registertour" class="item">
                <span>Khách Hàng</span>
            </a>            
        </li>        
        <li class="parent root">
            <a href="<%= request.getContextPath()%>/logout" class="daddy item">
                <span>Đăng Xuất</span>
            </a>
        </li>
    </ul>
</div>
<div class="clr"></div>
