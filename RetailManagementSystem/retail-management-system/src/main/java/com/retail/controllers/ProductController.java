package com.retail.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.retail.models.Product;
import com.retail.models.ProductCompany;
import com.retail.services.ProductCompanyService;
import com.retail.services.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private ProductCompanyService cservice;
	
	/*
	 * this handler will show the add product page where we can add the products, when this handler is called 
	 * a list of companies will returned from the database for selecting the companies for products.
	 */
	
	@RequestMapping("addproduct")
	public String getAddProduct(Model model) {
		List<ProductCompany> list = cservice.getCompany();
		model.addAttribute("company", list);
		return "view-pages/add-product";
	}
	
	/*
	 * it shows the list of all the products with all details which are stored in the database of our project.
	 */
	
	@RequestMapping("productreport")
	public String productReport(Model model) {
		List<Product> list = service.getProduct();
		model.addAttribute("product", list);
		return "view-pages/products-list";
	}
	
	/*
	 * it add the product in the database of this project and show the list of all products 
	 * by redirecting to that handler which shows the list of products.
	 */
	
	@RequestMapping("save-product")
	public String saveProduct(Product pr) {
		service.insertProduct(pr);
		return "redirect:productreport";
	}
	
	/*
	 * it is used to edit the info of the product if any of the info of that product is incorrect
	 */
	
	@RequestMapping("edit-product")
	public String viewProduct(Model model, int product_id) {
		Product p = service.getProduct(product_id);
		model.addAttribute("product", p);
		List<ProductCompany> list = cservice.getCompany();
		model.addAttribute("company", list);
		return "view-pages/edit-product";
	}
	
	/*
	 * it saves the edited info of the product in the database.
	 */
	
	@RequestMapping("editproduct")
	public String updateCompany(Product p) {
		service.addProduct(p);
		return "redirect:productreport";
	}
	
	/*
	 * it is used to delete the product from the database
	 */
	
	@RequestMapping("delete-product")
	public String deleteCompany(int product_id) {
		service.deleteCompany(product_id);
		return "redirect:productreport";
	}

}
