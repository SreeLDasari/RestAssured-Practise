import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateStudentPayLoad extends TestBase{
	
	@Test
	public void postrec() {
			
		String rec="{\"firstName\":\"Avyan\",\"lastName\":\"Y\",\"email\":\"a12@gmail.com\",\"programme\":\"Aeronatical\",\"courses\":[\"SpaceX\",\"ISRO\",\"NASA\"]}";
			given()
			.when()
			.contentType(ContentType.JSON)
			.body(rec)
			.post()
			.then()
			.statusCode(201);
	}
}
