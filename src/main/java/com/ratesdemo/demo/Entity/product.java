package com.ratesdemo.demo.Entity;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")

public class product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private product_Category category;
	
	@Column(name = "sku")
	private String sku;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "unit_price")
	private BigDecimal unit_price;

	@Column(name = "image_url")
	private String img_Url;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "units_in_stock")
	private int units_In_Stock;
	
	@Column(name = "date_created")
	private Date date_Created;
	
	@Column(name = "last_updated")
	private Date last_Updated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public product_Category getCategory() {
		return category;
	}

	public void setCategory(product_Category category) {
		this.category = category;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(BigDecimal unit_price) {
		this.unit_price = unit_price;
	}

	public String getImg_Url() {
		return img_Url;
	}

	public void setImg_Url(String img_Url) {
		this.img_Url = img_Url;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getUnits_In_Stock() {
		return units_In_Stock;
	}

	public void setUnits_In_Stock(int units_In_Stock) {
		this.units_In_Stock = units_In_Stock;
	}

	public Date getDate_Created() {
		return date_Created;
	}

	public void setDate_Created(Date date_Created) {
		this.date_Created = date_Created;
	}

	public Date getLast_Updated() {
		return last_Updated;
	}

	public void setLast_Updated(Date last_Updated) {
		this.last_Updated = last_Updated;
	}
	
}