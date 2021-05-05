import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.specification.ProxySpecification;

public class ProxyExample {

	@BeforeAll
	public static void init() {
		baseURI="http://localhost";
		port=8085;
		basePath="/student";
	
	}
	@Test
	public void test001() {
		given()
		.proxy("localhost",5555)
		.when()
		.get("/list")
		.then()
		.log()
		.body();


	}
	@Test
	public void test002() {
		ProxySpecification p=new ProxySpecification("localhost",5555,"http");
		given()
		.proxy(p)
		.when()
		.get("/list")
		.then()
		.log()
		.body();


	}
}
