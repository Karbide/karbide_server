package com.bluoh.controller;

import com.bluoh.model.Card;
import com.bluoh.model.CardServe;
import com.bluoh.service.CardService;
import com.bluoh.utils.CardNotFoundException;
import io.swagger.annotations.ApiOperation;
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

	@Secured("ROLE_USER")
	@RequestMapping(method = RequestMethod.GET, value = "/{id}/{cardIndex}")
	@ApiOperation(value = "get the card processed based on diffrent logics", notes = "{id},{cardIndex}:-First time send both values \"0\",onward send the previous response value.")
	public CardServe getCardDetails(@PathVariable String id, @PathVariable int cardIndex) {
		CardServe cardServe = new CardServe();
		cardServe.setId(id);
		cardServe.setCardIndex(cardIndex);
		//System.out.println(service.getUserCard(cardServe).getCards().get(0));
		//return null;
		return service.getUserCard(cardServe);
	}

}