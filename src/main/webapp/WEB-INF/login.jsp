<%@ include file="/WEB-INF/common/include.jsp" %>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Breadcrumb Section Begin -->
    <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text">
                        <a href="#"><i class="fa fa-home"></i> Home</a>
                        <span>Login</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Form Section Begin -->

    <!-- Register Section Begin -->
   <div class="panel-body">
    <form action="/user/login.htm" method="post">
        <fieldset>
            <legend>Please sign in</legend>
            <c:if test="${param.error != null}" >         
        <p>  
            Invalid username and password.  
        </p>  
    </c:if>  
    <c:if test="${param.logout != null}">         
        <p>  
            You have been logged out.  
        </p>  
    </c:if>  
            <div class="form-group">
                <input class="form:input-large" placeholder="User Name"
                       name='username' type="text">
            </div>
            <div class="form-group">
                <input class=" form:input-large" placeholder="Password"
                       name='password' type="password" value="">
            </div>
            <input class="btn" type="submit"
                   value="Login">
        </fieldset>
    </form>
</div>
   
    <!-- Register Form Section End -->

    <!-- Partner Logo Section Begin -->
    <div class="partner-logo">
        <div class="container">
            <div class="logo-carousel owl-carousel">
                <div class="logo-item">
                    <div class="tablecell-inner">
                        <img src="img/logo-carousel/logo-1.png" alt="">
                    </div>
                </div>
                <div class="logo-item">
                    <div class="tablecell-inner">
                        <img src="img/logo-carousel/logo-2.png" alt="">
                    </div>
                </div>
                <div class="logo-item">
                    <div class="tablecell-inner">
                        <img src="img/logo-carousel/logo-3.png" alt="">
                    </div>
                </div>
                <div class="logo-item">
                    <div class="tablecell-inner">
                        <img src="img/logo-carousel/logo-4.png" alt="">
                    </div>
                </div>
                <div class="logo-item">
                    <div class="tablecell-inner">
                        <img src="img/logo-carousel/logo-5.png" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Partner Logo Section End -->
