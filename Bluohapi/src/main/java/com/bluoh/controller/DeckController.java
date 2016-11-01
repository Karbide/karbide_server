package com.bluoh.controller;

import com.bluoh.model.Deck;
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
    DeckController(DeckService service){
        this.service = service;
    }

    @Secured({ "ROLE_ADMIN" , "ROLE_USER" })
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Deck createDeck(@RequestBody @Valid Deck deck){
        Deck created = service.create(deck);
        return created;
    }

    @Secured({ "ROLE_USER" })
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Page<Deck> getAllDeck(@RequestParam int page){
        HashMap<String, Object> response = new HashMap<String, Object>();
        Page<Deck> decks = service.findAll(page);
        return decks;
    }

    @Secured({"ROLE_USER"})
    @RequestMapping(method = RequestMethod.GET, value = "/{deckId}")
    @ResponseStatus(HttpStatus.OK)
    public Deck GetDeck(@PathVariable("deckId") long deckId){
        Deck response = service.findById(deckId);
        return response;
    }

}
