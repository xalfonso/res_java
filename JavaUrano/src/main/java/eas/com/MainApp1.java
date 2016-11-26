package eas.com;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by eduardo on 11/24/2016.
 *
 * Creates json object model from java code and send the json mode to Writer stream
 */
public class MainApp1 {

    public static void main(String[] args) throws IOException {


        /**
         * Build json object
         */
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("firstName", "Eduardo")
                .add("secondName", "")
                .add("firstSurname", "Alfonso")
                .add("secondSurname", "Sanchez")
                .add("grades", Json.createObjectBuilder()
                .add("math", 5)
                .add("lang", 4)
                .add("phy", 5))
                .add("index", Json.createArrayBuilder()
                .add(4)
                .add(6)
                .add(10)).build();

        /**
         * Send the model data to Stream System.out
         */
        JsonWriter jsonWriter = Json.createWriter(System.out);
        jsonWriter.writeObject(jsonObject);
        jsonWriter.close();


        /**
         * Send the model data to Stream File
         */
        JsonWriter jsonWriter1 = Json.createWriter(new FileWriter("outputModel.json"));
        jsonWriter1.writeObject(jsonObject);
        jsonWriter1.close();



    }

}
