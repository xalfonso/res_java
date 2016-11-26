package eas.com;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by eduardo on 11/26/2016.
 * <p>
 * Write with stream json api. Useful for large json data.
 */
public class MainApp3 {

    public static void main(String[] args) throws IOException {


        /**
         * Example 1
         * This example is not pretty representative of json stream. See the next example when i am sending info continually
         */
       /* JsonGenerator jsonGenerator = Json.createGenerator(new FileWriter("outputStream.json"));
        jsonGenerator.writeStartObject()
                .write("name", "Eduardo Alfonso")
                .write("age", 31)
                .write("smoke", false)
                  .writeStartArray("grades")
                      .writeStartObject()
                        .write("math", 100)
                        .write("lang", 97)
                      .writeEnd()
                      .writeStartObject()
                        .write("math", 100)
                        .write("lang", 96)
                      .writeEnd()
                  .writeEnd()
             .writeEnd()
             .close();
*/

        /**
         * Example 2
         * This example send the data part by part until the user stop (select n in the option)
         */
        JsonGenerator jsonGenerator1 = Json.createGenerator(new FileWriter("outputStream1.json"));
        jsonGenerator1.writeStartObject()
                .write("name", "Eduardo Alfonso")
                .write("age", 31)
                .write("smoke", false)
                .writeStartArray("grades");

        String option = "s";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while ("s".equals(option)) {
            System.out.println("Writing Data...");
            jsonGenerator1
                    .writeStartObject()
                    .write("math", 100)
                    .write("lang", 97)
                    .writeEnd()
                    .flush(); /*Send to the file the data that exist until now*/

            System.out.println("Do you want to continue s/n");
            option = reader.readLine();
        }

        System.out.println("Finished Stream");
        jsonGenerator1.writeEnd()
                .writeEnd()
                .close(); /* close the stream to the file*/

        reader.close();

    }
}
