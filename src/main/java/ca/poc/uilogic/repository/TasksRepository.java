package ca.poc.uilogic.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.poc.uilogic.domain.Task;
import ca.poc.uilogic.repository.interfaces.ITasksRepository;

/**
 * Repository (mock) implementation for: tasks.
 * 
 * @author daniel.fryze
 */
@Named("tasksRepository")
public class TasksRepository implements ITasksRepository {

	private static Logger logger = LoggerFactory.getLogger(TasksRepository.class);

	private List<Task> tasks;

	private AtomicInteger idCounter = new AtomicInteger(0);

	public TasksRepository() {
		init();
	}

	private void init() {
		tasks = new ArrayList<Task>();
	}

	public Task getTask(String id) {
		for (Task task : tasks) {
			if (task.getId().equals(id)) {
				return task;
			}
		}
		return null;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	@Override
	public void addTask(Task task) {
        int nextIdValue = idCounter.getAndIncrement();
        task.setId(Integer.toString(nextIdValue));
        tasks.add(task);
        logger.debug("The new task with id + " + nextIdValue + " has been added");
	}
}