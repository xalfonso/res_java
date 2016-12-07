package eas.com.resource.impl;

import eas.com.entity.Book;
import eas.com.resource.BookSubResource;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduardo on 12/6/2016.
 */
public class BookSubResourceDefaultImpl implements BookSubResource {

    @Override
    public Response getAll() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The lord of the ring", "Aventure"));
        books.add(new Book("Chuky", "Terror"));
        books.add(new Book("Walk in the cloud", "Drama"));
        GenericEntity<List<Book>> list =  new GenericEntity<List<Book>>(books){};
        return Response.status(Response.Status.OK).entity(list).build();
    }
}
