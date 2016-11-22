package eas.com;

import eas.com.entity.Author;
import eas.com.handleerror.ErrorHandleGea;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by eduardo on 11/22/2016.
 * <p>
 * Validating using XSD
 */
public class MainApp4 {


    public static void main(String[] args) throws SAXException, JAXBException {

        /**
         * Error will be throw because the numberBooks is > 100
         */
        Author author = new Author("Nelson", "Eduardo", "Alfonso", "Martinez", 150, 2000.36f, "Adventure");


        /**
         *  ok
         */
        Author author1 = new Author("Martha", "Paula", "Martinez", "Pozo", 50, 547.26f, "Horror");


        /**
         * Error will be throw cause the genre is wrong
         */
        Author author2 = new Author("Leydis", "Esther", "Garzon", "Giro", 80, 9666.36f, "Drama");


        /**
         * Schema is created
         */
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File("author.xsd"));


        /**
         * context is created and used to create sources for each country
         */
        JAXBContext jaxbContext = JAXBContext.newInstance(Author.class);
        JAXBSource jaxbSourceAuthor = new JAXBSource(jaxbContext, author);
        JAXBSource jaxbSourceAuthor1 = new JAXBSource(jaxbContext, author1);
        JAXBSource jaxbSourceAuthor2 = new JAXBSource(jaxbContext, author2);

        /**
         * Validator is initialized
         */
        Validator validator = schema.newValidator();
        validator.setErrorHandler(new ErrorHandleGea());

        /**
         * Validator in use
         */
        try{
            validator.validate(jaxbSourceAuthor);
            System.out.println("The author is correct");
        }catch (SAXException | IOException e){
            System.out.println("Author: Error of type: " + e.getClass().getName() + " Message: " + e.getMessage());
        }

        try{
            validator.validate(jaxbSourceAuthor1);
            System.out.println("The author1 is correct");
        }catch (SAXException | IOException e){
            System.out.println("Author1: Error of type: " + e.getClass().getName() + " Message: " + e.getMessage());
        }

        try{
            validator.validate(jaxbSourceAuthor2);
            System.out.println("The author2 is correct");
        }catch (SAXException | IOException e){
            System.out.println("Author2: Error of type: " + e.getClass().getName() + " Message: " + e.getMessage());
        }

    }
}
