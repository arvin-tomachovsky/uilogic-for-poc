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
 * Repository (mock) implementation for: recently serviced clients.
 * 
 * @author daniel.fryze
 */
@Named("recentClientsRepository")
public class RecentClientsRepository implements IClientsRepository {

	private static Logger logger = LoggerFactory.getLogger(RecentClientsRepository.class);

	private List<Client> recentClients;

	private AtomicInteger idCounter = new AtomicInteger(0);

	public RecentClientsRepository() {
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

	public void addClient(Client client) {
		int nextIdValue = idCounter.getAndIncrement();
		client.setId(nextIdValue);
		recentClients.add(client);
		logger.debug("The new client with id + " + nextIdValue + " has been added");
	}
}