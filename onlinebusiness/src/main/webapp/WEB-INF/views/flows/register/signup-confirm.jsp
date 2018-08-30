	<!-- flows-header.jsp -->
	<%@include file="../shared/flows-header.jsp"%>
	
		<div class="container">
			<div class="row">
			
				<!-- Personal Informations -->
				<div class="col-sm-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h4><b><i class="fa fa-user"></i> Personal Informations</b></h4>
						</div>
						<div class="panel-body">
							<div class="form-group">
								<label class="control-label col-md-4"><b>First Name</b></label>
								<div class="col-md-8"><h5>${registerUserModel.user.firstName} ${registerUserModel.user.lastName}</h5></div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4"><b>Email</b></label>
								<div class="col-md-8"><h5>${registerUserModel.user.email}</h5></div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4"><b>Contact Phone</b></label>
								<div class="col-md-8"><h5>${registerUserModel.user.contactNumber}</h5></div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4"><b>Role</b></label>
								<div class="col-md-8"><h5>${registerUserModel.user.role}</h5></div>
							</div>
						</div>
						<div class="panel-footer">
							<a href="${flowExecutionUrl}&_eventId_personalForm" class="btn btn-primary btn-md"><b><i class="fa fa-pencil"></i> Edit</b></a>
						</div>
					</div>
				</div>
				
				<!-- Address Informations -->
				<div class="col-sm-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h4><b><i class="fa fa-address-card"></i> Address Informations</b></h4>
						</div>
						<div class="panel-body">
							<div class="form-group">
								<label class="control-label col-md-4"><b>Address</b></label>
								<div class="col-md-8"><h5>${registerUserModel.billing.addressLineOne}</h5></div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4"><b>Complementary Address</b></label>
								<div class="col-md-8"><h5>${registerUserModel.billing.addressLineTwo}</h5></div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4"><b>Postal Code</b></label>
								<div class="col-md-8"><h5>${registerUserModel.billing.city}, ${registerUserModel.billing.postalCode}</h5></div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4"><b>State</b></label>
								<div class="col-md-8"><h5>${registerUserModel.billing.state}, ${registerUserModel.billing.country}</h5></div>
							</div>
						</div>
						<div class="panel-footer">
							<a href="${flowExecutionUrl}&_eventId_billingForm" class="btn btn-primary btn-md"><b><i class="fa fa-pencil"></i> Edit</b></a>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4 col-sm-offset-4">
					<div class="text-center">
						<a href="${flowExecutionUrl}&_eventId_submitForm" class="btn btn-success btn-lg"><b><i class="fa fa-check"></i> Confirmation</b></a>
					</div>
				</div>
			</div>
		</div>
		
	<!-- flows-footer.jsp -->
	<%@include file="../shared/flows-footer.jsp"%>
			