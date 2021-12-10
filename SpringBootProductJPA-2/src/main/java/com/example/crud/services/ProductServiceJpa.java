package com.example.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.dao.ProductDao;
import com.example.crud.pojo.Product;

@Service
public class ProductServiceJpa {
	
	@Autowired
	ProductDao pd;
	
	public Product createProductSevice(Product newProduct)
	{
		return this.pd.save(newProduct);
	}
	public List<Product> getAllProductService()
	{
		return this.pd.findAll();

	}
	
	public Optional<Product> getDetailsService( int id) {
		return this.pd.findById(id);
	}

	public int deleteProductService(int id) {
		try {
			this.pd.deleteById(id);
			return 1;
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	
	
	public Product updateProductService(Product proToUpdate,int id) {
		Optional<Product> foundProduct=this.pd.findById(id);
		if(foundProduct.isPresent())
		{
			Product oldProduct = foundProduct.get();
			oldProduct.setName(proToUpdate.getName());
			oldProduct.setPrice(proToUpdate.getPrice());
			oldProduct.setDescription(proToUpdate.getDescription());
			

			return this.pd.save(oldProduct);

		}
		return null;
	}

}
