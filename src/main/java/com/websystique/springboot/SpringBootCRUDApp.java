package com.websystique.springboot;
//XXX:http://websystique.com/spring-boot/spring-boot-angularjs-spring-data-jpa-crud-app-example/
//XXX:https://www.leveluplunch.com/java/tutorials/009-spring-boot-what-autoconfigurations-turned-on/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.websystique.springboot.configuration.JpaConfiguration;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages = { "com.websystique.springboot" })
public class SpringBootCRUDApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCRUDApp.class, args);
	}
}