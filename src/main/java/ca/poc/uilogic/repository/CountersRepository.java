package ca.poc.uilogic.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.poc.uilogic.domain.Counter;
import ca.poc.uilogic.repository.interfaces.ICountersRepository;

/**
 * Repository (mock) implementation for: counters.
 * 
 * @author daniel.fryze
 */
@Named("countersRepository")
public class CountersRepository implements ICountersRepository {

	private static Logger logger = LoggerFactory.getLogger(CountersRepository.class);

	private List<Counter> counters;

	private AtomicInteger idCounter = new AtomicInteger(0);

	public CountersRepository() {
		init();
	}

	private void init() {
		counters = new ArrayList<Counter>();
	}

	public Counter getCounter(long id) {
		for (Counter counter : counters) {
			if (counter.getId() == id) {
				return counter;
			}
		}
		return null;
	}

	public List<Counter> getCounters() {
		return counters;
	}

	@Override
	public void addCounter(Counter counter) {
        int nextIdValue = idCounter.getAndIncrement();
        counter.setId(nextIdValue);
        counters.add(counter);
        logger.debug("The new counter with id + " + nextIdValue + " has been added");
	}
}