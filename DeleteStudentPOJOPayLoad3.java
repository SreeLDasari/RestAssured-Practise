import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteStudentPOJOPayLoad3 extends TestBase{
	
	@Test
	public void puttrec() {
	
		Faker fake=new Faker();
		StudentPOJO ob=new StudentPOJO();
		

		//ob.setEmail(fake.internet().emailAddress());
	
			given()
			.when()
			.contentType(ContentType.JSON)
			.body(ob)
			.delete("/102")
			.then()
			.statusCode(204);
	}
}
