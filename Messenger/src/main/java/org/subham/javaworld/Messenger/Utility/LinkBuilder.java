package org.subham.javaworld.Messenger.Utility;

import javax.ws.rs.core.UriInfo;

import org.subham.javaworld.Messenger.Entity.Message;
import org.subham.javaworld.Messenger.Resources.CommentResource;
import org.subham.javaworld.Messenger.Resources.MessageResource;
import org.subham.javaworld.Messenger.Resources.ProfileResource;

public class LinkBuilder {
	
	public String getSelfUrl(UriInfo uriInfo, long msgId) {
		return uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(String.valueOf(msgId)).build()
				.toString();
	}

	public String getProfileUrl(UriInfo uriInfo, String author) {
		return uriInfo.getBaseUriBuilder()
				.path(ProfileResource.class)
				.path(author).build()
				.toString();
	}

	public String getCommentUrl(UriInfo uriInfo, Message message) {
		return uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(MessageResource.class,"getCommentResource")
				.path(CommentResource.class)
				.resolveTemplate("messageId", message.getId())
				.build()
				.toString();
	}
}
