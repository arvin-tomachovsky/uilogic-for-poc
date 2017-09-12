package ca.poc.uilogic.domain;

/**
 * Domain class for: task.
 * 
 * @author daniel.fryze
 */
public class Task {

	private String id;
	private String title;
	private String client;
	private String operator;

	private long setDate;
	private long expirationDate;

	private String status;
	private String result;

	boolean urgent;
	boolean recurring;
	boolean myTask;

	public Task() {
	}

	public Task(String title, String client, long setDate, long expirationDate, String status, String result,
			boolean urgent, boolean recurring, boolean myTask) {
		this.title = title;
		this.client = client;
		this.setDate = setDate;
		this.expirationDate = expirationDate;
		this.status = status;
		this.result = result;
		this.urgent = urgent;
		this.recurring = recurring;
		this.myTask = myTask;
	}

	public Task(String id, String title, String client, long setDate, long expirationDate, String status, String result,
			boolean urgent, boolean recurring, boolean myTask) {
		this(title, client, setDate, expirationDate, status, result, urgent, recurring, myTask);
		this.id = id;
	}

	@Override
	public int hashCode() {
		return (int) (Long.parseLong(id) ^ (Long.parseLong(id) >>> 32));
	}

	@Override
	public boolean equals(Object param) {

		if (this == param) {
			return true;
		}
		if (param == null || getClass() != param.getClass()) {
			return false;
		}

		Task task = (Task) param;

		return id.equals(task.id);
	}

	// GETTERS AND SETTERS

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getSetDate() {
		return setDate;
	}

	public void setSetDate(long setDate) {
		this.setDate = setDate;
	}

	public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}

	public boolean isRecurring() {
		return recurring;
	}

	public void setRecurring(boolean recurring) {
		this.recurring = recurring;
	}

	public boolean isMyTask() {
		return myTask;
	}

	public void setMyTask(boolean myTask) {
		this.myTask = myTask;
	}

	public void setExpirationDate(long expirationDate) {
		this.expirationDate = expirationDate;
	}

	public long getExpirationDate() {
		return expirationDate;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
}