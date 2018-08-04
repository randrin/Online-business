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
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Online Shopping - ${tittle}</title>
<script type="text/javascript">
	window.menu = '${tittle}';
</script>
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap SuperHero Themes -->
<link href="${css}/bootstrap-superhero-theme.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${css}/onlineBusiness.css" rel="stylesheet">
</head>
<body>

	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navBar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<!-- Loading Home Page -->
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Loading About Page -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Loading Services Page -->
			<c:if test="${userClickServices == true}">
				<%@include file="services.jsp"%>
			</c:if>

			<!-- Loading List Products Page -->
			<c:if test="${userClickListProducts == true or userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>

			<!-- Loading Contact Page -->
			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>
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
