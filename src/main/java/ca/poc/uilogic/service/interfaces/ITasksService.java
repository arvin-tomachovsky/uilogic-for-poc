package ca.poc.uilogic.service.interfaces;

import java.util.List;

import ca.poc.uilogic.domain.Task;

/**
 * Service interface for: operations on tasks.
 * 
 * @author daniel.fryze
 */
public interface ITasksService {

	List<Task> getAllTasks();

	List<Task> getUrgentTasks();

	List<Task> getExpiringTasks();

	List<Task> getCyclicalTasks();

	List<Task> getOwnTasks();

	Task getTask(String id);

	long getTasksCount();
}