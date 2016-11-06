package com.bluoh.controller;

import com.bluoh.model.Bookmarks;
import com.bluoh.service.BookmarksService;
import com.bluoh.utils.CardNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bookmarks")
public class BookmarksController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookmarksController.class);

	private final BookmarksService service;

	@Autowired
    BookmarksController(BookmarksService service){
		this.service = service;
	}

	@Secured({"ROLE_USER"})
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public List<Bookmarks> createBookmarks(@RequestBody @Valid List<Bookmarks> bookmarks) {
		List<Bookmarks> created = new ArrayList<Bookmarks>();
		for(Bookmarks bookmark : bookmarks) {
			created.add(service.create(bookmark));
		}
		return created;
	}

	@Secured({"ROLE_USER"})
	@RequestMapping(method = RequestMethod.GET)
	public List<Bookmarks> getBookmarksDetails() {
		return service.findAll();
	}

	@Secured({"ROLE_USER"})
	@RequestMapping(method = RequestMethod.PUT, value = "/{bookmarksId}")
	public Bookmarks editBook(@PathVariable("bookmarksId") String bookmarksId, @RequestBody @Valid Bookmarks bookmarks) {
		bookmarks.setId(bookmarksId);
		Bookmarks updated =  service.update(bookmarks);
		return updated;
	}

	@Secured({"ROLE_USER"})
	@RequestMapping(method = RequestMethod.DELETE, value = "/{bookmarksId}")
	public Bookmarks deleteBook(@PathVariable("bookmarksId") String bookmarksId) {
		Bookmarks deleted = service.delete(bookmarksId);
		return deleted;
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
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", ex.getMessage());
        return response;
    }
}