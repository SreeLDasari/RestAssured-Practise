import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

public class LoggingResponseValues extends TestBase{

	@Test
	public void test001() {
		System.out.println("------printing response headers----");
		given()
		.param("programme", "Computer Science")
		.param("limit", 1)
		.when()
		.get("/list")
		.then()
		.log()
		.headers()
		.statusCode(200);
	}

	@Test
	public void test002() {
		System.out.println("------printing response status line----");
		given()
		.param("programme", "Computer Science")
		.param("limit", 1)
		.when()
		.get("/list")
		.then()
		.log()
		.status()
		.statusCode(200);
	}
	@Test
	public void test003() {
		System.out.println("------printing response body----");
		given()
		.param("programme", "Computer Science")
		.param("limit", 1)
		.when()
		.get("/list")
		.then()
		.log()
		.body()
		.statusCode(200);
	}
	@Test
	public void test004() {
		System.out.println("------printing response if vaidation fails----");
		given()
		.param("programme", "Computer Science")
		.param("limit", -1)
		.when()
		.get("/list")
		.then()
		.log()
		.ifError();
		
	}

}
