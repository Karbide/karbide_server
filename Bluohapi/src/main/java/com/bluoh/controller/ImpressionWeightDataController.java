package com.bluoh.controller;

import com.bluoh.model.Card;
import com.bluoh.model.ImpressionWeightData;
import com.bluoh.service.CardService;
import com.bluoh.service.ImpressionWeightDataService;
import com.bluoh.utils.CardNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/impression")
public class ImpressionWeightDataController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ImpressionWeightDataController.class);

	private final ImpressionWeightDataService service;

	@Autowired
    ImpressionWeightDataController(ImpressionWeightDataService service){
		this.service = service;
	}

	@Secured({"ROLE_ADMIN" , "ROLE_USER"})
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> addCardImpression(@RequestBody ImpressionWeightData impressionWeightData){
		LOGGER.info("data:",impressionWeightData);
		service.create(impressionWeightData);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Secured("ROLE_USER")
	@RequestMapping(method = RequestMethod.GET)
	public List<ImpressionWeightData> getAllImpression() {
		List<ImpressionWeightData> impressionWeightDatas = service.findAll();
		LOGGER.info("ImpresionWeightData:"+impressionWeightDatas);
		return impressionWeightDatas;
	}

	@ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handleCardNotFound(CardNotFoundException ex) {
        LOGGER.error("Handling error with message: {}", ex.getMessage());
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", ex.getMessage());
        return response;
    }
}