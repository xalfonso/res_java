package eas.com.resource.impl;

import eas.com.Exception.AuthorExceptionNoFound;
import eas.com.entity.Author;
import eas.com.resource.AuthorResource;
import eas.com.service.AuthorService;
import eas.com.service.impl.AuthorServiceDefaultImpl;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
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
        GenericEntity<List<Author>> list = null;
        try {
            list = new GenericEntity<List<Author>>(this.authorService.getAll()) {
            };
        } catch (Throwable e) {
            /*When happens an exception the media type is text*/
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error detected. Cause: " + e.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
        return Response.status(Response.Status.OK).entity(list).build();
    }


    @Override
    public Response get(long id) {
        Author author = null;
        try {
           author = this.authorService.get(id);
        }catch (AuthorExceptionNoFound e){
            return Response.status(Response.Status.NOT_FOUND).entity("Error detected. Cause: " + e.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
        catch (Throwable e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error detected. Cause: " + e.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }

        return Response.status(Response.Status.OK).entity(author).build();
    }

    @Override
    public Response insert(Author author) {
        try {
            this.authorService.insert(author);
        }catch (Throwable e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error detected. Cause: " + e.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }

        return Response.status(Response.Status.CREATED).entity(author).build();
    }
}
