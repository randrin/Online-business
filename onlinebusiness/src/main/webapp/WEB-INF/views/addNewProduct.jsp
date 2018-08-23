<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>
<br><br>
<div class="container">
	<div class="row">
		<c:if test="${not empty message}">
			<div class="col-md-8 col-xs-12">
				<!-- Success Message -->
				<c:if test="${isSuccess}">
					<div class="alert alert-success alert-dismissible">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
							<div class="text-center">
								<b><i class="fa fa-check-circle" style="font-size: 15px;"> ${message}</i></b>
							</div>
					</div>
				</c:if>
				
				<!-- Fail Message -->
				<c:if test="${isFail}">
					<div class="alert alert-danger alert-dismissible">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
							<div class="text-center">
								<b><i class="fa fa-close" style="font-size: 15px;"> ${message}</i></b>
							</div>
					</div>
				</c:if>
			</div>
		</c:if>
		<div class="col-md-8 col-xs-12">
			<div style="overflow: auto;">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4><b><i class="fa fa-edit"> Product Management</i></b></h4>
					</div>
					<div class="panel-body">
					
						<!-- Insert Form Element there -->
						<springform:form class="form-horizontal" modelAttribute="product" 
							method="POST" 
							action="${contextRoot}/manage/new/product"
							enctype="multipart/form-data">
							<!-- Product Name -->
							<div class="form-group">
								<label class="control-label col-md-4" for="name"><b>Product Name: </b></label>
								<div class="col-md-8">
									<springform:input id="name" type="text" path="name" placeholder="Enter product name" class="form-control"/>
									<springform:errors path="name" cssClass="help-block" element="em"/>
								</div>
							</div>
							
							<!-- Brand Name -->
							<div class="form-group">
								<label class="control-label col-md-4" for="brand"><b>Brand Name: </b></label>
								<div class="col-md-8">
									<springform:input id="brand" type="text" path="brand" placeholder="Enter brand name" class="form-control"/>
									<springform:errors path="brand" cssClass="help-block" element="em"/>
								</div>
							</div>
							
							<!-- Product Description -->
							<div class="form-group">
								<label class="control-label col-md-4" for="description"><b>Product Description: </b></label>
								<div class="col-md-8">
									<springform:textarea id="description" rows="5" path="description" placeholder="Enter description product" class="form-control"></springform:textarea>
									<springform:errors path="description" cssClass="help-block" element="em"/>
								</div>
							</div>
							
							<!-- Product Price -->
							<div class="form-group">
								<label class="control-label col-md-4" for="unitPrice"><b>Product Price: </b></label>
								<div class="col-md-8">
									<springform:input id="unitPrice" type="number" path="unitPrice" placeholder="Price product" class="form-control" />
									<springform:errors path="unitPrice" cssClass="help-block" element="em"/>
								</div>
							</div>
							
							<!-- Product Quantity -->
							<div class="form-group">
								<label class="control-label col-md-4" for="quantity"><b>Product Quantity: </b></label>
								<div class="col-md-8">
									<springform:input id="quantity" type="number" path="quantity" placeholder="Quantity product" class="form-control" />
									<springform:errors path="quantity" cssClass="help-block" element="em"/>
								</div>
							</div>
							
							<!-- Product File -->
							<div class="form-group">
								<label class="control-label col-md-4" for="file"><b>Select Image: </b></label>
								<div class="col-md-8">
									<springform:input id="file" type="file" path="file" class="form-control" />
									<springform:errors path="file" cssClass="help-block" element="em"/>
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
									
									<!-- Add New Category for product with id = 0 -->
									<c:if test="${product.id == 0}">
										<div class="text-right">
											<!-- Button trigger modal -->
											<br><br>
											<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modalCategory">
											  <b>Add New Category</b>
											</button>
										</div>
									</c:if>
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
		<div class="col-md-4 col-xs-12">
			<div class="panel panel-success">
					<div class="panel-heading">
						<h4><b><i class="fa fa-edit"> Instruction Add New Product</i></b></h4>
					</div>
					<div class="panel-body">
					</div>
			</div>
		</div>
		
		<!-- Modal -->
		<div class="modal fade" id="modalCategory" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel"><b>Add New Category</b></h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		      	<springform:form id="categoryForm" modelAttribute="category" method="POST" 
		      	action="${contextRoot}/manage/new/category"
		      	class="form-horizontal">
		      		<!-- Category Name -->
		        	<div class="form-group">
						<label class="control-label col-md-4" for="cat_name"><b>Category Name: </b></label>
						<div class="col-md-8">
							<springform:input id="cat_name" type="text" path="name" placeholder="Enter Category name" class="form-control" />
							<springform:errors path="name" cssClass="help-block" element="em"/>
						</div>
					</div>
					
					<!-- Description Category -->
		        	<div class="form-group">
						<label class="control-label col-md-4" for="cat_description"><b>Category Name: </b></label>
						<div class="col-md-8">
							<springform:textarea id="cat_description" rows="5" cols="" path="description" placeholder="Enter Category decription" class="form-control"/>
							<springform:errors path="description" cssClass="help-block" element="em"/>
						</div>
					</div>
					
					<!-- Submit Button -->
					<div class="form-group">
						<div class="col-md-offset-4 col-md-8">
							<input type="submit" value="Add Category" class="btn btn-primary" />>
						</div>
					</div>
		      	</springform:form>
		      </div>
		    </div>
		  </div>
		</div>
	</div>
</div>