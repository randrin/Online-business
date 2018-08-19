<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.name}</li>
			</ol>
		</div>
	</div>
	<div class="row">
		<!-- Image -->
		<div class="col-xs-12 col-sm-4">
			<div class="thumbnail">
				<img src="${images}/${product.code}.png" class="img img-responsive">
			</div>
		</div>
		<!-- Description -->
		<div class="col-xs-12 col-sm-8">
			<h3>${product.name}</h3>
			<hr>
			<h3>${product.description}</h3>
			<hr>
			<h4>Price : <strong> Fcfa ${product.unitPrice}</strong></h4>
			<hr>
			<c:choose>
				<c:when test="${product.quantity < 1}">
					<h5>Qt. Available : <strong style="color:red;">Stock Indisponible</strong></h5>
				</c:when>
				<c:otherwise>
					<h5>Qt. Available : <strong>${product.quantity}</strong></h5>
				</c:otherwise>
			</c:choose>
			<br>
			<br>
			<a href="${contextRoot}/show/all/products" class="btn btn-primary"><b><i class="material-icons" style="font-size:10px">undo</i></span> Back to List Product</b></a>
			<security:authorize access="hasAuthority('USER')">
				<c:choose>
					<c:when test="${product.quantity < 1}">
						<a href="javascript:void(0)" class="btn btn-success disabled"><b><span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</b></a>
					</c:when>
					<c:otherwise>
						<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success"><b><span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</b></a>
					</c:otherwise>
				</c:choose>
			</security:authorize>
			<security:authorize access="hasAuthority('ADMIN')">
				<a href="${contextRoot}/manage/${product.id}/product" class="btn btn-success" title="Edit Product"><b><span class="glyphicon glyphicon-pencil"></span> Edit</b></a>
			</security:authorize>
		</div>
	</div>
</div>