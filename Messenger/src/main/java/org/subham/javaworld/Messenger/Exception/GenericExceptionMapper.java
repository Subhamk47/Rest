package org.subham.javaworld.Messenger.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.subham.javaworld.Messenger.Entity.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage message = new ErrorMessage(exception.getMessage(), 500, "https://www.google.com/");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(message).build();
	}

}
