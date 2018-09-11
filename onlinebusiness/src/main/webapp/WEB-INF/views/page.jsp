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
			<meta name="description" content="Prototype Website to make his own business Online">
			<meta name="author" content="Randrin Nzeukang">
			<meta name="_csrf" content="${_csrf.token}">
			<meta name="_csrf_header" content="${_csrf.headerName}">
			<title>Online Shopping - ${tittle}</title>
			<script type="text/javascript">
				window.menu = '${tittle}';
				window.contextRoot = '${contextRoot}';
			</script>
			<!-- Bootstrap core CSS -->
			<link href="${css}/bootstrap.css" rel="stylesheet">
			<!-- Bootstrap SuperHero Themes -->
			<link href="${css}/bootstrap-superhero-theme.css" rel="stylesheet">
			<!-- Custom styles for this template -->
			<link href="${css}/onlineBusiness.css" rel="stylesheet">
			<!-- Font-awesome style -->
			<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
			<!-- Material Icons style -->
			<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
			<!-- Bootstrap DataTables -->
<%-- 			<link href="${css}/dataTables.bootstrap.css" rel="stylesheet"> --%>
			<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.18/css/dataTables.bootstrap4.css"/>
		</head>
	<body>
		<div class="wrapper">
			<!-- Navigation -->
			<%@include file="./shared/navBar.jsp"%>
	
			<!-- Page Content -->
			<div class="content">
				<!-- Loading Home Page -->
				<c:if test="${userClickHome == true}">
					<%@include file="./site/home.jsp"%>
				</c:if>
	
				<!-- Loading About Page -->
				<c:if test="${userClickAbout == true}">
					<%@include file="./site/about.jsp"%>
				</c:if>
	
				<!-- Loading Services Page -->
				<c:if test="${userClickServices == true}">
					<%@include file="./site/services.jsp"%>
				</c:if>
	
				<!-- Loading List Products Page -->
				<c:if test="${userClickListProducts == true or userClickCategoryProducts == true}">
					<%@include file="./product/listProduct.jsp"%>
				</c:if>
	
				<!-- Loading Contact Page -->
				<c:if test="${userClickContact == true}">
					<%@include file="./site/contact.jsp"%>
				</c:if>
				
				<!-- Loading Single Page Product -->
				<c:if test="${userClickShowProduct == true}">
					<%@include file="./product/singleProduct.jsp"%>
				</c:if>
				
				<!-- Loading Management Product -->
				<c:if test="${userClickManageProducts == true}">
					<%@include file="./product/manageProduct.jsp"%>
				</c:if>
				
				<!-- Loading Add New Product -->
				<c:if test="${userClickAddNewProduct == true or userClickEditProduct == true}">
					<%@include file="./product/addNewProduct.jsp"%>
				</c:if>
				
				<!-- Loading Cart User -->
				<c:if test="${userClickShowCart == true}">
					<%@include file="./cart/cart.jsp"%>
				</c:if>
				
				<!-- Loading Profile User -->
				<c:if test="${userClickProfile == true}">
					<%@include file="./user/profileUser.jsp"%>
				</c:if>
				
				<!-- Loading Orders User -->
				<c:if test="${userClickOrders == true}">
					<%@include file="./user/ordersUser.jsp"%>
				</c:if>
				
				<!-- Loading Profile User Item-->
				<c:if test="${userClickSettings == true}">
					<%@include file="./user/settingsUser.jsp"%>
				</c:if>
			</div>
			<!-- Footer -->
			<%@include file="./shared/footer.jsp"%>
	
			<!-- Bootstrap core JavaScript -->
			<script src="${js}/jquery.js"></script>
			<script src="${js}/bootstrap.bundle.min.js"></script>
			<script src="${js}/onlineBusiness.js"></script>
			<!-- Bootbox Plugin -->
			<script src="${js}/bootbox.min.js"></script>
			<!-- Jquery Validate Plugin -->
			<script src="${js}/jquery.validate.js"></script>
			<!-- Jquery  DataTables -->
<%-- 			<script src="${js}/jquery.dataTables.js"></script> --%>
<%-- 			<script src="${js}/dataTables.bootstrap.js"></script> --%>
			<script type="text/javascript" src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.js"></script>
			<script type="text/javascript" src="https://cdn.datatables.net/1.10.18/js/dataTables.bootstrap4.js"></script>
		</div>
	</body>
</html>
