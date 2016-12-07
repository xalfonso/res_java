package eas.com.Exception;

import eas.com.entity.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by eduardo on 12/7/2016.
 *
 * This is a best way to management the exception in JAX-RS
 *
 *
 */
@Provider
public class AuthorExceptionMapper implements ExceptionMapper<AuthorExceptionNoFound> {


    @Override
    public Response toResponse(AuthorExceptionNoFound authorExceptionNoFound) {
        ErrorMessage errorMessage = new ErrorMessage(Response.Status.NOT_FOUND.getStatusCode(), authorExceptionNoFound.getMessage());
        return Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
    }
}
