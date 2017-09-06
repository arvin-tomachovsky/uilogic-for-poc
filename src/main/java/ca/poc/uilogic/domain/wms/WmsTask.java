package ca.poc.uilogic.domain.wms;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WMS Domain class for: single task from WMS.
 * 
 * @author daniel.fryze
 */
public class WmsTask {

	@JsonProperty("TaskID")
	private String TaskID;

	@JsonProperty("TaskInfo")
	private WmsTaskInfo TaskInfo;

	@JsonProperty("TaskData")
	private WmsTaskData TaskData;

	public WmsTask() {
	}

	@Override
	public int hashCode() {
		return (int) (Long.parseLong(TaskID) ^ (Long.parseLong(TaskID) >>> 32));
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

		return TaskID.equals(task.TaskID);
	}

	// GETTERS AND SETTERS

	public String getTaskID() {
		return TaskID;
	}

	public void setTaskID(String taskID) {
		TaskID = taskID;
	}

	public WmsTaskInfo getTaskInfo() {
		return TaskInfo;
	}

	public void setTaskInfo(WmsTaskInfo taskInfo) {
		TaskInfo = taskInfo;
	}
	
	public WmsTaskData getTaskData() {
		return TaskData;
	}

	public void setTaskData(WmsTaskData taskData) {
		TaskData = taskData;
	}
}