package CadastrarPessoaTests;

import org.hamcrest.Matchers;
import org.junit.Test;

import CadastroPessoalCore.BaseTest;

import static io.restassured.RestAssured.given;;

public class CadastroPessoaTest extends BaseTest {

	@Test
	public void RealizarNovoCadastro() {
		given().body("{\r\n" + "\"codigo\": 0,\r\n" + "\"nome\": \"Rommel Von\",\r\n" + "\"cpf\": \"12345678914\",\r\n"
				+ "\"enderecos\": [\r\n" + "{\r\n" + "\"logradouro\": \"Rua Alexandre Dumas\",\r\n"
				+ "\"numero\": 123,\r\n" + "\"complemento\": \"Empresa\",\r\n"
				+ "\"bairro\": \"Chacara Santo Antonio\",\r\n" + "\"cidade\": \"São Paulo\",\r\n"
				+ "\"estado\": \"SP\"\r\n" + "}\r\n" + "],\r\n" + "\"telefones\": [\r\n" + "{\r\n"
				+ "\"ddd\": \"11\",\r\n" + "\"numero\": \"985388880\"\r\n" + "}]\r\n" + "}")
		.when().post("/pessoas")
		.then().statusCode(201);

	}

	@Test
	public void RealizarCadastroInformandoCpfJáCadastrado() {
		given().body("{\r\n" + "\"codigo\": 0,\r\n" + "\"nome\": \"Rommel Von\",\r\n" + "\"cpf\": \"12345678912\",\r\n"
				+ "\"enderecos\": [\r\n" + "{\r\n" + "\"logradouro\": \"Rua Alexandre Dumas\",\r\n"
				+ "\"numero\": 123,\r\n" + "\"complemento\": \"Empresa\",\r\n"
				+ "\"bairro\": \"Chacara Santo Antonio\",\r\n" + "\"cidade\": \"São Paulo\",\r\n"
				+ "\"estado\": \"SP\"\r\n" + "}\r\n" + "],\r\n" + "\"telefones\": [\r\n" + "{\r\n"
				+ "\"ddd\": \"11\",\r\n" + "\"numero\": \"985388879\"\r\n" + "}]\r\n" + "}")
		.when().post("/pessoas")
		.then().statusCode(400).body("erro", Matchers.is("Já existe pessoa cadastrada com o CPF 12345678912"));

	}

	@Test
	public void RealizarCadastroInformandoNúmeroDeTelefoneJáCadastrado() {
		given().body("{\r\n" + "\"codigo\": 0,\r\n" + "\"nome\": \"Rommel Von\",\r\n" + "\"cpf\": \"12345678913\",\r\n"
				+ "\"enderecos\": [\r\n" + "{\r\n" + "\"logradouro\": \"Rua Alexandre Dumas\",\r\n"
				+ "\"numero\": 123,\r\n" + "\"complemento\": \"Empresa\",\r\n"
				+ "\"bairro\": \"Chacara Santo Antonio\",\r\n" + "\"cidade\": \"São Paulo\",\r\n"
				+ "\"estado\": \"SP\"\r\n" + "}\r\n" + "],\r\n" + "\"telefones\": [\r\n" + "{\r\n"
				+ "\"ddd\": \"11\",\r\n" + "\"numero\": \"985388879\"\r\n" + "}]\r\n" + "}")
		.when().post("/pessoas")
		.then().statusCode(400).body("erro", Matchers.is("Já existe pessoa cadastrada com o CPF 12345678913"));

	}
}
