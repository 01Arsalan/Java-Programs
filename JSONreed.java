
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;


public class JSONread
{
  public static void main(String[] args)
  {
    System.out.print("Start.");
    JSONParser parser = new JSONParser();
      try {
         Object obj = parser.parse(new FileReader("/Users/arsalanwani/Downloads/Employee_Data.json"));
         JSONObject jsonObject = (JSONObject)obj;

         

         JSONArray data = (JSONArray)jsonObject.get("data");

         Iterator iterator = data.iterator();

         
         while (iterator.hasNext()) {
            
         int id=(int)jsonObject.get("id");
         String first_name = (String)jsonObject.get("first_name");
         String last_name = (String)jsonObject.get("last_name");
         String email = (String)jsonObject.get("email");
         String gender = (String)jsonObject.get("gender");
         String country = (String)jsonObject.get("country");
         String phone = (String)jsonObject.get("phone");
         String address = (String)jsonObject.get("address");
         System.out.println("First Name: " + first_name+"\tLast name: "+last_name+"\tEmail: "+email+"\tGender: "+gender+"\tCountry: "+country+"\tPhone no: "+phone+"\tAddress: "+address+"\n\n");

            System.out.println(iterator.next());
         }
      } catch(Exception e) {
         e.printStackTrace();
      }
    


  }
}
