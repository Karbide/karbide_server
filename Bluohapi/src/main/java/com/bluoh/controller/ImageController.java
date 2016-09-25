package com.bluoh.controller;

import com.bluoh.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/image")
public class ImageController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ImageController.class);

	@Autowired
	private ImageService service;

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Map<String, Object> addImage(@RequestParam("file") MultipartFile[] submissions) {

		List<String> paths = service.upload(submissions);

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("message", "successfully uploaded");
		for (int i = 0; i < paths.size(); i++) {
			String path = paths.get(i);
			response.put("url" + i, path);
		}
		LOGGER.info("files uploaded");
		return response;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Map<String, Object> updateImage(@RequestParam("file") MultipartFile submissions, @RequestParam("url") String filename) {

		String ponse = service.upload(submissions, filename);
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("message", ponse);
		LOGGER.info("files updated");
		return response;
	}
}