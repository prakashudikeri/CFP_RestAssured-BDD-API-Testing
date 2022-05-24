package com.bridgelabz.bddCRUD;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


/* CRUD operations for JSON Server using BDD -  Resources: Profile*/
/*"profile": { "name": "typicode" }*/

public class BDD_Profile {

        @Test
        public void getTest_Profile_With_RestAssured() {
            Response response = given().header("Content-Type", "application/json").
                    when().get("http://localhost:3000/profile");
            response.then().assertThat().statusCode(200);
            response.prettyPrint();
        }

        @Test()
        public void postTest_Profile() {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "JSON");

            given().
                    header("Content-Type", "application/json").
                    body(jsonObject.toJSONString()).
                    when().post("http://localhost:3000/profile").then().statusCode(201);
        }

        @Test()
        public void putTest_Profile() {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "Postman");

            given().
                    header("Content-Type", "application/json").
                    body(jsonObject.toJSONString()).
                    when().put("http://localhost:3000/profile").then().statusCode(200);
        }

        @Test()
        public void deleteTest_Profile() {
            given().
                    header("Content-Type", "application/json").
                    when().delete("http://localhost:3000/profile").then().statusCode(200);
        }
}

