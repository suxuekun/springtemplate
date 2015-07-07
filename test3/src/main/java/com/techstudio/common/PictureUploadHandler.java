package com.techstudio.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.techstudio.util.ConnConfig;

@Component
public class PictureUploadHandler {
	
	private static final Logger log = Logger.getLogger(PictureUploadHandler.class);

	public String getIMGUrlWithUpload(MultipartFile[] files, HttpServletRequest request) {

		log.debug("getIMGUrl() entry");
		
		String rootPath = ConnConfig.getImageUploadDir();
		log.debug("ConnConfig.getUploadRoot():" + ConnConfig.getUploadRoot());

		String message = "";

		log.debug("files.length:" + files.length);
		log.debug("files.length:" + files[0].getOriginalFilename());

		
		
		if (files[0].getOriginalFilename().equals(""))
			return "null";

		
		for (int i = 0; i < files.length; i++) {
			
			MultipartFile file = files[i];

			try {
				byte[] bytes = file.getBytes();
				
				

				// Creating the directory to store file
				// String rootPath = System.getProperty("catalina.home");

				log.debug("rootPath:" + rootPath);

				File dir = new File(rootPath);
				if (!dir.exists())
					dir.mkdirs();
				
				String filename = file.getOriginalFilename();
				
				log.debug("filename:" + filename);
				
				
				
				File picFile = new File(dir.getAbsolutePath() + File.separator + filename);
				
				while (picFile.exists())
				{
					
					String[] fileSplit = filename.split("\\.(?=[^\\.]+$)");
					filename = fileSplit[0] + "_new."+ fileSplit[1];
					picFile = new File(dir.getAbsolutePath() + File.separator + filename);
				}
				
				if (filename.length()>18) {
					
					String[] fileSplit = filename.split("\\.(?=[^\\.]+$)");
					filename = fileSplit[0].substring(2,9) + "_new."+ fileSplit[1];
					
				}
				
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + filename);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				log.debug("Server File Location=" + serverFile.getAbsolutePath());

				message = message + "You successfully uploaded file=" + file.getOriginalFilename() + "<br />";
				return filename;

			} catch (Exception e) {
				
				log.debug(e,e);
				log.debug("failed to upload " + file.getOriginalFilename() + " => " + e.getMessage());

			}

		}
		return null;
	}

}
