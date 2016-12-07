package eas.com.util.criteria;

import eas.com.entity.Author;

import javax.ws.rs.QueryParam;

/**
 * Created by eduardo on 12/3/2016.
 */
public class CriteriaAuthor implements Criteria<Author> {

    @QueryParam("country")
    private String country;

    @QueryParam("genre")
    private String genre;


    public CriteriaAuthor(String country, String genre) {
        this.country = country;
        this.genre = genre;
    }

    /**
     * This constructor is needed for injecting the @QueryParam
     */
    public CriteriaAuthor() {
    }

    @Override
    public boolean emptyParam() {
        return (this.country == null || this.country.isEmpty())
                && (genre == null || genre.isEmpty());
    }

    @Override
    public boolean assertCriteria(Author author) {

        if (this.country != null && !this.country.isEmpty()) {
            if (!author.getCountry().equalsIgnoreCase(this.country))
                return false;

        }

        if (this.genre != null && !this.genre.isEmpty()) {
            if (!author.getGenre().equalsIgnoreCase(this.genre))
                return false;

        }

        return true;
    }
}
