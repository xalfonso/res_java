package eas.com;
import javax.json.JsonObject;
import javax.json.JsonArray;
import javax.json.JsonValue;
import javax.json.JsonReader;
import javax.json.Json;
import javax.json.JsonStructure;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by eduardo on 11/23/2016.
 *
 * Creates json object model from file
 *
 * I do not found the way of modify jsonObject load form file, apparently is an immutable object
 */
public class MainApp {

    public static void main(String[] args) throws FileNotFoundException {


        /**
         * Reader form File
         */
        JsonReader reader = Json.createReader(new FileReader("inputModel.json"));


        /**
         * JsonStructure represent top of inheritance. The children are JsonArray and JsonObject
         */
        JsonStructure jsonStructure = reader.read();


        System.out.println(jsonStructure.toString());

        /**
         * I know that the jsonStructure is represented as JsonObject
         */
        JsonObject jsonObject = (JsonObject) jsonStructure;


        /**
         * Acceding to a property of the object by the key
         */
        System.out.println("First Name: " + jsonObject.getString("firstName"));

        System.out.println("Age : " + jsonObject.getInt("age"));


        /**
         * Get one array that exist exist the object
         */
        JsonArray jsonArray = jsonObject.getJsonArray("phoneNumbers");


        /**
         * Iterate by jsonArray
         */
        for (JsonValue value: jsonArray){
            System.out.println(value.toString());
        }

    }


}
