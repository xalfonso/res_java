package eas.com.service.impl;

import eas.com.Exception.AuthorExceptionNoFound;
import eas.com.entity.Author;
import eas.com.service.AuthorService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by eduardo on 11/28/2016.
 */
public class AuthorServiceDefaultImpl implements AuthorService {

    /**
     * For simulating the data base
     */
    static private Map<Long, Author> dataAuthor = new HashMap<>();

    static {
        dataAuthor.put(1L, new Author(1L, "Leydis", "Esther", "Garzon", "Giro"));
        dataAuthor.put(2L, new Author(2L, "Yamile", "Yaquelin", "Sanchez", "Acosta"));
    }

    public AuthorServiceDefaultImpl() {
    }

    @Override
    public List<Author> getAll() {
        return new ArrayList<>(dataAuthor.values());
    }

    @Override
    public Author get(long id) throws AuthorExceptionNoFound {
        if (!dataAuthor.containsKey(id))
            throw new AuthorExceptionNoFound("There is no author with this id");
        return dataAuthor.get(id);
    }

    @Override
    public Author insert(Author author) {
        author.setId((long) (dataAuthor.size() + 1));
        dataAuthor.put(author.getId(), author);
        return author;
    }

    @Override
    public void delete(long id) throws Exception {

    }

    @Override
    public void update(Author author) throws Exception {

    }


}
