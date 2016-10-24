package com.bluoh.controller;

import com.bluoh.model.Card;
import com.bluoh.service.CardService;
import com.bluoh.utils.CardNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cardServe")
public class CardServeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CardServeController.class);

	private final CardService service;

	@Autowired
    CardServeController(CardService service){
		this.service = service;
	}

	@Secured({"ROLE_ADMIN" , "ROLE_USER"})
	@RequestMapping(method = RequestMethod.GET)
	public Map<String,Object> getCardPageWise(@RequestParam("cardIndex") long cardIndex){
		List<Card> cards = service.findAfterIndex(cardIndex);
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("totalCards", cards.size());
		response.put("cards", cards);
		return response;
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