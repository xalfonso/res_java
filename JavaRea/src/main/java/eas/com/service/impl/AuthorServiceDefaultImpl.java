package eas.com.service.impl;

import eas.com.Exception.AuthorExceptionNoFound;
import eas.com.entity.Author;
import eas.com.service.AuthorService;
import eas.com.util.criteria.CriteriaAuthor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by eduardo on 11/28/2016.
 */
public class AuthorServiceDefaultImpl implements AuthorService {

    /**
     * For simulating the data base
     */
    static private Map<Long, Author> dataAuthor = new HashMap<>();

    static {
        dataAuthor.put(1L, new Author(1L, "Leydis", "Esther", "Garzon", "Giro", "US", "Horror"));
        dataAuthor.put(2L, new Author(2L, "Yamile", "Yaquelin", "Sanchez", "Acosta", "SP", "Drama"));
    }

    public AuthorServiceDefaultImpl() {
    }

    @Override
    public List<Author> getAll() {
        return new ArrayList<>(dataAuthor.values());
    }

    @Override
    public List<Author> getAllByCriteria(CriteriaAuthor criteriaAuthor) {
        List<Author> authorList = dataAuthor.values().stream().filter(criteriaAuthor::assertCriteria).collect(Collectors.toList());
        return authorList;
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
    public void delete(long id) throws AuthorExceptionNoFound {
        if (!dataAuthor.containsKey(id))
            throw new AuthorExceptionNoFound("There is no author with this id");
        dataAuthor.remove(id);
    }

    @Override
    public Author update(Author author) throws AuthorExceptionNoFound {
        if (!dataAuthor.containsKey(author.getId()))
            throw new AuthorExceptionNoFound("There is no author with this id");
        dataAuthor.put(author.getId(), author);
        return author;
    }


}
