package com.bluoh.controller;

import com.bluoh.model.Media;
import com.bluoh.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
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
	public List<Media> addImage(@RequestParam("file") MultipartFile[] submissions, @RequestParam("source") @NotNull String source) {

		List<Media> response = service.upload(submissions,source);

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