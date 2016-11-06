package com.bluoh.service.impl;

import com.bluoh.model.Traffic;
import com.bluoh.repository.TrafficRepository;
import com.bluoh.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ashutosh on 06-11-2016.
 */
@Service
public class TrafficServiceImpl implements TrafficService {

    @Autowired
    private TrafficRepository repository;

    @Override
    public Traffic create(Traffic traffic) {
        return repository.save(traffic);
    }
}
