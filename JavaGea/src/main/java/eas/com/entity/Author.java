package eas.com.entity;

import eas.com.adapter.DateAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

/**
 * Created by eduardo on 11/20/2016.
 */

/**
 *  @XmlType(propOrder ... for specifying the order of the elements and attributes
 */
@XmlType(propOrder = {"genre", "firstName", "secondName", "firstSurname", "secondSurname", "salary", "numberBooks","id", "code", "localDate"})
@XmlRootElement
public class Author {

    private String code;

    private long id;

    private String firstName;

    private String secondName;

    private String firstSurname;

    private String secondSurname;

    private int numberBooks;

    private float salary;

    private String genre;

    private LocalDate localDate = LocalDate.now();


    public Author(String firstName, String secondName, String firstSurname, String secondSurname,int numberBooks, float salary, String genre) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.numberBooks = numberBooks;
        this.salary = salary;
        this.code = "XXX-0254-987-" + this.numberBooks;
        this.genre = genre;
    }

    public Author() {
    }


    @Override
    public String toString() {
        return "Author{" +
                "code='" + code + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", firstSurname='" + firstSurname + '\'' +
                ", secondSurname='" + secondSurname + '\'' +
                ", numberBooks=" + numberBooks +
                ", salary=" + salary +
                ", localDate=" + localDate +
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

    public int getNumberBooks() {
        return numberBooks;
    }

    public void setNumberBooks(int numberBooks) {
        this.numberBooks = numberBooks;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @XmlAttribute
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
