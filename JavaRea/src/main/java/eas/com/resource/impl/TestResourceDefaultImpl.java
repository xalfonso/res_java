package eas.com.resource.impl;

import eas.com.resource.TestResource;

import javax.ws.rs.HEAD;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by eduardo on 12/4/2016.
 */
@Path("/test")
public class TestResourceDefaultImpl implements TestResource {

    /**
     * Use of different type of param
     * @param genre
     * @param country
     * @param name
     * @param cookie
     * @return
     */
    @Override
    public Response test(String genre, String country, String name,  String cookie) {
        return Response.status(Response.Status.OK).entity(" (MaxPara)Genre: " + genre + " (MaxPara)Country: " + country + " (HeadPara)name: " + name + " (CooPara) cookie: " + cookie).build();

    }

    /**
     * Inject UriInfo
     * @return
     */
    @Override
    public Response testInjectUriInfo(UriInfo uriInfo) {
        /**
         * UriInfo have different information about the url request
         */

        String path = "Path: " + uriInfo.getPath();
        String url = "Absolute Path: " + uriInfo.getAbsolutePath().toString();

        return Response.status(Response.Status.OK).entity(path + " " + url).build();
    }

    @Override
    public Response testInjectHeader(HttpHeaders headers) {
        /**
         * HttpHeaders have different information about the header request
         */
        String cookie = "cookie: " + headers.getCookies().toString();
        return Response.status(Response.Status.OK).entity(cookie).build();

    }
}
