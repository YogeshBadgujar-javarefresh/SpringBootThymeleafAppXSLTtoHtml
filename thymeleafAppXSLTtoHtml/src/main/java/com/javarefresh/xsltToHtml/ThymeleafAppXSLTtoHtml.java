package com.javarefresh.xsltToHtml;

/**
 * Application - Based on xml, xslt and css input text, this application give you the HTML result.
 * Some minor vaildation from HTML as well as server side vaildation.
 * Technologies – Spring Boot-2.2.4.RELEASE, Thymeleaf for UI, Swagger for endpoints, 
 * dev-tool for hot deploy changes(check the pom.xml), Sonar for code quality 
 * 
 * Also added the Junit test cases. 
 * 
 * 
 * @author Yogesh Badgujar
 * email me in case any problem - badgujar.yogesh@gmail.com
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ThymeleafAppXSLTtoHtml {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafAppXSLTtoHtml.class, args);
	}
}
