package restAssured;

import io.restassured.RestAssured;
import files.Body;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class PostAddress {

    public static void main(String[]args)
    {
        //validate add address is working git push

        //given= all input details
        //when= http method,resource
        //then=validate status code
        RestAssured.baseURI="https://stage-qa.truemedsapi.in";
        String response= given().log().all().queryParam("customerId","51755")
                .queryParam("addressId","5273777")
                .header("Authorization","Bearer "+ "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNqqViouTVKyUrI0NjcwsLAwsTRT0lEqzi8tSk4Fiob4xoe7OgV7hrjGh8Wb6Bma6BkApYvyc1J9MotLlKyilYL8fVzjnUODQ_x9XYOUYnWUUisKlKwMLQyMgGZZmhjoKGUmAhUampsbGhsaAwVqAQAAAP__.cmh59K3Og-q1GcwkV1vU1nmZyG8EkMdGYC1Gv7bpAWAiiKD5J45Y1dZslPNHSdGFw8ejfaNnc6H-F8-_l0kZ6A")
                .contentType("application/json")
                .body(Body.PostAddress())
                .when().post("CustomerService/v1/saveAddress")
                .then().assertThat().statusCode(200)
                .extract().response().asString();

        System.out.println(response);
        JsonPath js = new JsonPath(response);
        String responseData= js.getString("responseData.addressId");
        System.out.println(responseData);

        //Put method

        given().log().all().queryParam("customerId","51755")
                .header("Authorization","Bearer "+ "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNqqViouTVKyUrI0NjcwsLAwsTRT0lEqzi8tSk4Fiob4xoe7OgV7hrjGh8Wb6Bma6BkApYvyc1J9MotLlKyilYL8fVzjnUODQ_x9XYOUYnWUUisKlKwMLQyMgGZZmhjoKGUmAhUampsbGhsaAwVqAQAAAP__.cmh59K3Og-q1GcwkV1vU1nmZyG8EkMdGYC1Gv7bpAWAiiKD5J45Y1dZslPNHSdGFw8ejfaNnc6H-F8-_l0kZ6A")
                .header("content-type","application/json")
                .body("{\"addressId\":5273895,\"addressType\":\"Pune\",\"addressline1\":\"Kolhapur\",\"addressline2\":\"Punjab\",\"cityName\":\"Mumbai\",\"landmark\":\"\",\"pincode\":\"400072\",\"stateName\":\"MAHARASHTRA\",\"receiverName\":\"\",\"receiverMobileNo\":\"9370088496\",\"receiverFirstName\":\"Aama\",\"receiverLastName\":\"Banakma\",\"latitude\":0,\"longitude\":0,\"placeId\":null,\"recalcLocation\":true}")
                .when().post("CustomerService/v1/saveAddress")
                .then().log().all().assertThat().statusCode(200);

        //Get Method

        given().log().all().queryParam("customerId","51755")
                .header("Authorization","Bearer "+ "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNqqViouTVKyUrI0NjcwsLAwsTRT0lEqzi8tSk4Fiob4xoe7OgV7hrjGh8Wb6Bma6BkApYvyc1J9MotLlKyilYL8fVzjnUODQ_x9XYOUYnWUUisKlKwMLQyMgGZZmhjoKGUmAhUampsbGhsaAwVqAQAAAP__.cmh59K3Og-q1GcwkV1vU1nmZyG8EkMdGYC1Gv7bpAWAiiKD5J45Y1dZslPNHSdGFw8ejfaNnc6H-F8-_l0kZ6A")
                .header("content-type","application/json")
                .when().get("CustomerService/v1/fetchAllAddress")
                .then().log().all().assertThat().statusCode(200);
    }
}
