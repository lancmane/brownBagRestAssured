package simpleGetTest;

import baseclass.BaseClass;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleGetTest extends BaseClass {

    @Test
    void requestToServer()
    {
        response = httpRequest.request(Method.GET, properties.getProperty("getAllUser"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

    @Test
    void getSinglePersonData() {
        response = httpRequest.request(Method.GET, properties.getProperty("getSingleEmployeeData"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
        String responseBody = response.getBody().asString();
        Assert.assertEquals(responseBody.contains("LigaL"), true);
    }

    @Test
    void getSinglePersonDataVerifyByName() {
        response = httpRequest.request(Method.GET, properties.getProperty("getSingleEmployeeData"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
        JsonPath jsonPath = response.jsonPath();
        String validateName = jsonPath.get("name").toString();
        Assert.assertEquals(validateName.contains("Ligaa"),true);
    }

    @Test
    void getSinglePersonDataById() {
        response = httpRequest.request(Method.GET, properties.getProperty("getSingleEmployeeDataById"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
        JsonPath jsonPath = response.jsonPath();
        String validateName = jsonPath.get("name").toString();
        Assert.assertEquals(validateName.contains("Ligaa"),true);
    }

    @Test
    void getSinglePersonDataVerifyAddressChange() {
        response = httpRequest.request(Method.GET, properties.getProperty("getSingleEmployeeData"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
        JsonPath jsonPath = response.jsonPath();
        String validateAddress = jsonPath.get("address").toString();
        Assert.assertEquals(validateAddress.contains("London"),true);
    }

    @Test
    void getSinglePersonDataVerifyCompany() {
        response = httpRequest.request(Method.GET, properties.getProperty("getSingleEmployeeData"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
        JsonPath jsonPath = response.jsonPath();
        String validateCompany = jsonPath.get("company").toString();
        Assert.assertEquals(validateCompany.contains("LLL"),true);
    }

    @Test
    void retrieveToDos()
    {
        response = httpRequest.request(Method.GET, properties.getProperty("getToDos"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

}
