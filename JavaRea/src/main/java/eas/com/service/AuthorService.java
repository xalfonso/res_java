package eas.com.service;

import eas.com.Exception.AuthorExceptionNoFound;
import eas.com.entity.Author;
import eas.com.util.criteria.Criteria;
import eas.com.util.criteria.CriteriaAuthor;

import java.util.List;

/**
 * Created by eduardo on 11/28/2016.
 */
public interface AuthorService {

    public List<Author> getAll();

    public List<Author> getAllByCriteria(CriteriaAuthor criteriaAuthor);

    public Author get(long id) throws AuthorExceptionNoFound;

    public Author insert(Author author);

    public void delete(long id) throws AuthorExceptionNoFound;

    public Author update(Author author) throws AuthorExceptionNoFound;
}
