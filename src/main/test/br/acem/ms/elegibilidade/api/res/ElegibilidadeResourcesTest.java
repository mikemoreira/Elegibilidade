package br.acem.ms.elegibilidade.api.res;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.junit.Test;

import com.ibm.json.java.JSON;
import com.ibm.json.java.JSONObject;

import io.restassured.RestAssured;

public class ElegibilidadeResourcesTest {

	public ElegibilidadeResourcesTest() {
		// Local
		// RestAssured.baseURI = "http://localhost:9080/elegibilidade";
		// Bluemix
		RestAssured.baseURI = "http://elegibilidade.mybluemix.net";
		try {

			Map<String, String> env = System.getenv();
			// Print All Env Vars
			for (String envName : env.keySet()) {
				System.out.format("%s=%s%n", envName, env.get(envName));
			}
			if (env.containsKey("VCAP_SERVICES")) {
				JSONObject vcap = (JSONObject) JSON.parse(env.get("VCAP_SERVICES"));
				System.out.println("Hello from " + vcap.toString());
			} else {
				System.out.println("VCAP Não Encontrado!");
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
