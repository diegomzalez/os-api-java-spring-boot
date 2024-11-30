package com.diegomzalez.products_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

import io.restassured.RestAssured;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductsServiceApplicationTests {
	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");
	@LocalServerPort
	private Integer localServerPort;

	void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = localServerPort;

	}

	static {
		mongoDBContainer.start();
	}

	@Test
	void shouldCreateAProduct() {
		String requestBody = """
								{
					"name": "RTX 4060",
					"description": "NVIDIA RTX 4060 8GB RAM.",
					"price": 500
				}
								""";

		RestAssured.given().contentType("application/json").body(requestBody).when().post("/api/v1/products").then()
				.statusCode(201);
	}

	@Test
	void shouldFindAllProducts() {
		RestAssured.given().contentType("application/json").when().get("/api/v1/products").then().statusCode(202);
	}
}
