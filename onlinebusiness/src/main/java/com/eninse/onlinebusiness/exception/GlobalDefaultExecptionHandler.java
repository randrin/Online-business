package com.eninse.onlinebusiness.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExecptionHandler {

	/*
	 * Exception trying to access in the wrong Url
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandleFoundException(){
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Page not available");
		
		mv.addObject("errorDescription", "The page you are looking for doesn't exist or it is under construction.");
		
		mv.addObject("tittle", "Error 404");
		return mv;
	}
	
	/*
	 * Exception trying to find product not present in the list Products
	 */
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleProductFoundException(){
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Product not available");
		
		mv.addObject("errorDescription", "The product you are looking for doesn't present in this moment. Try again later");
		
		mv.addObject("tittle", "Product not found");
		return mv;
	}
}
