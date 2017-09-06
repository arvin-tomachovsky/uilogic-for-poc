package ca.poc.uilogic.rest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ca.poc.uilogic.domain.Message;
import ca.poc.uilogic.service.interfaces.IMessagesService;

/**
 * Rest controller for: operations on messages.
 * 
 * @author daniel.fryze
 */
@CrossOrigin
@RestController
@RequestMapping("/message")
public class MessagesController {

	private Logger logger = LoggerFactory.getLogger(MessagesController.class);

	private IMessagesService messagesService;

	@Inject
	public MessagesController(@Named("messagesService") IMessagesService messagesService) {
		this.messagesService = messagesService;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Message> getMessages() {
		logger.debug("Rest controller has received request to get all messages");
		return messagesService.getMessages();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Message getMessage(@PathVariable("id") Long id) {
		logger.debug("Rest controller has received request to get message with id: " + id);
		return messagesService.getMessage(id);
	}
}