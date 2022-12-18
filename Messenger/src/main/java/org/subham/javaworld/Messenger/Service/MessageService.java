package org.subham.javaworld.Messenger.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.subham.javaworld.Messenger.DTO.DataBase;
import org.subham.javaworld.Messenger.Entity.Comments;
import org.subham.javaworld.Messenger.Entity.Message;
import org.subham.javaworld.Messenger.Exception.DataNotFoundException;

public class MessageService {
	
	private Map<Long, Message> messages =  DataBase.getMessage(); 
	
	@SuppressWarnings("deprecation")
	public MessageService() {
		messages.put(1l, new Message(1l,"Subham", 2022, "Subham"));
		Message m = messages.get(1l);
		m.getComments().put(1l, new Comments(1l, "Nice Pic", 12, "Prem"));
		messages.put(2l, new Message(2l,"VJ", 2022, "Vijay"));
		messages.put(3l, new Message(3l,"Arav",2019, "Arav"));
		messages.put(4l, new Message(4l,"Anirav", 2015, "Anirav"));
	}
	
	@SuppressWarnings("deprecation")
	public List<Message> getMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessageForYear(int year){
		List<Message> msg = new ArrayList<Message>();
		for(Message m  : messages.values()) {
			if(m.getCreatedDate() == year) {
				msg.add(m);
			}
		}
		return msg;
	}
	
	public List<Message> getAllMessagePaginated(int start , int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if(start+size>list.size()) return list;
		return list.subList(start, start+size);
	}
	 
	public Message getMessage(long id) {
		Message mess =  messages.get(id);;
		if(mess == null) throw new DataNotFoundException("Data Not found with message id : "+ id);
		return mess;
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId()<=0) return null;
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
