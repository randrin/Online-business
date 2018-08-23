package com.eninse.onlinebusiness.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eninse.businessbackend.dao.CategoryDAO;
import com.eninse.businessbackend.dao.ProductDAO;
import com.eninse.businessbackend.dto.Category;
import com.eninse.businessbackend.dto.Product;
import com.eninse.onlinebusiness.exception.ProductNotFoundException;

@Controller
public class PageController {

	private static final Logger log =  LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categorydao;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		log.debug("Init root controller ...");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("categorydao", categorydao.listCategory());
		mv.addObject("tittle", "Home");
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("tittle", "About Us");
		mv.addObject("categorydao", categorydao.listCategory());
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	/*
	 * Method to load products
	 */
	@RequestMapping(value = "/services")
	public ModelAndView services() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("tittle", "Services");
		mv.addObject("categorydao", categorydao.listCategory());
		mv.addObject("userClickServices", true);
		return mv;
	}
	
	@RequestMapping(value = "show/category/{id}/products")
	public ModelAndView categoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		//Fetch a single category
		Category catgegory = null;
		catgegory = categorydao.get(id);
		
		mv.addObject("tittle", catgegory.getName());
		mv.addObject("categorydao", categorydao.listCategory());
		mv.addObject("category", catgegory);
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	/*
	 * Rest Controller Single Product
	 */
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct (@PathVariable("id") int id) throws ProductNotFoundException {
		
		ModelAndView mv = new ModelAndView("page");
		
		//Update views product
		Product product = productDAO.get(id);
		
		if (product == null) throw new ProductNotFoundException();
		
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		mv.addObject("tittle", product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true);
		return mv;
	}
	
	@RequestMapping(value = "show/all/products")
	public ModelAndView listProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("tittle", "List of Products");
		mv.addObject("categorydao", categorydao.listCategory());
		mv.addObject("userClickListProducts", true);
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("tittle", "Contact Us");
		mv.addObject("categorydao", categorydao.listCategory());
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="test", required=false)String test) {
		ModelAndView mv = new ModelAndView("page");
		if (test == null) {
			test = "Hello user";
		}
		mv.addObject("greeting", test);
		return mv;
	}
	
	@RequestMapping(value="/test/{test}")
	public ModelAndView testPath(@PathVariable("test")String test) {
		ModelAndView mv = new ModelAndView("page");
		if (test == null) {
			test = "Hello user";
		}
		mv.addObject("greeting", test);
		return mv;
	}
	
	/*
	 * Login redirect
	 */
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(name="error", required = false)String error,
			@RequestParam(name="logout", required = false)String logout) {
		ModelAndView mv = new ModelAndView("login");
		
		if (error != null){
			mv.addObject("message", "Invalid username and/or password");
			log.info("Mesage error found ....");
		}
		
		if (logout != null){
			mv.addObject("logout", "You are successfully logout.");
		}
		
		mv.addObject("tittle", "Login");
		return mv;
	}
	
	/*
	 * Access Denied
	 */
	@RequestMapping(value="/deniedAccess")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("tittle", "Access Denied");
		mv.addObject("errorTittle", "Access Denied");
		mv.addObject("errorDescription", "You do not have the authorization to view this page. Please, Contact your administration");
		mv.addObject("errorCode", "403 Error");
		mv.addObject("error403ToShow", true);
		
		return mv;
	}
	
	/*
	 * Access Denied
	 */
	@RequestMapping(value="/logoutToAll")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication != null){
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/login?logout";
	}
}
