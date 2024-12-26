package com.sathya.springbootmvc.product.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.springbootmvc.product.entity.ProductEntity;
import com.sathya.springbootmvc.product.model.ProductModel;
import com.sathya.springbootmvc.product.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class ProductModelController {
	@Autowired
	ProductService productService;

@GetMapping("productform")
public String getProductForm(Model model) {
	ProductModel productModel=new ProductModel();
	productModel.setDiscountRate(10);
	productModel.setPrice(10);
	productModel.setBrand("oppo");
	model.addAttribute("productModel",productModel);
    return "add-product";
}

/*@PostMapping("/saveproduct")
public String postEmployee(ProductModel productModel) {
        
	 productService.saveProductDetails(productModel);
	    return "success";
}*/

@PostMapping("/saveproduct")
public String saveProduct(@Valid ProductModel productModel,BindingResult bindingResult,Model model) {
    HashMap<String, String> validationError=new HashMap<String,String>(); 
    if(bindingResult.hasErrors())
    {
    	for (FieldError fieldErrors:bindingResult.getFieldErrors()) {
			validationError.put(fieldErrors.getField(), fieldErrors.getDefaultMessage());
			model.addAttribute("validationError",validationError);
		}
        return "add-product";

    }
    productService.saveProductDetails(productModel);
    return "redirect:/getallproducts";
}

@GetMapping("/getallproducts")
public String getallproducts(Model model) {
	List<ProductEntity>products=productService.getAllproducts();
	model.addAttribute("products",products);
	return "product-list" ;
	}

@GetMapping("/getsearchform")
public String getSearchForm() {
    return "search-product";
}
@PostMapping("/searchbyid")
public String searchById(@RequestParam Long id,Model model) {
    
	ProductEntity productEntity=productService.searchById(id);
	model.addAttribute("product" ,productEntity);
    return "search-product";
}
@GetMapping("/delete/{id}")
public String deletedById(@PathVariable("id") Long id) {
	productService.deletedProductById(id);
	return "redirect:/getallproducts";
}

@GetMapping("/edit/{id}")
public String showEditForm(@PathVariable("id") Long id,Model model) {
	ProductEntity productEntity=productService.editById(id);
	model.addAttribute("products",productEntity);
	model.addAttribute("id",id);
    return "edit-product";
}

@PostMapping("/editsaveproduct/{id}")
public String updateProduct(@PathVariable("id") long id,ProductModel productModel) {

	productService.updateProduct(id,productModel);
    return "redirect:/getallproducts" ;
}

}



