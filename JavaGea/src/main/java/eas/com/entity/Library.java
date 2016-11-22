package eas.com.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduardo on 11/21/2016.
 */
@XmlType(propOrder = {"code", "name", "province", "authorList"})
@XmlRootElement
public class Library {

    private String code;

    private String name;

    private String province;

    private List<Author> authorList = new ArrayList<Author>();


    public Library(String code, String name, String province) {
        this.code = code;
        this.name = name;
        this.province = province;
    }

    public Library() {
    }

    @XmlAttribute
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @XmlElementWrapper(name = "authorList")
    @XmlElement(name = "author")
    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    @Override
    public String toString() {
        return "Library{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", authorList=" + authorList +
                '}';
    }
}
