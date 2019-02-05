<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<br>
<br>
<div class="container" style="padding-top: 30px;">
	<div class="row">
		<div class="clearfix" id="checkout">
			<div class="box">
				<form 
					method="post" 
					action="shop-checkout4.html">
					<ul class="nav nav-pills nav-justified">
						<li class="active"><a href="#"><i class="fa fa-eye"></i><br>Review Order</a></li>
						<li><a href="shop-checkout1.html"><i class="fa fa-map-marker"></i><br>Shipping Address</a></li>
						<li><a href="shop-checkout2.html"><i class="fa fa-money"></i><br>Confirmation</a></li>
					</ul>
					<div id="content">
						<div class="container">
							<div class="row">
								<div class="col-md-9 clearfix" id="basket">
									<div class="box">
										<form method="post" action="shop-checkout1.html">
											<div class="table-responsive">
												<table class="table">
													<thead>
														<tr>
															<th colspan="2">Produkt</th>
															<th>Anzahl</th>
															<th>Stückpreis</th>
															<th>Rabatt</th>
															<th colspan="2">Summe</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td><a href="#"> <img src="img/engelcard.jpg"
																	alt="Image engelCARD">
															</a></td>
															<td><p>
																	engelCARD <span class="text-info">Premium</span>
																</p>
																<p>Die „Alles-inklusive Notfallkarte“ von engelCARD
																	im Scheckkartenformat für gesicherte Notfall- und
																	Vitaldatenbank inkl. 24/7/365 weltweite Notfallhotline
																	(Medicall) sowie Dokumentensafe mit 200 MB Speicher,
																	Impfbox, Vertragsbox und Vorsorgebox</p></td>
															<td><input type="number" value="2"
																class="form-control"></td>
															<td>€12.00</td>
															<td>€0.00</td>
															<td>€24.00</td>
															<td><a href="#"><i class="fa fa-trash-o"></i></a></td>
														</tr>
													</tbody>
													<tfoot>
														<tr>
															<th colspan="5">Zwischensumme</th>
															<th colspan="2">€24.00</th>
														</tr>
														<tr>
															<th colspan="5">MwSt. (19%)</th>
															<th colspan="2">€4.56</th>
														</tr>
														<tr>
															<th colspan="5">Versand</th>
															<th colspan="2">€2.50</th>
														</tr>
														<tr>
															<th colspan="5">Total</th>
															<th colspan="2">€26.50</th>
														</tr>
													</tfoot>
												</table>
											</div>
											<!-- /.table-responsive -->
									</div>
									<!-- /.content -->
									<div class="box-footer">
										<div class="box-header">
											<h4>Gutschein-Code</h4>
											<p class="text-muted">Bitte geben Sie hier Ihren
												Gutscheincode ein.</p>
											<form>
												<div class="input-group col-md-6">
													<input type="text" class="form-control"> <span
														class="input-group-btn">
														<button class="btn btn-template-main" type="button">
															<i class="fa fa-gift"></i>
														</button>
													</span>
												</div>
												<!-- /input-group -->
											</form>
										</div>

										<div class="pull-left">
											<a href="shop-checkout3.html" class="btn btn-default"><i
												class="fa fa-chevron-left"></i>Zurück</a>
										</div>
										<div class="pull-right">
											<button class="btn btn-default">
												<i class="fa fa-refresh"></i> aktualisieren
											</button>
											<button type="submit" class="btn btn-template-main">
												zur Kasse <i class="fa fa-chevron-right"></i>
											</button>
										</div>
									</div>
				</form>
			</div>
			<!-- /.box -->
		</div>
		<!-- /.col-md-9 -->
		<!-- /.col-md-3 -->
	</div>
	<!-- /.row -->
</div>
