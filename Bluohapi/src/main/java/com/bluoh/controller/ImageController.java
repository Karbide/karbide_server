package com.bluoh.controller;

import com.bluoh.model.Media;
import com.bluoh.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@Controller
@RequestMapping("/image")
public class ImageController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ImageController.class);

    private final ImageService service;

	@Autowired
    public ImageController(ImageService service) {
        this.service = service;
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Object> addImage(@RequestParam("file") @NotNull MultipartFile[] submissions, @RequestParam("source") @NotNull String source) {

        LOGGER.info("File --" + submissions.length + ", " + Arrays.toString(submissions) + " , source --" + source);
        List<Media> ponse = service.upload(submissions,source);
        Map<String, Object> response = new LinkedHashMap<>();
        if(ponse != null){
            response.put("message", "files successfully uploaded!");
            response.put("content", ponse);
            LOGGER.info("files successfully uploaded");
        }else{
            response.put("message", "error uploading files");
            LOGGER.info("error uploading files");
        }
		return response;
	}

    @Secured({"ROLE_USER"})
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Map<String, Object> updateImage(@RequestParam("file") @NotNull MultipartFile submissions, @RequestParam("url") @NotNull String filename) {

		String ponse = service.update(submissions, filename);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", ponse);
		return response;
	}
}