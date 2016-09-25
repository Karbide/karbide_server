package com.bluoh.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
	
	List<String> upload(MultipartFile[] file);
	
	String upload(MultipartFile file, String path);
}
