package com.cs.upload.controller;



import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

/**
 * 
 * @author Max.Alencar
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventControllerTests {

	@Autowired
    private WebTestClient webTestClient;
    
	@Test
	public void uploadNoFile() {
		webTestClient.post()
        .exchange().expectStatus().isBadRequest()
        .expectBody(Void.class);
	}
	
	@Test
	public void uploadFile() throws FileNotFoundException {
		MultipartBodyBuilder bodyBuilder = new MultipartBodyBuilder();
		bodyBuilder.part("file", new ClassPathResource("upload-file-test.txt"));
		
		webTestClient.post()
		.body(BodyInserters.fromMultipartData(bodyBuilder.build()))
        .exchange().expectStatus().isOk()
        .expectBody(Void.class);
	}
}
