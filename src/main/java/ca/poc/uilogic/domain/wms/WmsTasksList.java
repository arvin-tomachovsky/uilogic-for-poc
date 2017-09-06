package ca.poc.uilogic.domain.wms;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WMS Domain class for: tasks list from WMS.
 * 
 * @author daniel.fryze
 */
public class WmsTasksList {

	@JsonProperty("Tasks")
	private List<WmsTask> TasksList;

	public WmsTasksList() {
	}

	// GETTERS AND SETTERS

	public List<WmsTask> getTasksList() {
		return TasksList;
	}

	public void setTasksList(List<WmsTask> tasksList) {
		TasksList = tasksList;
	}
}