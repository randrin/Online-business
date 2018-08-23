<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<nav class="navbar navbar-icon-top navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="${contextRoot}/home">
        	<b>Online Shopping</b>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item styleItem" id="home">
              <a class="nav-link" href="${contextRoot}/home">
              	<i class="fa fa-home"></i>
              	<b>HOME</b>
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item styleItem" id="about">
              <a class="nav-link" href="${contextRoot}/about">
              	<i class="fa fa-institution"></i>
              	<b>ABOUT</b>
              </a>
            </li>
            <li class="nav-item styleItem" id="services">
              <a class="nav-link" href="${contextRoot}/services">
              	<i class="fa fa-cogs"></i>
              	<b>SERVICES</b>
              </a>
            </li>
            <li class="nav-item styleItem" id="listOfProducts">
              <a class="nav-link" href="${contextRoot}/show/all/products">
              	<i class="fa fa-shopping-cart"></i>
              	<b>PRODUCTS</b>
              </a>
            </li>
            <security:authorize access="hasAuthority('ADMIN')">
	            <ul class="nav navbar-nav navbar-right">
		            <li class="nav-item dropdown styleItem" id="manageProducts">
		              <a class="nav-link dropdown-toggle" id="navbarDropdownManageProducts" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" href="#">
		              	<i class="fa fa-leaf"></i>
		              	<b>MANAGE PRODUCT</b>
		              </a>
		            	<div class="dropdown-menu" aria-labelledby="navbarDropdownManageProducts">
				          <a class="dropdown-item" href="${contextRoot}/manage/products"><b><i class="fa fa-list-ol"></i> List Products</b></a>
				          <a class="dropdown-item" href="${contextRoot}/manage/new/product"><b><i class="fa fa-cart-arrow-down"></i> Add New Product</b></a>
				        </div>
		            </li>
	            </ul>
            </security:authorize>
            <li class="nav-item styleItem" id="contact">
              <a class="nav-link" href="${contextRoot}/contact">
              	<i class="fa fa-phone"></i>
              	<b>CONTACT</b>
              </a>
            </li>
            <security:authorize access="hasAuthority('USER')">
            	<li style="padding-left: 30px; padding-top: 10px;">
		          <a href="${contextRoot}/cart/show" class="btn btn-primary btn-circle btn-xl"> <i class="fa fa-cart-arrow-down"></i></a>
		           <span class="cart-items-count"><span class="notification-counter"><b>${profileUserModel.cart.cartLines}</b></span></span>
		        </li>
            </security:authorize>
          </ul>
          
          <ul class="nav navbar-nav navbar-right">
          	<security:authorize access="isAnonymous()">
          		<li class="nav-item dropdown styleItem" id="register">
			    	<a class="nav-link" id="navbarDropdownManageSettings" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" href="#">
			    		<b><i style="font-size: 50px;" class="fa fa-power-off fa-rotate-90"></i></b>
			    	</a>
		            <div class="dropdown-menu" aria-labelledby="navbarDropdownManageSettings">
				          <a class="dropdown-item" href="${contextRoot}/register"><b><i class="fa fa-sign-in"></i> SIGN UP</b></a>
				          <a class="dropdown-item" href="${contextRoot}/login"><b><i class="fa fa-user"></i> LOGIN</b></a>
				       </div>
				</li>
			</security:authorize>
          	<security:authorize access="isAuthenticated()">
          			<li class="nav-item dropdown styleItem">
				    	<a href="javascript:void(0)" class="btn btn-primary dropdown-toggle" id="dropdrown1" data-toggle="dropdown">
				    		<b><i class="fa fa-user"></i> ${profileUserModel.fullName}</b>
				    	</a>
				    	<ul class="dropdown-menu" style="padding-left: 10px;">
				    		<security:authorize access="hasAuthority('USER')">
					    		<li>
					    			<h5><b><a href="${contextRoot}/cart/show">
					    				<i style="font-size: 15px;" class="fa fa-cart-arrow-down"></i>
					    				<span class="badge notification"><b>${profileUserModel.cart.cartLines}</b></span><span><b> - Fcfa ${profileUserModel.cart.total}</b></span>
					    			</a></b></h5>
					    		</li>
					    		<li class="divider" role="separator"></li>
				    			<li><h6><b><a href="${contextRoot}/setting"><b><i style="font-size: 15px;" class="fa fa-cog"></i> Parameters</b></a></b></h6></li>
				    			<li><h6><b><a href="${contextRoot}/user"><b><i style="font-size: 15px;" class="fa fa-address-card"></i> Personals Infos</b></a></b></h6></li>
				    		</security:authorize>
				    		<li class="divider" role="separator"></li>
				    		<li><h6><b><a href="${contextRoot}/logoutToAll"><b><i style="font-size: 15px;" class="fa fa-sign-out"></i> Logout</b></a></b></h6></li>
				    	</ul>
				    </li>
          	</security:authorize>
          </ul>
        </div>
      </div>
    </nav>
    
    <script>
    	window.userRole = '${profileUserModel.role}';
    </script>