package App;

import java.util.ArrayList;

public class Reservation {

	private ArrayList<Movie> movies;
	private String firstName = null;
	private String lastName = null;
	private int id;
	private Client registeredClient = null;


	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public Client getClient() { return this.registeredClient; }

	public int getId() { return this.id; }

	public ArrayList<Movie> getMovies() { return this.movies; }

	/**
	 *
	 * @param movies
	 * @param firstName
	 * @param lastName
	 */

	public void Reservation(ArrayList<Movie> movies, String firstName, String lastName) {
		this.movies = movies;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * 
	 * @param movies
	 * @param clientId
	 */
	public void Reservation(ArrayList<Movie> movies, int clientId) {
		this.movies = movies;
		this.registeredClient = Clients.getInstance().getClientById(clientId);
	}

	/**
	 * 
	 * @param movieId
	 */
	public void addMovieToReservation(int movieId) {
		this.movies.add(Movies.getInstance().getMovieById(movieId));
	}

	/**
	 * 
	 * @param movieId
	 */
	public void removeMovieFromReservation(int movieId) {
		this.movies.
	}




}