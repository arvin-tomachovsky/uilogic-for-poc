package ca.poc.uilogic.domain.wms;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WMS Domain class for: single task data from WMS.
 * 
 * @author daniel.fryze
 */
public class WmsTaskData {

	@JsonProperty("Description")
	private String description;

	@JsonProperty("Deadline")
	private String deadline;

	public WmsTaskData() {
	}

	// GETTERS AND SETTERS

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
}