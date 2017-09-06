package ca.poc.uilogic.domain.wms;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WMS Domain class for: single task data from WMS.
 * 
 * @author daniel.fryze
 */
public class WmsTaskData {

	@JsonProperty("description")
	private String description;

	public WmsTaskData() {
	}

	// GETTERS AND SETTERS

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}