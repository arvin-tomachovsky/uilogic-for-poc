package ca.poc.uilogic.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ca.poc.uilogic.domain.Counter;
import ca.poc.uilogic.repository.interfaces.ICountersRepository;
import ca.poc.uilogic.service.interfaces.ICountersService;

/**
 * Service implementation for: operations on counters.
 * 
 * @author daniel.fryze
 */
@Named("countersService")
public class CountersService implements ICountersService {

	private ICountersRepository countersRepository;

	@Inject
	public CountersService(@Named("countersRepository") ICountersRepository countersRepository) {
		this.countersRepository = countersRepository;
		init();
	}

	private void init() {
		countersRepository.addCounter(new Counter("wszystkie", 12));
		countersRepository.addCounter(new Counter("kampanie", 151));
		countersRepository.addCounter(new Counter("longchannel", 30));
	}

	public Counter getCounter(long id) {
		return countersRepository.getCounter(id);
	}

	public List<Counter> getCounters() {
		return countersRepository.getCounters();
	}

	public long getCountersCount() {
		return getCounters().size();
	}
}