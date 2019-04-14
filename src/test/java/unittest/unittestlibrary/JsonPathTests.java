package unittest.unittestlibrary;

//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTests {
    @Test
    public void testAsserts(){
        String responseString = "[" +
                "  {" +
                "    \"id\": \"10000\"," +
                "    \"item\": \"Pencil\"," +
                "    \"quantity\": 5" +
                "  }," +
                "  {" +
                "    \"id\": \"10001\"," +
                "    \"item\": \"Pen\"," +
                "    \"quantity\": 10" +
                "  }," +
                "  {" +
                "    \"id\": \"10002\"," +
                "    \"item\": \"Eraser\"," +
                "    \"quantity\": 15" +
                "  }" +
                "]";

        final DocumentContext context = JsonPath.parse(responseString);
        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);

        //print elements with index 0 to 1
        //System.out.println(context.read("$.[0:2]").toString());

        //conditional Printing
        //System.out.println(context.read("$.[?(@.item=='Eraser')]").toString());

        //assert the initial quantity values of all the items
        assertThat(context.read("$..quantity").toString()).contains("5","10");

        //convert JSONArray to ArrayList
        //Gson converter = new Gson();
        //Type type = new TypeToken<List<Integer>>(){}.getType();
        //List<Integer> quantities = converter.fromJson(context.read("$..quantity").toString(), type );

        //assert if the quantities are sorted
        //assertThat(quantities).isSorted();

        //assert the sum of quantities
        //assertThat(quantities.stream().reduce(0,Integer::sum)).isEqualTo(30);
    }

    @Test
    public void test() throws Exception{
        String responseString = "{\"tool\":{\"jsonpath\":{\"creator\":" +
                "{\"name\":\"Iftekhar\",\"location\":[\"Malmo\"," +
                "\"San Francisco\",\"Helsingborg\"]}}},\"books\":[{\"title\":\"Beginning JSON\",\"price\":49.99}," +
                "{\"title\":\"JSON at Work\",\"price\":29.99}]}";

        final DocumentContext context = JsonPath.parse(responseString);

        //assert the creator
        assertThat(context.read("$['tool']['jsonpath']['creator']['name']").toString()).isEqualTo("Iftekhar");


        //assert the locations
        assertThat(context.read("$['tool']['jsonpath']['creator']['location']").toString()).contains("Malmo","San Francisco","Helsingborg");


       /* Gson converter = new Gson();
        Type type = new TypeToken<List<Float>>(){}.getType();
        List<Float> quantities = converter.fromJson(context.read("$['books']..price").toString(), type );

        //assert the sum of price
        assertThat(quantities.stream().reduce(0f,Float::sum)).isEqualTo(79.98f);*/
    }

}
