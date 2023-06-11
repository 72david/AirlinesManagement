package com.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.Models.Airoplanedetails;
import com.Models.Variables;
import com.Models.bookingentity;
import com.Repository.*;
import com.service.*;


@SpringBootApplication(scanBasePackageClasses = indexcontroller.class)
@ComponentScan(basePackageClasses= {indexcontroller.class,CheckDatas.class
		,Variables.class,bookingentity.class,Airoplanedetails.class,flightservice.class,ticketservice.class})
@EnableJpaRepositories(basePackageClasses ={UserDataRepository.class,TicketsRepository.class,AiroplaneRepository.class})
@EntityScan("com.Models")
public class AirlinesManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(AirlinesManagementApplication.class, args);
	}
}
