package eas.com;

import eas.com.entity.Author;
import jersey.repackaged.com.google.common.collect.Lists;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
        List<Author> authorList = new ArrayList<>();
        /*authorList.add(new Author("Nelson", "Alfonso", "Alfonso", "Martinez"));
        authorList.add(new Author("Leydis", "Esther", "Garzon", "Giro"));
        authorList.add(new Author("Yamile", "Yaquelin", "Sanchez", "Acosta"));
        authorList.add(new Author("Miguel", "Angel", "Bandera", "Riberon"));*/

        /*Necessary for wrap the list*/
        GenericEntity<List<Author>> list = new GenericEntity<List<Author>>(authorList) {
        };

        return Response.status(Response.Status.OK).entity(list).build();

        //return authorList;
    }
}
