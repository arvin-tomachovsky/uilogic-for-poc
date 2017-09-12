package ca.poc.uilogic.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Domain class for: update tasks details.
 * 
 * @author daniel.fryze
 */
public class UpdateTaskIds {

	@JsonProperty("tasksId")
	private String[] tasksId;

	public UpdateTaskIds() {
	}

	// GETTERS AND SETTERS

	public String[] getTasksId() {
		return tasksId;
	}

	public void setTasksId(String[] tasksId) {
		this.tasksId = tasksId;
	}
}