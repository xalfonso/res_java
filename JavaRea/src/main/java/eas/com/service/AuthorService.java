package eas.com.service;

import eas.com.Exception.AuthorExceptionNoFound;
import eas.com.entity.Author;

import java.util.List;

/**
 * Created by eduardo on 11/28/2016.
 */
public interface AuthorService {

    public List<Author> getAll();

    public Author get(long id) throws AuthorExceptionNoFound;

    public Author insert(Author author);

    public void delete(long id) throws Exception;

    public void update(Author author) throws Exception;
}
