package com.heitor.personapi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class ProfileTest {

    @Value("${spring.h2.console.path}")
    private String pathConsole;
    @Autowired
    private DataBaseInstance db;

    private final Logger LOG = LoggerFactory.getLogger(ProfileTest.class);

    @Bean
    public void profileTestConfigurarion(){

        LOG.info("TEST PROFILE LOADED");

        db.intanceRoles();
        db.instancePerson();
    }
}
