/*    */ package com.io.extService.upsShipping.shipment;
/*    */ 
/*    */ public class UPSWsdlFactory
/*    */ {
/*    */   public static UPSShipmentInvoker getInvoker(String invokerType)
/*    */   {
/*    */     String str;
/* 11 */     switch ((str = invokerType.toLowerCase()).hashCode()) { case -516329062:
/* 11 */       if (str.equals("shipment"))
/*    */       {
/* 13 */         return new UPSShipmentInvoker();
/*    */       }
/*    */       break; }
/* 16 */     return null;
/*    */   }
/*    */ }

/* Location:           /home/cloudio/IoUpsWsdlInvoker.jar
 * Qualified Name:     com.io.extService.upsShipping.shipment.UPSWsdlFactory
 * JD-Core Version:    0.6.2
 */