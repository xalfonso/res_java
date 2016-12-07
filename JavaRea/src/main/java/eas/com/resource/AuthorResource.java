package eas.com.resource;

import eas.com.entity.Author;
import eas.com.util.criteria.CriteriaAuthor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by eduardo on 11/28/2016.
 * <p>
 * When Produces Multiple MediaType. The client must specify in the header
 * "Accept: application/json" or "Accept: application/xml" for selecting the format that he wants to receive
 *
 * When Consumes multiples MediaType. The client must specify in the header
 * "Content-Type: application/json" or "Content-Type: application/xml" for selecting the format that he wants to send
 */
public interface AuthorResource {

    /**
     * List of Authors
     *
     * @return Response (List of Authors)
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAll(@BeanParam CriteriaAuthor criteriaAuthor);

    /**
     * Author by Id
     * @return Response (Author)
     */
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response get(@PathParam("id") long id);

    /**
     * @param author author to create
     * @return author created with the id generated
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response insert(Author author);


    /**
     *
     * @param id of author to update
     * @param author to update
     * @return Response (author updated)
     */
    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response update(@PathParam("id") long id, Author author);

    /**
     *
     * @param id of author to delete
     * @return Response (no content)
     */
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id);


    /**
     * Mapping to sub resource
     * @return
     */
    @Path("/{authorId}/books")
    public BookSubResource getBookResource();

}
