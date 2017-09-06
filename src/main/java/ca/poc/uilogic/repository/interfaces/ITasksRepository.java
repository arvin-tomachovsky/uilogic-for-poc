package ca.poc.uilogic.repository.interfaces;

import java.util.List;

import ca.poc.uilogic.domain.Task;

/**
 * Repository interface for: tasks.
 * 
 * @author daniel.fryze
 */
public interface ITasksRepository {

	List<Task> getTasks();

	Task getTask(String id);

	void addTask(Task task);
}