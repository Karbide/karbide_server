package com.bluoh.service.impl;

import com.bluoh.model.Template;
import com.bluoh.repository.TemplateRepository;
import com.bluoh.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ashutosh on 25-09-2016.
 */
@Service
public class TemplateServiceImpl implements TemplateService{

    @Autowired
    TemplateRepository repository;

    @Override
    public List<Template> getAll() {
        List<Template> templates = repository.findAll();
        return templates;
    }

    @Override
    public boolean addTemplate(String template) {
        return false;
    }
}
