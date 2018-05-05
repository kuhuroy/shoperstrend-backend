package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Products")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotEmpty(message="ProductName cannot be blank(*)")
	private String product_item;
	@NotEmpty(message="Product description is required(*)")
	private String product_Description;
	@Min(value=1,message="minimum price must be 1")
	private double price;
	@Min(value=1,message="minimum quantity must be 1")
	private int quantity;
	@ManyToOne
	@JoinColumn(name="cid")
	private Category category;
	@Transient //not persistent
	private MultipartFile image;
	
	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct_item() {
		return product_item;
	}
	public void setProduct_item(String product_item) {
		this.product_item = product_item;
	}
	public String getProduct_Description() {
		return product_Description;
	}
	public void setProduct_Description(String product_Description) {
		this.product_Description = product_Description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
