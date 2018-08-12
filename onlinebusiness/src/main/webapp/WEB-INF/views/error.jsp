<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/resources/css" var="css"></spring:url>
<spring:url value="/resources/js" var="js"></spring:url>
<spring:url value="/resources/images" var="images"></spring:url>
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
	<!-- Bootstrap core CSS -->
	<link href="${css}/bootstrap.min.css" rel="stylesheet">
	<!-- Bootstrap SuperHero Themes -->
	<link href="${css}/bootstrap-superhero-theme.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="${css}/onlineBusiness.css" rel="stylesheet">
	<!-- Font-awesome style -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div class="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container">
				<a class="navbar-brand" href="${contextRoot}/home"><b><i class="fa fa-chevron-left"></i> Online Shopping</b></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
			</div>
		</nav>

		<!-- Error Page Content -->
		<div class="content">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<div class="text-center">
							<div style="margin: 30px;"><i class="fa fa-frown-o" style="font-size:100px;color:red"></i></div>
							<br>
							<h2><b>404</b></h2>
							<br>
							<h2><b>Page not found</b></h2>
							<br>
							<h1><b>${errorDescription}</b></h1>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<script src="${js}/onlineBusiness.js"></script>
	</div>
</body>
</html>
