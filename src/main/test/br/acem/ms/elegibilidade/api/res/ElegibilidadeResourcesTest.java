package br.acem.ms.elegibilidade.api.res;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.junit.Test;

import io.restassured.RestAssured;

public class ElegibilidadeResourcesTest {

	public ElegibilidadeResourcesTest() {
		try {
			Map<String, String> env = System.getenv();
			if (env.containsKey("MY_ENV")) {
				String myEnv = env.get("MY_ENV");
				System.out.println("MY_ENV : " + myEnv);
				if (myEnv != null && myEnv.equals("local")) {
					RestAssured.baseURI = "http://localhost:9080/elegibilidade";
				} else {
					RestAssured.baseURI = "http://elegibilidade.mybluemix.net";
				}
			} else {
				System.out.println("Sem Variavel");
			}
		} catch (Exception excEnv) {
			System.out.println("ERRO : VCAP Não Encontrado!");
		}
	}

	@Test
	public void testeSimples() {
		System.out.println(baseURI);
		get("/validarElegibilidade/123").then().statusCode(200).body("valor", equalTo("Calculado GET"));

	}
}
