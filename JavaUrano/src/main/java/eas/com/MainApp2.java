package eas.com;

import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by eduardo on 11/25/2016.
 * <p>
 * Read with stream json api. Useful for large json data
 */
public class MainApp2 {


    public static void main(String[] args) throws FileNotFoundException {
        JsonParser jsonParser = Json.createParser(new FileReader("inputStream.json"));

        while (jsonParser.hasNext()) {
            JsonParser.Event event = jsonParser.next();

            /**
             * The parser is supported in events.
             */
            switch (event) {
                case START_ARRAY:
                case END_ARRAY:
                case START_OBJECT:
                case END_OBJECT:
                case VALUE_TRUE:
                case VALUE_FALSE:
                    System.out.println(event.toString());
                    break;
                case KEY_NAME:
                    /**
                     * jsonParser.getString() only available if the event is KEY_NAME, VALUE_NUMBER or VALUE_STRING
                     */
                    System.out.print(event.toString() + " KEY: " + jsonParser.getString() + " - ");
                 break ;
                case VALUE_NUMBER:
                case VALUE_STRING:
                    System.out.println("VALUE: " + jsonParser.getString());
                    break;
            }

        }
    }

}
