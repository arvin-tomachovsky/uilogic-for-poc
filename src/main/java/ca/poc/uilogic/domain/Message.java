package ca.poc.uilogic.domain;

/**
 * Domain class for: single notification item.
 * 
 * @author daniel.fryze
 */
public class Message {

	private long id;
	private String date;
	private String title;
	private String content;

	public Message(String date, String title, String content) {
		this.date = date;
		this.setTitle(title);
		this.content = content;
	}

	public Message(long id, String date, String title, String content) {
		this(date, title, content);
		this.id = id;
	}

	@Override
	public int hashCode() {
		return (int) (id ^ (id >>> 32));
	}

	@Override
	public boolean equals(Object param) {

		if (this == param) {
			return true;
		}
		if (param == null || getClass() != param.getClass()) {
			return false;
		}

		Message message = (Message) param;

		return id == message.id;
	}

	// GETTERS AND SETTERS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
