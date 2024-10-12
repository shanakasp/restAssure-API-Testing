package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;  
import static org.hamcrest.Matchers.*;  
import io.restassured.response.Response;

public class TestsExamples {

    @Test
    public void test1() {

        
        Response response = get("https://reqres.in/api/users?page=2");

      
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Time: " + response.getTime());
        System.out.println("Response Body: " + response.asString());

       
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void test2() {
      
        baseURI = "https://reqres.in/api";

  
        given().
            get("/users?page=2").
        then().
            statusCode(200).   
            body("data[1].id", equalTo(10)).log().all(); 
    }
}
