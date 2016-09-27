package com.bluoh.service;

import com.bluoh.model.Media;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
	
	List<Media> upload(MultipartFile[] file, String source);
	
	String upload(MultipartFile file, String path);
}
