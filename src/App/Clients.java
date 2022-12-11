package App;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Clients {

	private ArrayList<Client> listOfClients;

	private static Clients instance = null;

	private Clients() {
		this.listOfClients = new ArrayList<>();
	}

	public static Clients getInstance(){
		if(instance == null){
			instance = new Clients();
		}
		return instance;
	}

	public ArrayList<Client> getClients() {
		return this.listOfClients;
	}

	/**
	 * 
	 * @param id
	 */
	public Client getClientById(int id) {
		return this.listOfClients.stream()
				.filter(movie -> movie.getId() == id)
				.collect(Collectors.toList()).get(0);
	}

	/**
	 * 
	 * @param userName
	 * @param firstName
	 * @param lastName
	 */
	public ArrayList<Client> searchClients(String userName, String firstName, String lastName) {
		List<Client> filteredList = this.listOfClients.stream()
				.filter(client -> client.getUserName().contains(userName) && client.getFirstName().contains(firstName) && client.getLastName().contains(lastName))
				.collect(Collectors.toList());
		return new ArrayList<Client>(filteredList);
	}

	/**
	 *
	 * @param userName
	 * @param password
	 * @param firstName
	 * @param lastName
	 */
	public void addClient(String userName, String password, String firstName, String lastName) {
		LinkedList<Client> localLinkedList = (LinkedList<Client>) this.listOfClients.stream().toList();
		this.listOfClients.add(new Client(localLinkedList.getLast().getId()+1,userName, password, firstName,lastName));
	}

}