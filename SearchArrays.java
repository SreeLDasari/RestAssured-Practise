import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class SearchArrays {

	@BeforeAll
	public static void init() {
		baseURI="http://localhost";
		port=8085;
		basePath="/student";
	
	}
	@Test
	public void test001() {
	String id=given()
		.when()
		.get("/1")
		.then()
		.extract().path("courses[0]");
	System.out.println(id);
	}
	@Test
	public void test002() {
	int size=given()
		.when()
		.get("/1")
		.then()
	.extract().path("courses.size()");
	System.out.println(size);
	}
}
