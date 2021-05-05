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

public class SoftAssertionExamples {

	@BeforeAll
	public static void init() {
	

		baseURI="http://localhost";
		port=8085;
		basePath="/student";
	
	
	}
	@Test
	public void hardAsser() {
		given()
		.when()
		.get("/2")
		.then()
		.body("id",equalTo(2))
		.body("firstName",equalTo("Murphy"))
		.body("courses",hasItems("Accounting","Statistics"))
		.statusCode(200).body("programme",equalTo("Financial Analysis"))
		.body("courses",hasItems("Accounting","Statistics"))
		.statusCode(200);

	}
	@Test
	public void softAsser() {
		given()
		.when()
		.get("/2")
		.then()
		.body("id",equalTo(2),"firstName",equalTo("Murphy"),"courses",hasItems("Accounting","Statistics"),"programme",equalTo("Financial Analysis")
				,"courses",hasItems("Accounting","Statistics")).statusCode(200);
		
	}
}
