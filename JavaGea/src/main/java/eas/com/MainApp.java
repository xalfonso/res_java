package eas.com;

import eas.com.entity.Author;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Created by eduardo on 11/20/2016.
 *
 * Create a simple xml of Author class
 */
public class MainApp {

    public static void main(String[] args) throws JAXBException {


        Author author = new Author("Nelson", "Miguel", "Francis", "Laredo", 150, 2000.36f, "Adventure");

        /* init jaxb marshaller */
        JAXBContext jaxbContext = JAXBContext.newInstance(Author.class);
        Marshaller marshaller = jaxbContext.createMarshaller();

        /* set this flag to true to format the output */
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        /* marshaling of java objects in xml (output to file and standard output) */
        marshaller.marshal(author, System.out);
        marshaller.marshal(author, new File("author.xml"));

    }

}
