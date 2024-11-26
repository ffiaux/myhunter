package com.myhunter.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhunter.products.domain.Category;
import com.myhunter.products.domain.Product;
import com.myhunter.products.repository.CategoryRepository;
import com.myhunter.products.repository.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService 
{
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public List<Product> listAllProducts() {
		return this.productRepository.findAll();
	}

	@Override
	public List<Category> listAllCategories() {
		return this.categoryRepository.findAll();
	}

	@Override
	public Product getProduct(long id) {
		Optional<Product> p = this.productRepository.findById(id);
		
		if (p.isPresent())
		{
			return p.get();
		}
		else
		{
			return null;
		}
	}

	@Override
	public Category getCategory(long id) {
		Optional<Category> c = this.categoryRepository.findById(id);
		
		if (c.isPresent())
		{
			return c.get();
		}
		else
		{
			return null;
		}
	}

	@Override
	public void deleteProduct(long id) {
		this.productRepository.deleteById(id);
	}

	@Override
	public void saveProduct(Product p) {
		this.productRepository.save(p);
	}

}
