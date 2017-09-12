package ca.poc.uilogic.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Domain class for: update tasks details.
 * 
 * @author daniel.fryze
 */
public class UpdateTaskUserId {

	@JsonProperty("user")
	private String user;

	public UpdateTaskUserId() {
	}

	// GETTERS AND SETTERS

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}