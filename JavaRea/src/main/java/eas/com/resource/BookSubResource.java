package eas.com.resource;

import eas.com.entity.Author;
import eas.com.entity.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by eduardo on 12/5/2016.
 *
 * This subResource is used by different resources
 *
 * Example of SubResource
 */
public interface BookSubResource {

    /**
     * List of Books by the resource specified
     *
     * @return Response (List of Authors)
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAll();

    /**
     * Books by id inside the resource specified
     * @return Response (Book)
     */
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response get(@PathParam("id") long id);

    /**
     * @param book to create associated with the resource specified
     * @return author created with the id generated
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response insert(Book book);


    /**
     *
     * @param id of author to update
     * @param book to update associated with the resource specified
     * @return Response (book updated)
     */
    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response update(@PathParam("id") long id, Book book);

    /**
     *
     * @param id of book to delete associated with the resource specified
     * @return Response (no content)
     */
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id);


}
