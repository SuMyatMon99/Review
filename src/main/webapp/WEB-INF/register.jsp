<%@ include file="/WEB-INF/common/include.jsp"%>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>
    <!-- Header End -->

    <!-- Breadcrumb Section Begin -->
    <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text">
                        <a href="#"><i class="fa fa-home"></i> Home</a>
                        <span>Register</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="register-login-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="login-form">
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
                        <h2>Register</h2>
                   <form:form method="post" action="/register.htm" modelAttribute="userDTO">
                   	 <div class="form-group">						
                   	 	<label>User Name:</label><form:input path="userName" class="form-control" type="text"/><br>
                     </div>
                   	 <div class="form-group">
						<label>Enter the email:</label><form:input path="email" class="form-control" type="text"/><br>                   	 
                   	 </div>
                   	 <div class="form-group">
						<label>Enter the phone:</label><form:input path="phone" class="form-control" type="text"/><br>                   	 
                   	 </div>
                   	 <div class="form-group">
						<label>Enter the Password:</label><form:password path="password" class="form-control" /><br>                   	 
                   	 </div>                   	 
					<input type="submit" value="Submit" class="form-control btn-custom"/>
					</form:form>
					</fieldset>
                <div class="switch-login">
                            <a href="/login" class="or-login">Or Login</a>
                        </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    <!-- Register Form Section End -->
    
    <!-- Partner Logo Section Begin -->
    <div class="partner-logo">
        <div class="container">
            <div class="logo-carousel owl-carousel">
                <div class="logo-item">
                    <div class="tablecell-inner">
                        <img src="/resources/img/logo-carousel/logo-1.png" alt="">
                    </div>
                </div>
                <div class="logo-item">
                    <div class="tablecell-inner">
                        <img src="/resources/img/logo-carousel/logo-2.png" alt="">
                    </div>
                </div>
                <div class="logo-item">
                    <div class="tablecell-inner">
                        <img src="/resources/img/logo-carousel/logo-3.png" alt="">
                    </div>
                </div>
                <div class="logo-item">
                    <div class="tablecell-inner">
                        <img src="/resources/img/logo-carousel/logo-4.png" alt="">
                    </div>
                </div>
                <div class="logo-item">
                    <div class="tablecell-inner">
                        <img src="/resources/img/logo-carousel/logo-5.png" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Partner Logo Section End -->
