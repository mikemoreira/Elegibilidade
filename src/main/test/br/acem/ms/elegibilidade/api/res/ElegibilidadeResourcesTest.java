package br.acem.ms.elegibilidade.api.res;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static org.junit.Assert.fail;

import org.junit.Test;

import io.restassured.RestAssured;

public class ElegibilidadeResourcesTest {
	
	public ElegibilidadeResourcesTest(){
		//Local
		//RestAssured.baseURI =  "http://localhost:9080/elegibilidade";
		//Bluemix 
		RestAssured.baseURI =  "http://elegibilidade.mybluemix.net";
		
		System.out.println("Hello from " + System.getenv("VCAP_APP_HOST") + ":" + System.getenv("VCAP_APP_PORT"));
	}
	

	
	@Test
	public void testeSimples() {
		System.out.println(baseURI);
		get("/validarElegibilidade/123")
		.then()
			.statusCode(200)
			.body("valor", equalTo("Calculado GET"));

	}
}
