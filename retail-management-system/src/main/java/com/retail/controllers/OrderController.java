package com.retail.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.retail.models.CustomerDetails;
import com.retail.models.CustomerOrder;
import com.retail.models.OrderReport;
import com.retail.models.Product;
import com.retail.services.OrderService;
import com.retail.services.ProductService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService oservice;
	@Autowired
	private ProductService pservice;
	@Autowired
	private HttpSession ses;
	
	/*
	 * this handler returns the customerinfo page where customer details are entered for further process
	 */
	
	@RequestMapping("order")
	public String getCustomer() {
		return "view-pages/customerinfo";
	}
	
	/*
	 * it saves the info of the customer into the database and redirect to the add order page where
	 * we add the multiple products which are buyed by the customer and then bill is generated.
	 */
	
	@RequestMapping("save-customer")
	public String saveCustomer(CustomerDetails cd) {
		ses.setAttribute("customer", cd);
		oservice.addCustomer(cd);
		return "redirect:add-order";
	}
	
	/*
	 * it shows the add order page
	 */
	
	@RequestMapping("add-order")
	public String addOrder(Model model) {
		List<Product> list = pservice.getProduct();
		model.addAttribute("product", list);
		return "view-pages/orderdetails";
	}
	
	/*
	 * it add the ordered product in the database with quantity and price and total amount
	 */
	
	@RequestMapping("order-product")
	public String order(CustomerOrder co) {
		
		//it get the price of the product from the customerOrder table where mapping is associated with the product table
		int prc = co.getProduct().getPrice();
		
		//it change the integer price value into the string 
		co.setPrice(String.valueOf(prc));
		
		//amount is calculated with the this technique
		int amount = prc*Integer.parseInt(co.getQuantity());
		
		//amount is setted by using the setter method
		co.setAmount(String.valueOf(amount));
		
		//here session is used because customer is at another page to getting the customer we use session object here
		co.setCustomer((CustomerDetails)ses.getAttribute("customer"));
		
		//is saves the all the details to the database by calling the service of the order service
		oservice.setCustomerOrder(co);
		return "redirect:add-order";
	}
	
	/*
	 * it redirect to the show-invoice handler
	 */
	
	@RequestMapping("invoice")
	public String getInvoice(OrderReport or) {
		or.setDate(LocalDate.now().toString());
		or.setCustomer((CustomerDetails)ses.getAttribute("customer"));
		oservice.addOrderReport(or);
		return "redirect:show-invoice";
	}
	
	/*
	 * it shows the list of all the orders, how many order selled till now
	 */
	
	@RequestMapping("orderreport")
	public String showOrderReport(Model model) {
		List<OrderReport> or = oservice.getOrderReport();
		model.addAttribute("order", or);
		return "view-pages/order-report";
	}
	
	/*
	 * it shows the invoice of the products which the customer buys
	 */
	
	@RequestMapping("show-invoice")
	public String showInvoice(Model model) {
		CustomerDetails cd = (CustomerDetails)ses.getAttribute("customer");
		int cid = cd.getCustomer_no();
		List<CustomerOrder> co = oservice.getCustomerOrderList(cid);
		OrderReport or = oservice.getOrderByCustomerId(cid);
		int amount = 0;
		for (CustomerOrder c_o : co) {
			amount += Integer.parseInt(c_o.getAmount());
		}
		model.addAttribute("order", or);
		model.addAttribute("co", co);
		model.addAttribute("amount", amount);
		return "view-pages/invoice";
	}
	
	/*
	 * it shows the stored invoice of order table, it shows that which customer buy which products
	 */
	
	@RequestMapping("stored-invoice")
	public String showStoredInvoice(Model model, int order_no) {
		OrderReport or = oservice.getOrder(order_no);
		int cid = or.getCustomer().getCustomer_no();
		List<CustomerOrder> co = oservice.getCustomerOrderList(cid);
		int amount = 0;
		for (CustomerOrder c_o : co) {
			amount += Integer.parseInt(c_o.getAmount());
		}
		model.addAttribute("order", or);
		model.addAttribute("co", co);
		model.addAttribute("amount", amount);
		return "view-pages/invoice";
	}
	
	/*
	 * it is used to delete the order report from the database if now not needed
	 */
	
	@RequestMapping("delete-orderreport")
	public String deleteOrderReport(int order_no) {
		oservice.deleteReport(order_no);
		return "redirect:orderreport";
	}
}
