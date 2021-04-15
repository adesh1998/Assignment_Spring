package com.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootApplication
public class Assignment1Application {

	public static void main(String[] args) {
		log.info("Start");
		SpringApplication.run(Assignment1Application.class, args);
	}

}
