package com.eninse.onlinebusiness.handler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.eninse.businessbackend.constants.UtilsConstants;
import com.eninse.businessbackend.dao.UserDAO;
import com.eninse.businessbackend.dto.Address;
import com.eninse.businessbackend.dto.Cart;
import com.eninse.businessbackend.dto.User;
import com.eninse.onlinebusiness.constants.TextMessagesConstants;
import com.eninse.onlinebusiness.model.RegisterUserModel;
import com.eninse.onlinebusiness.utils.UserUtils;

@Component
public class RegisterUserHandler {

	public static final Logger log = LoggerFactory.getLogger(RegisterUserHandler.class);
	
	private static Pattern pattern = Pattern.compile(UtilsConstants.EMAIL_REGEX, Pattern.CASE_INSENSITIVE);

	private Matcher matcher;

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	public RegisterUserModel init () {
		return new RegisterUserModel();
	}
	
	public void registerUser (RegisterUserModel registerUserModel, User user){
		registerUserModel.setUser(user);
	}
	
	public void registerAddress (RegisterUserModel registerUserModel, Address address){
		registerUserModel.setBilling(address);
	}
	
	public String saveUserAndAddress (RegisterUserModel registerUserModel){
		String transition = "successPage";
		
		//fetch the user and create the cart to the user
		User user = registerUserModel.getUser();
		
		if (user.getRole().equals("USER")){
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		//Encode the user password
		user.setPassword(pwdEncoder.encode(user.getPassword()));
		
		//Save the user in db
		user.setCodPromo(UserUtils.calculUserCodePromo(user));
		userDAO.addUser(user);
		
		//Fetch the user address
		Address address = registerUserModel.getBilling();
		address.setUser(user);
		address.setBilling(true);
		
		//Save the user in db
		userDAO.addAddress(address);
		
		return transition;
	}
	
	public String validationUser (User user, MessageContext messageContext) {
		
		log.info("Format date user: " +user.getDateOfBorn());
		
		String operation = "success";
		
		//Verify correct match password and confirm password
		if (!(user.getPassword().equals(user.getConfirmPassword()))){
			messageContext.addMessage(
						new MessageBuilder()
						.error()
						.source("confirmPassword")
						.defaultText(TextMessagesConstants.TEXT_NOT_MATCH_PASSWORD)
						.build()
					);
			operation = "failure";
		}
		
		//Verify correct format email address
		if (!correctFormatEmail(user.getEmail())){
			messageContext.addMessage(
						new MessageBuilder()
						.error()
						.source("email")
						.defaultText(TextMessagesConstants.TEXT_NOT_MATCH_EMAIL_FORMAT)
						.build()
					);
			operation = "failure";
		}
		
		//Verify correct user email already present in db
		if (userDAO.getByEmail(user.getEmail()) != null){
			messageContext.addMessage(
					new MessageBuilder()
					.error()
					.source("email")
					.defaultText(TextMessagesConstants.TEXT_ALREADY_PRESENT_EMAIL)
					.build()
				);
			operation = "failure";
		}
		
		// Verify correct user email already present in db
		if (userDAO.getByFirstAndLastName(user.getFirstName(), user.getLastName()) != null) {
			messageContext.addMessage(new MessageBuilder()
					.error()
					.source("firstName")
					.source("lastName")
					.defaultText(TextMessagesConstants.TEXT_ALREADY_PRESENT_FIRST_AND_LAST_NAME)
					.build()
				);
			operation = "failure";
		}
		
		return operation;
	}
	
	public boolean correctFormatEmail(String email) {
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
