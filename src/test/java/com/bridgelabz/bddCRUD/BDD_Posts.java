package com.bridgelabz.bddCRUD;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/* CRUD operations for JSON Server using BDD -  Resources: Posts */
/*{ "id": 1, "title": "json-server", "author": "typicode" }*/

public class BDD_Posts {

    @Test
    public void getTest_Posts_With_RestAssured() {
        Response response = given().header("Content-Type", "application/json").
                            when().get("http://localhost:3000/posts");
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
    }

    @Test()
    public void postTest_Posts() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 22);
        jsonObject.put("title", "Postman");
        jsonObject.put("author", "Rest");

        given().
                header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).
                when().post("http://localhost:3000/posts/").then().statusCode(201);
    }

    @Test()
    public void putTest_posts() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", "New World");
        jsonObject.put("author", "Order");

        given().
                header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).
                when().put("http://localhost:3000/posts/22").then().statusCode(200);

    }

    @Test()
    public void deleteTest() {
        given().
                header("Content-Type", "application/json").
                when().delete("http://localhost:3000/posts/1").then().statusCode(200);

    }
}
