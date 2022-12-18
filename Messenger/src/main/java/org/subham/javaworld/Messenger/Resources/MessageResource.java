package org.subham.javaworld.Messenger.Resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import java.util.logging.*;
import org.subham.javaworld.Messenger.DTO.MessageFilterBean;
import org.subham.javaworld.Messenger.Entity.Message;
import org.subham.javaworld.Messenger.Service.MessageService;
import org.subham.javaworld.Messenger.Utility.LinkBuilder;

@Path("/messages")
@Produces(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML}) //use Accept parameter in Header 
@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML}) // use content-type in header
public class MessageResource {
	
	private static final Logger LOGGER  = Logger.getLogger(MessageResource.class.getName());
	
	MessageService msgService = new MessageService();
	
	LinkBuilder lb = new LinkBuilder();
//	@GET
//	public List<Message> getMessages(@QueryParam("year") int year, @QueryParam("start") int start,@QueryParam("size") int size) {
//		if (year > 0) {
//			LOGGER.log(Level.INFO, "Started getMessage Service with queryParam value : {0}", year);
//			return msgService.getAllMessageForYear(year);
//		}
//		if (start > 0 && size > 0) {// http://localhost:8080/Messenger/webapi/messages?start=2&size=2
//			LOGGER.log(Level.INFO, "Started getMessage Service with  queryParam values start : {0} & size : {1}",
//					new Object[] { start, size });
//			return msgService.getAllMessagePaginated(start, size);
//		}
//		LOGGER.log(Level.INFO, "Started getMessage Service without queryParam");
//		List<Message> result = msgService.getMessages();
//		return result;
//	}
	
	// making upper API simpler by using beamParam
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			LOGGER.log(Level.INFO, "Started getMessage Service with queryParam value : {0}", filterBean.getYear());
			return msgService.getAllMessageForYear(filterBean.getYear());
		}
		if (filterBean.getStart() > 0 && filterBean.getSize() > 0) {// http://localhost:8080/Messenger/webapi/messages?start=2&size=2
			LOGGER.log(Level.INFO, "Started getMessage Service with  queryParam values start : {0} & size : {1}",
					new Object[] { filterBean.getStart(), filterBean.getSize() });
			return msgService.getAllMessagePaginated(filterBean.getStart(), filterBean.getSize());
		}
		LOGGER.log(Level.INFO, "Started getMessage Service without queryParam");
		List<Message> result = msgService.getMessages();
		return result;
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId, @Context UriInfo uriInfo) {
		LOGGER.log(Level.INFO, "Started getMessage service with messageid : {0}", messageId);
		Message message = msgService.getMessage(messageId);
		message.addLink(lb.getSelfUrl(uriInfo,message.getId()), "self");
		message.addLink(lb.getProfileUrl(uriInfo, message.getAuthor()), "profile");
		message.addLink(lb.getCommentUrl(uriInfo, message),"comments");
		return message;
	}
	
	@DELETE
	@Path("/{messageId}")
	public Message deleteMessage(@PathParam("messageId") long messageId) {
		LOGGER.log(Level.INFO, "Started deleteMessage service with messageid : {0}", messageId);
		return msgService.removeMessage(messageId);
	}

	@POST
	public Response addMessage(Message message , @Context UriInfo uriInfo) {
		LOGGER.log(Level.INFO, "Started addMessage service...! ");
		Message newMessage =  msgService.addMessage(message);
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build();
		return Response.created(uri).status(Status.OK).entity(newMessage).build();
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
		try {
			LOGGER.log(Level.INFO, "Started updateMessage service with messageid : {0}", messageId);
			message.setId(messageId);
			return msgService.updateMessage(message);
		} finally {
			LOGGER.log(Level.INFO, "End updateMessage service with messageid : {0}", messageId);
		}
	}
	// call sub-resource 
	// This is called deligation
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
}
