package com.practice.restaurantlisting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.practice.restaurantlisting", "com.practice.restaurantlisting.config"})
public class RestaurantListingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantListingApplication.class, args);
	}

}
