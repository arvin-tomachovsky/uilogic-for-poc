package ca.poc.uilogic.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ca.poc.uilogic.domain.Client;
import ca.poc.uilogic.repository.interfaces.IClientsRepository;
import ca.poc.uilogic.service.interfaces.IClientsService;

/**
 * Service implementation for: operations on messages.
 * 
 * @author daniel.fryze
 */
@Named("clientsService")
public class ClientsService implements IClientsService {

	private IClientsRepository recentClientsRepository;
	private IClientsRepository myClientsRepository;

	@Inject
	public ClientsService(@Named("recentClientsRepository") IClientsRepository recentClientsRepository,
			@Named("myClientsRepository") IClientsRepository myClientsRepository) {
		this.recentClientsRepository = recentClientsRepository;
		this.myClientsRepository = myClientsRepository;
		init();
	}

	private void init() {

		recentClientsRepository.addClient(new Client(1, "Adam Jankowski", "77*******11"));
		recentClientsRepository.addClient(new Client(2, "Tomasz Hiszpański", "75*******02"));
		recentClientsRepository.addClient(new Client(3, "Janusz Hefner", "84*******43"));
		recentClientsRepository.addClient(new Client(4, "Joanna Matusiak", "82*******19"));
		recentClientsRepository.addClient(new Client(5, "Kinga Preiss", "90*******65"));

		myClientsRepository.addClient(new Client(3, "Janusz Hefner", "84*******43"));
		myClientsRepository.addClient(new Client(4, "Joanna Matusiak", "82*******19"));
		myClientsRepository.addClient(new Client(5, "Kinga Preiss", "90*******65"));
	}

	public Client getRecentClient(long id) {
		return recentClientsRepository.getClient(id);
	}

	public List<Client> getRecentClients() {
		return recentClientsRepository.getClients();
	}

	public long getRecentClientsCount() {
		return getRecentClients().size();
	}

	public Client getMyClient(long id) {
		return myClientsRepository.getClient(id);
	}

	public List<Client> getMyClients() {
		return myClientsRepository.getClients();
	}

	public long getMyClientsCount() {
		return getMyClients().size();
	}
}
