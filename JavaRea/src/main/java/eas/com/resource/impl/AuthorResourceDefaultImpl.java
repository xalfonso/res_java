package eas.com.resource.impl;

import eas.com.entity.Author;
import eas.com.resource.AuthorResource;
import eas.com.resource.BookSubResource;
import eas.com.service.AuthorService;
import eas.com.service.impl.AuthorServiceDefaultImpl;
import eas.com.util.criteria.CriteriaAuthor;

import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * Created by eduardo on 11/28/2016.
 */

@Path("/authors")
public class AuthorResourceDefaultImpl implements AuthorResource {

    private AuthorService authorService = new AuthorServiceDefaultImpl();

    @Override
    public Response getAll(CriteriaAuthor criteriaAuthor) {
        GenericEntity<List<Author>> list = null;

        if (criteriaAuthor.emptyParam()) {
            list = new GenericEntity<List<Author>>(this.authorService.getAll()) {
            };
        } else {
            list = new GenericEntity<List<Author>>(this.authorService.getAllByCriteria(criteriaAuthor)) {
            };
        }

        return Response.status(Response.Status.OK).entity(list).build();
    }


    @Override
    public Response get(long id) {
        Author author = null;
        author = this.authorService.get(id);
        return Response.status(Response.Status.OK).entity(author).build();
    }

    @Override
    public Response insert(Author author, UriInfo uriInfo) {
        this.authorService.insert(author);
        /**
         * This way create the header response: Location = http://localhost:8080/webapi/authors/:id
         * And of course return the status code 201 (created)
         */
        return Response.created(uriInfo.getAbsolutePathBuilder().path(String.valueOf(author.getId())).build())
                .entity(author)
                .build();
    }

    @Override
    public Response update(long id, Author author) {
        author.setId(id);
        this.authorService.update(author);
        return Response.status(Response.Status.CREATED).entity(author).build();
    }

    @Override
    public Response delete(long id) {
        this.authorService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @Override
    public BookSubResource getBookResource(long id) {
        return new BookSubResourceDefaultImpl(Author.class, id);
    }

}
