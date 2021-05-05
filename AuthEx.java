import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AuthEx {

	@Test
	public void test001() {
			given()
			.auth()
			.preemptive()
			.basic("unusual-ostrich@example.com", "Angry-Parrot-49")
			.when()
			.get("https://authorization-server.com/authorize? response_type=code &client_id=r379SLzn_xkPg1ud7Lpx9aUk&redirect_uri=https://www.oauth.com/playground/authorization-code.html &scope=photo+offline_access &state=Lbutj-BB-W5AE1kH")
			.then()
			.statusCode(200);
			
		
	}
	@Test
	public void test002() {
			given()
			.param("format", "json")
			.auth()
			.basic("unusual-ostrich@example.com", "Angry-Parrot-49")
			.when()
			.get("https://authorization-server.com/authorize? response_type=code &client_id=r379SLzn_xkPg1ud7Lpx9aUk&redirect_uri=https://www.oauth.com/playground/authorization-code.html &scope=photo+offline_access &state=Lbutj-BB-W5AE1kH")
			.then()
			.log()
			.all();
			
			
		
	}
}
