<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<br>
<br>
<div class="container" style="padding-top: 30px;">
	<!-- Message update cartLine -->
	<div class="col-md-3"></div>
	<div class="col-md-6">
		<c:if test="${not empty message}">
			<div class="alert alert-info">
				<h3 class="text-center"><b><i class="fa fa-cart-arrow-down"></i> ${message}</b></h3>
			</div>
		</c:if>
	</div>
	<div class="col-md-3"></div>
	<c:choose>
		<c:when test="${not empty cartLines}">
			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 50%"><b>Product</b></th>
						<th style="width: 10%"><b>Price</b></th>
						<th style="width: 8%"><b>Quantity</b></th>
						<th style="width: 22%" class="text-center"><b>Subtotal</b></th>
						<th style="width: 10%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cartLines}" var="cartItem">
						<tr>
							<td data-th="Product">
								<div class="row">
									<!-- Image Products -->
									<div class="col-sm-2 hidden-xs">
										<img src="${images}/${cartItem.product.code}.png" width="150" height="150" alt="${cartItem.product.name}" class="img-responsive" />
									</div>
									
									<!-- Image Products -->
									<div class="col-sm-10">
										<h4 class="nomargin"><b>${cartItem.product.name}</b></h4>
<%-- 										<c:if test="${cartItem.isAvailable == false}"> --%>
<!-- 											<strong class="unAvailableProduct">(Not Available)</strong> -->
<%-- 										</c:if> --%>
										<p><b>Brand - ${cartItem.product.brand}</b></p>
										<p><b>${cartItem.product.description}</b></p>
									</div>
								</div>
							</td>
							<td data-th="Price">${cartItem.product.unitPrice}</td>
							<td data-th="Quantity"><input type="number" id="count_${cartItem.id}" min="1" max="3" class="form-control text-center" value="${cartItem.productCount}"></td>
							<td data-th="Subtotal" class="text-center"><b>Fcfa ${cartItem.total}</b></td>
							<td class="actions" data-th="">
								<button type="button" name="cartRefresh" value="${cartItem.id}" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-refresh"></span></button>
								<a href="${contextRoot}/cart/${cartItem.id}/delete" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr class="visible-xs">
						<td class="text-center"><strong>Total ${profileUserModel.cart.total} Fcfa</strong></td>
					</tr>
					<tr>
						<td><a href="${contextRoot}/show/all/products" class="btn btn-warning"><span class="glyphicon glyphicon-chevron-left"></span> <b>Continue Shopping</b></a></td>
						<td colspan="2" class="hidden-xs"></td>
						<td class="hidden-xs text-center"><strong><b>Total ${profileUserModel.cart.total} </b></strong></td>
						<td><a href="#" class="btn btn-success btn-block"><b>Checkout</b> <span class="glyphicon glyphicon-chevron-right"></a></td>
					</tr>
				</tfoot>
			</table>
		</c:when>
		<c:otherwise>
			<div style="padding-top: 50px;" class="text-center">
				<div class="jumbotron">
					<div class="text-center">
						<img src="${contextRoot}/resources/img/emptyCart.png" width="50" height="50"/>
						<br><br>
						<h2><b>Your Shopping Cart is empty.</b></h2>
					</div>
				</div>
				<a href="${contextRoot}/show/all/products" class="btn btn-warning btn-lg"><span class="glyphicon glyphicon-chevron-left"></span> <b>Continue Shopping</b></a>
			</div>
		</c:otherwise>
	</c:choose>
</div>