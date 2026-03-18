package com.nareshit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FileServApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileServApplication.class, args);
	}

}
