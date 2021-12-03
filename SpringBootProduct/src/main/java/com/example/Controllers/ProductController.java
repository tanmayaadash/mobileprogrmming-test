package com.example.Controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Pojo.Product;


@RestController
@RequestMapping("product")
public class ProductController {
	
	ArrayList<Product> pro = new ArrayList<>();
	
	@PostMapping("add")
	public Product createProduct(@RequestBody Product newProduct) {
		Product userToUpdateProduct = new Product(newProduct.getName(),newProduct.getPrice(),newProduct.getDescription());
		this.pro.add(userToUpdateProduct);
		return userToUpdateProduct;
	}
	@GetMapping("all")
	public ArrayList<Product> getAllUser(){
		return this.pro;
	}
	
//	@PutMapping("update")
//	public Boolean updateProduct(@RequestBody Product newProduct) {
//		
//		for (Product product : pro) {
//			System.out.println(product.getPid()+" product_id= "+ newProduct.getPid());
//			if(product.getPid() == newProduct.getPid()) {
//				product.setName( newProduct.getName());
//				product.setPrice( newProduct.getPrice());
//				product.setDescription( newProduct.getDescription());
//
//				return true;
//			}
//		}
//		
//		return false;
//	}
	@PutMapping("update")
	public Boolean updateUser(@RequestBody Product newProduct) {

		for (Product product : pro) {
			if (product.getPid() == newProduct.getPid()) {
				product.setName(newProduct.getName());
				product.setPrice(newProduct.getPrice());
				product.setDescription(newProduct.getDescription());
			
				return true;
			}
		}

		return false;
	}
	
	@DeleteMapping("delete/{id}")
	public Boolean deleteProduct(@PathVariable("id") int id) {
		System.out.println(" product_id is "+id);
		for (Product product : pro) {
			if(product.getPid()==id) {
				return pro.remove(product);
			}
		}
		return false;
	}

}
