package org.subham.javaworld.Messenger.DTO;

import java.util.HashMap;
import java.util.Map;

import org.subham.javaworld.Messenger.Entity.Comments;
import org.subham.javaworld.Messenger.Entity.Message;
import org.subham.javaworld.Messenger.Entity.Profile;

public class DataBase {
	private static Map<Long, Message> messages = new HashMap<Long, Message>();
	private static Map<String, Profile> profiles = new HashMap<>();
	private static Map<Long, Comments> comments = new HashMap<>();
	public static Map<Long, Message> getMessage(){
		return messages;
	}
	public static Map<String, Profile> getProfile(){
		return profiles;
	}
	public static Map<Long, Comments> getComments() {
		return comments;
	}
}
