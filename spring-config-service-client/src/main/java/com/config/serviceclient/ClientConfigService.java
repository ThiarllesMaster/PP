package com.config.serviceclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientConfigService {

	@Value("${database.connection}")
	private String database;
	
	@GetMapping(path = "/database-config")
	public String getDatabase() {
		return database;
	}
}
