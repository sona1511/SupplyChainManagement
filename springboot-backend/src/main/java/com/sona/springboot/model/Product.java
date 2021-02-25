package com.sona.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long prod_id;
	
	@Column(name = "prod_name")
	private String prodName;

	@Column(name = "prod_brand")
	private String prodBrand;
	
	@Column(name = "prod_price")
	private int prodPrice;
	
	public Product() {
		
	}

	public Product(String prodName, String prodBrand, int prodPrice) {
		super();
		this.prodName = prodName;
		this.prodBrand = prodBrand;
		this.prodPrice = prodPrice;
	}

	public long getProd_id() {
		return prod_id;
	}

	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdBrand() {
		return prodBrand;
	}

	public void setProdBrand(String prodBrand) {
		this.prodBrand = prodBrand;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	
	
	
	
}
