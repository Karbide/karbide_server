package com.bluoh.controller;

import com.bluoh.model.Deck;
import com.bluoh.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Deck createDeck(@RequestBody @Valid Deck deck){
        Deck created = service.create(deck);
        return created;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{deckId}")
    @ResponseStatus(HttpStatus.FOUND)
    public Deck GetDeck(@PathVariable("cardId") String cardId){

        return null;
    }

}
