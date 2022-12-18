package org.subham.javaworld.Messenger.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.subham.javaworld.Messenger.DTO.DataBase;
import org.subham.javaworld.Messenger.Entity.Comments;
import org.subham.javaworld.Messenger.Entity.ErrorMessage;
import org.subham.javaworld.Messenger.Entity.Message;

public class CommentsService {
	
	private Map<Long, Message> messsages = DataBase.getMessage();
	
	public List<Comments> getAllComments(long messageId){
		Map<Long, Comments> comments= messsages.get(messageId).getComments();
		return new ArrayList<Comments>(comments.values());
	}
	
	@SuppressWarnings("unused")
	public Comments getComments(long messsgeId, long commentId) {
		Response response = Response.status(Status.NOT_FOUND).entity(new ErrorMessage("Not Found", 404, "google.com")).build();
		Message messge = messsages.get(messsgeId);
		if (messge == null) {
			throw new WebApplicationException(response);
		}
		Map<Long, Comments> comments = messge.getComments();
		Comments comment = comments.get(commentId);
		if(comments == null ) {
			throw new NotFoundException(response);
		}
		return comment;
	}
	
	public Comments addComments(long messageId, Comments comment) {
		Map<Long, Comments> comments = messsages.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comments updateComments(long messageId, Comments comment) {
		Map<Long, Comments> comments = messsages.get(messageId).getComments();
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comments removeComments(long messageId, long commentId) {
		Map<Long, Comments> comments = messsages.get(messageId).getComments();
		return comments.remove(commentId);
	}
}
