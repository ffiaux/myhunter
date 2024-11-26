package com.myhunter.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myhunter.products.domain.Category;
import com.myhunter.products.domain.Product;
import com.myhunter.products.service.IProductService;

@Controller
@RequestMapping("/products")
public class ProductsController 
{
	private IProductService productService;
	
	@Autowired
	public ProductsController(IProductService productService) {
		this.productService = productService;
	}
		
	@GetMapping("/all")
	public String products(Model m) 
	{
		List<Product> products = this.productService.listAllProducts();
		m.addAttribute("products", products);
		
		return "products/index";
	}
	
	@GetMapping("/create")
	public String create(Model m) 
	{
		List<Category> categories = this.productService.listAllCategories();
		m.addAttribute("categories", categories);
		
		return "products/create";
	}	
	
    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model m)
    {    
        Product p = this.productService.getProduct(Integer.toUnsignedLong(id));    
        m.addAttribute("product", p);
        
		List<Category> categories = this.productService.listAllCategories();
		m.addAttribute("categories", categories);
    	
        return "products/edit";    
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam int id)
    {    
        this.productService.deleteProduct(Integer.toUnsignedLong(id));
    	
        return "redirect:all";
    }    
    
    @PostMapping("/update")
    public String update(@ModelAttribute Product product) 
    {
    	this.productService.saveProduct(product);
    	
    	return "redirect:all";
    }   
    
    @PostMapping("/save")
    public String save(@ModelAttribute Product product, @RequestParam int category) 
    {
    	product.setCategory(this.productService.getCategory(Integer.toUnsignedLong(category)));
    	this.productService.saveProduct(product);
       
    	return "redirect:all";
    }      
}