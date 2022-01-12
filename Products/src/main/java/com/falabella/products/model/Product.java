package com.falabella.products.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "products")
public class Product {
	@NotEmpty
	@Id
    @GeneratedValue(generator = "sku_id")
    @GenericGenerator(name = "sku_id", strategy = "com.falabella.repository.SkuIdGenerator")
  
	private String sku;
	@Length(min = 3, max = 50)
	@NotEmpty
	private String name;
	@Length(min = 3, max = 50)
	@NotEmpty
	private String brand;
	private String size;
	@Range(min = (long) 1.00, max = (long) 99999999.00)
	@NotEmpty
	private float price = (float) 0.0;
	@NotEmpty
	private String principleImage;
	private String otherImage;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPrincipleImage() {
		return principleImage;
	}

	public void setPrincipleImage(String principleImage) {
		this.principleImage = principleImage;
	}

	public String getOtherImage() {
		return otherImage;
	}

	public void setOtherImage(String otherImage) {
		this.otherImage = otherImage;
	}

	public Product(@NotEmpty String sku, @Length(min = 3, max = 50) @NotEmpty String name,
			@Length(min = 3, max = 50) @NotEmpty String brand, String size,
			@Range(min = 1, max = 99999999) @NotEmpty float price, @NotEmpty String principleImage, String otherImage) {
		super();
		this.sku = sku;
		this.name = name;
		this.brand = brand;
		this.size = size;
		this.price = price;
		this.principleImage = principleImage;
		this.otherImage = otherImage;
	}
 public Product()
 {
	 
 }
}
