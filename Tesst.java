
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;
public class Tesst extends TestBase{

	private void styles() {
		RestAssured.given()
		.queryParam("", "")
		.when()
		.get("https://www.google.com/")
		.then();
		
		RestAssured.given()
			.expect()
			.when();
				
	}
	//@DisplayName("Getting all the student names from database")
	@org.junit.jupiter.api.Test
	void getAllStudents() {
		/*
		RequestSpecification req=RestAssured.given();
		//https://petstore.swagger.io/v2/pet/findByStatus?status=available
		Response response=req.get("http://localhost:8085/student/list");
	
		response.prettyPrint();
		
		ValidatableResponse validateResponse=response.then();
		validateResponse.statusCode(200);
		
		RestAssured.given()
					.when()
					.get("http://localhost:8085/student/list")
					.then()
					.statusCode(200);*/
		//RestAssured.
					given()
					.expect()
					.statusCode(200)
					.when()
					.get("/list");
	}
	//@Disabled
	@org.junit.jupiter.api.Test
	void getsingleRec() {
		/*
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("programme", "Medicine");
		params.put("limit", 1);

		params.entrySet().stream().forEach(i->System.out.println(i));
		
		for(Map.Entry<String,Object> m:params.entrySet())
		{
			Response res=given()
					.queryParam(m.getKey(),m.getValue())
					.when()
					.get("http://localhost:8085/student/list");
			res.prettyPrint();
		}*/
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("programme", "Medicine");
		params.put("limit", 1);
		Response res=given()
				.queryParams(params)
				.when()
				.get("/list");
		res.prettyPrint();
	}
	@org.junit.jupiter.api.Test
	void getFirstStudent() {
		Response response=given()
		.pathParam("id", 2)
		.when()
		.get("/{id}");
		
		response.prettyPrint();
		/*
		RestAssured.reset();
		Response response2=given()
				.pathParam("id", 2)
				.when()
				.get("/{id}");
				
				response2.prettyPrint();
				*/
		
	}
	
}
