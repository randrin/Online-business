package com.eninse.onlinebusiness.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class UploadFilesUtils {

	public static final Logger log = LoggerFactory.getLogger(UploadFilesUtils.class);
	
	private static final String ABS_PATH = "C:\\Users\\Lenovo\\git\\Online-business\\onlinebusiness\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = "";
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		
		// Get the real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		log.info("Real Path: " +REAL_PATH);
		
		//Verification path exists and make them
		if (!new File(ABS_PATH).exists()){
			new File(ABS_PATH).mkdirs();
		}
		
		if (!new File(REAL_PATH).exists()){
			new File(REAL_PATH).mkdirs();
		}
		
		try {
			//Transfert file to absolute path
			file.transferTo(new File(ABS_PATH +code+ ".png"));
			//Transfert file to real path
			file.transferTo(new File(REAL_PATH +code+ ".png"));
		} catch (IOException e){
			log.error("Error uploading file: " +e.getMessage()+ " - " +e.getCause());
		}
	}
			
			
	
}
