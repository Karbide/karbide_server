package com.bluoh.service.impl;

import com.bluoh.model.Bookmarks;
import com.bluoh.model.Deck;
import com.bluoh.repository.BookmarksRepository;
import com.bluoh.service.BookmarksService;
import com.bluoh.service.DeckService;
import com.bluoh.utils.CardNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
final class BookmarksServiceImpl implements BookmarksService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookmarksServiceImpl.class);

	private final BookmarksRepository repository;

	@Autowired
	private MongoOperations mongoOperation;

	@Autowired
	private DeckService deckService;

	@Autowired
    BookmarksServiceImpl(BookmarksRepository repository) {
		this.repository = repository;
	}

	@Deprecated
	@Override
	public Bookmarks create(Bookmarks bookmarks) {
		LOGGER.info("Creating a new bookmarks entry with information: {}", bookmarks);

		Bookmarks persisted = repository.save(bookmarks);
		LOGGER.info("Created a new bookmarks entry with information: {}", persisted);

		return persisted;
	}

	@Override
	public Bookmarks delete(String id) {
		LOGGER.info("Deleting a bookmarks entry with id: {}", id);

		Bookmarks deleted = findBookmarksById(id);
		repository.delete(deleted);

		LOGGER.info("Deleted bookmarks entry with information: {}", deleted);

		return deleted;
	}

	@Override
	public List<Bookmarks> delete(String deckId, String cardId) {
		List<Bookmarks> bookmarks;
		LOGGER.info("Deleting a bookmarks entry with deckId: "+ deckId+", cardId: "+ cardId);
		if(cardId.equals("0")){
			bookmarks = mongoOperation.findAllAndRemove(Query.query(Criteria.where("deckId").is(Long.parseLong(deckId))),Bookmarks.class);
			return bookmarks;
		}
		bookmarks = mongoOperation.findAllAndRemove(Query.query(Criteria.where("deckId").is(Long.parseLong(deckId)).and("cardId").is(cardId)),Bookmarks.class);
		return bookmarks;
	}

	/*public List<Bookmarks> findAll() {
		LOGGER.info("Finding all bookmarks entries.");
		List<Bookmarks> cardEntries = repository.findAll();
		LOGGER.info("Found {} bookmarks entries", cardEntries.size());
		return cardEntries;
	}*/

	public Page<Deck> findAll(int page) {
        Bookmarks bookmarks = new Bookmarks();
		LOGGER.info("Finding all bookmarks entries.");
		List<Bookmarks> cardEntries = mongoOperation.find(Query.query(Criteria.where("userId").in(bookmarks.getUserId())),Bookmarks.class);
		LOGGER.info("Found {} bookmarks entries", cardEntries.size());
		Set<Long> deckIds = cardEntries.stream().map(Bookmarks::getDeckId).collect(Collectors.toSet());
		return deckService.findAll(deckIds.toArray(new Long[deckIds.size()]),page);
	}

	@Override
	public Bookmarks findById(String id) {
		LOGGER.info("Finding bookmarks entry with id: {}", id);

		Bookmarks found = findBookmarksById(id);

		LOGGER.info("Found bookmarks entry: {}", found);

		return found;
	}

	@Override
	public Bookmarks update(Bookmarks bookmarks) {
		LOGGER.info("Updating card entry with information: {}", bookmarks);

		Bookmarks original = findById(bookmarks.getId());
		if(original == null){
			throw new CardNotFoundException(bookmarks.getId());
		}
		copyNonNullProperties(bookmarks,original);
		Bookmarks updated = repository.save(original);

		LOGGER.info("Updated card entry with information: {}", updated);
		return updated;
	}

	private Bookmarks findBookmarksById(String id) {
		Bookmarks result = repository.findOne(id);
		return result;
	}

	/*private boolean CheckTags(Card card){
		boolean bIsValid = false;
		Tags tags = card.getTags();
		tagrepo.find(tags);
		return true;
	}*/

	private void copyNonNullProperties(Object src, Object target){
		BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
	}

	private String[] getNullPropertyNames (Object source) {
	    final BeanWrapper src = new BeanWrapperImpl(source);
	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

	    Set<String> emptyNames = new HashSet<String>();
	    for(java.beans.PropertyDescriptor pd : pds) {
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) emptyNames.add(pd.getName());
	    }
	    String[] result = new String[emptyNames.size()];
	    return emptyNames.toArray(result);
	}

	private Pageable createPageRequest() {
		return new PageRequest(0, 10);
	}
}