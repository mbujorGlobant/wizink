package com.wizink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class WizinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(WizinkApplication.class, args);
	}

}
