package eas.com.entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by eduardo on 12/1/2016.
 */
@XmlType(propOrder = {"id", "name", "genre"})
@XmlRootElement
public class Book {

    private long id = System.nanoTime();
    private String name;
    private String genre;

    public Book(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public Book() {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
