/*    */ package com.io.extService.upsShipping.shipment;
/*    */ 
/*    */ import com.ups.xmlschema.xoltws.ship.v1.LabelImageFormatType;
/*    */ import com.ups.xmlschema.xoltws.ship.v1.LabelSpecificationType;
/*    */ 
/*    */ public class UPSShipLabelDetails
/*    */ {
/*  8 */   LabelSpecificationType labelSpecificationType = new LabelSpecificationType();
/*  9 */   LabelImageFormatType labelImageFormat = new LabelImageFormatType();
/*    */ 
/*    */   public void setLabelFormat(String label)
/*    */   {
/* 13 */     this.labelImageFormat.setCode(label);
/* 14 */     this.labelImageFormat.setDescription(label);
/* 15 */     this.labelSpecificationType.setLabelImageFormat(this.labelImageFormat);
/*    */   }
/*    */ 
/*    */   public void setHTTPUserAgent(String code) {
/* 19 */     this.labelSpecificationType.setHTTPUserAgent(code);
/*    */   }
/*    */ 
/*    */   public LabelSpecificationType getLabelSpecifications() {
/* 23 */     return this.labelSpecificationType;
/*    */   }
/*    */ }

/* Location:           /home/cloudio/IoUpsWsdlInvoker.jar
 * Qualified Name:     com.io.extService.upsShipping.shipment.UPSShipLabelDetails
 * JD-Core Version:    0.6.2
 */