package eas.com.util.criteria;

import eas.com.entity.Book;

import javax.ws.rs.QueryParam;

/**
 * Created by eduardo on 12/6/2016.
 */
public class CriteriaBook implements Criteria<Book> {

    @QueryParam("genre")
    private String genre;


    public CriteriaBook(String genre) {
        this.genre = genre;
    }

    public CriteriaBook() {
    }

    @Override
    public boolean emptyParam() {
        return (this.genre == null || this.genre.isEmpty());
    }

    @Override
    public boolean assertCriteria(Book book) {
        if (this.genre != null && !this.genre.isEmpty()) {
            if (!book.getGenre().equalsIgnoreCase(this.genre))
                return false;

        }

        return true;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
