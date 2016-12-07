package eas.com.service.impl;

import eas.com.Exception.AuthorExceptionNoFound;
import eas.com.db.DataBase;
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


    public AuthorServiceDefaultImpl() {
    }

    @Override
    public List<Author> getAll() {
        return new ArrayList<>(DataBase.getDataAuthor().values());
    }

    @Override
    public List<Author> getAllByCriteria(CriteriaAuthor criteriaAuthor) {
        List<Author> authorList = DataBase.getDataAuthor().values().stream().filter(criteriaAuthor::assertCriteria).collect(Collectors.toList());
        return authorList;
    }

    @Override
    public Author get(long id) throws AuthorExceptionNoFound {
        if (!DataBase.getDataAuthor().containsKey(id))
            throw new AuthorExceptionNoFound("There is no author with this id");
        return DataBase.getDataAuthor().get(id);
    }

    @Override
    public Author insert(Author author) {
        author.setId((long) (DataBase.getDataAuthor().size() + 1));
        DataBase.getDataAuthor().put(author.getId(), author);
        return author;
    }

    @Override
    public void delete(long id) throws AuthorExceptionNoFound {
        if (!DataBase.getDataAuthor().containsKey(id))
            throw new AuthorExceptionNoFound("There is no author with this id");
        DataBase.getDataAuthor().remove(id);
    }

    @Override
    public Author update(Author author) throws AuthorExceptionNoFound {
        if (!DataBase.getDataAuthor().containsKey(author.getId()))
            throw new AuthorExceptionNoFound("There is no author with this id");
        DataBase.getDataAuthor().put(author.getId(), author);
        return author;
    }


}
