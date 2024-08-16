package Helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class APIBaseTest {

    public Properties properties = getProperties("src//test//resources//config.properties");

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        try{
            FileInputStream stream = new FileInputStream(fileName);
            properties.load(stream);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return properties;
    }

    public String getStringProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    public Response getResponse(String endpoint) {
        RestAssured.baseURI =getStringProperty("baseUrl");
        RequestSpecification request = RestAssured.given();
        return request.get(endpoint);
    }

    public Response postResponse(String endpoint) {
        RestAssured.baseURI =getStringProperty("baseUrl");
        RequestSpecification request = RestAssured.given();
        return request.post(endpoint);
    }
}
