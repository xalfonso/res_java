package eas.com.entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by eduardo on 12/1/2016.
 */
@XmlType(propOrder = {"code", "name", "genre"})
@XmlRootElement
public class Book {

    private String code;
    private String name;
    private String genre;

    public Book(String name, String genre) {
        this.code = String.valueOf(System.nanoTime());
        this.name = name;
        this.genre = genre;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
