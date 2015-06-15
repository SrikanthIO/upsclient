/*     */ package com.io.extService.upsShipping.shipment;
/*     */ 
/*     */ import com.ups.xmlschema.xoltws.ship.v1.DeliveryConfirmationType;
/*     */ import com.ups.xmlschema.xoltws.ship.v1.DimensionsType;
/*     */ import com.ups.xmlschema.xoltws.ship.v1.PSOCODType;
/*     */ import com.ups.xmlschema.xoltws.ship.v1.PackageDeclaredValueType;
/*     */ import com.ups.xmlschema.xoltws.ship.v1.PackageServiceOptionsType;
/*     */ import com.ups.xmlschema.xoltws.ship.v1.PackageType;
/*     */ import com.ups.xmlschema.xoltws.ship.v1.PackageWeightType;
/*     */ import com.ups.xmlschema.xoltws.ship.v1.PackagingType;
/*     */ import com.ups.xmlschema.xoltws.ship.v1.ReferenceNumberType;
/*     */ import com.ups.xmlschema.xoltws.ship.v1.ShipUnitOfMeasurementType;
/*     */ import java.util.List;
/*     */ 
/*     */ public class UPSShipPackageDetails
/*     */ {
/*  18 */   PackageType packageType = new PackageType();
/*  19 */   PackagingType packagingType = new PackagingType();
/*  20 */   PackageServiceOptionsType packageServiceOptionsType = new PackageServiceOptionsType();
/*  21 */   private String deliveryCinfirmationStatus = "2";
/*     */ 
/*     */   public void setPackagingDetails(String code, String packageDescription)
/*     */   {
/*  50 */     this.packagingType.setCode(code);
/*  51 */     if ((packageDescription != null) && (!"".equals(packageDescription))) {
/*  52 */       this.packagingType.setDescription(packageDescription);
/*     */     }
/*  54 */     this.packageType.setPackaging(this.packagingType);
/*     */   }
/*     */ 
/*     */   public void setDimensions(String length, String width, String Height, String unitCode)
/*     */   {
/*  65 */     DimensionsType dimensionsType = new DimensionsType();
/*  66 */     ShipUnitOfMeasurementType unitOfMeasurementType = new ShipUnitOfMeasurementType();
/*  67 */     unitOfMeasurementType.setCode(unitCode);
/*  68 */     dimensionsType.setUnitOfMeasurement(unitOfMeasurementType);
/*  69 */     dimensionsType.setLength(length);
/*  70 */     dimensionsType.setWidth(width);
/*  71 */     dimensionsType.setHeight(Height);
/*  72 */     this.packageType.setDimensions(dimensionsType);
/*     */   }
/*     */ 
/*     */   public void setWeight(String weight, String unitCode)
/*     */   {
/*  87 */     PackageWeightType packageWeightType = new PackageWeightType();
/*  88 */     ShipUnitOfMeasurementType unitOfMeasurementType = new ShipUnitOfMeasurementType();
/*  89 */     unitOfMeasurementType.setCode(unitCode);
/*  90 */     packageWeightType.setWeight(weight);
/*  91 */     packageWeightType.setUnitOfMeasurement(unitOfMeasurementType);
/*  92 */     this.packageType.setPackageWeight(packageWeightType);
/*     */   }
/*     */ 
/*     */   public void setAdditionalHandlingIndicator(boolean isRequired)
/*     */   {
/* 100 */     if (isRequired)
/* 101 */       this.packageType.setAdditionalHandlingIndicator(String.valueOf(isRequired));
/*     */   }
/*     */ 
/*     */   public void setLargePackageIndicator(boolean isRequired)
/*     */   {
/* 108 */     if (isRequired)
/* 109 */       this.packageType.setLargePackageIndicator(String.valueOf(isRequired));
/*     */   }
/*     */ 
/*     */   public void setDeclaredValue(String value)
/*     */   {
/* 115 */     PackageDeclaredValueType declaredValueType = new PackageDeclaredValueType();
/* 116 */     declaredValueType.setMonetaryValue(value);
/* 117 */     this.packageServiceOptionsType.setDeclaredValue(declaredValueType);
/*     */   }
/*     */ 
/*     */   public void setConfirmDeliveryNotification(boolean isRequired)
/*     */   {
/* 131 */     if (isRequired)
/* 132 */       this.deliveryCinfirmationStatus = "2";
/*     */   }
/*     */ 
/*     */   public void setDeliverWithOutSignature(boolean isRequired)
/*     */   {
/* 137 */     if (isRequired)
/* 138 */       this.deliveryCinfirmationStatus = "1";
/*     */   }
/*     */ 
/*     */   public void setCOD(boolean isRequired)
/*     */   {
/* 148 */     if (isRequired) {
/* 149 */       PSOCODType codType = new PSOCODType();
/* 150 */       codType.setCODFundsCode("0");
/* 151 */       this.packageServiceOptionsType.setCOD(codType);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setReferenceNumber(String number1, String number2, boolean isBarCodeRequired)
/*     */   {
/* 157 */     List references = this.packageType.getReferenceNumber();
/*     */ 
/* 159 */     ReferenceNumberType referenceNumberType1 = new ReferenceNumberType();
/* 160 */     ReferenceNumberType referenceNumberType2 = new ReferenceNumberType();
/* 161 */     referenceNumberType1.setValue(number1);
/*     */ 
/* 163 */     if (isBarCodeRequired) {
/* 164 */       referenceNumberType1.setBarCodeIndicator(String.valueOf(isBarCodeRequired));
/*     */     }
/*     */ 
/* 167 */     references.add(referenceNumberType1);
/*     */ 
/* 169 */     if ((number2 != null) && (!"".equals(number2))) {
/* 170 */       referenceNumberType2.setValue(number2);
/* 171 */       references.add(referenceNumberType2);
/*     */     }
/*     */   }
/*     */ 
/*     */   public PackageType getPackage()
/*     */   {
/* 178 */     return this.packageType;
/*     */   }
/*     */ 
/*     */   public PackageServiceOptionsType getAdditionalPackageServices()
/*     */   {
/* 183 */     DeliveryConfirmationType deliveryConfirmationType = new DeliveryConfirmationType();
/* 184 */     deliveryConfirmationType.setDCISType(this.deliveryCinfirmationStatus);
/* 185 */     this.packageServiceOptionsType.setDeliveryConfirmation(deliveryConfirmationType);
/*     */ 
/* 187 */     return this.packageServiceOptionsType;
/*     */   }
/*     */ }

/* Location:           /home/cloudio/IoUpsWsdlInvoker.jar
 * Qualified Name:     com.io.extService.upsShipping.shipment.UPSShipPackageDetails
 * JD-Core Version:    0.6.2
 */