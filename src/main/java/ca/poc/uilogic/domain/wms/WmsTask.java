package ca.poc.uilogic.domain.wms;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WMS Domain class for: single task from WMS.
 * 
 * @author daniel.fryze
 */
public class WmsTask {

	@JsonProperty("TaskID")
	private String taskId;

	@JsonProperty("TaskInfo")
	private WmsTaskInfo taskInfo;

	@JsonProperty("TaskData")
	private WmsTaskData taskData;

	public WmsTask() {
	}

	@Override
	public int hashCode() {
		return (int) (Long.parseLong(taskId) ^ (Long.parseLong(taskId) >>> 32));
	}

	@Override
	public boolean equals(Object param) {

		if (this == param) {
			return true;
		}
		if (param == null || getClass() != param.getClass()) {
			return false;
		}

		WmsTask task = (WmsTask) param;

		return taskId.equals(task.taskId);
	}

	// GETTERS AND SETTERS

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public WmsTaskInfo getTaskInfo() {
		return taskInfo;
	}

	public void setTaskInfo(WmsTaskInfo taskInfo) {
		this.taskInfo = taskInfo;
	}

	public WmsTaskData getTaskData() {
		return taskData;
	}

	public void setTaskData(WmsTaskData taskData) {
		this.taskData = taskData;
	}
}