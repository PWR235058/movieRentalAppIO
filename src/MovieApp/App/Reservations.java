package MovieApp.App;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reservations {

	private ArrayList<Reservation> listOfReservations;
	private static Reservations instance;

	public ArrayList<Reservation> getReservations() {
		return this.listOfReservations;
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param clientId
	 */
	public ArrayList<Reservation> searchReservations(String firstName, String lastName, int clientId) {
		List<Reservation> filteredList = this.listOfReservations.stream().filter(
				reservation -> reservation.getFirstName().contains(firstName)
						|| reservation.getLastName().contains(lastName)
						|| reservation.getClientId() == clientId
		).collect(Collectors.toList());

		return new ArrayList<>(filteredList);
	}

	/**
	 * 
	 * @param id
	 */
	public Reservation getReservationById(int id) {
		return this.listOfReservations.stream()
				.filter(reservation -> reservation.getId() == id)
				.collect(Collectors.toList()).get(0);
	}

	/**
	 * 
	 * @param clientId
	 * @param movies
	 */
	public void addReservation(int clientId, ArrayList<Movie> movies) {
		this.listOfReservations.add(new Reservation(movies,clientId, this.listOfReservations.size()+1));
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param movies
	 */
	public void addReservationNewClient(String firstName, String lastName, ArrayList<Movie> movies) {
		this.listOfReservations.add(new Reservation(movies,firstName,lastName, this.listOfReservations.size()+1));
	}


	public static Reservations getInstance() {
		if(instance == null){
			instance = new Reservations();
		}
		return  instance;
	}

	private Reservations() {
		this.listOfReservations = new ArrayList<>();
	}

}