package ca.poc.uilogic.domain.wms;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WMS Domain class for: single task info from WMS.
 * 
 * @author daniel.fryze
 */
public class WmsTaskInfo {

	@JsonProperty("taskTypeID")
	private String taskTypeID;

	@JsonProperty("name")
	private String name;

	@JsonProperty("priority")
	private String priority;

	@JsonProperty("expireDate")
	private String expireDate;

	@JsonProperty("createdDate")
	private String createdDate;

	@JsonProperty("status")
	private String status;

	@JsonProperty("createdBy")
	private String createdBy;

	@JsonProperty("assignedToList")
	private String[] assignedToList;

	public WmsTaskInfo() {
	}

	// GETTERS AND SETTERS

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public String getTaskTypeID() {
		return taskTypeID;
	}

	public void setTaskTypeID(String taskTypeID) {
		this.taskTypeID = taskTypeID;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String[] getAssignedToList() {
		return assignedToList;
	}

	public void setAssignedToList(String[] assignedToList) {
		this.assignedToList = assignedToList;
	}
}