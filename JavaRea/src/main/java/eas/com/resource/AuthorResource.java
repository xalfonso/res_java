package eas.com.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by eduardo on 11/28/2016.
 */
public interface AuthorResource {

    /**
     * Multiple MediaType of Response. The client must specify in the header Accept:
     * application/json or application/xml for selecting the format that want
     *
     * @return Response (List of Authors)
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAll();
}
