package com.example.crud.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.pojo.Product;
import com.example.crud.services.ProductServiceJpa;
@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductServiceJpa ps;
	
	@PostMapping("add")
	public Product createProduct(@RequestBody Product newProduct) {
		
		return this.ps.createProductSevice(newProduct);
	}
	
	@GetMapping("all")
	public List<Product> getAllProduct(){
		return this.ps.getAllProductService();
	}
	
	@GetMapping("details/{id}")
	public Optional<Product> getDetails(@PathVariable("id") int id) {
		return this.ps.getDetailsService(id);
	}
	
	
	@DeleteMapping("delete/{id}")
	public int deleteProduct(@PathVariable("id") int id) {
		return this.ps.deleteProductService(id);
	}
	
	@PutMapping("update/{id}")
	public Product updateProduct(@RequestBody Product p,@PathVariable("id")int id) {
		return this.ps.updateProductService(p, id);  
		
		}
}
