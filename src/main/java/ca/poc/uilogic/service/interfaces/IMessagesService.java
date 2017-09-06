package ca.poc.uilogic.service.interfaces;

import java.util.List;

import ca.poc.uilogic.domain.Message;

/**
 * Service interface for: operations on messages.
 * 
 * @author daniel.fryze
 */
public interface IMessagesService {

	List<Message> getMessages();

	Message getMessage(long id);

	long getMessagesCount();
}