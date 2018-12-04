package com.example.fileUpload.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.fileUpload.beans.Beans;
import com.example.fileUpload.dao.Dao;

@Service
public class Services {

	@Autowired
	Dao dao;
	
	Beans beans = new Beans();
	
	public Beans fileUpload(MultipartFile file) throws IOException {
			byte[] filearray = file.getBytes();
			beans.setFile(filearray);
			Beans bean = dao.save(beans);
			return bean;		
	}

}
