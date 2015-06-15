/*    */ package com.io.extService.upsShipping.shipment;
/*    */ 
/*    */ import com.ups.xmlschema.xoltws.ship.v1.BillShipperType;
/*    */ import com.ups.xmlschema.xoltws.ship.v1.CreditCardAddressType;
/*    */ import com.ups.xmlschema.xoltws.ship.v1.CreditCardType;
/*    */ import com.ups.xmlschema.xoltws.ship.v1.PaymentInfoType;
/*    */ import com.ups.xmlschema.xoltws.ship.v1.ShipmentChargeType;
/*    */ import java.util.List;
/*    */ 
/*    */ public class UPSShipPaymentDetails
/*    */ {
/* 12 */   PaymentInfoType paymentInfoType = new PaymentInfoType();
/* 13 */   ShipmentChargeType shipmentChargeType = new ShipmentChargeType();
/* 14 */   BillShipperType billShipper = new BillShipperType();
/* 15 */   CreditCardType creditCardType = new CreditCardType();
/* 16 */   CreditCardAddressType creditCardAddressType = new CreditCardAddressType();
/*    */ 
/* 18 */   private String paymentMethod = "accountNumber";
/*    */ 
/*    */   public void setShipmentChargeType(String type)
/*    */   {
/* 22 */     this.shipmentChargeType.setType(type);
/*    */   }
/*    */ 
/*    */   public void setAccountNumber(String accountNumber)
/*    */   {
/* 27 */     this.paymentMethod = "accountNumber";
/* 28 */     this.billShipper.setAccountNumber(accountNumber);
/*    */   }
/*    */ 
/*    */   public void setCreditCardType(String typeCode)
/*    */   {
/* 36 */     this.paymentMethod = "creditCard";
/* 37 */     this.creditCardType.setType(typeCode);
/*    */   }
/*    */ 
/*    */   public void setCardNumber(String cardNumber) {
/* 41 */     this.paymentMethod = "creditCard";
/* 42 */     this.creditCardType.setNumber(cardNumber);
/*    */   }
/*    */ 
/*    */   public void setVerificationCode(String code) {
/* 46 */     this.creditCardType.setSecurityCode(code);
/*    */   }
/*    */ 
/*    */   public void setExpirationDate(String expirationDate) {
/* 50 */     this.creditCardType.setExpirationDate(expirationDate);
/*    */   }
/*    */ 
/*    */   public void setAddressLines(String addressLine1, String addressLine2, String addressLine3)
/*    */   {
/* 55 */     List creditCardAddressLines = this.creditCardAddressType.getAddressLine();
/* 56 */     creditCardAddressLines.add(addressLine1);
/*    */ 
/* 58 */     if ((addressLine2 != null) && (!"".equals(addressLine2))) {
/* 59 */       creditCardAddressLines.add(addressLine2);
/*    */     }
/*    */ 
/* 62 */     if ((addressLine3 != null) && (!"".equals(addressLine3)))
/* 63 */       creditCardAddressLines.add(addressLine3);
/*    */   }
/*    */ 
/*    */   public void setCity(String city)
/*    */   {
/* 68 */     this.creditCardAddressType.setCity(city);
/*    */   }
/*    */ 
/*    */   public void setStateProvinceCode(String stateCode) {
/* 72 */     this.creditCardAddressType.setStateProvinceCode(stateCode);
/*    */   }
/*    */ 
/*    */   public void setCountryCode(String countryCode) {
/* 76 */     this.creditCardAddressType.setCountryCode(countryCode);
/*    */   }
/*    */ 
/*    */   public void setZipCode(String zipCode) {
/* 80 */     this.creditCardAddressType.setPostalCode(zipCode);
/*    */   }
/*    */ 
/*    */   public PaymentInfoType getPaymentInfo()
/*    */   {
/* 88 */     if ("creditCard".equals(this.paymentMethod)) {
/* 89 */       this.billShipper.setCreditCard(this.creditCardType);
/*    */     }
/* 91 */     this.shipmentChargeType.setBillShipper(this.billShipper);
/*    */ 
/* 93 */     List shipmentChargesList = this.paymentInfoType.getShipmentCharge();
/* 94 */     shipmentChargesList.add(this.shipmentChargeType);
/*    */ 
/* 96 */     return this.paymentInfoType;
/*    */   }
/*    */ }

/* Location:           /home/cloudio/IoUpsWsdlInvoker.jar
 * Qualified Name:     com.io.extService.upsShipping.shipment.UPSShipPaymentDetails
 * JD-Core Version:    0.6.2
 */