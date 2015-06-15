/*    */ package com.io.extService.upsShipping.shipment;
/*    */ 
/*    */ import com.ups.xmlschema.xoltws.upss.v1.UPSSecurity;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class UPSInvoker
/*    */ {
/*    */   public UPSSecurity getUPSSecurity(String accessNumber, String userName, String password)
/*    */   {
/* 11 */     UPSSecurity upsSecurity = new UPSSecurity();
/* 12 */     UPSSecurity.UsernameToken usernameToken = new UPSSecurity.UsernameToken();
/* 13 */     usernameToken.setUsername(userName);
/* 14 */     usernameToken.setPassword(password);
/* 15 */     upsSecurity.setUsernameToken(usernameToken);
/* 16 */     UPSSecurity.ServiceAccessToken accessToken = new UPSSecurity.ServiceAccessToken();
/* 17 */     accessToken.setAccessLicenseNumber(accessNumber);
/* 18 */     upsSecurity.setServiceAccessToken(accessToken);
/* 19 */     return upsSecurity;
/*    */   }
/*    */ 
/*    */   public abstract void initService(String paramString);
/*    */ 
/*    */   public abstract void getUPSLoginAccess(String paramString1, String paramString2, String paramString3);
/*    */ }

/* Location:           /home/cloudio/IoUpsWsdlInvoker.jar
 * Qualified Name:     com.io.extService.upsShipping.shipment.UPSInvoker
 * JD-Core Version:    0.6.2
 */