package com.github.vipekon.vipekontelegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class VipekonTelegrambotApplication {

	public static void main(String[] args) {

		SpringApplication.run(VipekonTelegrambotApplication.class, args);
	}

}
