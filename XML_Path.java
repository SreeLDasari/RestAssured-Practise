import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class XML_Path {


	@BeforeAll
	public static void init() {
	

		baseURI="https://petstore.swagger.io";
		basePath="/v2/pet/findByStatus";
	}
	@Test
	public void getRoot() {
	
		given().queryParam("status", "available").when().get().then().statusCode(200);

	List<Integer> id=	given().when().get().then().extract().path("Pets.pet.category.id");
	System.out.println(id);
	
	int size=	given().queryParam("status", "available").when().get().then().extract().path("Pets.pet.category.size()");
	System.out.println(size);
	
	String xml=given().queryParam("status", "available").queryParam("format","xml").when().get().asString();

	}
}
