import static io.restassured.RestAssured.basePath;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*;

public class AssertionExamples2 {

	@BeforeAll
	public static void init() {
	

		baseURI="http://localhost";
		port=8085;
		basePath="/student";
	
	
	}
	@Test
	public void test001() {
		int id=given().when().get("/2").then().extract().path("id");
		System.out.println(id);
		assertEquals(2,id);
		
		given().when().get("/2").then().body("id",equalTo(2));
	
		given().when().get("/2").then().body("programme",equalTo("Financial Analysis"));

		given().when().get("/2").then().body("courses",hasItems("Accounting","Statistics")).statusCode(200);

		given().when().get("/2").then().body("programme",equalTo("Financial Analysis")).body("courses",hasItems("Accounting","Statistics")).statusCode(200);

	}
}
