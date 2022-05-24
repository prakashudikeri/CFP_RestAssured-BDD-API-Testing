package com.bridgelabz.restAssuredReqresWeb;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

/* Sample Get Method for given http -  Reqres  */

public class Get_Method {
    public static Response response;

    @Test
    public void getTest_Web(){
        response = RestAssured.get( "https://reqres.in/api/users?page=2/");
            System.out.println("Status Code: " + response.getStatusCode());
            System.out.println("Response as String: " +response.asString());
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),  200);
    }

    @Test
    public void getTest_Web_Total(){
        RestAssured.given().when().get("https://reqres.in/api/users?page=2").
                then().body("total",equalTo(12));
    }

    @Test
    public void getTest_Web_Email(){
        RestAssured.given().when().get("https://reqres.in/api/users?page=2").then()
                .body("data.email[0]", equalTo("michael.lawson@reqres.in"));
    }
}

