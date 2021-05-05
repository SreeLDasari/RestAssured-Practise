import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.JsonPath;

public class JsonPathJaywayExamples {

	static String jsonResponse;

	@BeforeAll
	public static void init() {
	
	
		baseURI="http://localhost";
		port=8085;
		basePath="/student";
		jsonResponse=given().when().get("/list").asString();
	
	}
	@Test
	public void getRoot() {
		ArrayList<String> rootElement=JsonPath.read(jsonResponse,"$");
		
		System.out.println((rootElement.toString()));
		List<String> lastDataElement = JsonPath.read(jsonResponse, "$..[*].id");
		System.out.println(lastDataElement.toString());


	}
}
