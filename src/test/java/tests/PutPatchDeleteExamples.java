package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchDeleteExamples {

	@Test
	public void testPut() {
		baseURI = "https://reqres.in/api";
		
		
		JSONObject request = new JSONObject();
		
		request.put("name", "user1");
		request.put("job", "job1");
		
		System.out.println(request.toJSONString());
		
		given().
		body(request.toJSONString()).
		when().
		put("/users/2").
		then().
		statusCode(200).log().all();
	}
	
	@Test
	public void testPatch() {
		baseURI = "https://reqres.in/api";
		
		
		JSONObject request = new JSONObject();
		
		request.put("name", "user133");
		request.put("job", "job1");
		
		System.out.println(request.toJSONString());
		
		given().
		body(request.toJSONString()).
		when().
		patch("/users/2").
		then().
		statusCode(200).log().all();
	}
	
	@Test
	public void testDelete() {
		baseURI = "https://reqres.in/api";
				
	 given().
		when().
		delete("/users/2").
		then().
		statusCode(204).log().all();
	}
	
}
