<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<br><br>
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
	<br>
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
			<a href="${contextRoot}/show/all/products" class="btn btn-primary"><b><i class="material-icons" style="font-size:10px">undo</i></span> Back</b></a>
			<security:authorize access="hasAuthority('USER')">
				<c:choose>
					<c:when test="${product.quantity < 1}">
						<a href="javascript:void(0)" class="btn btn-success disabled"><b><i class="fa fa-cart-arrow-down"></i> Add</b></a>
					</c:when>
					<c:otherwise>
						<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success"><b><i class="fa fa-cart-arrow-down"></i> Add</b></a>
					</c:otherwise>
				</c:choose>
			</security:authorize>
			<security:authorize access="hasAuthority('ADMIN')">
				<a href="${contextRoot}/manage/${product.id}/product" class="btn btn-success" title="Edit Product"><b><span class="glyphicon glyphicon-pencil"></span> Edit</b></a>
			</security:authorize>
		</div>
	</div>
	<br>
	<security:authorize access="hasAuthority('USER')">
		<div class="row">
		<div class="col-xs-12">
			<div class="card gedf-card">
                    <div class="card-header">
                        <ul class="nav nav-tabs card-header-tabs" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="posts-tab" data-toggle="tab" href="#posts" role="tab" aria-controls="posts" aria-selected="true">Make
                                    a publication</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="images-tab" data-toggle="tab" role="tab" aria-controls="images" aria-selected="false" href="#images">Images</a>
                            </li>
                        </ul>
                    </div>
                    <div class="card-body">
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="posts" role="tabpanel" aria-labelledby="posts-tab">
                                <div class="form-group">
                                    <label class="sr-only" for="message">post</label>
                                    <textarea class="form-control" id="message" rows="3" placeholder="What are you thinking?"></textarea>
                                </div>

                            </div>
                            <div class="tab-pane fade" id="images" role="tabpanel" aria-labelledby="images-tab">
                                <div class="form-group">
                                    <div class="custom-file">
                                        <input type="file" class="custom-file-input" id="customFile">
                                        <label class="custom-file-label" for="customFile">Upload image</label>
                                    </div>
                                </div>
                                <div class="py-4"></div>
                            </div>
                        </div>
                        <div class="btn-toolbar justify-content-between">
                            <div class="btn-group">
                                <button type="submit" class="btn btn-primary">share</button>
                            </div>
                            <div class="btn-group">
                                <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                                    aria-expanded="false">
                                    <i class="fa fa-globe"></i> Public
                                </button>
                                <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                                    <a class="dropdown-item" href="#"><i class="fa fa-globe"></i> Public</a>
                                    <a class="dropdown-item" href="#"><i class="fa fa-users"></i> Friends</a>
                                    <a class="dropdown-item" href="#"><i class="fa fa-user"></i> Just me</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
		</div>
	</security:authorize>
</div>