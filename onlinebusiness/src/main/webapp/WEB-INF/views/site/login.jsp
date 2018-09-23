<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/resources/css" var="css"></spring:url>
<spring:url value="/resources/js" var="js"></spring:url>
<spring:url value="/resources/images" var="images"></spring:url>
<spring:url value="/resources/img" var="img"></spring:url>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
	<html lang="en">
		<head>
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
			<meta name="description" content="">
			<meta name="author" content="">
			<title>Online Shopping - ${tittle}</title>
			<script type="text/javascript">
				window.menu = '${tittle}';
				window.contextRoot = '${contextRoot}';
			</script>
			<link rel="icon" type="image/gif/png" href="${img}/casaShopUrl.png">
			<!-- Bootstrap core CSS -->
			<link href="${css}/bootstrap.css" rel="stylesheet">
			<!-- Bootstrap SuperHero Themes -->
<%-- 			<link href="${css}/bootstrap-superhero-theme.css" rel="stylesheet"> --%>
			<!-- Bootstrap Cyborg Themes -->
			<link href="${css}/bootstrap-cyborg-theme.css" rel="stylesheet">
			<!-- Custom styles for this template -->
			<link href="${css}/onlineBusiness.css" rel="stylesheet">
			<!-- Font-awesome style -->
			<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		</head>
		<body>
			<div class="wrapper">
				<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
					<div class="container">
						<div class="navbar-header">
							<a class="navbar-brand" href="${contextRoot}/home"><b><b><i class="fa fa-chevron-left"></i> Online Shopping</b></a>
						</div>
					</div>
				</nav>
				<div class="content">
					<div class="container">
						<div class="row">
							<br>
							<div class="col-md-6 col-md-offset-3" style="padding: 10px;">
								<h2 class="text-center"><b>A pleasure to see you again !!</b></h2>
							</div>
							<br>
							<!-- Error Message -->
							<c:if test="${not empty message}">
								<div class="col-md-6 col-md-offset-3">
									<!-- Fail Credenzial -->
									<div class="alert alert-danger alert-dismissible">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
											<div class="text-center">
												<b><i class="fa fa-close" style="font-size: 15px;"> ${message}</i></b>
											</div>
									</div>
								</div>
							</c:if>
							<!-- Logout Message -->
							<c:if test="${not empty logout}">
								<div class="col-md-6 col-md-offset-3">
									<div class="alert alert-success alert-dismissible">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
											<div class="text-center">
												<b><i class="fa fa-check" style="font-size: 15px;"> ${logout}</i></b>
											</div>
									</div>
								</div>
							</c:if>
							<div class="col-md-6 col-md-offset-3">
								<div class="panel panel-primary">
									<div class="panel-heading">
										<h4><b><i class="fa fa-address-card"></i> Login</b></h4>
									</div>
									<div class="panel-body">
										<form method="POST" 
												action="${contextRoot}/login"
												class="form-horizontal" 
												id="loginForm">
												
												<!-- Username /Email -->
												<div class="form-group">
													<label class="control-label col-md-4" for="username"><b>Username</b></label>
													<div class="col-md-8">
														<input id="username" type="text" name="username" class="form-control" placeholder="abc@zyx.com" />
													</div>
												</div>
												
												<!-- Password -->
												<div class="form-group">
													<label class="control-label col-md-4" for="password"><b>Password</b></label>
													<div class="col-md-8">
														<input id="password" type="password" name="password" class="form-control" placeholder="Password" />
														<br>
														<!-- Forgot Password -->
														<a class="pull-right" href="${contextRoot}/password-forgot"><b>Forgot your Password?</b></a>
													</div>
												</div>
												<br>
												
												<!-- Next Step Button -->
												<div class="form-group">
													<div class="col-md-offset-4 col-md-8">
														<button type="submit" class="btn btn-primary btn-md">
															<b>Access to Sales</b> <span class="glyphicon glyphicon-triangle-right"></span>
														</button>
														<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
													</div>
												</div>
										</form>
									</div>
									<div class="panel-footer">
										<div class="text-right">
								       		<b>New User? </b><a href="${contextRoot}/register"><b>Register Here</b></a>
								       	</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- Footer -->
				<%@include file="../shared/footer.jsp"%>
		
				<!-- Bootstrap core JavaScript -->
				<script src="${js}/jquery.js"></script>
				<script src="${js}/bootstrap.bundle.min.js"></script>
				<script src="${js}/onlineBusiness.js"></script>
				<!-- Jquery Validate Plugin -->
				<script src="${js}/jquery.validate.js"></script>
				<script type="text/javascript">
					setTimeout(function(){
						$('.alert').fadeOut('slow');
					}, 2000)
				</script>
			</div>
	</body>
</html>
