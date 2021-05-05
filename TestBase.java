
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import io.restassured.RestAssured;

public class TestBase {

	
//	http://localhost:8085/student/list
	@BeforeAll
	public static void init() {
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8085;
		RestAssured.basePath="/student";
	}
	
}
