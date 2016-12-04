//package eas.com.resource;
//
//import eas.com.entity.Author;
//import eas.com.entity.Book;
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
///**
// * Created by eduardo on 12/1/2016.
// */
//public interface BookResource {
//
//    /**
//     * List of Books
//     *
//     * @return Response (List of Books)
//     */
//    @GET
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Response getAll();
//
//    /**
//     * Author by Id
//     * @return Response (Author)
//     */
//    @GET
//    @Path("/{id}")
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Response get(@PathParam("id") long id);
//
//    /**
//     * @param book to create
//     * @return author created with the id generated
//     */
//    @POST
//    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Response insert(Book book);
//
//    /**
//     *
//     * @param id of book top update
//     * @param book to update
//     * @return Response (author updated)
//     */
//    @PUT
//    @Path("/{id}")
//    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Response update(@PathParam("id") long id, Book book);
//
//    /**
//     *
//     * @param id of book to delete
//     * @return Response (no contend)
//     */
//    @DELETE
//    @Path("/{id}")
//    public Response delete(@PathParam("id") long id);
//}
