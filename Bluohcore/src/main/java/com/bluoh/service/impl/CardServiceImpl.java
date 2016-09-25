package com.bluoh.service.impl;

import com.bluoh.model.Card;
import com.bluoh.repository.CardRepository;
import com.bluoh.service.CardService;
import com.bluoh.utils.CardNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
final class CardServiceImpl implements CardService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CardServiceImpl.class);

	private final CardRepository repository;

	@Autowired
	CardServiceImpl(CardRepository repository) {
		this.repository = repository;
	}

	@Override
	public Card create(Card card) {
		LOGGER.info("Creating a new card entry with information: {}", card);
		
		Card persisted = repository.save(card);
		LOGGER.info("Created a new card entry with information: {}", persisted);

		return persisted;
	}

	@Override
	public Card delete(String id) {
		LOGGER.info("Deleting a card entry with id: {}", id);

		Card deleted = findBookById(id);
		repository.delete(deleted);

		LOGGER.info("Deleted card entry with informtation: {}", deleted);

		return deleted;
	}

	@Override
	public List<Card> findAll() {
		LOGGER.info("Finding all card entries.");

		List<Card> cardEntries = repository.findAll();

		LOGGER.info("Found {} card entries", cardEntries.size());

		return cardEntries;
	}

	@Override
	public Card findById(String id) {
		LOGGER.info("Finding card entry with id: {}", id);

		Card found = findBookById(id);

		LOGGER.info("Found card entry: {}", found);

		return found;
	}

	@Override
	public Card update(Card card) {
		LOGGER.info("Updating card entry with information: {}", card);
		
		Card original = findById(card.getId());
		if(original == null){
			throw new CardNotFoundException(card.getId());
		}
		copyNonNullProperties(card,original);
		Card updated = repository.save(original);

		LOGGER.info("Updated card entry with information: {}", updated);
		return updated;
	}

	private Card findBookById(String id) {
		Card result = repository.findOne(id);
		return result;
	}
	
	/*private boolean CheckTags(Card card){
		boolean bIsValid = false;
		Tags tags = card.getTags();
		tagrepo.find(tags);
		return true;
	}*/
	
	public void copyNonNullProperties(Object src, Object target){
		BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
	}
	
	public String[] getNullPropertyNames (Object source) {
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
}