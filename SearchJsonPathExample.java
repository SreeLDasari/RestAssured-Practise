import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class SearchJsonPathExample {

	static final String APIKEY="75e3u4sgb2khg673cbv2gjup";
	
	@BeforeAll
	public static void init() {
		baseURI="http://api.walmartlabs.com";
		basePath="/v1";
	
	}
	@Test
	public void test001() {
	int numitems=	given()
		.queryParam("query", "ipod")
		.queryParam("apiKey", APIKEY)
		.queryParam("format", "json")
		.when()
		.get("/search")
		.then()
		//.log().body();
		.extract().path("numItems");
	System.out.println(numitems);
	}
	@Test
	public void test002() {
		String queryValue=	given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then()
				//.log().body();
				.extract().path("query");
			System.out.println(queryValue);
	}
	@Test
	public void test003() {
		given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then()
				//.log().body();
				.extract().path("query");
			System.out.println();
	}
}
