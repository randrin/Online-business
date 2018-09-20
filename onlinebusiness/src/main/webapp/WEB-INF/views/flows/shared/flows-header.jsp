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
			<title>Online Shopping - Sign Up</title>
			<script type="text/javascript">
				window.menu = '${tittle}';
				window.contextRoot = '${contextRoot}';
			</script>
			<link rel="icon" type="image/gif/png" href="${img}/casaShopUrl.png">
			<!-- Bootstrap core CSS -->
			<link href="${css}/bootstrap.css" rel="stylesheet">
			<!-- Bootstrap SuperHero Themes -->
			<link href="${css}/bootstrap-superhero-theme.css" rel="stylesheet">
			<!-- Custom styles for this template -->
			<link href="${css}/onlineBusiness.css" rel="stylesheet">
			<!-- Font-awesome style -->
			<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
			<!-- Bootstrap DataTables -->
<%-- 			<link href="${css}/dataTables.bootstrap.css" rel="stylesheet"> --%>
			<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.18/css/dataTables.bootstrap4.css"/>
		</head>
		<body>
		<div class="wrapper">
			<!-- fows-navbar.jsp -->
			<%@include file="flows-navBar.jsp"%>
			
			<!-- Page Content -->
			<div class="content">