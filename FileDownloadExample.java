import static io.restassured.RestAssured.basePath;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*;

public class FileDownloadExample {

	@Test
	public void verifyDownloadableFile() {
		File inputFile=new File(System.getProperty("user.dir")+File.separator+"geckodriver-v0.29.0-linux32.tar.gz");
		
		int expectedSize=(int)inputFile.length();
		System.out.println("Size of expected file is  "+expectedSize+"  bytes");
		

		byte[] actualValue=	given()
				.when()
				.get("https://github.com/mozilla/geckodriver/releases/download/v0.29.0/geckodriver-v0.29.0-linux32.tar.gz")
				.then()
				.extract()
				.asByteArray();
		int actualsize=(int)actualValue.length;
		
		
		System.out.println("Size of actual file is  "+actualsize+"  bytes");
		
		assertThat(expectedSize,equalTo(actualsize));

	}

	private void assertThat(int expectedSize, Matcher<Integer> equalTo) {
		
	}
}
