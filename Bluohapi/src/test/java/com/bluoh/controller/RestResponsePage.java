package com.bluoh.controller;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashutosh on 18-12-2016.
 */
public class RestResponsePage<T> extends PageImpl<T> {

    private static final long serialVersionUID = 3248189030448292002L;

    public RestResponsePage(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
        // TODO Auto-generated constructor stub
    }

    public RestResponsePage(List<T> content) {
        super(content);
        // TODO Auto-generated constructor stub
    }

    /* PageImpl does not have an empty constructor and this was causing an issue for RestTemplate to cast the Rest
    API response
     * back to Page.
     */
    public RestResponsePage() {
        super(new ArrayList<T>());
    }
}