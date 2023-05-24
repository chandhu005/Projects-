package net.chandhuguides.SpringBoot_Transaction.managment;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootTransactionManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTransactionManagmentApplication.class, args);
	}

}
