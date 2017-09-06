package ca.poc.uilogic.service.interfaces;

import java.util.List;

import ca.poc.uilogic.domain.Counter;

/**
 * Service interface for: operations on counters.
 * 
 * @author daniel.fryze
 */
public interface ICountersService {

	List<Counter> getCounters();

	Counter getCounter(long id);

	long getCountersCount();
}