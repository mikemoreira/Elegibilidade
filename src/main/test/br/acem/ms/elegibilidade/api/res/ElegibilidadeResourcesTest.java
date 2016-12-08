package br.acem.ms.elegibilidade.api.res;

import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ElegibilidadeResourcesTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test(expected = AssertionError.class)
	public void testValidarElegibilidadeGET() {
		fail("Testando Método testValidarElegibilidadeGET");
	}

	@Test(expected = AssertionError.class)
	public void testValidarElegibilidadePOST() {
		fail("Testando Metodo testValidarElegibilidadePOST");
	}

}
