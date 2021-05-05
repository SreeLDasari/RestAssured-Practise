package practice2;


import java.util.ArrayList;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

public class httpverbs {

	public static void main(String[] args) {

		ArrayList<String> res=RestAssured.given()
					.when()
					.get("http://localhost:8085/student/list")
					.then()
					.extract()
					.path("firstName");
		System.out.println(res);
		Response r1=RestAssured.given()
				.when()
				.get("http://localhost:8085/student/list");
		
		JsonPath js=r1.jsonPath();
		String f=js.get("firstName").toString();
		System.out.println(f);
		ValidatableResponse s=r1.then().body("firstName",equalTo("Amal"));
		System.out.println(s);
					
	}

}
