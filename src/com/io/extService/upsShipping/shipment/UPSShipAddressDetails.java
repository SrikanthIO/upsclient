/*     */ package com.io.extService.upsShipping.shipment;
/*     */ 
/*     */ import com.ups.xmlschema.xoltws.ship.v1.CompanyInfoType;
/*     */ import com.ups.xmlschema.xoltws.ship.v1.ShipAddressType;
/*     */ import com.ups.xmlschema.xoltws.ship.v1.ShipFromType;
/*     */ import com.ups.xmlschema.xoltws.ship.v1.ShipPhoneType;
/*     */ import com.ups.xmlschema.xoltws.ship.v1.ShipToAddressType;
/*     */ import com.ups.xmlschema.xoltws.ship.v1.ShipToType;
/*     */ import com.ups.xmlschema.xoltws.ship.v1.ShipperType;
/*     */ import java.util.List;
/*     */ 
/*     */ public class UPSShipAddressDetails
/*     */ {
/*  15 */   ShipAddressType shipperAddressType = null;
/*  16 */   CompanyInfoType companyInfoType = null;
/*  17 */   List<String> addressLineList = null;
/*  18 */   ShipPhoneType shipPhoneType = new ShipPhoneType();
/*     */ 
/*     */   public void setAddresserType(String type)
/*     */   {

			if("to".equals(type)) {
				this.companyInfoType = new ShipToType();
				this.shipperAddressType = new ShipToAddressType();
				this.addressLineList = this.shipperAddressType.getAddressLine();
			} else if("from".equals(type)) {
				this.companyInfoType = new ShipFromType();
				this.shipperAddressType = new ShipAddressType();
				this.addressLineList = this.shipperAddressType.getAddressLine();
			}else if("shipper".equals(type)) {
				 this.companyInfoType = new ShipperType();
				this.shipperAddressType = new ShipAddressType();
				 this.addressLineList = this.shipperAddressType.getAddressLine();
			}

/*     */   }
/*     */ 
/*     */   public void setAccountNumber(String accountNumber)
/*     */   {
/*  53 */     if (this.companyInfoType != null)
/*     */     {
/*  55 */       if ((this.companyInfoType instanceof ShipperType))
/*     */       {
/*  57 */         ((ShipperType)this.companyInfoType).setShipperNumber(accountNumber);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setCompanyName(String name)
/*     */   {
/*  64 */     if (this.companyInfoType != null)
/*  65 */       this.companyInfoType.setCompanyDisplayableName(name);
/*     */   }
/*     */ 
/*     */   public void setAttentionName(String name)
/*     */   {
/*  70 */     if (this.companyInfoType != null)
/*  71 */       this.companyInfoType.setAttentionName(name);
/*     */   }
/*     */ 
/*     */   public void setContactName(String name)
/*     */   {
/*  76 */     if (this.companyInfoType != null)
/*  77 */       this.companyInfoType.setName(name);
/*     */   }
/*     */ 
/*     */   public void setAddressLine1(String addressLine1)
/*     */   {
/*  82 */     if ((this.shipperAddressType != null) && (this.addressLineList != null))
/*  83 */       this.addressLineList.add(addressLine1);
/*     */   }
/*     */ 
/*     */   public void setAddressLine2(String addressLine2)
/*     */   {
/*  88 */     if ((this.shipperAddressType != null) && (this.addressLineList != null))
/*  89 */       this.addressLineList.add(addressLine2);
/*     */   }
/*     */ 
/*     */   public void setAddressLine3(String addressLine3)
/*     */   {
/*  94 */     if ((this.shipperAddressType != null) && (this.addressLineList != null))
/*  95 */       this.addressLineList.add(addressLine3);
/*     */   }
/*     */ 
/*     */   public void setCity(String city)
/*     */   {
/* 100 */     if (this.shipperAddressType != null)
/* 101 */       this.shipperAddressType.setCity(city);
/*     */   }
/*     */ 
/*     */   public void setStateProvinceCode(String stateProvinceCode)
/*     */   {
/* 106 */     if (this.shipperAddressType != null)
/* 107 */       this.shipperAddressType.setStateProvinceCode(stateProvinceCode);
/*     */   }
/*     */ 
/*     */   public void setCountryCode(String countryCode)
/*     */   {
/* 113 */     if (this.shipperAddressType != null)
/* 114 */       this.shipperAddressType.setCountryCode(countryCode);
/*     */   }
/*     */ 
/*     */   public void setZipCode(String zipCode)
/*     */   {
/* 119 */     if (this.shipperAddressType != null)
/* 120 */       this.shipperAddressType.setPostalCode(zipCode);
/*     */   }
/*     */ 
/*     */   public void setPhoneNumber(String phoneNumber, String ext)
/*     */   {
/* 126 */     this.shipPhoneType.setNumber(phoneNumber);
/*     */ 
/* 128 */     if ((ext != null) && (!"".equals(ext))) {
/* 129 */       this.shipPhoneType.setExtension(ext);
/*     */     }
/*     */ 
/* 132 */     if (this.companyInfoType != null)
/* 133 */       this.companyInfoType.setPhone(this.shipPhoneType);
/*     */   }
/*     */ 
/*     */   public void setResidentialAddress(boolean isResidential)
/*     */   {
/* 138 */     if (this.shipperAddressType != null)
/*     */     {
/* 140 */       if ((this.shipperAddressType instanceof ShipToAddressType))
/* 141 */         ((ShipToAddressType)this.shipperAddressType).setResidentialAddressIndicator(String.valueOf(isResidential));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setEMailAddress(String email)
/*     */   {
/* 148 */     if (this.companyInfoType != null)
/*     */     {
/* 150 */       if ((this.companyInfoType instanceof ShipToType))
/*     */       {
/* 152 */         ((ShipToType)this.companyInfoType).setEMailAddress(email);
/*     */       }
/* 154 */       else if ((this.companyInfoType instanceof ShipperType))
/*     */       {
/* 156 */         ((ShipperType)this.companyInfoType).setEMailAddress(email);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setFaxNumber(String fax) {
/* 162 */     if (this.companyInfoType != null)
/*     */     {
/* 164 */       if ((this.companyInfoType instanceof ShipToType)) {
/* 165 */         ((ShipToType)this.companyInfoType).setFaxNumber(fax);
/*     */       }
/* 167 */       else if ((this.companyInfoType instanceof ShipperType)) {
/* 168 */         ((ShipperType)this.companyInfoType).setFaxNumber(fax);
/*     */       }
/* 170 */       else if ((this.companyInfoType instanceof ShipFromType))
/* 171 */         ((ShipFromType)this.companyInfoType).setFaxNumber(fax);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setTaxIdentificationNumber(String taxIndicationNumber)
/*     */   {
/* 178 */     if (this.companyInfoType != null)
/* 179 */       this.companyInfoType.setTaxIdentificationNumber(taxIndicationNumber);
/*     */   }
/*     */ 
/*     */   public CompanyInfoType getAddress()
/*     */   {
/* 190 */     if (this.companyInfoType != null) {
/* 191 */       if (((this.companyInfoType instanceof ShipToType)) && ((this.shipperAddressType instanceof ShipToAddressType)))
/*     */       {
/* 193 */         ((ShipToType)this.companyInfoType).setAddress((ShipToAddressType)this.shipperAddressType);
/*     */       }
/* 196 */       else if ((this.companyInfoType instanceof ShipFromType))
/*     */       {
/* 198 */         ((ShipFromType)this.companyInfoType).setAddress(this.shipperAddressType);
/*     */       }
/* 201 */       else if ((this.companyInfoType instanceof ShipperType))
/*     */       {
/* 203 */         ((ShipperType)this.companyInfoType).setAddress(this.shipperAddressType);
/*     */       }
/*     */ 
/* 206 */       return this.companyInfoType;
/*     */     }
/*     */ 
/* 209 */     return null;
/*     */   }
/*     */ 
/*     */   public String getAddressType()
/*     */   {
/* 214 */     if (this.companyInfoType != null) {
/* 215 */       if ((this.companyInfoType instanceof ShipFromType))
/* 216 */         return "from";
/* 217 */       if ((this.companyInfoType instanceof ShipToType))
/* 218 */         return "to";
/* 219 */       if ((this.companyInfoType instanceof ShipperType)) {
/* 220 */         return "return";
/*     */       }
/*     */     }
/* 223 */     return "none";
/*     */   }
/*     */ 
/*     */   public String getCompanyName()
/*     */   {
/* 228 */     if (this.companyInfoType != null) {
/* 229 */       return this.companyInfoType.getCompanyDisplayableName();
/*     */     }
/* 231 */     return "";
/*     */   }
/*     */ 
/*     */   public String getAttention()
/*     */   {
/* 236 */     if (this.companyInfoType != null) {
/* 237 */       return this.companyInfoType.getAttentionName();
/*     */     }
/* 239 */     return "";
/*     */   }
/*     */ 
/*     */   public String getContactName()
/*     */   {
/* 245 */     if (this.companyInfoType != null) {
/* 246 */       return this.companyInfoType.getName();
/*     */     }
/* 248 */     return "";
/*     */   }
/*     */ 
/*     */   public String getAddressLine1()
/*     */   {
/* 253 */     if ((this.addressLineList != null) && (this.addressLineList.size() > 0)) {
/* 254 */       return (String)this.addressLineList.get(0);
/*     */     }
/* 256 */     return "";
/*     */   }
/*     */ 
/*     */   public String getAddressLine2()
/*     */   {
/* 261 */     if ((this.addressLineList != null) && (this.addressLineList.size() > 1)) {
/* 262 */       return (String)this.addressLineList.get(1);
/*     */     }
/* 264 */     return "";
/*     */   }
/*     */ 
/*     */   public String getAddressLine3()
/*     */   {
/* 269 */     if ((this.addressLineList != null) && (this.addressLineList.size() > 2)) {
/* 270 */       return (String)this.addressLineList.get(2);
/*     */     }
/* 272 */     return "";
/*     */   }
/*     */ 
/*     */   public String getCity()
/*     */   {
/* 277 */     if (this.shipperAddressType != null) {
/* 278 */       return this.shipperAddressType.getCity();
/*     */     }
/* 280 */     return "";
/*     */   }
/*     */ 
/*     */   public String getStateProvinceCode()
/*     */   {
/* 285 */     if (this.shipperAddressType != null) {
/* 286 */       return this.shipperAddressType.getStateProvinceCode();
/*     */     }
/* 288 */     return "";
/*     */   }
/*     */ 
/*     */   public String getZipCode()
/*     */   {
/* 293 */     if (this.shipperAddressType != null) {
/* 294 */       return this.shipperAddressType.getPostalCode();
/*     */     }
/* 296 */     return "";
/*     */   }
/*     */ 
/*     */   public String getEmailAddress()
/*     */   {
/* 301 */     if (this.companyInfoType != null)
/*     */     {
/* 303 */       if ((this.companyInfoType instanceof ShipToType))
/*     */       {
/* 305 */         return ((ShipToType)this.companyInfoType).getEMailAddress();
/*     */       }
/* 307 */       if ((this.companyInfoType instanceof ShipperType))
/*     */       {
/* 309 */         return ((ShipperType)this.companyInfoType).getEMailAddress();
/*     */       }
/*     */     }
/*     */ 
/* 313 */     return "";
/*     */   }
/*     */ 
/*     */   public String getTaxIdentificationNumber()
/*     */   {
/* 318 */     if (this.companyInfoType != null) {
/* 319 */       return this.companyInfoType.getTaxIdentificationNumber();
/*     */     }
/* 321 */     return "";
/*     */   }
/*     */ 
/*     */   public String getFaxNumber()
/*     */   {
/* 326 */     if (this.companyInfoType != null)
/*     */     {
/* 328 */       if ((this.companyInfoType instanceof ShipToType)) {
/* 329 */         return ((ShipToType)this.companyInfoType).getFaxNumber();
/*     */       }
/* 331 */       if ((this.companyInfoType instanceof ShipperType)) {
/* 332 */         return ((ShipperType)this.companyInfoType).getFaxNumber();
/*     */       }
/* 334 */       if ((this.companyInfoType instanceof ShipFromType)) {
/* 335 */         return ((ShipFromType)this.companyInfoType).getFaxNumber();
/*     */       }
/*     */     }
/* 338 */     return "";
/*     */   }
/*     */ 
/*     */   public boolean gitResidentialAddressIndicator()
/*     */   {
/* 343 */     if (this.shipperAddressType != null)
/*     */     {
/* 345 */       if ((this.shipperAddressType instanceof ShipToAddressType)) {
/* 346 */         return Boolean.valueOf(((ShipToAddressType)this.shipperAddressType).getResidentialAddressIndicator()).booleanValue();
/*     */       }
/*     */     }
/* 349 */     return false;
/*     */   }
/*     */ 
/*     */   public String getPhoneNumber()
/*     */   {
/* 354 */     if (this.shipPhoneType.getExtension() != null) {
/* 355 */       return this.shipPhoneType.getNumber() + "(" + this.shipPhoneType.getExtension() + ")";
/*     */     }
/* 357 */     return this.shipPhoneType.getNumber();
/*     */   }
/*     */ }

/* Location:           /home/cloudio/IoUpsWsdlInvoker.jar
 * Qualified Name:     com.io.extService.upsShipping.shipment.UPSShipAddressDetails
 * JD-Core Version:    0.6.2
 */