package com.rafaelmgr12.digitalwallet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;


@Configuration
public class ModelMapperConfiguration {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}