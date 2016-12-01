package eas.com.resource.impl;

import eas.com.entity.Author;
import eas.com.resource.AuthorResource;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduardo on 11/20/2016.
 */
@Path("/authors")
public class AuthorResourceImpl implements AuthorResource {


    public Response getAll() {
        System.out.println("Enter to API rest");

        List<Author> authorList = new ArrayList<>();

        authorList.add(new Author("Nelson", "Alfonso", "Alfonso", "Martinez"));
        authorList.add(new Author("Leydis", "Esther", "Garzon", "Giro"));
        authorList.add(new Author("Yamile", "Yaquelin", "Sanchez", "Acosta"));
        authorList.add(new Author("Miguel", "Angel", "Bandera", "Riberon"));

        return Response.status(Response.Status.OK).entity(new Author("Nelson", "Alfonso", "Alfonso", "Martinez")).build();
    }

    @Override
    public Author get(int id) {
        return new Author("Nelson", "Alfonso", "Alfonso", "Martinez");
    }

    @Override
    public Response getText() {
        return Response.status(Response.Status.OK).entity("Hello World").build();
    }
}
