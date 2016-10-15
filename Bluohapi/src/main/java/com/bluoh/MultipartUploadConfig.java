package com.bluoh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Created by Ashutosh on 15-10-2016.
 */
@Configuration
public class MultipartUploadConfig {

    @Bean(name = "filterMultipartResolver")
    public MultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
    }
}
