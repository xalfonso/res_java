package eas.com.service.impl;

import eas.com.Exception.AuthorExceptionNoFound;
import eas.com.Exception.BookExceptionNoFound;
import eas.com.db.DataBase;
import eas.com.entity.Book;
import eas.com.service.BookService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduardo on 12/7/2016.
 */
public class BookServiceDefaultImpl implements BookService {

    @Override
    public List<Book> getAllByAuthor(long idAuthor) throws AuthorExceptionNoFound {
        if (!DataBase.getDataAuthor().containsKey(idAuthor))
            throw new AuthorExceptionNoFound("There is no author with this id: " + idAuthor);
        return new ArrayList<>(DataBase.getDataAuthor().get(idAuthor).getBookMap().values());
    }

    @Override
    public Book getByAuthor(long idAuthor, long id) throws AuthorExceptionNoFound, BookExceptionNoFound {
        if (!DataBase.getDataAuthor().containsKey(idAuthor))
            throw new AuthorExceptionNoFound("There is no author with this id: " + idAuthor);

        if (!DataBase.getDataAuthor().get(idAuthor).getBookMap().containsKey(id))
            throw new BookExceptionNoFound("There is no book with this id: " + id + " inside the author with id: " + idAuthor);

        return DataBase.getDataAuthor().get(idAuthor).getBookMap().get(id);
    }

    @Override
    public Book insertAssociatedAuthor(long idAuthor, Book book) throws AuthorExceptionNoFound {
        if (!DataBase.getDataAuthor().containsKey(idAuthor))
            throw new AuthorExceptionNoFound("There is no author with this id: " + idAuthor);

        DataBase.getDataAuthor().get(idAuthor).getBookMap().put(book.getId(), book);

        return book;
    }

    @Override
    public void deleteAssociatedAuthor(long idAuthor, long id) throws AuthorExceptionNoFound, BookExceptionNoFound {
        if (!DataBase.getDataAuthor().containsKey(idAuthor))
            throw new AuthorExceptionNoFound("There is no author with this id: " + idAuthor);

        if (!DataBase.getDataAuthor().get(idAuthor).getBookMap().containsKey(id))
            throw new BookExceptionNoFound("There is no book with this id: " + id + " inside the author with id: " + idAuthor);

        DataBase.getDataAuthor().get(idAuthor).getBookMap().remove(id);
    }

    @Override
    public Book updateAssociatedAuthor(long idAuthor, Book book) throws AuthorExceptionNoFound, BookExceptionNoFound {
        if (!DataBase.getDataAuthor().containsKey(idAuthor))
            throw new AuthorExceptionNoFound("There is no author with this id: " + idAuthor);

        if (!DataBase.getDataAuthor().get(idAuthor).getBookMap().containsKey(book.getId()))
            throw new BookExceptionNoFound("There is no book with this id: " + book.getId() + " inside the author with id: " + idAuthor);

        DataBase.getDataAuthor().get(idAuthor).getBookMap().put(book.getId(), book);

        return book;
    }
}
