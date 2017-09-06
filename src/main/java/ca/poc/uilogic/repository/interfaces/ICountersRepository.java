package ca.poc.uilogic.repository.interfaces;

import java.util.List;

import ca.poc.uilogic.domain.Counter;

/**
 * Repository interface for: counters.
 * 
 * @author daniel.fryze
 */
public interface ICountersRepository {

	List<Counter> getCounters();

	Counter getCounter(long id);

	void addCounter(Counter counter);
}