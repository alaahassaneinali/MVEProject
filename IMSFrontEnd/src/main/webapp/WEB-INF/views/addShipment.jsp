<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Shipments</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Shipments</h1>
				<p>Add shipments</p>
			</div>
 			<div class="pull-right" style="padding-right:50px">
				<a href="?language=en" >English</a>|<a href="?language=nl" >Dutch</a>					
			</div>
			
		</div>
	</section>
	<section class="container">
		<form:form  modelAttribute="newShipment" class="form-horizontal" >
			<fieldset>
				<legend>Add new shipment</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="shipmentId"><spring:message code="addShipment.form.shipmentId.label"/></label>
					<div class="col-lg-10">
						<form:input id="shipmentId" path="shipmentId" type="text" class="form:input-large"/>
						<form:errors path="shipmentId" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="shipComp"><spring:message code="addShipment.form.shipComp.label"/></label>
					<div class="col-lg-10">
						<form:input id="shipComp" path="shipComp" type="text" class="form:input-large"/>
						<form:errors path="shipComp" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="shipmentDate"><spring:message code="addShipment.form.shipmentDate.label"/></label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input type="date" id="shipmentDate" path="shipmentDate" type="text" class="form:input-large"/>
							<form:errors path="shipmentDate" cssClass="text-danger"/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="deliveryDate"><spring:message code="addShipment.form.deliveryDate.label"/></label>
					<div class="col-lg-10">
						<form:input type="date" id="deliveryDate" path="deliveryDate" rows = "2"/>
					</div>
				</div>


				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
