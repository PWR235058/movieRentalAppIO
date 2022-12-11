package App;

public class Client {

	private int id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;

	public String getUserName() {
		return this.userName;
	}

	public String getPassword() {
		return this.password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public int getId(){
		return this.id;
	}

	public Client(int id, String userName, String password, String firstName, String lastName) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 *
	 * @param id
	 * @param userName
	 * @param password
	 * @param firstName
	 * @param lastName
	 */
}