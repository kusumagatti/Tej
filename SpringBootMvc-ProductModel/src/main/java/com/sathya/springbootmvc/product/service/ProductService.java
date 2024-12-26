package com.sathya.springbootmvc.product.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.springbootmvc.product.entity.ProductEntity;
import com.sathya.springbootmvc.product.model.ProductModel;
import com.sathya.springbootmvc.product.repository.Productrepository;

@Service
public class ProductService {
 
	@Autowired
	Productrepository productrepository;

	public void saveProductDetails(ProductModel productModel) {
      
		double stockValue;
		stockValue=productModel.getPrice()*productModel.getQuantity();
		double discountPrice;
		discountPrice=productModel.getPrice()*productModel.getDiscountRate()/100;
		double taxPrice;
		taxPrice=18;
		double offerPrice;
		offerPrice=productModel.getPrice()- discountPrice;
		double finalPrice;
		finalPrice=offerPrice+(taxPrice/100);
		ProductEntity productEntity=new ProductEntity();
		productEntity.setName(productModel.getName());
		productEntity.setBrand(productModel.getBrand());
		productEntity.setMadeIn(productModel.getMadeIn());
		productEntity.setPrice(productModel.getPrice());
		productEntity.setQuantity(productModel.getQuantity());
		productEntity.setDiscountRate(productModel.getDiscountRate());
		productEntity.setDiscountPrice(discountPrice);
		productEntity.setTaxRate(taxPrice);
		productEntity.setOfferPrice(offerPrice);
		productEntity.setFinalPrice(finalPrice);
		productEntity.setStockValue(stockValue);
	   
		productrepository.save(productEntity);
		
	
	}

 	public  List<ProductEntity> getAllproducts() {
		List<ProductEntity> products=productrepository.findAll();
 		return products;
	}

	public ProductEntity searchById(Long id) {
     
		Optional<ProductEntity> optionalData=productrepository.findById(id);
		if(optionalData.isPresent())
		{
			ProductEntity product=optionalData.get();
			return product;
		}
		else
		{
		return null;
		}
	}

	public  void deletedProductById(Long id) {
		productrepository.deleteById(id);		
	}

	public ProductEntity editById(Long id) {
		ProductEntity product = productrepository.findById(id).get();
			return product;
		}

	public void updateProduct(long id, ProductModel productModel) {
    Optional<ProductEntity>	optionalData=productrepository.findById(id);
    if(optionalData.isPresent())
    {
    	ProductEntity entity=optionalData.get();
    	entity.setName(productModel.getName());
    	entity.setBrand(productModel.getBrand());
    	entity.setMadeIn(productModel.getMadeIn());
        entity.setPrice(productModel.getPrice());
        entity.setQuantity(productModel.getQuantity());
        entity.setDiscountRate(productModel.getDiscountRate());  
        double stockValue;
		stockValue=productModel.getPrice()*productModel.getQuantity();
		double discountPrice;
		discountPrice=productModel.getPrice()*productModel.getDiscountRate()/100;
		double taxPrice;
		taxPrice=18;
		double offerPrice;
		offerPrice=productModel.getPrice()- discountPrice;
		double finalPrice;
		finalPrice=offerPrice+(taxPrice/100);
		entity.setDiscountPrice(discountPrice);
		entity.setTaxRate(taxPrice);
		entity.setOfferPrice(offerPrice);
		entity.setFinalPrice(finalPrice);
		entity.setStockValue(stockValue);
	   
		productrepository.save(entity);
    }
	}
		

}
