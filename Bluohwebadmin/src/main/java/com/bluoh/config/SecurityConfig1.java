package com.bluoh.config;

import com.bluoh.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Ashutosh on 11-10-2016.
 */

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebMvc
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig1 extends WebSecurityConfigurerAdapter{

    private final UserServiceImpl service;
    private final CORSFilter corsFilter;

    @Autowired
    public SecurityConfig1(UserServiceImpl service, CORSFilter corsFilter) {
        this.service = service;
        this.corsFilter = corsFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/tags").permitAll() // #4
                .antMatchers("/deck/**").hasRole("USER") // #6
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        http.addFilterBefore(corsFilter, ChannelProcessingFilter.class);
    }

    /*@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/image/");
    }*/

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service);
    }
}
