<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>

<!-- flows-header.jsp -->
<%@include file="../shared/flows-header.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4><b><i class="fa fa-user"></i> Personal Informations</b></h4>
				</div>
				<div class="panel-body">
					
					<!-- Insert Form Element there -->
					<springform:form 
						method="POST" 
						modelAttribute="user"
						class="form-horizontal" 
						id="registerForm">

						<!-- First Name -->
						<div class="form-group">
							<label class="control-label col-md-4"><b>First Name</b></label>
							<div class="col-md-8">
								<springform:input type="text" path="firstName" class="form-control" placeholder="First Name" />
								<springform:errors path="firstName" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- Last Name -->
						<div class="form-group">
							<label class="control-label col-md-4"><b>Last Name</b></label>
							<div class="col-md-8">
								<springform:input type="text" path="lastName" class="form-control" placeholder="Last Name" />
								<springform:errors path="lastName" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- Male or Female choice -->
						<div class="form-group">
							<label class="control-label col-md-4"><b>Select sexe</b></label>
							<div class="col-md-8">
								<label class="radio-inline"> 
									<springform:radiobutton path="gender" value="M" checked="checked"/><b> M</b>
								</label>
								<label class="radio-inline">
									<springform:radiobutton path="gender" value="F"/><b> F</b>
								</label>
							</div>
						</div>
						
						<!-- Email -->
						<div class="form-group">
							<label class="control-label col-md-4"><b>Email</b></label>
							<div class="col-md-8">
								<springform:input type="text" path="email" class="form-control" placeholder="abc@zyx.com" />
								<springform:errors path="email" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<!-- Contact Number -->
						<div class="form-group">
							<label class="control-label col-md-4"><b>Contact Number</b></label>
							<div class="col-md-8">
								<springform:input type="text" path="contactNumber" class="form-control" placeholder="XXXXXXXXXX" maxlength="10" />
								<springform:errors path="contactNumber" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<!-- Password -->
						<div class="form-group">
							<label class="control-label col-md-4"><b>Password</b></label>
							<div class="col-md-8">
								<springform:input type="password" path="password" class="form-control" placeholder="Password" />
								<springform:errors path="password" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<!-- Confirm Password -->
						<div class="form-group">
							<label class="control-label col-md-4"><b>Confirm Password</b></label>
							<div class="col-md-8">
								<springform:input type="password" path="confirmPassword" class="form-control" placeholder="Re-type password" />
								<springform:errors path="confirmPassword" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<!-- User or Supplier choice -->
						<div class="form-group">
							<label class="control-label col-md-4"><b>Select Role</b></label>
							<div class="col-md-8">
								<label class="radio-inline"> 
									<springform:radiobutton path="role" value="USER" checked="checked"/><b> User</b>
								</label>
								<label class="radio-inline">
									<springform:radiobutton path="role" value="SUPPLIER"/><b> Supplier</b>
								</label>
							</div>
						</div>

						<!-- Next Step Button -->
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
							<br>
								<button type="submit" name="_eventId_billingForm" class="btn btn-primary btn-md">
									<b>Address Infos</b> <span class="glyphicon glyphicon-chevron-right"></span>
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
