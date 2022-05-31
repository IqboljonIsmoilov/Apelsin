package com.company;

import com.company.dto.UserTestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;

@SpringBootTest
class ApelsinApplicationTests {

	@Test
	void contextLoads() {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject("https://gorest.co.in/public/v2/users/9", String.class);

	}

	@Test
	void post1() {
		RestTemplate restTemplate = new RestTemplate();
		UserTestDTO dto = new UserTestDTO();
		dto.setName("Alish");
		dto.setGarden("male");
		dto.setStatus("active");
		dto.setEmail("iqbol.ismoilov007@gmail.com");

		org.springframework.http.HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Author", "Barer ");
	}

}
