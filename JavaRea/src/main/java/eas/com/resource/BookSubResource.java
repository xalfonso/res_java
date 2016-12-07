package eas.com.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by eduardo on 12/5/2016.
 */
public interface BookSubResource {

    /**
     * List of Authors
     *
     * @return Response (List of Authors)
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAll();
}
