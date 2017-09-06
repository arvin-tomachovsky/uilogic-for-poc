package ca.poc.uilogic.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.poc.uilogic.domain.Message;
import ca.poc.uilogic.repository.interfaces.IMessagesRepository;

/**
 * Repository (mock) implementation for: messages.
 * 
 * @author daniel.fryze
 */
@Named("messagesRepository")
public class MessagesRepository implements IMessagesRepository {

	private static Logger logger = LoggerFactory.getLogger(MessagesRepository.class);

	private List<Message> messages;

	private AtomicInteger idCounter = new AtomicInteger(0);

	public MessagesRepository() {
		init();
	}

	private void init() {
		messages = new ArrayList<Message>();
	}

	public Message getMessage(long id) {
		for (Message message : messages) {
			if (message.getId() == id) {
				return message;
			}
		}
		return null;
	}

	public List<Message> getMessages() {
		return messages;
	}

	@Override
	public void addMessage(Message message) {
        int nextIdValue = idCounter.getAndIncrement();
        message.setId(nextIdValue);
        messages.add(message);
        logger.debug("The new message with id + " + nextIdValue + " has been added");
	}
}