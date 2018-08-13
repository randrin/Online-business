package com.eninse.onlinebusiness.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.eninse.businessbackend.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Product p = (Product) target;
		
		if (p.getFile() == null || p.getFile().getOriginalFilename().equals("")){
			errors.rejectValue("file", null, "Please select an image file to upload");
			return;
		}

		if(!(p.getFile().getContentType().equals("image/jpeg") ||
				p.getFile().getContentType().equals("image/png") ||
				p.getFile().getContentType().equals("image/gif"))){
			errors.rejectValue("file", null, "Please use only image file to upload");
			return;
		}
	}

}
