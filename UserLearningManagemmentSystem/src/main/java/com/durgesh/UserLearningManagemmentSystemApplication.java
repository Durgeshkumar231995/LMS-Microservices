package com.durgesh;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "UserLearningManagemmentSystemApplication API", version = "1.0", description = "User View Courses Information"))

@EnableEurekaClient
//@EnableDiscoveryClient
public class UserLearningManagemmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserLearningManagemmentSystemApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}
