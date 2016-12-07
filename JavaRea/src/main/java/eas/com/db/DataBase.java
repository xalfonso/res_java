package eas.com.db;

import eas.com.entity.Author;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eduardo on 12/6/2016.
 * For simulating the data base
 */
public class DataBase {

    static private Map<Long, Author> dataAuthor = new HashMap<>();

    static {
        dataAuthor.put(1L, new Author(1L, "Leydis", "Esther", "Garzon", "Giro", "US", "Horror"));
        dataAuthor.put(2L, new Author(2L, "Yamile", "Yaquelin", "Sanchez", "Acosta", "SP", "Drama"));
    }

    public static Map<Long, Author> getDataAuthor() {
        return dataAuthor;
    }

    public static void setDataAuthor(Map<Long, Author> dataAuthor) {
        DataBase.dataAuthor = dataAuthor;
    }
}
