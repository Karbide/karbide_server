package com.bluoh.service.impl;

import com.bluoh.model.Metadata;
import com.bluoh.repository.MetadataRepository;
import com.bluoh.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ashutosh on 05-11-2016.
 */
@Service
public class MetadataServiceImpl implements MetadataService {

    @Autowired
    private MetadataRepository repository;

    @Override
    public List<Metadata> findAll() {
        return repository.findAll();
    }
}
