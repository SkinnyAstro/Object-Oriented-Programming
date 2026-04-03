package files;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Sumvalidation {
@Test
    public void Sumofall() {

       JsonPath js = new JsonPath(Body.Complexcode());
       int count = js.getInt("courses.size()");
        System.out.println(count);

         int sum =0;
        for (int i=0;i<count;i++) {
            int prices = js.getInt("courses[" + i + "].price");
            int amount = js.getInt("courses[" + i + "].copies");
            int total = prices * amount;
            sum=total+sum;
            System.out.println(sum);
        }
            int purchase= js.getInt("dashboard.purchaseAmount");
            Assert.assertEquals(sum,purchase);

             }
        }




