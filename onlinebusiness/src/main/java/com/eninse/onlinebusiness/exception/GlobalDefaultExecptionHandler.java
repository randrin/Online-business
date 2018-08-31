package com.eninse.onlinebusiness.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.eninse.onlinebusiness.constants.DeniedMessagesConstants;

@ControllerAdvice
public class GlobalDefaultExecptionHandler {

	/*
	 * Exception trying to access in the wrong Url
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandleFoundException(){
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("tittle", "Error 404");
		mv.addObject("errorTittle", DeniedMessagesConstants.DENIED_ACCESS_URL);
		mv.addObject("errorDescription", DeniedMessagesConstants.DENIED_404_CODE);
		mv.addObject("errorCode", DeniedMessagesConstants.DENIED_404_CODE);
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
		mv.addObject("errorTittle", DeniedMessagesConstants.DENIED_ACCESS_PRODUCT);
		mv.addObject("errorDescription", DeniedMessagesConstants.DENIED_ACCESS_PRODUCT_DESCRIPTION);
		mv.addObject("errorCode", DeniedMessagesConstants.DENIED_404_CODE);
		mv.addObject("error404ToShow", true);
		
		return mv;
	}
}
