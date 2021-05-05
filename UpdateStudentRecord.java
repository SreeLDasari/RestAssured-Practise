import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpdateStudentRecord extends TestBase{
	
	@Test
	public void puttrec() {
		/*	
		StudentPOJO ob=new StudentPOJO();
		List<String> course=new ArrayList<>();
		course.add("C");
		course.add("CPP");
		ob.setFirstName("Saanvi");
		ob.setEmail("ds@gmal.com");
		ob.setProgramme("Computers");
		ob.setLasttName("D");
		ob.setCourses(course);*/
		Faker fake=new Faker();
		StudentPOJO ob=new StudentPOJO();
		List<String> course=new ArrayList<>();
		course.add("C");
		course.add("CPP");
		ob.setFirstName(fake.name().firstName());
		ob.setEmail(fake.internet().emailAddress());
		ob.setProgramme(fake.educator().course());
		ob.setLastName(fake.name().lastName());
		ob.setCourses(course);
			given()
			.when()
			.contentType(ContentType.JSON)
			.body(ob)
			.put("/101")
			.then()
			.statusCode(200);
	}
}
