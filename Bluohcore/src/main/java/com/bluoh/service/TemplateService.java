package com.bluoh.service;

import com.bluoh.model.Template;

import java.util.List;

/**
 * Created by Ashutosh on 25-09-2016.
 */
public interface TemplateService {

    List<Template> getAll();

    boolean addTemplate(String template);

}
