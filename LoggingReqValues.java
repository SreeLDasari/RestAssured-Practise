import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
public class LoggingReqValues extends TestBase{

	@Test
	public void test001() {
		given()
		.log()
		.headers()
		.when()
		.get("/1")
		.then()
		.statusCode(200);
	}
	@Test
	public void test002() {
		given()
		.param("programme", "Computer Science")
		.param("limit", 1)
		.log()
		.params()
		.when()
		.get("/list")
		.then()
		.statusCode(200);
	}
	@Test
	public void test003() {
		System.out.println("----------Request body----------");
		StudentPOJO ob=new StudentPOJO();
		List<String> course=new ArrayList<>();
		course.add("C");
		course.add("CPP");
		ob.setFirstName("Saanvi");
		ob.setEmail("ds@gmal.com");
		ob.setProgramme("Computers");
		ob.setLastName("D");
		ob.setCourses(course);
		given()
		.log()
		.body()
		.when()
		.body(ob)
		.post();
		
	}
	@Test
	public void test004() {
		System.out.println("----------Print all the request details----------");
		StudentPOJO ob=new StudentPOJO();
		List<String> course=new ArrayList<>();
		course.add("C");
		course.add("CPP");
		ob.setFirstName("Saanvi");
		ob.setEmail("ds@gmal.com");
		ob.setProgramme("Computers");
		ob.setLastName("D");
		ob.setCourses(course);
		given()
		.log()
		.all()
		.when()
		.body(ob)
		.post();
		
	}
	@Test
	public void test005() {
		System.out.println("----------Print all the request details if validation fails----------");
		StudentPOJO ob=new StudentPOJO();
		List<String> course=new ArrayList<>();
		course.add("C");
		course.add("CPP");
		ob.setFirstName("smayan");
		ob.setEmail("daas@gmal.com");
		ob.setProgramme("Computers Sc");
		ob.setLastName("D");
		ob.setCourses(course);
		given()
		.contentType(ContentType.JSON)
		.log()
		.ifValidationFails()
		.when()
		.body(ob)
		.post()
		.then()
		.statusCode(201);
		
	}
}
