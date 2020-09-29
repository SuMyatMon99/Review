 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
                
                <div class="ht-right">
                <sec:authorize access="isAuthenticated()">
				<a href="/logout" class="login-panel">Logout</a>                
                <a href="/profile" class="login-panel">
						<sec:authentication property="principal.username"/></a>
         
				</sec:authorize>
						
<sec:authorize access="isAnonymous()">
                    <a href="login" class="login-panel"><i class="fa fa-user"></i>Login</a>
</sec:authorize>
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
                        <sec:authorize access="hasAuthority('ADMIN')">
                        <div class="nav-depart">
                    <div class="depart-btn">
                        <i class="ti-menu"></i>                        
                        <span>MANAGE</span>
                            <ul class="depart-hover">
								<li><a href="<c:url value='/brand/create_brand' />">Create Brand</a></li>
								<li><a href="<c:url value='/brand/brand_list' />">Brand List</a></li>
								<li><a href="<c:url value='/shop/create_shop' />">Create Shop</a></li>
								<li><a href="<c:url value='/shop/shop_list' />">Shop List</a></li>
								<li><a href="<c:url value='/category/create_category' />">Create Category</a></li>	
								<li><a href="<c:url value='/category/category_list' />">Category List</a></li>
								<li><a href="/user/user_list">User List</a></li>							
								<li><a href="/product_list">User View</a></li>	
                            </ul>
                             </div>
                </div>
  				</sec:authorize>
				<sec:authorize access="hasAuthority('USER')">
				<div class="nav-depart">
                    <div class="depart-btn">
                        <i class="ti-menu"></i>
				        <span>All departments</span>
                        <ul class="depart-hover">
                            <li><a href="/product_list">All Category</a></li>
                       <c:forEach items="${categories}" var="cat" varStatus="row">
                            <li value="${cat.cat_id }"><a href="/product_list/${cat.cat_id}">${cat.cat_name }</a></li>
                           </c:forEach>
                        </ul>
                        </div>
                </div>
                  </sec:authorize>
                    
                <nav class="nav-menu mobile-menu">
                    <ul>
                        <li class="active"><a href="/">Home</a></li>
                        <li><a href="#">Pages</a>
                            <ul class="dropdown">
                                <li><a href="/blog-details.htm">Blog Details</a></li>
                                <li><a href="/faq.htm">Faq</a></li>
                           <sec:authorize access="isAnonymous()">
                                <li><a href="/register.htm">Register</a></li>
                                <li><a href="/login.htm">Login</a></li>
                            </sec:authorize>
                            </ul>
                        </li>
                    </ul>
                  

                </nav>
                
                   
                <div id="mobile-menu-wrap"></div>
            </div>
        </div>
    </header>
   