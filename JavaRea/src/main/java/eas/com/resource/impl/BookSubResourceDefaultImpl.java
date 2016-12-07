package eas.com.resource.impl;

import eas.com.Exception.AuthorExceptionNoFound;
import eas.com.Exception.BookExceptionNoFound;
import eas.com.entity.Author;
import eas.com.entity.Book;
import eas.com.resource.BookSubResource;
import eas.com.service.BookService;
import eas.com.service.impl.BookServiceDefaultImpl;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by eduardo on 12/6/2016.
 */
public class BookSubResourceDefaultImpl implements BookSubResource {

    /**
     * This attributes are for re-use this subResources in several resources
     */
    private Class entityResource;
    private long idIdentityResource;

    private BookService bookService = new BookServiceDefaultImpl();


    public BookSubResourceDefaultImpl(Class entityResource, long idIdentityResource) {
        this.entityResource = entityResource;
        this.idIdentityResource = idIdentityResource;
    }

    public BookSubResourceDefaultImpl() {
    }

    @Override
    public Response getAll() {
        GenericEntity<List<Book>> list = null;
        try {
            if (this.entityResource.equals(Author.class)) { /*Is this subResource is called from AuthorResource*/
                list = new GenericEntity<List<Book>>(this.bookService.getAllByAuthor(idIdentityResource)) {

                };
            }

            /**
             * Here I need to put conditions if this subResource is called from other Resource
             */

        } catch (AuthorExceptionNoFound e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Error detected. Cause: " + e.getMessage()).type(MediaType.TEXT_PLAIN).build();
        } catch (Throwable e) {
            /*When happens an exception the media type is text*/
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error detected. Cause: " + e.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
        return Response.status(Response.Status.OK).entity(list).build();


    }

    @Override
    public Response get(long id) {
        Book book = null;
        try {
            if (this.entityResource.equals(Author.class)) { /*Is this subResource is called from AuthorResource*/
                book = this.bookService.getByAuthor(this.idIdentityResource, id);
            }
        } catch (AuthorExceptionNoFound | BookExceptionNoFound e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Error detected. Cause: " + e.getMessage()).type(MediaType.TEXT_PLAIN).build();
        } catch (Throwable e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error detected. Cause: " + e.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }

        return Response.status(Response.Status.OK).entity(book).build();

    }

    @Override
    public Response insert(Book book) {
        try {
            if (this.entityResource.equals(Author.class)) { /*Is this subResource is called from AuthorResource*/
                this.bookService.insertAssociatedAuthor(this.idIdentityResource, book);
            }
        } catch (AuthorExceptionNoFound e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Error detected. Cause: " + e.getMessage()).type(MediaType.TEXT_PLAIN).build();
        } catch (Throwable e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error detected. Cause: " + e.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }

        return Response.status(Response.Status.CREATED).entity(book).build();
    }

    @Override
    public Response update(long id, Book book) {
        try {
            book.setId(id);
            if (this.entityResource.equals(Author.class)) { /*Is this subResource is called from AuthorResource*/
                this.bookService.updateAssociatedAuthor(this.idIdentityResource, book);
            }
        } catch (AuthorExceptionNoFound | BookExceptionNoFound e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Error detected. Cause: " + e.getMessage()).type(MediaType.TEXT_PLAIN).build();
        } catch (Throwable e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error detected. Cause: " + e.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }

        return Response.status(Response.Status.CREATED).entity(book).build();
    }

    @Override
    public Response delete(long id) {
        try {
            if (this.entityResource.equals(Author.class)) { /*Is this subResource is called from AuthorResource*/
                this.bookService.deleteAssociatedAuthor(this.idIdentityResource, id);
            }
        } catch (AuthorExceptionNoFound | BookExceptionNoFound e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Error detected. Cause: " + e.getMessage()).type(MediaType.TEXT_PLAIN).build();
        } catch (Throwable e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error detected. Cause: " + e.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }

        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
