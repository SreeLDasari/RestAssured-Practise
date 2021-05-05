import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.List;

import org.apache.commons.io.output.WriterOutputStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class FilterExamples {


	public static StringWriter reqWriter;
	public static PrintStream reqCapture;
	
	public static StringWriter resWriter;
	public static PrintStream resCapture;
	
	@BeforeAll
	public static void init() {

		baseURI="http://localhost";
		port=8085;
		basePath="/student";
	}
	
	@BeforeEach
	public  void beforeEachTest() {
		reqWriter = new StringWriter();
		reqCapture =new PrintStream(new WriterOutputStream(reqWriter),true);
		
		resWriter = new StringWriter();
		resCapture =new PrintStream(new WriterOutputStream(resWriter),true);
		
	}
	
	@Test
	public void test001() {
	
		String response=given()
						.when()
						.get("/list")
						.asString();
		//System.out.println(response);
						given()
						.filter(new RequestLoggingFilter(reqCapture))
						.filter(new ResponseLoggingFilter(resCapture))
						.when()
						.get("/list");
			System.err.println(reqWriter.toString());	
			System.err.println(resWriter.toString());			

	}
}
