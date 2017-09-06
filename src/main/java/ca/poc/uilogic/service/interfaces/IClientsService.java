package ca.poc.uilogic.service.interfaces;

import java.util.List;

import ca.poc.uilogic.domain.Client;

/**
 * Service interface for: operations on recently serviced clients.
 * 
 * @author daniel.fryze
 */
public interface IClientsService {

	List<Client> getRecentClients();

	Client getRecentClient(long id);

	long getRecentClientsCount();

	List<Client> getMyClients();

	Client getMyClient(long id);

	long getMyClientsCount();
}