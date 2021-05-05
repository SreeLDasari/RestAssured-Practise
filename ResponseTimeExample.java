import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ResponseTimeExample {

	@BeforeAll
	public static void init() {
		baseURI="http://localhost";
		port=8085;
		basePath="/student";
	
	}
	@Test
	public void test001() {
	long id=given()
		.when()
		.get("/1")
		.time();
	System.out.println(id);
	}
	@Test
	public void test002() {
	long id=given()
		.when()
		.get("/1")
		.timeIn(TimeUnit.SECONDS);
	System.out.println(id);
	given()
	.when()
	.get("/1")
	.then()
	.time(lessThan(5L),TimeUnit.SECONDS);
	

	
	}
}
