package br.acem.ms.elegibilidade.api.res;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.junit.Test;

import io.restassured.RestAssured;

public class ElegibilidadeResourcesTest {
	
	
	public ElegibilidadeResourcesTest(){
		//Local
		//RestAssured.baseURI =  "http://localhost:9080/elegibilidade";
		//Bluemix 
		RestAssured.baseURI =  "http://elegibilidade.mybluemix.net";
		
		Map env = System.getenv();
		String host = (String)env.get("VCAP_APP_HOST");
		String port = (String)env.get("VCAP_APP_PORT");
		
		System.out.println("Hello from " + host + ":" + port);
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
