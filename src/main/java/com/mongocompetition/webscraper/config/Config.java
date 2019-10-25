package com.mongocompetition.webscraper.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.mongocompetition" })
public class Config {
//
//    @Bean
//    public HttpMessageConverter<Object> createFormHttpConverter() {
//        FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
//        return formHttpMessageConverter;
//    }

}
