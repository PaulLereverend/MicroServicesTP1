package com.paullereverend;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.paullereverend.controllers.UtilisateurController;

@SpringBootApplication
public class MicroServiceTp1Application {

    private static final Logger logger = Logger.getLogger(MicroServiceTp1Application.class);

	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(MicroServiceTp1Application.class, args);
	}
}
