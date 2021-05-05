import static io.restassured.RestAssured.basePath;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestSpecificationExample {

	static RequestSpecBuilder builder;
	static RequestSpecification requestSpec;
	static ResponseSpecBuilder responseBuilder;
	static ResponseSpecification responseSpec;
	

	@BeforeAll
	public static void init() {
		baseURI="http://localhost";
		port=8085;
		basePath="/student";
		builder =new RequestSpecBuilder();
	//	builder.addQueryParam("status","available");
		builder.addQueryParam("format", "xml");
		requestSpec = builder.build();
		responseBuilder =new ResponseSpecBuilder();
		responseBuilder.expectHeader("Content-Type", "application/json;charset=UTF-8");
		responseBuilder.expectStatusCode(200);
		//responseBuilder.expectBody("firstName",equalTo("Vernon"));
		responseSpec=responseBuilder.build();
	}
	@Test
	public void getRoot() {
	
			given()
			.spec(requestSpec)
			.when()
			.get("/list")
			.then()
			.spec(responseSpec);



	}
}
