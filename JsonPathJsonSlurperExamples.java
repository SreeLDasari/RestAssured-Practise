import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.ValidatableResponse;

public class JsonPathJsonSlurperExamples {

	static ValidatableResponse validatableResponse;

	@BeforeAll
	public static void init() {
	
	//	http://localhost:8085/student/list
		baseURI="http://localhost";
		port=8085;
		basePath="/student";
		validatableResponse=given().when().get("/list").then();
	
	}
	@Test
	public void getRoot() {
	
	//	given().when().get("/list").then().statusCode(200);
		ArrayList<Integer> id=validatableResponse.extract().path(("id"));
		
		System.out.println((id.toString()));
		ArrayList<String> prg=validatableResponse.extract().path(("programme"));
		
		System.out.println((prg.toString()));
		
		ArrayList<String> course=validatableResponse.extract().path(("courses[2]"));
		
		System.out.println((course.toString()));
		Map<String,?> info=validatableResponse.extract().path("find{it.id==2}");
		System.out.println(info.toString());
		
		String email=validatableResponse.extract().path("find{it.id==2}.email");
		System.out.println(email);
		
		Map<Integer,?> maxid=validatableResponse.extract().path("max{it.id}");
		System.out.println(maxid);
		
		String name=validatableResponse.extract().path("max{it.id}.firstName");
		System.out.println(name);
		

		Map<Integer,?> minid=validatableResponse.extract().path("min{it.id}");
		System.out.println(minid);
		
		String fName=validatableResponse.extract().path("min{it.id}.firstName");
		System.out.println(fName);

	}
}
