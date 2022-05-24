package com.bridgelabz.restAssuredCRUD;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/* CRUD operations for JSON Server -  Resources: Comments */
/*{ "id": 1, "body": "some comment", "postId": 1 }*/

public class Rest_Comments {
       public static RequestSpecification request;
       public static Response response;

    @Test
    public void getTest_Comments() {
        response = RestAssured.get( "http://localhost:3000/comments");
        response.prettyPrint();
            System.out.println("Status Code:" + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),  200);
    }

    @Test
    public void postTest_Comments(){
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", 2);
            jsonObject.put("body", "XYZ");
            jsonObject.put("postId", 1);
        request.body(jsonObject.toJSONString());
        response = request.post("http://localhost:3000/comments");
            System.out.println("Status Code:" + response.getStatusCode());
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),  201);
    }

    @Test
    public void putTest_Comments(){
        request = RestAssured.given();
        request.header("Content-type", "application/json");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", 2);
            jsonObject.put("body", "Games");
            jsonObject.put("postId", 1);
        request.body(jsonObject.toJSONString());
        response = request.put( "http://localhost:3000/comments/2");
            System.out.println("Status Code:" + response.getStatusCode());
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),  200);
    }

    @Test
    public void deleteTest_Comments(){
        request = RestAssured.given();
        response = request.delete("http://localhost:3000/comments/2");
            System.out.println("Status Code:" + response.getStatusCode());
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),  200);
    }
}
