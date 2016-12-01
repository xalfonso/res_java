package eas.com.resource;

import eas.com.resource.impl.AuthorResourceDefaultImpl;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.net.URI;


/**
 * Created by eduardo on 11/29/2016.
 *
 * I am using the Embedded Grizzly server for up the api rest
 * and test directly in the url
 *
 */
public class AuthorResourceTest {

    private HttpServer httpServer;
    public static final String BASE_URL = "http://localhost:8080/webapi";
    public static final String ACCEPT_XML = "application/xml";
    public static final String ACCEPT_JSON = "application/json";
    private WebTarget webTargetAuthors;



    @Before
    public void setUp() throws Exception {

        /**
         * Register the implementation of resource class
         */
        final ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(AuthorResourceDefaultImpl.class);

        /**
         * Configure and start server
         */
        this.httpServer = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URL), resourceConfig);


        /**
         * Configure client
         */
        Client client = ClientBuilder.newClient();
        this.webTargetAuthors = client.target(BASE_URL + "/authors");
    }

    @After
    public void tearDown() throws Exception {
        httpServer.shutdown();
    }

    @Test
    public void testGetIt() {
        Response response = this.webTargetAuthors.request().header("Accept", ACCEPT_XML).get();
        String responseInText = response.readEntity(String.class);

        System.out.println("Response Text "  + responseInText);
    }


}
