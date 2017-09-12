package ca.poc.uilogic.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Domain class for: update tasks details.
 * 
 * @author daniel.fryze
 */
public class UpdateTask {

	@JsonProperty("TasksIds")
	private UpdateTaskIds updateTaskIds;

	@JsonProperty("UserId")
	private UpdateTaskUserId userId;

	public UpdateTask() {
	}

	// GETTERS AND SETTERS

	public UpdateTaskIds getUpdateTaskIds() {
		return updateTaskIds;
	}

	public void setUpdateTaskIds(UpdateTaskIds updateTaskIds) {
		this.updateTaskIds = updateTaskIds;
	}

	public UpdateTaskUserId getUserId() {
		return userId;
	}

	public void setUserId(UpdateTaskUserId userId) {
		this.userId = userId;
	}
}