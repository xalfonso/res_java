package eas.com.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by eduardo on 11/28/2016.
 */
@XmlType(propOrder = {"id", "firstName", "secondName", "firstSurname", "secondSurname", "genre", "country"})
@XmlRootElement
public class Author {


    private long id;

    private String firstName;

    private String secondName;

    private String firstSurname;

    private String secondSurname;

    private String country;

    private String genre;

    private Map<String, Book> bookMap = new HashMap<>();


    public Author(long id, String firstName, String secondName, String firstSurname, String secondSurname, String country, String genre) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.country = country;
        this.genre = genre;
    }

    public Author() {
    }


    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", firstSurname='" + firstSurname + '\'' +
                ", secondSurname='" + secondSurname + '\'' +
                '}';
    }

    /*Setter and Getter*/
    @XmlAttribute
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Author setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getSecondName() {
        return secondName;
    }

    public Author setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public Author setFirstSurname(String firtSurname) {
        this.firstSurname = firtSurname;
        return this;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public Author setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    @XmlTransient
    public Map<String, Book> getBookMap() {
        return bookMap;
    }

    public void setBookMap(Map<String, Book> bookMap) {
        this.bookMap = bookMap;
    }
}
