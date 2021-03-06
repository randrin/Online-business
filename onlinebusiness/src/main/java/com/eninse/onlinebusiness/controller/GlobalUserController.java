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
import com.eninse.businessbackend.dto.Address;
import com.eninse.businessbackend.dto.User;
import com.eninse.onlinebusiness.model.ProfileUserModel;
import com.eninse.onlinebusiness.utils.InitialUserUtils;

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
				profileUserModel.setDateOfBorn(user.getDateOfBorn());
				profileUserModel.setRole(user.getRole());
				profileUserModel.setGender(user.getGender());
				profileUserModel.setContactNumber(user.getContactNumber());
				profileUserModel.setFullName(user.getFirstName()+ " " +user.getLastName().toUpperCase());
				profileUserModel.setUserInitial(InitialUserUtils.calculTwoInitialUser(user.getFirstName(), user.getLastName()));
				profileUserModel.setLogged(true);
				
				//Set cart only for user
				if (user.getRole().equalsIgnoreCase("USER")) {
					profileUserModel.setCart(user.getCart());
				}
				
				//Address
				Address address = userDAO.getBillingAddress(user);
				profileUserModel.setAddressLineOne(address.getAddressLineOne());
				profileUserModel.setAddressLineTwo(address.getAddressLineTwo());
				profileUserModel.setCity(address.getCity());
				profileUserModel.setCountry(address.getCountry());
				profileUserModel.setState(address.getState());
				profileUserModel.setPostalCode(address.getPostalCode());
				
				session.setAttribute("profileUserModel", profileUserModel);
			}
		} 
		return (ProfileUserModel) session.getAttribute("profileUserModel");
	}
}
