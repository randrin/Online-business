package com.eninse.onlinebusiness.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eninse.businessbackend.dao.CategoryDAO;
import com.eninse.businessbackend.dao.ProductDAO;
import com.eninse.businessbackend.dto.Category;
import com.eninse.businessbackend.dto.Product;
import com.eninse.onlinebusiness.utils.UploadFilesUtils;
import com.eninse.onlinebusiness.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ProductManagementController {

	public static final Logger log = LoggerFactory.getLogger(ProductManagementController.class);
	
	ProductValidator productValidator = new ProductValidator();
		
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	/*
	 * START Controller ADD NEW PRODUCT
	 */
	@RequestMapping(value="/new/product", method=RequestMethod.GET)
	public ModelAndView addNewProduct(@RequestParam(name="operation", required=false) String operation){
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("tittle", "New Product");
		mv.addObject("userClickAddNewProduct", true);
		
		Product pdt = new Product();
		pdt.setActive(true);
		pdt.setSupplierId(1);
		
		mv.addObject("product", pdt);
		
		if (operation != null) {
			if(operation.equals("product")){
				mv.addObject("message", "New Product added Successfully");
				mv.addObject("isSuccess", true);
			}
		}
		return mv;
	}
	
	@RequestMapping(value="/new/product", method=RequestMethod.POST)
	public String newProductSubmission(@Valid @ModelAttribute("product") Product pdt, BindingResult results, 
			Model model, HttpServletRequest request){
		
		//Validation File content
		if (pdt.getId() == 0) {
			productValidator.validate(pdt, results);
		} else {
			if (!pdt.getFile().getOriginalFilename().equals("")){
				productValidator.validate(pdt, results);
			}
		}
		
		if (results.hasErrors()){
			model.addAttribute("tittle", "New Product");
			model.addAttribute("userClickAddNewProduct", true);
			model.addAttribute("message", "Failed to add new Product");
			model.addAttribute("isFail", true);
			
			return "page";
		}
		
		if (!pdt.getFile().getOriginalFilename().equals("")){
			UploadFilesUtils.uploadFile(request, pdt.getFile(), pdt.getCode());
		}
		
		log.info(pdt.toString());
		
		if (pdt.getId() == 0) {
			productDAO.add(pdt);		
		} else {
			productDAO.update(pdt);
		}
		return "redirect:/manage/new/product?operation=product";
	}
	
	/*
	 * START Controller MANAGEMENT PRODUCT
	 */
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showProductManage(@RequestParam(name="operation", required=false) String operation){
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("tittle", "Manage Products");
		mv.addObject("userClickManageProducts", true);
		
		Product pdt = new Product();
		pdt.setActive(true);
		pdt.setSupplierId(1);
		
		mv.addObject("product", pdt);
		
		if (operation != null) {
			if(operation.equals("product")){
				mv.addObject("message", "New Product added Successfully");
				mv.addObject("isSuccess", true);
			}
		}
		return mv;
	}
	
	@ModelAttribute("categories")
	public List<Category> listCategoryAvailable(){
		return categoryDAO.listCategory();
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String productSubmission(@Valid @ModelAttribute("product") Product pdt, BindingResult results, 
			Model model, HttpServletRequest request){
		
		log.info("Product to validate: " +pdt.toString());
	
		//Validation File content
		if (pdt.getId() == 0) {
			productValidator.validate(pdt, results);
		} else {
			if (!pdt.getFile().getOriginalFilename().equals("")){
				productValidator.validate(pdt, results);
			}
		}
		
		if (results.hasErrors()){
			model.addAttribute("tittle", "Manage Products");
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("message", "Failed to add new Product");
			model.addAttribute("isFail", true);
			
			return "page";
		}
		
		if (!pdt.getFile().getOriginalFilename().equals("")){
			UploadFilesUtils.uploadFile(request, pdt.getFile(), pdt.getCode());
		}
		
		log.info("File to upload: " +pdt.toString());
		
		if (pdt.getId() == 0) {
			productDAO.add(pdt);		
		} else {
			productDAO.update(pdt);
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value="/product/{id}/action", method=RequestMethod.POST)
	@ResponseBody
	public String adminActivationAndDeactivationProduct(@PathVariable int id){
		
		//get the spedific Product with id
		Product product = productDAO.get(id);
		
		//update Product to false
		product.setActive(!product.isActive());
		productDAO.update(product);
		
		return (!product.isActive()) 
				? "The product with id "+product.getId()+" is successfully deactivated" 
				: "The product with id "+product.getId()+" is successfully activated";
	}
	
	@RequestMapping(value="/{id}/product", method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id){
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("tittle", "Edit Product");
		mv.addObject("userClickEditProduct", true);
		
		//Retrieve the speficif product in the database
		Product pdt = productDAO.get(id);
		mv.addObject("product", pdt);
		
		log.info("Product to edit: " +pdt.toString());
		return mv;
	} 
}
