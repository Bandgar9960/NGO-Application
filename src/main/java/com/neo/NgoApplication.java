package com.neo;

import com.neo.model.Admin;
import com.neo.model.Login;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class NgoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NgoApplication.class, args);
	}


}
