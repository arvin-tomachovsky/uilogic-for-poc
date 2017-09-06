package ca.poc.uilogic.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ca.poc.uilogic.domain.Message;
import ca.poc.uilogic.repository.interfaces.IMessagesRepository;
import ca.poc.uilogic.service.interfaces.IMessagesService;

/**
 * Service implementation for: operations on messages.
 * 
 * @author daniel.fryze
 */
@Named("messagesService")
public class MessagesService implements IMessagesService {

	private IMessagesRepository messagesRepository;

	@Inject
	public MessagesService(@Named("messagesRepository") IMessagesRepository messagesRepository) {
		this.messagesRepository = messagesRepository;
		init();
	}

	private void init() {
		messagesRepository.addMessage(new Message("2017-08-01 12:15",
				"Offline BZWBK. Utrudnienia w dostępie do transakcji kartowych.",
				"W dniu dzisiejszym wystąpią trudności techniczne w dostępie do operacji na kartach kredytowych i rachunkach ubezpieczeniowych."));
		messagesRepository.addMessage(new Message("2017-08-03 10:10",
				"Niedostępność modułu płatności przez dwa tygodnie.",
				"Przez najbliższe dwa dni z uwagi na prace serwisowe niedostępne będą moduły płatności zarówno internetowych jak i tych na aplikacjach mobilnych."));
		messagesRepository.addMessage(new Message("2017-08-07 16:05",
				"Brak dostepu do systemu Profile przez tydzień od dzisiaj",
				"Operatorzy z Back Office będą mieli utrudnienia w logowaniu do Profile z powodu na trwające tam prace serwisowe wykonywane przez zespół administratorów."));
		messagesRepository.addMessage(new Message("2017-08-11 18:00",
				"Offline Alior Bank. Utrudnienia w dostępie do transakcji krdytowych.",
				"W dniu dzisiejszym wystąpią trudności techniczne w dostępie do operacji na kartach kredytowych i niektórych ubezpieczeniwoych."));
	}

	public Message getMessage(long id) {
		return messagesRepository.getMessage(id);
	}

	public List<Message> getMessages() {
		return messagesRepository.getMessages();
	}

	public long getMessagesCount() {
		return getMessages().size();
	}
}