package org.example;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;
public class Basics {

    public static void main(String[]args)
    {
        //validate add address is working git push

        //given= all input details
        //when= httpmethod,resourse
        //then=validate status code
        RestAssured.baseURI="https://stage-qa.truemedsapi.in";
        given().log().all().queryParam("customerId","51637","addressId","5273777")
                .header("Authorization","Bearer "+ "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNqqViouTVKyUrI0NjcwsLAwsTRT0lEqzi8tSk4Fiob4xoe7OgV7hrjGh8Wb6Bma6BkApYvyc1J9MotLlKyilYL8fVzjnUODQ_x9XYOUYnWUUisKlKwMLQyMgGZZmhjoKGUmAhUampsbGhsaAwVqAQAAAP__.cmh59K3Og-q1GcwkV1vU1nmZyG8EkMdGYC1Gv7bpAWAiiKD5J45Y1dZslPNHSdGFw8ejfaNnc6H-F8-_l0kZ6A")
                .contentType("application/json")
                .body("{\n" +
                        "    \"addressId\": null,\n" +
                        "    \"addressType\": \"Pune\",\n" +
                        "    \"addressline1\": \"Kolhapur\",\n" +
                        "    \"addressline2\": \"Ansa Industrial Estate, Marol, Saki Naka\",\n" +
                        "    \"cityName\": \"Mumbai\",\n" +
                        "    \"landmark\": \"\",\n" +
                        "    \"pincode\": \"400072\",\n" +
                        "    \"stateName\": \"MAHARASHTRA\",\n" +
                        "    \"receiverName\": \"\",\n" +
                        "    \"receiverMobileNo\": \"9370088496\",\n" +
                        "    \"receiverFirstName\": \"Aama\",\n" +
                        "    \"receiverLastName\": \"Banakma\",\n" +
                        "    \"latitude\": null,\n" +
                        "    \"longitude\": null,\n" +
                        "    \"placeId\": null,\n" +
                        "    \"recalcLocation\": true\n" +
                        "}")
                .when().post("CustomerService/v1/saveAddress")
                .then().log().all().assertThat().statusCode(200);



    }
}
