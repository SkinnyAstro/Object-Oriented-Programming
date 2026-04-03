package files;

import io.restassured.path.json.JsonPath;

public class ComplexJasonParse {
    public static void main (String [] args)
    {
        JsonPath js1 = new JsonPath(Body.Complexcode());
//print purchaseAmount
        { System.out.println("print purchaseAmount");
       int purchaseAmount= js1.getInt("dashboard.purchaseAmount");
       System.out.println(purchaseAmount);}
//print title
        {  System.out.println("print  title which is in 2nd index");
            String title= js1.getString("courses[2].title");
        System.out.println(title);}

 //no of courses
        { System.out.println("Total no of courses");
            int count=js1.getInt("courses.size()");
            System.out.println(count);
//titles & there prices
        { System.out.println("titles & there prices");
        for (int i=0;i<count;i++)
        {
        String NameCouserse= js1.getString("courses["+i+"].title");
        System.out.println(NameCouserse);
        System.out.println(js1.getInt("courses["+i+"].price"));}
//no of copies sold by Cypress
        System.out.println("no of copies sold by Cypress");
         for (int j=0;j<count;j++) {
             String CourseTitle = js1.getString("courses[" + j + "].title");
             if (CourseTitle.equalsIgnoreCase("Cypress")) {
                 int copies = js1.get("courses[" + j + "].copies");
                 System.out.println(copies);
                 break;
             }
         }}}}}
