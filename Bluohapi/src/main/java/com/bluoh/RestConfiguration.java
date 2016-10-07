/*
package com.bluoh;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

*/
/**
 * Created by Ashutosh on 02-10-2016.
 *//*

@Configuration
@EnableWebMvc
public class RestConfiguration extends WebMvcConfigurerAdapter {

    */
/*@Bean
    public CorsFilter corsFilter() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // you USUALLY want this
        config.addAllowedOrigin("*");
//        config.
        config.addAllowedHeader("*");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        source.registerCorsConfiguration("*", config);
        return new CorsFilter(source);
    }*//*


    */
/*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/")
                .allowedOrigins("http://localhost:8009")
                .allowCredentials(false)
                .maxAge(3600)
                .allowedHeaders("Accept", "Content-Type", "Origin", "Authorization", "X-Auth-Token")
                .exposedHeaders("X-Auth-Token", "Authorization")
                .allowedMethods("POST", "GET", "DELETE", "PUT", "OPTIONS");
    }*//*

}
*/
