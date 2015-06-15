/*    */ package com.io.extService.upsShipping.shipment;
/*    */ 
/*    */ import com.ups.xmlschema.xoltws.ship.v1.EmailDetailsType;
/*    */ import com.ups.xmlschema.xoltws.ship.v1.NotificationType;
/*    */ import com.ups.xmlschema.xoltws.ship.v1.ServiceType;
import com.ups.xmlschema.xoltws.ship.v1.ShipmentType;
/*    */ import com.ups.xmlschema.xoltws.ship.v1.ShipmentType.ShipmentServiceOptions;

/*    */ import java.util.List;
/*    */ 
/*    */ public class UPSShipServiceDetails
/*    */ {
/* 12 */   ServiceType service = new ServiceType();
/* 13 */   ShipmentType.ShipmentServiceOptions shipmentServiceOptions = new ShipmentType.ShipmentServiceOptions();
/*    */ 
/*    */   public void setDetails(String code, String description)
/*    */   {
/* 17 */     this.service.setCode(code);
/* 18 */     if ((description != null) && (!"".equals(description)))
/* 19 */       this.service.setDescription(description);
/*    */   }
/*    */ 
/*    */   public void setSaturdayDeliveryIndicator(boolean isRequired)
/*    */   {
/* 24 */     if (isRequired)
/* 25 */       this.shipmentServiceOptions.setSaturdayDeliveryIndicator(String.valueOf(isRequired));
/*    */   }
/*    */ 
/*    */   public void setUPScarbonneutralIndicator(boolean isRequired)
/*    */   {
/* 31 */     if (isRequired)
/* 32 */       this.shipmentServiceOptions.setUPScarbonneutralIndicator(String.valueOf(isRequired));
/*    */   }
/*    */ 
/*    */   public void setEmailNotification(String emailAddress)
/*    */   {
/* 43 */     NotificationType notificationType = new NotificationType();
/* 44 */     notificationType.setNotificationCode("6");
/* 45 */     EmailDetailsType emailDetailsType = new EmailDetailsType();
/* 46 */     emailDetailsType.setFromEMailAddress(emailAddress);
/* 47 */     notificationType.setEMail(emailDetailsType);
/*    */ 
/* 49 */     List notifications = this.shipmentServiceOptions.getNotification();
/* 50 */     notifications.add(notificationType);
/*    */   }
/*    */ 
/*    */   public ServiceType getService() {
/* 54 */     return this.service;
/*    */   }
/*    */ 
/*    */   public ShipmentType.ShipmentServiceOptions getAdditonalServices() {
/* 58 */     return this.shipmentServiceOptions;
/*    */   }
/*    */ }

/* Location:           /home/cloudio/IoUpsWsdlInvoker.jar
 * Qualified Name:     com.io.extService.upsShipping.shipment.UPSShipServiceDetails
 * JD-Core Version:    0.6.2
 */