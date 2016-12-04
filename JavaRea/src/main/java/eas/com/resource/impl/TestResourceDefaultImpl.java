package eas.com.resource.impl;

import eas.com.resource.TestResource;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by eduardo on 12/4/2016.
 */
@Path("/test")
public class TestResourceDefaultImpl implements TestResource {
    @Override
    public Response test(String genre, String country, String name,  String cookie) {
        return Response.status(Response.Status.OK).entity(" (MaxPara)Genre: " + genre + " (MaxPara)Country: " + country + " (HeadPara)name: " + name + " (CooPara) cookie: " + cookie).build();

    }
}
