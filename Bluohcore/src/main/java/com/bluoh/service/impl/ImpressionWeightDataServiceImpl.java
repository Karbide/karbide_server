package com.bluoh.service.impl;

import com.bluoh.model.Card;
import com.bluoh.model.ImpressionWeightData;
import com.bluoh.repository.CardRepository;
import com.bluoh.repository.ImpressionWeightDataRepository;
import com.bluoh.service.CardService;
import com.bluoh.service.ImpressionWeightDataService;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
final class ImpressionWeightDataServiceImpl implements ImpressionWeightDataService{

	private static final Logger LOGGER = LoggerFactory.getLogger(ImpressionWeightDataServiceImpl.class);

	private final ImpressionWeightDataRepository repository;

	@Autowired
	private MongoOperations mongoOperation;

	@Autowired
    ImpressionWeightDataServiceImpl(ImpressionWeightDataRepository repository) {
		this.repository = repository;
	}

	@Override
	public ImpressionWeightData create(ImpressionWeightData impressionWeightData) {
		ImpressionWeightData persisted = repository.save(impressionWeightData);
		LOGGER.info("Created a new card entry with information: {}", persisted);
		return persisted;
	}

	@Override
	public ImpressionWeightData delete(String id) {
		return null;
	}

	@Override
	public List<ImpressionWeightData> findAll() {
		return null;
	}

	@Override
	public ImpressionWeightData update(ImpressionWeightData impressionWeightData) {
		return null;
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