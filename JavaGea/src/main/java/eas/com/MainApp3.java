package eas.com;

import eas.com.entity.Library;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by eduardo on 11/21/2016.
 *
 * For convert From XML to compose  Java Object (No different with the simple Object)
 */
public class MainApp3 {
    public static void main(String[] args) throws JAXBException {
        /* File for Reading */
        File file = new File("library.xml");

         /* init jaxb unmarshaller */
        JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        /* unmarshaller xml to java object */
        Library library = (Library) jaxbUnmarshaller.unmarshal(file);

        /* print java object*/
        System.out.println(library);
    }
}
