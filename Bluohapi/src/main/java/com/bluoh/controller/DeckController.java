package com.bluoh.controller;

import com.bluoh.model.Deck;
import com.bluoh.model.DeckActivity;
import com.bluoh.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

/**
 * Created by Ashutosh on 25-09-2016.
 */
@RestController
@RequestMapping("/deck")
public class DeckController {

    private final DeckService service;

    @Autowired
    DeckController(DeckService service) {
        this.service = service;
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Deck createDeck(@RequestBody @Valid Deck deck) {
        return service.create(deck);
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Deck> getAllDeck(@RequestParam int page, @RequestParam(required = false) String category, @RequestParam
            (required = false) String tags) {
        return service.findAll(page, category, tags);
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(method = RequestMethod.GET, value = "/{deckId}")
    @ResponseStatus(HttpStatus.OK)
    public Deck GetDeck(@PathVariable("deckId") long deckId) {
        return service.findById(deckId);
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(method = RequestMethod.PUT, value = "/update/{deckId}")
    @ResponseStatus(HttpStatus.OK)
    public Deck UpdateDeck(@PathVariable("deckId") long deckId, @RequestBody @Valid Deck deck) {
        deck.setDeckId(deckId);
        return service.update(deck);
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(method = RequestMethod.DELETE, value = "/{deckId}")
    @ResponseStatus(HttpStatus.OK)
    public HashMap<String, Object> DeleteDeck(@PathVariable("deckId") long deckId) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("Deleted", service.delete(deckId + ""));
        response.put("DeckId", deckId);
        return response;
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(method = RequestMethod.PUT, value = "/update/{deck}")
    @ResponseStatus(HttpStatus.OK)
    public HashMap<String, Object> UpdateDeckActivity(@PathVariable("deck") long deckId, @RequestBody @Valid
            DeckActivity deckActivity) {
        HashMap<String, Object> response = new HashMap<>();
        deckActivity.setDeckId(deckId);
        boolean isGood = service.updateDeckActivity(deckActivity);
        if (isGood) {
            response.put("message", "Things went out well");
        } else {
            response.put("message", "We need to do more than this");
        }
        return response;
    }
}