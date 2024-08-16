package tests;

import Helpers.APIBaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import responseDto.Dog;

import java.util.Collections;
import java.util.List;

public class BreedsTest extends APIBaseTest {
Response response;
    @Test
    public void getBreeds(){
        String breedsEndpoint = getStringProperty("GET_BREEDS_BY_LIMIT_PAGE");
        response = getResponse(breedsEndpoint);
        List<Dog> dogsList = Collections.singletonList(response.as(Dog.class));
        dogsList.forEach(x -> Assert.assertNotNull(x.getName()));

    }
}
