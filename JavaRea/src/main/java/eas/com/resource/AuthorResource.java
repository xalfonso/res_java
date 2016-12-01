package eas.com.resource;

import eas.com.entity.Author;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by eduardo on 11/28/2016.
 * <p>
 * Produces Multiple MediaType. The client must specify in the header
 * "Accept: application/json" or "Accept: application/xml" for selecting the format that he wants
 */
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public interface AuthorResource {

    /**
     * List of Authors
     *
     * @return Response (List of Authors)
     */
    @GET
    public Response getAll();

    /**
     * Author by Id
     * @return Response (Author)
     */
    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") long id);

    /**
     * Consumes multiples MediaType. The client must specify in the header
     * "Content-Type: application/json" or "Content-Type: application/xml" for selecting the format that he wants
     * @param author
     * @return
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response insert(Author author);

}
