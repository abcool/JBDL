package com.abcool.OAuth2DB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class OAuth2DbApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2DbApplication.class, args);
	}

}
