package ca.poc.uilogic.domain;

/**
 * Domain class for: counter.
 * 
 * @author daniel.fryze
 */
public class Counter {

	private long id;
	private String name;
	private int value;

	public Counter(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public Counter(long id, String name, int value) {
		this(name, value);
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

		Counter counter = (Counter) param;

		return id == counter.id;
	}

	// GETTERS AND SETTERS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}