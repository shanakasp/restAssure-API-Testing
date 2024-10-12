package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class GetAndPost {

//	@Test
	public void testget() {
		
		baseURI = "https://reqres.in/api";
		
		given()
		.get("/users?page=2")
		.then()
		.statusCode(200).
		body("data[4].first_name",equalTo("George")).
		body("data.first_name", hasItems("George" , "Rachel"));
	}
	
	@Test
	public void testPost() {
		baseURI = "https://reqres.in/api";
		
		
		JSONObject request = new JSONObject();
		
		request.put("name", "user1");
		request.put("job", "job1");
		
		System.out.println(request.toJSONString());
		
		given().
		body(request.toJSONString()).
		when().
		post("/users").
		then().
		statusCode(201).log().all();
	}
}
