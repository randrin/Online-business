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
			<h5>Qt. Availableb : <strong>${product.quantity}</strong></h5>
			<br>
			<br>
			<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success"><b><span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</b></a>
			<a href="${contextRoot}/show/all/products" class="btn btn-primary"><b><span class="glyphicon glyphicon-list-alt"></span> Back to List Product</b></a>
		</div>
	</div>
</div>