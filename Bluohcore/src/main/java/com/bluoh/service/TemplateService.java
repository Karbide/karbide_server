package com.bluoh.service;

import com.bluoh.model.Template;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Ashutosh on 25-09-2016.
 */
@Document
public interface TemplateService {

    Template getAll();

    boolean addTemplate(String template);

}
