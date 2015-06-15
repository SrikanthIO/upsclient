/*    */ package com.io.extService.upsShipping.shipment;
/*    */ 
/*    */ import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
/*    */ import com.sun.org.apache.xml.internal.security.utils.Base64;
/*    */ import com.ups.xmlschema.xoltws.common.v1.CodeDescriptionType;
/*    */ import com.ups.xmlschema.xoltws.common.v1.ResponseType;
/*    */ import com.ups.xmlschema.xoltws.ship.v1.LabelType;
/*    */ import com.ups.xmlschema.xoltws.ship.v1.PackageResultsType;
/*    */ import com.ups.xmlschema.xoltws.ship.v1.ShipmentResponse;
/*    */ import com.ups.xmlschema.xoltws.ship.v1.ShipmentResultsType;
/*    */ import java.io.File;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class UPSShipmentResponse
/*    */ {
/* 17 */   private ShipmentResponse shipmentResponse = null;
/* 18 */   private List<PackageResultsType> packageResultList = null;
/*    */ 
/*    */   public UPSShipmentResponse(ShipmentResponse shipmentResponse)
/*    */   {
/* 22 */     this.shipmentResponse = shipmentResponse;
/*    */   }
/*    */ 
/*    */   public boolean isResponseSuccessful()
/*    */   {
/* 27 */     if (this.shipmentResponse != null)
/*    */     {
/* 29 */       String responseCode = this.shipmentResponse.getResponse().getResponseStatus().getCode();
/* 30 */       String responseDesc = this.shipmentResponse.getResponse().getResponseStatus().getDescription();
/*    */ 
/* 32 */       if (("1".equals(responseCode)) && ("success".equals(responseDesc.toLowerCase())))
/*    */       {
/* 34 */         this.packageResultList = this.shipmentResponse.getShipmentResults().getPackageResults();
/* 35 */         return true;
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 40 */     return false;
/*    */   }
/*    */ 
/*    */   public List<String> getTrackingNumbers()
/*    */   {
/* 45 */     List labelNumbersList = new ArrayList();
/*    */ 
/* 47 */     if ((this.packageResultList != null) && (this.packageResultList.size() > 0))
/*    */     {
/* 49 */       for (int i = 0; i < this.packageResultList.size(); i++)
/*    */       {
/* 51 */         labelNumbersList.add(((PackageResultsType)this.packageResultList.get(i)).getTrackingNumber());
/*    */       }
/*    */     }
/*    */ 
/* 55 */     return labelNumbersList;
/*    */   }
/*    */ 
/*    */   public void printAllLabelsAsPDF(String saveFileLocation) throws Base64DecodingException, IOException
/*    */   {
/* 60 */     for (PackageResultsType packageResultsType : this.packageResultList)
/*    */     {
/* 62 */       writeFile(packageResultsType.getShippingLabel().getGraphicImage(), saveFileLocation, packageResultsType.getTrackingNumber());
/*    */     }
/*    */   }
/*    */ 
/*    */   public ShipmentResponse getShipmentResponse()
/*    */   {
/* 68 */     return this.shipmentResponse;
/*    */   }
/*    */ 
/*    */   private static void writeFile(String gifImageString, String saveFileLocation, String labelNumber)
/*    */     throws Base64DecodingException, IOException
/*    */   {
/* 85 */     File f = new File(saveFileLocation + labelNumber);
/* 86 */     byte[] b = Base64.decode(gifImageString);
/* 87 */     FileOutputStream _os = new FileOutputStream(f);
/* 88 */     _os.write(b);
/* 89 */     _os.close();
/*    */   }
/*    */ }

/* Location:           /home/cloudio/IoUpsWsdlInvoker.jar
 * Qualified Name:     com.io.extService.upsShipping.shipment.UPSShipmentResponse
 * JD-Core Version:    0.6.2
 */