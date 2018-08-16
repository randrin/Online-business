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
						</div>
						<div class="panel-footer">
							<a href="${flowExecutionUrl}&_eventId_personalForm" class="btn btn-primary"><b><i class="fa fa-pencil"></i> Edit</b></a>
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
						</div>
						<div class="panel-footer">
							<a href="${flowExecutionUrl}&_eventId_billingForm" class="btn btn-primary"><b><i class="fa fa-pencil"></i> Edit</b></a>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4 col-sm-offset-4">
					<div class="text-center">
						<a href="${flowExecutionUrl}&_eventId_successForm" class="btn btn-success"><b><i class="fa fa-check"></i> Confirmation</b></a>
					</div>
				</div>
			</div>
		</div>
		
	<!-- flows-footer.jsp -->
	<%@include file="../shared/flows-footer.jsp"%>
			