package com.bluoh.service.impl;

import com.bluoh.model.Card;
import com.bluoh.model.CardServeData;
import com.bluoh.model.ImpressionWeightData;
import com.bluoh.repository.CardRepository;
import com.bluoh.repository.CardServeDataRepository;
import com.bluoh.repository.ImpressionWeightDataRepository;
import com.bluoh.service.CardService;
import com.bluoh.utils.CardNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
final class CardServiceImpl implements CardService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CardServiceImpl.class);

	private final CardRepository repository;

    @Autowired
	private final ImpressionWeightDataRepository impressionWeightDataRepository;

    @Autowired
    private final CardServeDataRepository cardServeDataRepository;

	@Autowired
	private MongoOperations mongoOperation;

	@Autowired
	CardServiceImpl(CardRepository repository, ImpressionWeightDataRepository impressionWeightDataRepository, CardServeDataRepository cardServeDataRepository) {
		this.repository = repository;
        this.impressionWeightDataRepository = impressionWeightDataRepository;
        this.cardServeDataRepository = cardServeDataRepository;
    }

	@Deprecated
	@Override
	public Card create(Card card) {
		LOGGER.info("Creating a new card entry with information: {}", card);
//		Tags tags = card.getTags();

		Card persisted = repository.save(card);
		LOGGER.info("Created a new card entry with information: {}", persisted);

		return persisted;
//		return null;
	}

	@Override
	public Card delete(String id) {
		LOGGER.info("Deleting a card entry with id: {}", id);

		Card deleted = findCardById(id);
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

	public List<Card> find(Query query) {
		LOGGER.info("Finding all card entries.");
		List<Card> cardEntries = mongoOperation.find(query,Card.class);
		LOGGER.info("Found {} card entries", cardEntries.size());
		return cardEntries;
	}

	@Override
	public Card findById(String id) {
		LOGGER.info("Finding card entry with id: {}", id);

		Card found = findCardById(id);

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

	private Card findCardById(String id) {
		Card result = repository.findOne(id);
		return result;
	}
	
	/*private boolean CheckTags(Card card){
		boolean bIsValid = false;
		Tags tags = card.getTags();
		tagrepo.find(tags);
		return true;
	}*/

	@Override
	public List<Card> findAfterIndex(CardServeData cardServeData) {
		LOGGER.info("Finding all card entries.");
        if(cardServeData.getCardIndex()==1){
            List<Card> cardEntries =  repository.findByStatusOrderByCurretWeightAscCreatedTimeDesc("Completed");
            List<ImpressionWeightData> impressionWeightDatas = impressionWeightDataRepository.findByUserIdAndCardId(cardServeData.getUserId(),cardServeData.getCardId());
            //cardEntries.removeAll(impressionWeightDatas);

            Calendar c = Calendar.getInstance();
            Date date = new Date();
            c.setTime(date);
            c.add(Calendar.DATE, -2);
            date.setTime( c.getTime().getTime() );

            for(ImpressionWeightData impressionWeightData : impressionWeightDatas){
                //remove from Ist and add at end
                List<Card> tempRemoveCard = new ArrayList<>();
                if(impressionWeightData.getImpressionDate().after(date)){
                    if(cardEntries.contains(impressionWeightData)){
                        int index = cardEntries.indexOf(impressionWeightData);
                        tempRemoveCard.add(cardEntries.get(index));
                    }
                }
                else {
                    break;
                }
                //add card at end
                cardEntries.removeAll(tempRemoveCard);
                cardEntries.addAll(tempRemoveCard);
            }

            //add mongo temp table
            cardServeData.setCardList(cardEntries);
            cardServeDataRepository.save(cardServeData);
        }

        List<Card> data = null;
        return data;


	}


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