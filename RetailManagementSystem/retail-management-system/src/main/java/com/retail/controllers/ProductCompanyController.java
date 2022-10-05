package com.retail.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.retail.models.ProductCompany;
import com.retail.services.ProductCompanyService;

@Controller
public class ProductCompanyController {
	
	@Autowired
	private ProductCompanyService service;

	/*
	 * this handler will show the add product company page where we can add the companies for our products,
	 */
	
	@RequestMapping("addproductcompany")
	public String addProductCompany() {
		return "view-pages/add-product-company";
	}
	
	/*
	 * it add the company in the database of this project and show the list of all companies 
	 * by redirecting to that handler which shows the list of companies.
	 */
	
	@RequestMapping("addcompany")
	public String addCompany(ProductCompany pc) {
		service.addCompany(pc);
		return "redirect:productcompany";
	}
	
	/*
	 * it shows the list of all the companies which are stored in the database of our project.
	 */
	
	@RequestMapping("productcompany")
	public String getProductCompanyReport(Model model) {
		List<ProductCompany> list = service.getProductCompany();
		model.addAttribute("company", list);
		return "view-pages/product-companies-list";
	}
	
	/*
	 * it is used to edit the info of the company if any of the info of that company is incorrect
	 */
	
	@RequestMapping("edit-company")
	public String viewCompany(Model model, int company_id) {
		ProductCompany pc = service.getCompany(company_id);
		model.addAttribute("company", pc);
		return "view-pages/edit-product-company";
	}
	
	/*
	 * it saves the edited info of the company in the database.
	 */
	
	@RequestMapping("editcompany")
	public String updateCompany(ProductCompany pc) {
		service.addCompany(pc);
		return "redirect:productcompany";
	}
	
	/*
	 * it is used to delete the company from the database
	 */
	
	@RequestMapping("delete-company")
	public String deleteCompany(int company_id) {
		service.deleteCompany(company_id);
		return "redirect:productcompany";
	}
}
