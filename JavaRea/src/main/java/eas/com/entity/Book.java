package eas.com.entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by eduardo on 12/1/2016.
 */
@XmlType(propOrder = {"code", "name", "author"})
@XmlRootElement
public class Book {

    private String code;
    private String name;
    private Author author;


    public Book(String name, Author author) {
        this.code = String.valueOf(System.currentTimeMillis());
        this.name = name;
        this.author = author;
    }

    public Book() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
