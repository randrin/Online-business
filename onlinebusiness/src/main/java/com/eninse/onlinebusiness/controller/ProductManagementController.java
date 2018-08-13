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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	public static final Logger logger = LoggerFactory.getLogger(ProductManagementController.class);
	
	ProductValidator productValidator = new ProductValidator();
		
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
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
		
		//Validation File content
		productValidator.validate(pdt, results);
		
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
		
		logger.info(pdt.toString());
		productDAO.add(pdt);
		return "redirect:/manage/products?operation=product";
	}
}
