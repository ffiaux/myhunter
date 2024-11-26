package com.myhunter.products.service;

import java.util.List;

import com.myhunter.products.domain.Category;
import com.myhunter.products.domain.Product;

public interface IProductService 
{
	public List<Product> listAllProducts();
	
	public List<Category> listAllCategories();
	
	public Product getProduct(long id);
	
	public Category getCategory(long id);
	
	public void deleteProduct(long id);
	
	public void saveProduct(Product p);
}