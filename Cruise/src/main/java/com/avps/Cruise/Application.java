package com.avps.Cruise;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.avps.Cruise.RestController.CruiseRestController;

@SpringBootApplication
@EnableMongoRepositories
@ComponentScan({ "com.avps.Cruise.RestController", "com.avps.Cruise.Service" })
public class Application {
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		CruiseRestController controller = ctx.getBean(CruiseRestController.class);
		System.out.println(controller);
		System.out.println(new Date());
	}
}
