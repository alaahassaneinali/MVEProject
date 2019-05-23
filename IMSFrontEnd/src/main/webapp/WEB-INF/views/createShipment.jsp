<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Shipment</h1>
				<p>Create Shipment for the product</p>
			</div>

		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="newShipment" method="POST"
			class="form-horizontal">
			<fieldset>
				<legend>Create Shipment</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div" />
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="shipmentNumber"><spring:message
							code="createShipment.form.shipmentNumber" /></label>
					<div class="col-lg-10">
						<form:input id="shipmentNumber" path="shipmentNumber" type="text"
							class="form:input-large" />
						<form:errors path="shipmentNumber" cssClass="text-danger" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId"><spring:message
							code="createShipment.form.productId" /></label>
					<div class="col-lg-10">
						<form:input id="productId" path="productId" type="text"
							value="${productId}" disabled="true" class="form:input-large" />
						<form:errors path="productId" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="quantity"><spring:message
							code="createShipment.form.quantity" /></label>
					<div class="col-lg-10">
						<form:input id="quantity" path="quantity" type="text"
							class="form:input-large" />
						<form:errors path="quantity" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for=storeId><spring:message
							code="createShipment.form.storeID" /></label>
					<div class="col-lg-10">
		
						<form:select id="storeId" path="store.id">
							<option value="1">Walmart FairField</option>
							<option value="2">Walmart Batavia</option>
							<option value="2">Walmart Ottumwa</option>
						</form:select>
						<form:errors path="store.id" cssClass="text-danger" />
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-lg-2" for="name"><spring:message
							code="createShipment.form.shipmentService" /></label>
					<div class="col-lg-10">
						<form:select id="shipComp" path="shipComp">
							<option value="DHL">DHL</option>
							<option value="FEDEX">FEDEX</option>
							<option value="USPS">USPS</option>
						</form:select>
						<form:errors path="shipComp" cssClass="text-danger" />
					</div>
				</div>


				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="create" class="btn btn-primary"
							value="Create" />
					</div>
				</div>

			</fieldset>
		</form:form>
	</section>
</body>
</html>
