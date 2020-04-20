package com.example.xsltToHtmlDemo;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.javarefresh.xsltToHtml.ThymeleafAppXSLTtoHtml;

/**
 * Junit for checking with RestTemplate in 2 format
 * 1) With on server
 * 2) Without on the server
 * 
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */

@RunWith(SpringRunner.class)
//Note - If server is running then no need to have @SpringBootTest, you can comment is and check
// but you have to specify port of the application
@SpringBootTest(classes = ThymeleafAppXSLTtoHtml.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ThymeleafAppUsingRestTemplateTests {

	//Note - 
	@LocalServerPort
	int randomServerPort;
	
	//Note - If server is running then give the server port number and uncomment below line
	//int randomServerPort = 8080;

	// @Autowired
	// RestTemplate restTemplate;

	@Test
	public void contextLoadsOrHomePage() throws URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort + "/javaRefresh/home";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());

	}
}
