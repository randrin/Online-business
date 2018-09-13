package com.eninse.onlinebusiness.utils;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eninse.businessbackend.dto.User;

public class UserUtils {

	public static final Logger log = LoggerFactory.getLogger(UserUtils.class);
	
	/*
	 * User
	 */
	public static String calculUserCodePromo(User user) {
		
		log.info("init calcul code promo user "+user.getFirstName()+ " " +user.getLastName());
		
		String codPromo = "";
		
		codPromo = user.getFirstName().substring(0, 3).toUpperCase()
				+ user.getDateOfBorn().toString().substring(2, 4)
				+ generateThreeRandomCharacter()
				+ user.getDateOfBorn().toString().substring(8);
		return codPromo;
		
	}

	private static String generateThreeRandomCharacter() {
		
		String chars = "ABCDEFGHIJKLMNOPGRSTXWYZ";
		Random rnd = new Random();
		
		String str = "";
		
		for (int i = 0; i < 3; i++) {
			char c = chars.charAt(rnd.nextInt(chars.length()));
			str += c;
		}
		return str;
	}
}
