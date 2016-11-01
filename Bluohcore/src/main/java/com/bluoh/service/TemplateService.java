package com.bluoh.service;

import com.bluoh.model.Template;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Ashutosh on 25-09-2016.
 */
@Document
public interface TemplateService {

    List<Template> getAll();

    boolean addTemplate(String template);

}
