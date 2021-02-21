package practicalBB;

import baseclass.BaseClass;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateData extends BaseClass {

    @Test
    void updateAddress() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("street", "High St");
        jsonObject.put("suite", "45");
        jsonObject.put("city", "London");
        jsonObject.put("zipcode", "1234");

        httpRequest.header("content-Type", "application/json");
        httpRequest.body(jsonObject.toJSONString());

        response = httpRequest.request(Method.PUT, properties.getProperty("updateRecord"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 204);
    }

    @Test
    void updateCompany() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "LLL");
        jsonObject.put("catchPhrase", "yep");
        jsonObject.put("bs", "something");

        httpRequest.header("content-Type", "application/json");
        httpRequest.body(jsonObject.toJSONString());

        response = httpRequest.request(Method.PUT, properties.getProperty("updateCompany"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 204);
    }

}

