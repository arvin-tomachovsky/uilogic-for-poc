package ca.poc.uilogic.repository.interfaces;

import java.util.List;

import ca.poc.uilogic.domain.Message;

/**
 * Repository interface for: messages.
 * 
 * @author daniel.fryze
 */
public interface IMessagesRepository {

	List<Message> getMessages();

	Message getMessage(long id);

	void addMessage(Message message);
}