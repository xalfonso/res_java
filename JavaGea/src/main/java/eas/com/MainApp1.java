package eas.com;

import eas.com.entity.Author;
import eas.com.entity.Library;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Created by eduardo on 11/21/2016.
 *
 * Create the xml from Library class. More complex because the library object have a collections of authors
 */
public class MainApp1 {

    public static void main(String[] args) throws JAXBException {

        Author author = new Author("Javier", "Lorenzo", "Fernandez", "Perez", 150, 2000.36f, "Adventure");
        Author author1 = new Author("Martha", "Paula", "Martinez", "Pozo", 300, 547.26f, "Horror");
        Author author2 = new Author("Isabella", "Esther", "Sanchez", "Smith", 845, 9666.36f, "Thriller");

        Library library = new Library("LIB-CH-005", "Abraham lincoln Library", "Chicago");

        library.getAuthorList().add(author);
        library.getAuthorList().add(author1);
        library.getAuthorList().add(author2);


        /* init jaxb marshaller */
        JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);
        Marshaller marshaller = jaxbContext.createMarshaller();

        /* set this flag to true to format the output */
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        /* marshaling of java objects in xml (output to file and standard output) */
        marshaller.marshal(library, System.out);
        marshaller.marshal(library, new File("library.xml"));
    }
}
