package com.eninse.onlinebusiness.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.eninse.businessbackend.dao.UserDAO;
import com.eninse.businessbackend.dto.User;
import com.eninse.onlinebusiness.model.ProfileUserModel;

@ControllerAdvice
public class GlobalUserController {

	private Logger log = LoggerFactory.getLogger(GlobalUserController.class);
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	private ProfileUserModel profileUserModel = null;
	
	@ModelAttribute("profileUserModel")
	public ProfileUserModel getUserModel() {
		
		//Check if the user is logged
		if (session.getAttribute("profileUserModel") == null){
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			log.info("authentication.getName() - "+authentication.getName());
			
			User user = userDAO.getByEmail(authentication.getName());
			
			if (user != null) {
				profileUserModel = new ProfileUserModel();
				profileUserModel.setEmail(user.getEmail());
				profileUserModel.setId(user.getId());
				profileUserModel.setRole(user.getRole());
				profileUserModel.setGender(user.getGender());
				profileUserModel.setFullName(user.getFirstName()+ " " +user.getLastName().toUpperCase());
				profileUserModel.setLogged(true);
				
				//Set cart only for user
				if (user.getRole().equalsIgnoreCase("USER")) {
					profileUserModel.setCart(user.getCart());
				}
				session.setAttribute("profileUserModel", profileUserModel);
			}
		} 
		return (ProfileUserModel) session.getAttribute("profileUserModel");
	}
}
