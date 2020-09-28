<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" 
    xmlns:th="http://www.thymeleaf.org" 
    xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
   <head>
   <script type="text/javascript">
   document.querySelector("#react-search-bar > div");
   </script>
  
   </head>
   <body>
 <%@ include file="/WEB-INF/common/include.jsp"%>   
 <header class="header-section">
        <div class="header-top">
            <div class="container">
                 <div class="col-lg-2 col-md-2 pt-4">
                        <div class="logo">
                            <a href="/">
                                <img src="/resources/img/logo.png" alt="">
                            </a>
                        </div>
                        </div>
                   <!--  <div class="mail-service">
                        <i class=" fa fa-envelope"></i>
                        hello.review@gmail.com
                    </div>
                    <div class="phone-service">
                        <i class=" fa fa-phone"></i>
                        +959 439928839
                    </div> -->
                
                <div class="ht-right">
                    <a href="login" class="login-panel"><i class="fa fa-user"></i>Login</a>
                    <div class="lan-selector">
                        <select class="language_drop" name="countries" id="countries" style="width:300px;">
                            <option value='yt' data-image="/resources/img/flag-1.jpg" data-imagecss="flag yt"
                                data-title="English">English</option>
                            <option value='yu' data-image="/resources/img/flag-2.jpg" data-imagecss="flag yu"
                                data-title="Myanmar">Myanmar </option>
                        </select>
                    </div>
                    <div class="top-social">
                        <a href="#"><i class="ti-facebook"></i></a>
                        <a href="#"><i class="ti-twitter-alt"></i></a>
                        <a href="#"><i class="ti-linkedin"></i></a>
                        <a href="#"><i class="ti-pinterest"></i></a>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="nav-item">
            <div class="container">
                <div class="nav-depart">
                    <div class="depart-btn">
                        <i class="ti-menu"></i>
                        <span>All departments</span>
                        <ul class="depart-hover">
                       <c:forEach items="${categories}" var="cat" varStatus="row">
                            <li th:vlaue="${cat.cat_id }"><a href="/productsbycategory/${cat.cat_id }">${cat.cat_name }</a></li>
                           </c:forEach>
                        </ul>
                    </div>
                </div>
                <nav class="nav-menu mobile-menu">
                    <ul>
                        <li class="active"><a href="/">Home</a></li>
                        <li><a href="#">Pages</a>
                            <ul class="dropdown">
                                <li><a href="/blog-details.htm">Blog Details</a></li>
                                <li><a href="/faq.htm">Faq</a></li>
                                <li><a href="/register.htm">Register</a></li>
                                <li><a href="/login.htm">Login</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
                <div id="mobile-menu-wrap"></div>
            </div>
        </div>
    </header>
    </body>
    </html>