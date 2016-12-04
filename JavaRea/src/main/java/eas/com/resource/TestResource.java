package eas.com.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by eduardo on 12/4/2016.
 */
public interface TestResource {

    /**
     * Test Matrix params
     *
     * @return Response
     */
    @POST
    @Produces({MediaType.TEXT_PLAIN})
    public Response test(@MatrixParam("genre") String genre, @MatrixParam("country") String country, @HeaderParam("name") String name, @CookieParam("cookie") String cookie);
}
