package com.catstrackingrestapi.CatsTrackingRestAPI.src;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import source.Models.Cat;
import source.Models.CatColor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import src.Services.CatService;
import src.Services.OwnerService;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
@RestController
@EnableJpaRepositories(basePackages = {"src.Repositories"})
@ComponentScan(basePackages = {"src.Services", "source"})
@EntityScan(basePackages={"source.Models"})
public class CatsTrackingRestApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(CatsTrackingRestApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CatService catService, OwnerService ownerService) {
		return args -> {
			catService.addCatToMainTable("Tom", "Siberian", LocalDate.of(2019, 1, 1), CatColor.black);
			catService.addCatToMainTable("Jerry", "Siberian", LocalDate.of(2019, 1, 1), CatColor.semi_color);
			catService.addFriendToCat("Tom", "Jerry");

			ownerService.addOwnerWithoutCats("Alice", LocalDate.of(1990, 1, 1));
			ownerService.addOwnerWithInitialCats("Bob", LocalDate.of(1990, 1, 1), new ArrayList<>(List.of("Tom", "Jerry")));

			//catService.deleteCatFromMainTable("Jerry");
		};
	}
}