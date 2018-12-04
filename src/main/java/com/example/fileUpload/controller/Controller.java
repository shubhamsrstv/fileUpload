package com.example.fileUpload.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.fileUpload.beans.Response;
import com.example.fileUpload.services.Services;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	Services services;
	
	Response response = new Response();
	
	@RequestMapping(method = RequestMethod.POST, value="/fileupload")
	@ResponseBody
	private Response createAccount(@RequestParam(required=false) MultipartFile file) throws IOException {
		System.out.println("Controller begins");
		if(file!=null) {
			if(services.fileUpload(file) != null);
			response.setResponseCode(0);
			response.setResponseMessage(file.getOriginalFilename()+" uploaded succesfully");
			return response;
		}
	else {
		System.out.println("File is empty");
		response.setResponseCode(1);
		response.setResponseMessage("File is empty");
		return response;
	}
	}
}
