package files;

import io.restassured.path.json.JsonPath;
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
            sum = prices * amount;
            System.out.println(sum);
        }
            System.out.println("Sum of all");
            int purchase= js.getInt("dashboard.purchaseAmount");
            int SumAll = sum+purchase;
            System.out.println(SumAll);
        }


    }

