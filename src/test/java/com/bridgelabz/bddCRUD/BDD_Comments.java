package com.bridgelabz.bddCRUD;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

/* CRUD operations for JSON Server using BDD -  Resources: Comments */
/*{ "id": 1, "body": "some comment", "postId": 1 }*/

public class BDD_Comments {

    @Test
    public void getTest_Comments_With_RestAssured() {
        Response response = given().header("Content-Type", "application/json").
                when().get("http://localhost:3000/posts/1/comments");
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getTest_Comments_With_RestAssured1() {
        Response response = given().header("Content-Type", "application/json").
                when().get("http://localhost:3000/comments");
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void postTest_Comments() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 2);
        jsonObject.put("body", "JSON");
        jsonObject.put("postId", 1);

        given().
                header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).
                when().post("http://localhost:3000/comments").then().statusCode(201);
    }

    @Test()
    public void putTest_Comments() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 1);
        jsonObject.put("postId", 1);
        jsonObject.put("body", "Modified Postman again");

        given().
                header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).
                when().put("http://localhost:3000/comments/1").then().statusCode(200);
    }

    @Test
    public void deleteTest_Comments() {
        given().
                header("Content-Type", "application/json").
                when().delete("http://localhost:3000/comments/2").then().statusCode(200);

    }
}
