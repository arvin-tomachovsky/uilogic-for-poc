package ca.poc.uilogic.domain.wms;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WMS Domain class for: single task info from WMS.
 * 
 * @author daniel.fryze
 */
public class WmsTaskInfo {

	@JsonProperty("name")
	private String name;

	@JsonProperty("expireDate")
	private String expireDate;

	@JsonProperty("createdDate")
	private String createdDate;

	@JsonProperty("status")
	private String status;

	@JsonProperty("createdBy")
	private String createdBy;

	public WmsTaskInfo() {
	}

	// GETTERS AND SETTERS

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
}