package br.acem.ms.elegibilidade;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.acem.ms.elegibilidade.api.res.ElegibilidadeResources;
import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

/* Incluido PipeLine no Bluemix*/

@ApplicationPath("/")
@SwaggerDefinition(info = @Info(title = "Elegibilidade API", version = "1.0", contact = @Contact(name = "Mike Moreira", email = "mikemoreira@gmail.com")), tags = {
		@Tag(name = "Elegibilidade", description = "Elegibilidade JAXRS Based API") })
public class ElegibilidadeAPI extends Application {

	/*
	 * Método que carrega as classes de recurso e disponibiliza os mapeamentos
	 * como APIs
	 */

	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();

		// Elegibilidade
		classes.add(ElegibilidadeResources.class);

		// Disponibilização das classes
		return classes;
	}

}
