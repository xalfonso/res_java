package eas.com.service;

import eas.com.Exception.AuthorExceptionNoFound;
import eas.com.Exception.BookExceptionNoFound;
import eas.com.entity.Author;
import eas.com.entity.Book;

import java.util.List;

/**
 * Created by eduardo on 12/7/2016.
 */
public interface BookService {

    public List<Book> getAllByAuthor(long idAuthor) throws AuthorExceptionNoFound;

    public Book getByAuthor(long idAuthor, long id) throws AuthorExceptionNoFound, BookExceptionNoFound;

    public Book insertAssociatedAuthor(long idAuthor, Book book) throws AuthorExceptionNoFound;

    public void deleteAssociatedAuthor(long idAuthor, long id) throws AuthorExceptionNoFound, BookExceptionNoFound;

    public Book updateAssociatedAuthor(long idAuthor, Book book) throws AuthorExceptionNoFound, BookExceptionNoFound;
}
