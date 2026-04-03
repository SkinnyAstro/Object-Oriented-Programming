package restAssured;

import io.restassured.RestAssured;
import files.Body;
import io.restassured.path.json.JsonPath;
import org.apache.http.util.Asserts;
import org.testng.Assert;


import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class RestMethods {

    public static void main(String[]args) {
        //validate add address is working git push

        //given= all input details
        //when= http method,resource
        //then=validate status code
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        //given
        String response = given().log().all().queryParam("key", "qaclick123")
                .body(Body.PostAddress())
                //when
                .when().post("maps/api/place/add/json")
                //then
                .then().log().all().assertThat().statusCode(200)
        //if you want to validate any value from responce
                .body("scope",equalTo("APP"))
        //if you want to store response & want to use it later just insert new variable (response)
                .extract().response().asString(); // we are storing here response as string
                System.out.println(response);
        //now we want to convert that String response into json
                JsonPath js = new JsonPath(response);
        // want place id to use it
               String placeid= js.getString("place_id");
                System.out.println(placeid);



        //update place with new address
        String NewAddress= "70 Summer walk, USA";
                given().queryParam("key", "qaclick123")
                        .body("{\n" +
                                "\"place_id\":\""+placeid+"\",\n" +
                                "\"address\":\""+NewAddress+"\",\n" +
                                "\"key\":\"qaclick123\"\n" +
                                "}")
                        .when().put("maps/api/place/update/json")
                        .then().log().all().assertThat().statusCode(200);


        //Fetch  address
             String Address =given().queryParam("key", "qaclick123")
                     .queryParam("place_id",placeid)
                .when().get("maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200)
                 .extract().response().asString();
                System.out.println(Address);

                JsonPath j1 = new JsonPath(Address);
                String Actualaddress = j1.getString("address");
                System.out.println(Actualaddress);
        Assert.assertEquals(Actualaddress,NewAddress);




    }
}
