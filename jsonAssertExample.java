import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class jsonAssertExample {
	
	@Test
	public void getStudents() throws IOException, JSONException{
		String expected=new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+
							File.separator+"file.txt")));
	String actual=given().when().get("http://localhost:8085/student/list").asString();

		System.out.println(expected);
		System.out.println(actual);
		Assertions.assertEquals(expected, actual);
		JSONAssert.assertEquals(expected, actual, JSONCompareMode.LENIENT);

	}
	@Test
	public void getStudentsStrict() throws IOException, JSONException{
		String expected=new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+
							File.separator+"file.txt")));
	String actual=given().when().get("http://localhost:8085/student/list").asString();

		System.out.println(expected);
		System.out.println(actual);
		Assertions.assertEquals(expected, actual);
		JSONAssert.assertEquals(expected, actual, JSONCompareMode.STRICT);

	}
	

}
