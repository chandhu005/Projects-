package com.springboot.Blog;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title="Spring Boot Blog App Rest Apis",
				description="Spring  Boot Blog App REST APis Documentation"
				,version ="v1.0"
				,contact=@Contact(
						name="Chandhu",
				        email="chandrasekharchadalawada7@gmail.com",
				url="https://www.chandhuguides.net"
		),
				license =@License(
						name="Apache 2.0",
						url="https://www.chandhuguides.net/license"
		)
		),
		externalDocs  =@ExternalDocumentation(
				description = "Spring Boot Blog App Documentation",
		  url="https://github.com/chandhu005/Projects-"
)
)
public class SpringbootBlogRestApiApplication {
	@Bean
public ModelMapper modelMapper(){
	return new ModelMapper();
}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogRestApiApplication.class, args);
	}

}
