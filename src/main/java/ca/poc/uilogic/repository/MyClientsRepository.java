package ca.poc.uilogic.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.poc.uilogic.domain.Client;
import ca.poc.uilogic.repository.interfaces.IClientsRepository;

/**
 * Repository (mock) implementation for: all my clients.
 * 
 * @author daniel.fryze
 */
@Named("myClientsRepository")
public class MyClientsRepository implements IClientsRepository {

	private static Logger logger = LoggerFactory.getLogger(MyClientsRepository.class);

	private List<Client> recentClients;

	private AtomicInteger idCounter = new AtomicInteger(0);

	public MyClientsRepository() {
		init();
	}

	private void init() {
		recentClients = new ArrayList<Client>();
	}

	public Client getClient(long id) {
		for (Client recentClient : recentClients) {
			if (recentClient.getId() == id) {
				return recentClient;
			}
		}
		return null;
	}

	public List<Client> getClients() {
		return recentClients;
	}

	@Override
	public void addClient(Client client) {
		int nextIdValue = idCounter.getAndIncrement();
		client.setId(nextIdValue);
		recentClients.add(client);
		logger.debug("The new client with id + " + nextIdValue + " has been added");
	}
}