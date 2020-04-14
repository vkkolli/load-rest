package com.cei.load;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class LoadRestApplication.
 */
@SpringBootApplication
@EnableSwagger2
public class LoadRestApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(LoadRestApplication.class, args);
	}
	
	/**
	 * Model mapper.
	 *
	 * @return the model mapper
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
