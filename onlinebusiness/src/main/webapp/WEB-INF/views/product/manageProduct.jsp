<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<h3><b>Product Avalaible in Store</b></h3>
		</div>
		<br><br>
		<div class="col-xs-12">
				<table id="adminProductsTable" class="table table-striped table-borderd">
					<thead>
						<tr>
							<th>Id</th>
							<th>&#160</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Qt. Available</th>
							<th>Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Id</th>
							<th>&#160</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Qt. Available</th>
							<th>Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</tfoot>
				</table>
		</div>
	</div>
</div>