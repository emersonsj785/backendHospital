package com.reto02.microservicios.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviciosHospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosHospitalApplication.class, args);
	}

}
