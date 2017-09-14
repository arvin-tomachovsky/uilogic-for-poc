package ca.poc.uilogic.rest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ca.poc.uilogic.domain.Task;
import ca.poc.uilogic.domain.UpdateTask;
import ca.poc.uilogic.service.interfaces.ITasksService;

/**
 * Rest controller for: operations on tasks.
 * 
 * @author daniel.fryze
 */
@CrossOrigin
@RestController
@RequestMapping("/task")
public class TasksController {

	private Logger logger = LoggerFactory.getLogger(TasksController.class);

	private ITasksService tasksService;

	@Value("#{environment['services.mode']}")
	private String mode;
	
	@Inject
	public TasksController(@Named("tasksService") ITasksService tasksService) {
		this.tasksService = tasksService;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Task> getAllTasks() {
		logger.debug("Rest controller has received request to get all tasks");
		return tasksService.getAllTasks(null);
	}

	@RequestMapping(value = "/all/{user}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Task> getAllTasks(@PathVariable("user") String user) {
		logger.debug("Rest controller has received request to get all tasks for given user");
		return tasksService.getAllTasks((user != null && "null".equals(user)) ? null : user);
	}

	@RequestMapping(value = "/{taskId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Task getTask(@PathVariable("taskId") String taskId) {
		logger.debug("Rest controller has received request to get task with id: " + taskId);
		return tasksService.getTask(taskId);
	}

	@RequestMapping(value = "/urgent", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Task> getUrgentTasks() {
		logger.debug("Rest controller has received request to get urgent tasks");
		return tasksService.getAllTasks(null);
	}

	@RequestMapping(value = "/expring", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Task> getExpiringTasks() {
		logger.debug("Rest controller has received request to get expiring tasks");
		return tasksService.getAllTasks(null);
	}

	@RequestMapping(value = "/cyclical", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Task> getCyclicalTasks() {
		logger.debug("Rest controller has received request to get cyclical tasks");
		return tasksService.getAllTasks(null);
	}

	@RequestMapping(value = "/own", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Task> getOwnTasks() {
		logger.debug("Rest controller has received request to get own tasks");
		return tasksService.getAllTasks(null);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void reassignTask(@RequestBody UpdateTask updateDetails) {
		logger.debug("Rest controller has received request to update task");
		if (updateDetails != null && updateDetails.getUserId() != null && updateDetails.getUserId().getUser() != null && updateDetails.getUserId().getUser().length() > 0 && updateDetails.getUpdateTaskIds() != null && updateDetails.getUpdateTaskIds().getTasksId() != null) {
			for (String taskId : updateDetails.getUpdateTaskIds().getTasksId()) {
				if (taskId != null && taskId.length() > 0) {
					tasksService.updateTaskOwner(taskId, updateDetails.getUserId().getUser());
				}
			}
		}
	}
}