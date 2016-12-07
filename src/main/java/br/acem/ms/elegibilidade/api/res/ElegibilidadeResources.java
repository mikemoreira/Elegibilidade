package br.acem.ms.elegibilidade.api.res;

import java.io.IOException;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import com.ibm.json.java.JSON;
import com.ibm.json.java.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/")
@Api("Validacao Elegibilidade")
public class ElegibilidadeResources {

	private final String RETURN_CODE_ERROR = "\"ReturnCode\":\"-1\"";
	private final String RETURN_MESS_ERROR = "\"ReturnMessage\":\"Dados enviados em formato incorreto\"";

	@GET
	@Path("/validarElegibilidade/{carteirinha}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Valida Elegibilidade", notes = "Verifica se o paciente pode ser atendido ou nao - by GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 500, message = "Algo Errado") })
	@ApiParam(value = "carteirinha", required = true)
	public Response validarElegibilidadeGET(@PathParam(value = "carteirinha") String carteirinha) {
		System.out.println(" Parametro : " + carteirinha);
		StatusType statusRetorno = Response.Status.OK;
		String retornoMetodo = "{\"valor\":\"Calculado GET\",\"beneficiario\":[" + carteirinha + "]}";
		return Response
				// valor a ser retornado
				.status(statusRetorno)
				// objeto ou parametros transformados no tipo do produces
				.entity(retornoMetodo)
				// gerador do retorno
				.build();
	}
	
	@SuppressWarnings("unchecked")
	@POST
	@Path("/validarElegibilidade")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Valida Elegibilidade", notes = "Verifica se o paciente pode ser atendido ou nao - by POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 500, message = "Algo Errado") })
	public Response validarElegibilidadePOST(
			@FormParam(value = "Carteirinha") String valor,
			@FormParam(value = "Rede")        String rede) {
		StatusType statusRetorno = null;
		String retornoMetodo = null;
		try {
			JSONObject newObject = (JSONObject) JSON.parse("{\"valor\":\"Calculado POST\"}");
			JSONObject obj = (JSONObject) JSON.parse(valor);
			JSONObject objRede = (JSONObject) JSON.parse(rede);
			String newValue = newObject.get("valor").toString() + " : " + obj.get("data").toString() + objRede.get("rede").toString();
			newObject.replace("valor", newValue);
			retornoMetodo = newObject.toString();
			statusRetorno = Status.OK;
		} catch (IOException ioExc) {
			statusRetorno = Status.BAD_REQUEST;
			retornoMetodo = "{" + this.RETURN_CODE_ERROR + "," + this.RETURN_MESS_ERROR + "}";
		} catch (Exception genExc) {
			statusRetorno = Status.BAD_REQUEST;
			;
			retornoMetodo = "{" + this.RETURN_CODE_ERROR + "," + this.RETURN_MESS_ERROR + "}";
		}
		return Response
				// valor a ser retornado
				.status(statusRetorno)
				// objeto ou parametros transformados no tipo do produces
				.entity(retornoMetodo)
				// gerador do retorno
				.build();

	}
}
