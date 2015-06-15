/*     */package com.io.extService.upsShipping.shipment;

/*     */
/*     *//*     */import java.util.List;

/*     */
import javax.xml.ws.BindingProvider;

import com.ups.wsdl.xoltws.ship.v1.ShipPortType;
/*     */
import com.ups.wsdl.xoltws.ship.v1.ShipService;
/*     */
import com.ups.wsdl.xoltws.ship.v1.ShipmentErrorMessage;
/*     */
import com.ups.xmlschema.xoltws.common.v1.RequestType;
/*     */
import com.ups.xmlschema.xoltws.ship.v1.PackageType;
/*     */
import com.ups.xmlschema.xoltws.ship.v1.ShipFromType;
/*     */
import com.ups.xmlschema.xoltws.ship.v1.ShipToType;
/*     */
import com.ups.xmlschema.xoltws.ship.v1.ShipmentRequest;
import com.ups.xmlschema.xoltws.ship.v1.ShipmentResponse;
/*     */
import com.ups.xmlschema.xoltws.ship.v1.ShipmentType;
/*     */
import com.ups.xmlschema.xoltws.ship.v1.ShipperType;
/*     */
import com.ups.xmlschema.xoltws.upss.v1.UPSSecurity;

/*     */
/*     */
/*     */public class UPSShipmentInvoker extends UPSInvoker
/*     */{
	/*     */ShipPortType shipPort;
	/* 22 */ShipmentRequest shipmentRequest = new ShipmentRequest();
	/* 23 */ShipmentType shipmentType = new ShipmentType();
	/* 24 */RequestType requestType = new RequestType();
	/* 25 */UPSSecurity upsSecurity = null;
	/* 26 */List<PackageType> packageList = this.shipmentType.getPackage();

	/*     */
	/*     */public void initService(String endPointUrl)
	/*     */{
		/* 33 */ShipService shipService = new ShipService();
		/* 34 */ShipPortType shipPort = shipService.getShipPort();
		/* 35 */BindingProvider bp = (BindingProvider) shipPort;
		/* 36 */bp.getRequestContext().put(
				"javax.xml.ws.service.endpoint.address", endPointUrl);
		/* 37 */this.shipPort = shipPort;
		/*     */}

	/*     */
	/*     */public void getUPSLoginAccess(String accessNumber, String userName,
			String password)
	/*     */{
		/* 42 */this.upsSecurity = super.getUPSSecurity(accessNumber, userName,
				password);
		/*     */}

	/*     */
	/*     */public void setRequestOptions(boolean validateAddress)
	/*     */{
		/* 47 */List requestOption = this.requestType.getRequestOption();
		/*     */
		/* 49 */if (validateAddress) {
			/* 50 */requestOption.add("validate");
			/* 51 */this.shipmentRequest.setRequest(this.requestType);
			/*     */} else {
			/* 53 */requestOption.add("nonvalidate");
			/* 54 */this.shipmentRequest.setRequest(this.requestType);
			/*     */}
		/*     */}

	/*     */
	/*     */public void setShipFromAddress(
			UPSShipAddressDetails upsShipAddressDetails)
	/*     */{
		/* 60 */ShipFromType shipFromType = (ShipFromType) upsShipAddressDetails
				.getAddress();
		/*     */
		/* 62 */if (shipFromType != null)
		/*     */{
			/* 64 */this.shipmentType.setShipFrom(shipFromType);
			/*     */}
		/*     */}

	/*     */
	/*     */public void setShipToAddress(
			UPSShipAddressDetails upsShipAddressDetails)
	/*     */{
		/* 70 */ShipToType shipToType = (ShipToType) upsShipAddressDetails
				.getAddress();
		/*     */
		/* 72 */if (shipToType != null)
			/* 73 */this.shipmentType.setShipTo(shipToType);
		/*     */}

	/*     */
	/*     */public void setShipperAddress(
			UPSShipAddressDetails upsShipAddressDetails)
	/*     */{
		/* 80 */ShipperType shipperType = (ShipperType) upsShipAddressDetails
				.getAddress();
		/*     */
		/* 82 */if (shipperType != null)
		/*     */{
			/* 84 */this.shipmentType.setShipper(shipperType);
			/*     */}
		/*     */}

	/*     */
	/*     */public void setPackageDetails(
			UPSShipPackageDetails upsShipPackageDetails, int numOfPackages)
	/*     */{
		/* 91 */for (int i = 0; i < numOfPackages; i++)
			/* 92 */this.packageList.add(upsShipPackageDetails.getPackage());
		/*     */}

	/*     */
	/*     */public void setLabelSpecification(
			UPSShipLabelDetails upsShipLabelDetails)
	/*     */{
		/* 97 */this.shipmentRequest.setLabelSpecification(upsShipLabelDetails
				.getLabelSpecifications());
		/*     */}

	/*     */
	/*     */public void setPaymentInfo(UPSShipPaymentDetails upsShipPaymentDetails)
	/*     */{
		/* 102 */this.shipmentType.setPaymentInformation(upsShipPaymentDetails
				.getPaymentInfo());
		/*     */}

	/*     */
	/*     */public void setUPSServiceInfo(
			UPSShipServiceDetails upsShipServiceDetails) {
		/* 106 */this.shipmentType.setService(upsShipServiceDetails
				.getService());
		/*     */}

	/*     */
	/*     */public UPSShipmentResponse processShipment()
			throws ShipmentErrorMessage
	/*     */{
		/* 111 */this.shipmentRequest.setShipment(this.shipmentType);
		ShipmentResponse _response = this.shipPort.processShipment(
				this.shipmentRequest, this.upsSecurity);
		/* 112 */return new UPSShipmentResponse(_response);
		/*     */}

	/*     */
	/*     */public UPSShipAddressDetails getAddressDetailsInstance() {
		/* 116 */return new UPSShipAddressDetails();
		/*     */}

	public ShipmentRequest getShipmentRequest() {
		return shipmentRequest;
	}

	public void setShipmentRequest(ShipmentRequest shipmentRequest) {
		this.shipmentRequest = shipmentRequest;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public ShipmentType getShipmentType() {
		return shipmentType;
	}

	public void setShipmentType(ShipmentType shipmentType) {
		this.shipmentType = shipmentType;
	}

	
	/*     */
}

/*
 * Location: /home/cloudio/IoUpsWsdlInvoker.jar Qualified Name:
 * com.io.extService.upsShipping.shipment.UPSShipmentInvoker JD-Core Version:
 * 0.6.2
 */