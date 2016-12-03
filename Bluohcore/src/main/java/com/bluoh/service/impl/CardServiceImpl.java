package com.bluoh.service.impl;

import com.bluoh.config.Config;
import com.bluoh.model.Card;
import com.bluoh.model.CardIdBean;
import com.bluoh.model.CardIdList;
import com.bluoh.model.CardServe;
import com.bluoh.repository.CardIdListRepository;
import com.bluoh.repository.CardRepository;
import com.bluoh.repository.CardServeRepository;
import com.bluoh.service.CardService;
import com.bluoh.utils.CardNotFoundException;
import com.bluoh.utils.Util;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
final class CardServiceImpl implements CardService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CardServiceImpl.class);

	private final CardRepository repository;

	private final CardServeRepository cardServeRepository;

	private final CardIdListRepository cardIdListRepository;

	private final Config config;

	@Autowired
	private MongoOperations mongoOperation;

	@Autowired
	CardServiceImpl(Config config, CardRepository repository, CardServeRepository cardServeRepository, CardIdListRepository cardIdListRepository) {
		this.config=config;
		this.repository = repository;
		this.cardServeRepository = cardServeRepository;
		this.cardIdListRepository = cardIdListRepository;
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
		Util.copyNonNullProperties(card,original);
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

	private Pageable createPageRequest() {
		return new PageRequest(0, 10);
	}


	@Override
	public CardServe getUserCard(CardServe cardServe) {
		CardIdList cardIdListBean = null;
		if(cardServe.getId().equals("0")) {
			Stream<CardIdBean> cardIdBeen = cardServeRepository.readAllByIdNotNull();
			//cardIdBeen.forEach(System.out::println);
			List<CardIdBean> cardIdList = cardIdBeen.collect(Collectors.toList());
			cardIdListBean = new CardIdList();
			cardIdListBean.setCardIdBeen(cardIdList);
			cardIdListBean = cardIdListRepository.save(cardIdListBean);
			System.out.println(cardIdListBean);
		}

		if(cardIdListBean == null){
			cardIdListBean = cardIdListRepository.findOne(cardServe.getId());
		}

		System.out.println(config.getCardServeCount());
		List<String> cardListId = new ArrayList<String>();
		int cardIndex = cardServe.getCardIndex();
		int countCard = 0;
		for(int i =0; i<config.getCardServeCount(); i++) {

			if((cardServe.getCardIndex()+countCard)>=cardIdListBean.getCardIdBeen().size()){
				cardIndex = 0;
				countCard=0;
				cardServe.setCardIndex(cardIndex);
			}
			cardIndex = cardServe.getCardIndex()+countCard;
			countCard++;
			//Card card = new Card();
			//card.setId(cardIdListBean.getCardIdBeen().get(cardIndex).getId());
			System.out.println("[i]["+i+"] [cardIndex]["+cardIndex+"]");
			cardListId.add(cardIdListBean.getCardIdBeen().get(cardIndex).getId());
		}
		cardServe.setCardIndex(cardIndex+1);
		//Idwise sorting doing the repository which need to stop.
		List<Card> cardList1 = repository.findByIdIn(cardListId);
		cardServe.setCards(cardList1);
		System.out.println(cardServe.getCards().get(0));
		return cardServe;
	}
}