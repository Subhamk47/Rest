package org.subham.javaworld.Messenger.Resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.subham.javaworld.Messenger.Entity.Comments;
import org.subham.javaworld.Messenger.Service.CommentsService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	CommentsService commentService = new CommentsService();
	
	@GET
	public List<Comments> getAllComments(@PathParam("messageId") long messageId){
		return commentService.getAllComments(messageId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comments getComments(@PathParam("messageId") long messageId , @PathParam("commentId") long commentId) {
		return commentService.getComments(messageId, commentId);
	}
	
	@DELETE
	@Path("/{commentId}")
	public Comments deleteComments(@PathParam("messageId") long messageId , @PathParam("commentId") long commentId) {
		return commentService.removeComments(messageId, commentId);
	}
	
	@POST
	public Comments addComments(@PathParam("messageId") long messageId, Comments comment) {
		return commentService.addComments(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comments updateComments(@PathParam("messageId") long messageId, Comments comment,@PathParam("commentId") long commentId ) {
		comment.setId(commentId);
		return commentService.updateComments(messageId, comment);
	}
}
