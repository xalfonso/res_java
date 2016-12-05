package eas.com.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * Created by eduardo on 12/4/2016.
 */
public interface TestResource {

    /**
     * Test Matrix params
     *
     * @return Response
     */
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/param")
    public Response test(@MatrixParam("genre") String genre, @MatrixParam("country") String country, @HeaderParam("name") String name, @CookieParam("cookie") String cookie);


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/uri")
    public Response testInjectUriInfo(@Context UriInfo uriInfo);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/header")
    public Response testInjectHeader(@Context HttpHeaders headers);
}
