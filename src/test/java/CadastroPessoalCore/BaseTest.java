package CadastroPessoalCore;

import org.junit.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

public class BaseTest implements Constantes {

	@BeforeClass
	public static void setup() {
				
		
		RequestSpecBuilder requestBilder = new RequestSpecBuilder();		
		requestBilder.setContentType(CONTENT_TYPE);
		RestAssured.requestSpecification = requestBilder.build();
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}
	
}
