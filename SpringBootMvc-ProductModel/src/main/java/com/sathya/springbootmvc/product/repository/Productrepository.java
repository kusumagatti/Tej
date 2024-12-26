package com.sathya.springbootmvc.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathya.springbootmvc.product.entity.ProductEntity;

public interface Productrepository extends JpaRepository<ProductEntity ,Long >{
	 
	
}
 
	

