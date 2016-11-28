package eas.com;

import eas.com.entity.Author;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by eduardo on 11/21/2016.
 * <p>
 * FROM XML to simple Java Object
 */
public class MainApp2 {

    public static void main(String[] args) throws JAXBException {

        File file = new File("author.xml");

        JAXBContext jaxbContext = JAXBContext.newInstance(Author.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Author author = (Author) jaxbUnmarshaller.unmarshal(file);

        System.out.println(author);
    }
}
