<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">
		<c:if test="${not empty message}">
			<div class="col-md-offset-2 col-xs-12">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
						<div class="text-center">
							<h3><b><i class="fa fa-check-circle"> ${message}</i></b></h3>
						</div>
				</div>
			</div>
		</c:if>
		<div class="col-md-offset-2 col-xs-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4><b><i class="fa fa-edit"> Product Management</i></b></h4>
				</div>
				<div class="panel-body">
					<!-- Insert Form Element there -->
					<springform:form class="form-horizontal" modelAttribute="product" 
						method="POST" action="${contextRoot}/manage/products">
						<!-- Product Name -->
						<div class="form-group">
							<label class="control-label col-md-4" for="name"><b>Product Name: </b></label>
							<div class="col-md-8">
								<springform:input id="name" type="text" path="name" placeholder="Enter product name" class="form-control"/>
							</div>
						</div>
						
						<!-- Brand Name -->
						<div class="form-group">
							<label class="control-label col-md-4" for="brand"><b>Brand Name: </b></label>
							<div class="col-md-8">
								<springform:input id="brand" type="text" path="brand" placeholder="Enter brand name" class="form-control"/>
							</div>
						</div>
						
						<!-- Product Description -->
						<div class="form-group">
							<label class="control-label col-md-4" for="description"><b>Product Description: </b></label>
							<div class="col-md-8">
								<springform:textarea id="description" rows="5" path="description" placeholder="Enter description product" class="form-control"></springform:textarea>
							</div>
						</div>
						
						<!-- Product Price -->
						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice"><b>Product Price: </b></label>
							<div class="col-md-8">
								<springform:input id="unitPrice" type="number" path="unitPrice" placeholder="Price product" class="form-control" />
							</div>
						</div>
						
						<!-- Product Quantity -->
						<div class="form-group">
							<label class="control-label col-md-4" for="quantity"><b>Product Quantity: </b></label>
							<div class="col-md-8">
								<springform:input id="quantity" type="number" path="quantity" placeholder="Quantity product" class="form-control" />
							</div>
						</div>
						
						<!-- Product Category -->
						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId"><b>Product Category: </b></label>
							<div class="col-md-8">
								<springform:select class="form-control" id="categoryId" path="categoryId" 
									items="${categories}"
									itemLabel="name"
									itemValue="id"/>
							</div>
						</div>
						
						<!-- Submit Button -->
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input id="submit" type="submit" name="submit" value="Submit" class="btn btn-primary"/>
								
								<!-- Fieds Hidden -->
								<springform:hidden path="id"/>
								<springform:hidden path="code"/>
								<springform:hidden path="supplierId"/>
								<springform:hidden path="active"/>
								<springform:hidden path="views"/>
								<springform:hidden path="purchases"/>
							</div>
						</div>
					</springform:form>
				</div>
			</div>
		</div>
	</div>
</div>