import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class XMLPathrExamples {

	

	@BeforeAll
	public static void init() {
	

		baseURI="http://localhost";
		port=8085;
		basePath="/student";
	}
	@Test
	public void getRoot() {
	

	List<Integer> id=	given().when().get("/list").then().extract().path("id");
	System.out.println(id);
	
	int size=	given().when().get("/list").then().extract().path("progrmme.size()");
	System.out.println(size);
	
	String xml=given().queryParam("format","xml").when().get("/1").asString();

	}
}
