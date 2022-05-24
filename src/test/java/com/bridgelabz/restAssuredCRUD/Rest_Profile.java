package com.bridgelabz.restAssuredCRUD;


/* CRUD operations for JSON Server -  Resources: Profile */
/*"profile": { "name": "typicode" }*/

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Rest_Profile {
        public static RequestSpecification request;
        public static Response response;

    @Test
    public void getTest_Profile() {
        response = RestAssured.get( "http://localhost:3000/profile");
        response.prettyPrint();
            System.out.println("Status Code:" + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),  200);
    }

    @Test
    public void postTest_Profile(){
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "Prakash");
        request.body(jsonObject.toJSONString());
        response = request.post("http://localhost:3000/profile");
            System.out.println("Status Code:" + response.getStatusCode());
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),  201);
    }

    @Test
    public void putTest_Profile(){
        request = RestAssured.given();
        request.header("Content-type", "application/json");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "Prakash Udikeri");
        request.body(jsonObject.toJSONString());
        response = request.put( "http://localhost:3000/profile");
            System.out.println("Status Code:" + response.getStatusCode());
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),  200);
    }

    @Test
    public void deleteTest_Profile(){
        request = RestAssured.given();
        response = request.delete("http://localhost:3000/profile");
            System.out.println("Status Code:" + response.getStatusCode());
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),  404);
    }

}
