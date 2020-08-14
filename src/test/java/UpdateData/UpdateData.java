package UpdateData;

import baseclass.BaseClass;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateData extends BaseClass {

    @Test
    void updateUserAddress()
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("city", "Riga");
        jsonObject.put("street", "Krisjana Barona iela 23");
        jsonObject.put("suite", "55");
        jsonObject.put("zipcode", "LV-1011");

        httpRequest.header("content-Type", "application/json");
        httpRequest.body(jsonObject.toJSONString());
        response = httpRequest.request(Method.PUT,properties.getProperty("updateRecord"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,204);
    }
}
