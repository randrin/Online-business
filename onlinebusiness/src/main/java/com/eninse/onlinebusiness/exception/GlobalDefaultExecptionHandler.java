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
		
		mv.addObject("tittle", "Error 404");
		mv.addObject("errorTittle", "Wrong Url");
		mv.addObject("errorDescription", "The page you are looking for doesn't exist or it is under construction.");
		mv.addObject("errorCode", "404 Error");
		mv.addObject("error404ToShow", true);

		return mv;
	}
	
	
	/*
	 * Exception trying to find product not present in the list Products
	 */
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleProductFoundException(){
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("tittle", "Product not found");
		mv.addObject("errorTittle", "Product not found");
		mv.addObject("errorDescription", "The product you are looking for doesn't present in this moment. Try again later");
		mv.addObject("errorCode", "404 Error");
		mv.addObject("error404ToShow", true);
		
		return mv;
	}
}
