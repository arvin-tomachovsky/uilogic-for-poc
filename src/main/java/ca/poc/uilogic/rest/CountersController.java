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

import ca.poc.uilogic.domain.Counter;
import ca.poc.uilogic.service.interfaces.ICountersService;

/**
 * Rest controller for: operations on counters.
 * 
 * @author daniel.fryze
 */
@CrossOrigin
@RestController
@RequestMapping("/counter")
public class CountersController {

	private Logger logger = LoggerFactory.getLogger(CountersController.class);

	private ICountersService countersService;

	@Inject
	public CountersController(@Named("countersService") ICountersService countersService) {
		this.countersService = countersService;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Counter> getMessages() {
		logger.debug("Rest controller has received request to get all counters");
		return countersService.getCounters();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Counter getCounter(@PathVariable("id") Long id) {
		logger.debug("Rest controller has received request to get counter with id: " + id);
		return countersService.getCounter(id);
	}
}