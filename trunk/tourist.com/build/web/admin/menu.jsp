<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="horizmenu-surround">
    <ul class="menutop level1">
        <li class="parent root">
            <a href="#" class="daddy item">
                <span>Bài Viết</span>
            </a>
            <ul class="level2">
                <li class="">
                    <a href="<%= request.getContextPath()%>/article" class="daddy item">
                        <span>Tin Tức</span>
                    </a>                    
                </li>
                <li class="">
                    <a href="<%= request.getContextPath()%>/tourist" class="daddy item">
                        <span>Chương Trình Tour</span>
                    </a>
                </li>
            </ul>
        </li>
        <li class="parent root">
            <a href="#" class="daddy item">
                <span>Khách Hàng</span>
            </a>
            <ul class="level2">
                <li class="item60">
                    <a href="" class="item">
                        <span>Đăng Tour</span>
                    </a>
                </li>
                <li class="item61">
                    <a href="/webproject/index.php?option=com_content&amp;view=article&amp;id=55&amp;Itemid=61" class="item">
                            <span>Sub menu 2</span>
                    </a>
                </li>
                <li class="item62">
                    <a href="/webproject/index.php?option=com_content&amp;view=category&amp;layout=blog&amp;id=37&amp;Itemid=62" class="item">
                            <span>Sub menu 3</span>
                    </a>
                </li>
            </ul>
        </li>
        <li class="parent root">
            <a href="#" class="daddy item">
                <span>Chỉnh Sửa Chung</span>
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
