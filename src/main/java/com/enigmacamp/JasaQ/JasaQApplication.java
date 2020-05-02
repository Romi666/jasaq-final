package com.enigmacamp.JasaQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.enigmacamp.JasaQ.exceptions.FileStorageProperties;


@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class JasaQApplication {

	public static void main(String[] args) {
		SpringApplication.run(JasaQApplication.class, args);
	}

}
