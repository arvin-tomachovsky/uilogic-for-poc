package ca.poc.uilogic.repository.interfaces;

import java.util.List;

import ca.poc.uilogic.domain.Client;

/**
 * Repository interface for: clients.
 * 
 * @author daniel.fryze
 */
public interface IClientsRepository {

	List<Client> getClients();

	Client getClient(long id);

	void addClient(Client message);
}