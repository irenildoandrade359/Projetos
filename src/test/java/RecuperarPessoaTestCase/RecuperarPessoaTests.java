package RecuperarPessoaTestCase;

import org.hamcrest.Matchers;
import org.junit.Test;

import CadastroPessoalCore.BaseTest;

import static io.restassured.RestAssured.given;;

public class RecuperarPessoaTests extends BaseTest {

	@Test
	public void RecuperarDadosDeUmaPessoaCadastrada() {
		given()

				.when().get("/pessoas/11/985388878").then()
				.statusCode(200)

		;

	}

	@Test
	public void RecuperarDadosDeUmaPessoaCadastradaInformandoDadosErrados() {
		given()

				.when().get("/pessoas/12/9853888781")
				.then().statusCode(404)
				.body("erro", Matchers.is("Não existe pessoa com o telefone (12)9853888781"))

		;

	}

	@Test
	public void RecuperarDadosDeUmaPessoaInformandoDDDNãoCadastrado() {
		given()

				.when().get("/pessoas/12/985388878").then().statusCode(404)
				.body("erro", Matchers.is("Não existe pessoa com o telefone (12)985388878"))

		;

	}

	@Test
	public void RecuperarDadosDeUmaPessoaInformandoNumeroNãoCadastrado() {
		given()

				.when().get("/pessoas/11/9853888781").then().statusCode(404)
				.body("erro", Matchers.is("Não existe pessoa com o telefone (11)9853888781"))

		;

	}
}
