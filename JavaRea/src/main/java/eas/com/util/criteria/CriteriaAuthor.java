package eas.com.util.criteria;

import eas.com.entity.Author;

/**
 * Created by eduardo on 12/3/2016.
 */
public class CriteriaAuthor implements Criteria<Author> {
    private String country;
    private String genre;


    public CriteriaAuthor(String country, String genre) {
        this.country = country;
        this.genre = genre;
    }

    /**
     * @return true if do not exist some param to search, false otherwise
     */
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
