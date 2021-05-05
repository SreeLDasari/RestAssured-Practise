import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SearchJPList {

	
	@BeforeAll
	public static void init() {
		baseURI="https://petstore.swagger.io";
	
		basePath="v2/store";
	
	}
	@Test
	public void test001() {
	int sold=given()
		.when()
		.get("/inventory")
		.then()
		.extract().path("available");
	System.out.println(sold);
	}
	
}
