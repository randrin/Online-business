<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>

<!-- flows-header.jsp -->
<%@include file="../shared/flows-header.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4><b><i class="fa fa-address-card"></i> Address Informations</b></h4>
				</div>
				<div class="panel-body">
				
				<!-- Insert Form Element there -->
					<springform:form 
						method="POST" 
						modelAttribute="address"
						class="form-horizontal" 
						id="billingForm">

						<!-- Address Line One -->
						<div class="form-group">
							<label class="control-label col-md-4" for="addressLineOne"><b>Address Line One</b></label>
							<div class="col-md-8">
								<springform:input type="text" path="addressLineOne" class="form-control" placeholder="Enter Address Line One" />
								<springform:errors path="addressLineOne" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<!-- Address Line Two -->
						<div class="form-group">
							<label class="control-label col-md-4" for="addressLineTwo"><b>Address Line Two</b></label>
							<div class="col-md-8">
								<springform:input type="text" path="addressLineTwo" class="form-control" placeholder="Enter Address Line Two" />
								<springform:errors path="addressLineTwo" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- City -->
						<div class="form-group">
							<label class="control-label col-md-4" for="city"><b>City</b></label>
							<div class="col-md-8">
								<springform:input type="text" path="city" class="form-control" placeholder="Enter City Name" />
								<springform:errors path="city" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- Postal Code -->
						<div class="form-group">
							<label class="control-label col-md-4" for="postalCode"><b>Postal Code</b></label>
							<div class="col-md-8">
								<springform:input type="text" path="postalCode" class="form-control" placeholder="XXXXXX" />
								<springform:errors path="postalCode" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- State -->
						<div class="form-group">
							<label class="control-label col-md-4" for="state"><b>State</b></label>
							<div class="col-md-8">
								<springform:input type="text" path="state" class="form-control" placeholder="Enter State Name" />
								<springform:errors path="state" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- Country -->
						<div class="form-group">
							<label class="control-label col-md-4" for="country"><b>Country</b></label>
							<div class="col-md-8">
								<springform:input type="text" path="country" class="form-control" placeholder="Enter Country Name" />
								<springform:errors path="country" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- Prevouis / Next Step Button -->
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<button type="submit" name="_eventId_personalForm" class="btn btn-primary">
									<span class="glyphicon glyphicon-chevron-left"></span> <b>Personal Infos</b>
								</button>
								<button type="submit" name="_eventId_confirmForm" class="btn btn-primary">
									<b>Confirmation</b> <span class="glyphicon glyphicon-chevron-right"></span>
								</button>
							</div>
						</div>
					</springform:form>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- flows-footer.jsp -->
<%@include file="../shared/flows-footer.jsp"%>
