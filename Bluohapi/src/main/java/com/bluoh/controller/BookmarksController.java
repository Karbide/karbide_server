package com.bluoh.controller;

import com.bluoh.model.Bookmarks;
import com.bluoh.model.Deck;
import com.bluoh.service.BookmarksService;
import com.bluoh.utils.CardNotFoundException;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookmarks")
public class BookmarksController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookmarksController.class);

	private final BookmarksService service;
	private String deckId;

	@Autowired
    BookmarksController(BookmarksService service){
		this.service = service;
	}

	@Secured({"ROLE_USER"})
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Insert Bookmarks", notes = "Sample Request : [\n" +
			"  {\n" +
			"    \"cardId\": \"string\",\n" +
			"    \"deckId\": 12,\n" +
			"  }\n" +
			"]")
	public List<Bookmarks> createBookmarks(@RequestBody @Valid List<Bookmarks> bookmarks) {
		return bookmarks.stream().map(service::create).collect(Collectors.toList());
	}

	@Secured({"ROLE_USER"})
	@RequestMapping(method = RequestMethod.GET)
	public Page<Deck> getBookmarksDetails(@RequestParam int page) {
		return service.findAll(page);
	}

//	@Secured({"ROLE_USER"})
//	@RequestMapping(method = RequestMethod.PUT, value = "/{bookmarksId}")
//	@ApiOperation(value = "Update Bookmarks", notes = "This is deprecated please refrain from using this")
//	public Bookmarks editBook(@PathVariable("bookmarksId") String bookmarksId, @RequestBody @Valid Bookmarks bookmarks) {
//		bookmarks.setId(bookmarksId);
//		Bookmarks updated =  service.update(bookmarks);
//		return updated;
//	}
//
//	@Secured({"ROLE_USER"})
//	@RequestMapping(method = RequestMethod.DELETE, value = "/{bookmarksId}")
//	public Bookmarks deleteBook(@PathVariable("bookmarksId") String bookmarksId) {
//		Bookmarks deleted = service.delete(bookmarksId);
//		return deleted;
//	}

	@Secured({"ROLE_USER"})
	@RequestMapping(method = RequestMethod.DELETE, value = "/{deckId}/{cardId}")
	@ApiOperation(value = "Delete Bookmarks", notes = "cardId with value 0 will result in deletion of each bookmark related to that particular deck")
	public List<Bookmarks> deleteBookMarks(@PathVariable("deckId") String deckId,@PathVariable("cardId") String cardId) {
		return service.delete(deckId, cardId);
	}

//	@Secured("ROLE_ADMIN")
//	@RequestMapping(method = RequestMethod.GET)
//	public Map<String, Object> getAllBookmarkss() {
//		List<Bookmarks> bookmarkss = service.findAll();
//		Map<String, Object> response = new LinkedHashMap<String, Object>();
//		response.put("totalBookmarkss", bookmarkss.size());
//		response.put("bookmarkss", bookmarkss);
//		return response;
//	}
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handleBookmarksNotFound(CardNotFoundException ex) {
        LOGGER.error("Handling error with message: {}", ex.getMessage());
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("message", ex.getMessage());
        return response;
    }
}