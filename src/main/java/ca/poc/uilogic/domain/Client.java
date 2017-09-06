package ca.poc.uilogic.domain;

/**
 * Domain class for: client.
 * 
 * @author daniel.fryze
 */
public class Client {

	private long id;
	private String name;
	private String pesel;

	public Client(String name, String pesel) {
		this.name = name;
		this.pesel = pesel;
	}

	public Client(long id, String name, String pesel) {
		this(name, pesel);
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

		Client client = (Client) param;

		return id == client.id;
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

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
}