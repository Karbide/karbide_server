package com.bluoh.controller;

import com.bluoh.BluohApiApplication;
import com.bluoh.model.Deck;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

/**
 * Created by Ashutosh on 18-12-2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BluohApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DeckControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void testGetAllDeck() throws Exception {
        ResponseEntity<RestResponsePage> responseEntity =
                restTemplate.getForEntity("/deck?page=0", RestResponsePage.class);
        RestResponsePage<Deck> client = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, client.getTotalPages());
    }
}