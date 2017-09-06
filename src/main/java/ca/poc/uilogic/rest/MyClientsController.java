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

import ca.poc.uilogic.domain.Client;
import ca.poc.uilogic.service.interfaces.IClientsService;

/**
 * Rest controller for: operations on my clients.
 * 
 * @author daniel.fryze
 */
@CrossOrigin
@RestController
@RequestMapping("/client")
public class MyClientsController {

	private Logger logger = LoggerFactory.getLogger(MyClientsController.class);

	private IClientsService clientsService;

	@Inject
	public MyClientsController(@Named("clientsService") IClientsService clientsService) {
		this.clientsService = clientsService;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Client> getRecentClients() {
		logger.debug("Rest controller has received request to get all my clients");
		return clientsService.getMyClients();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Client getRecentClient(@PathVariable("id") Long id) {
		logger.debug("Rest controller has received request to get my client with id: " + id);
		return clientsService.getMyClient(id);
	}
}