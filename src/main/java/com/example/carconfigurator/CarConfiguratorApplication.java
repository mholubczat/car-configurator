package com.example.carconfigurator;

import com.example.carconfigurator.engine.Car;
import com.example.carconfigurator.engine.Engine;
import com.example.carconfigurator.service.CarOfferService;
import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.applet.AppletContext;

@SpringBootApplication
public class CarConfiguratorApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(CarConfiguratorApplication.class);

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	CarOfferService carOfferService;

	public static void main(String[] args) {
		SpringApplication.run(CarConfiguratorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Engine engine1 = applicationContext.getBean("enginePetrol20",Engine.class);
		Engine engine2 = applicationContext.getBean("enginePetrol20",Engine.class);
		Car car1 = applicationContext.getBean("mazdaCx5Petrol25", Car.class);
		Car car2 = applicationContext.getBean("mazdaCx5Petrol25", Car.class);
		LOG.info("engine1==engine2 = {}", engine1==engine2);
		LOG.info("car1==car2 = {}", car1==car2);

		prepareAndSendOffer("mazda6Petrol20","Biały",17,"kamil@gmail.com");
		prepareAndSendOffer("mazda6Petrol25","Czerwony",19,"kamila@gmail.com");
		prepareAndSendOffer("mazda6Petrol20","Biały",18,"kamilan@gmail.com");
		prepareAndSendOffer("mazda6Petrol20","Biały",20,"kamilon@gmail.com");
	}
	private void prepareAndSendOffer(String carBeanName,String carColor, int carWheelsSize, String clientEmail){
		Car car = applicationContext.getBean(carBeanName, Car.class);
		car.setColor(carColor);
		car.setWheelsSize(carWheelsSize);

		carOfferService.prepareAndSendOffer(car, clientEmail);
	}
}
