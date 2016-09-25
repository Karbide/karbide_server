package com.bluoh.controller;

import com.bluoh.model.Card;
import com.bluoh.service.CardService;
import com.bluoh.utils.CardNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/card")
public class CardController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CardController.class);

	private final CardService service;

	@Autowired
	CardController(CardService service){
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Card createBook(@RequestBody @Valid Card card) {
		Card created = service.create(card);
		return created;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{cardId}")
	public Card getBookDetails(@PathVariable("cardId") String cardId) {
		return service.findById(cardId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{cardId}")
	public Card editBook(@PathVariable("cardId") String cardId, @RequestBody @Valid Card card) {
		card.setId(cardId);
		Card updated =  service.update(card);
		return updated;
	}

	/*@RequestMapping(method = RequestMethod.DELETE, value = "/{cardId}")
	public Card deleteBook(@PathVariable("cardId") String cardId) {
		Card deleted = service.delete(cardId);
		return deleted;
	}*/
	
	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> getAllBooks() {
		List<Card> cards = service.findAll();
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("totalBooks", cards.size());
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