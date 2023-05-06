package com.notaris.soro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NotarisApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotarisApplication.class, args);
	}

}
