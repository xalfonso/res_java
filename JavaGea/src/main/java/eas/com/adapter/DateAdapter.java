package eas.com.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

/**
 * Created by eduardo on 11/22/2016.
 * Custom converter for type that is not supported by jaxb. In this case: LocalDate
 */
public class DateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String dateString) throws Exception {
        return LocalDate.parse(dateString);
    }

    @Override
    public String marshal(LocalDate date) throws Exception {
        return date.toString();
    }
}
