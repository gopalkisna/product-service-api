package com.gk.productservice;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gk.productservice.model.Product;
import com.gk.productservice.repository.ProductRepository;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner demo(ProductRepository repository) {
		return (args) -> {
			repository.save(new Product("p-123", "M-20", "Samsung-M20",
					LocalDateTime.parse("2019-09-28 07:34:32", DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))));
			repository.save(new Product("p-456", "Note", "Samsung-Note",
					LocalDateTime.parse("2019-09-28 07:34:32", DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))));
			repository.save(new Product("p-789", "J-10", "Samsung-J10",
					LocalDateTime.parse("2019-09-28 07:34:32", DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))));
			repository.save(new Product("p-111", "A-50", "Samsung-A50",
					LocalDateTime.parse("2019-09-28 07:34:32", DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))));
		};
	}*/

}
