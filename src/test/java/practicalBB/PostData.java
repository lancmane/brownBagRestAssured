package practicalBB;

import baseclass.BaseClass;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostData extends BaseClass {

    @Test
    void createNewEmployee() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Ligaa");
        jsonObject.put("userName", "LigaL");
        jsonObject.put("email", "liga@liga.com");
        jsonObject.put("address", "Address 123");
        jsonObject.put("phone", "12345678");
        jsonObject.put("website", "www.thisiswebsite.com");

        httpRequest.header("content-Type", "application/json");
        httpRequest.body(jsonObject.toJSONString());

        response = httpRequest.request(Method.POST,properties.getProperty("postData"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,201);
    }

    @Test
    void createNewToDo() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", "WhatToDoNow");

        httpRequest.header("content-Type", "application/json");
        httpRequest.body(jsonObject.toJSONString());

        response = httpRequest.request(Method.POST,properties.getProperty("postToDo"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,201);
    }
}
