package restAssured;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class AddMed {

    public static void main(String[]args)
    {
        //validate add address is working git push

        //given= all input details
        //when= httpmethod,resourse
        //then=validate status code
        RestAssured.baseURI="https://stage-qa.truemedsapi.in";
        given().log().all().queryParam("customerId","51637")
                .queryParam("pincode","400072")
                .queryParam("srcTypeId","303")
                .queryParam("newAlgo","true")
                .queryParam("variantId","10")
                .queryParam("newDeliveryCharge","true")
                .queryParam("addressId","5273777")
                .queryParam("applyTmCash","false")
                .queryParam("pageName","empty-cart")
                .queryParam("source","app")
                .queryParam("version","9.0.0")
                .queryParam("orderId","0")
                .queryParam("offerId","0")
                .header("Authorization","Bearer "+ "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNqqViouTVKyUrI0NjcwsLAwsTRT0lEqzi8tSk4Fiob4xoe7OgV7hrjGh8Wb6Bma6BkApYvyc1J9MotLlKyilYL8fVzjnUODQ_x9XYOUYnWUUisKlKwMLQyMgGZZmFrqKGUmAhUampsbGhsaAwVqAQAAAP__.-WCVxG8NbWJxjrCOIoEyqS5RFBp6mbdeJyYpShrUAOqG3DkJjuUneLe9K_7IkxdeJn5dT5bZjrX9Qv6aZ0no3Q")
                .contentType("application/json")
                .body("[{\"medicineName\":\"Iodex Balm 40gm\",\"productCode\":\"TM-OINT1-000934\",\"cxAcceptedSubs\":false,\"cxOrgAdded\":false,\"isKeepOrg\":false,\"quantity\":3}]")
                .when().post("OrderManagementService/v1/saveMedsAndCreateOrder")
                .then().log().all().assertThat().statusCode(200);





    }
}

