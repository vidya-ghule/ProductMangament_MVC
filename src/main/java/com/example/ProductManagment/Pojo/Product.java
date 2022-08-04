package com.example.ProductManagment.Pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
	public class Product {
		@Id
		private String procudtId;
		private String productName;
		private float productPrice;
		private Date productExpiryDate;
		
		
		public Product() {
			// TODO Auto-generated constructor stub
		}


		public Product(String procudtId, String productName, float productPrice, Date productExpiryDate) {
			super();
			this.procudtId = procudtId;
			this.productName = productName;
			this.productPrice = productPrice;
			this.productExpiryDate = productExpiryDate;
		}


		public String getProcudtId() {
			return procudtId;
		}


		public void setProcudtId(String d) {
			this.procudtId = d;
		}


		public String getProductName() {
			return productName;
		}


		public void setProductName(String productName) {
			this.productName = productName;
		}


		public float getProductPrice() {
			return productPrice;
		}


		public void setProductPrice(double d) {
			this.productPrice = (float) d;
		}


		public Date getProductExpiryDate() {
			return productExpiryDate;
		}


		public void setProductExpiryDate(Date productExpiryDate) {
			this.productExpiryDate = productExpiryDate;
		}
		
		
		
		

	}


