package eas.com.resource;

import eas.com.entity.Author;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by eduardo on 11/20/2016.
 */

public interface AuthorResource {

    /**
     * List of author
     *
     * @return HTTP Response code and a json formatted list of authors
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response getAll();

    /**
     * Get author by Id
     */
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Author get(@PathParam("id") int id);


    @Path("/text")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    Response getText();
}
