package eas.com.resource.impl;

import eas.com.entity.Author;
import eas.com.resource.AuthorResource;
import eas.com.service.AuthorService;
import eas.com.service.impl.AuthorServiceDefaultImpl;

import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by eduardo on 11/28/2016.
 */

@Path("/authors")
public class AuthorResourceDefaultImpl implements AuthorResource {

    private AuthorService authorService = new AuthorServiceDefaultImpl();

    @Override
    public Response getAll() {
        GenericEntity<List<Author>> list = new GenericEntity<List<Author>>(this.authorService.getAll()) {};
        return Response.status(Response.Status.OK).entity(list).build();
    }
}
