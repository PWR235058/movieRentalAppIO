package App.Resources;

import java.util.ArrayList;

public class Reservation {

	private Client client = null;
	private ArrayList<Movie> movies;
	private String firstName = null;
	private String lastName = null;
	private int id;

	public String getFirstName() {
		if(client != null) return client.getFirstName();
		return this.firstName;
	}

	public String getLastName() {
		if(client != null) return client.getLastName();
		return this.lastName;
	}

	public Client getClient() {
		return this.client;
	}

	public int getClientId() {
		return this.client.getId();
	}

	public int getId() { return this.id; }

	public ArrayList<Movie> getMovies() { return this.movies; }

	/**
	 *
	 * @param movies
	 * @param firstName
	 * @param lastName
	 */

	public Reservation(String firstName, String lastName, ArrayList<Movie> movies, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.movies = movies;
		this.id = id;
	}

	/**
	 * 
	 * @param client
	 * @param movies
	 */
	public Reservation(Client client, ArrayList<Movie> movies, int id) {
		this.client = client;
		this.movies = movies;
		this.id = id;
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
		this.movies.remove(Movies.getInstance().getMovieById(movieId));
	}

}
