package com.sathya.springbootmvc.product.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
 
	@NotBlank(message="product name cannot be blank")
	private String name;
	@NotBlank(message="Brand cannot bo blank")
	private String brand;
	@NotBlank(message="Made-in field cannot be blank")
	private String madeIn;
	@Positive(message="Price must be greatter than zero")
	private double price;
	@Min( value=1,message="Quantity must be atleast one")
	private int quantity;
	@DecimalMax(value="100.0",message="discount rate cannot exceed 100")
	private int discountRate;
	
	}


