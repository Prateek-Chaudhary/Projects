package com.retail.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	/* With this handler of main controller login page is shown where credentials are entered for entering in the
	 * home page . This handler is called by the spring boot by default when project's server is started and run.
	 */
	
	@RequestMapping("/")
	public String getLogin() {
		return "view-pages/login";
	}
	
	/*
	 * This handler will check the credentials are correct or not given from the login page if correct
	 * redirected to home page, else login page is returned with unmatched credential message.   
	 */
	
	@RequestMapping("validation")
	public String getValidate(HttpSession session,String username,String password,Model model) {
		if(username.equals("myretailshop") && password.equals("shopnow")) {
			session.setAttribute("name", "Prateek Chaudhary");
			return "redirect:home";
		}
		model.addAttribute("msg", "Id  Password is invalid !");
		return "view-pages/login";
	}
	
	/*
	 * This handler is used for showing the home page
	 */
	
	@RequestMapping("home")
	public String getHome() {
		return "view-pages/home";
	}
	
	/*
	 * it is used to logout from the web application's dashboard to login page
	 */
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
