package MovieApp.App;

import java.util.ArrayList;

public class Reservation {

	private ArrayList<Movie> movies;
	private String firstName = null;
	private String lastName = null;
	private int id;
	private int clientId ;




	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public int getClientId() { return this.clientId; }

	public int getId() { return this.id; }

	public ArrayList<Movie> getMovies() { return this.movies; }

	/**
	 *
	 * @param movies
	 * @param firstName
	 * @param lastName
	 */

	public  Reservation(ArrayList<Movie> movies, String firstName, String lastName, int id) {
		this.movies = movies;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * 
	 * @param movies
	 * @param clientId
	 */
	public  Reservation(ArrayList<Movie> movies, int clientId, int id) {
		this.movies = movies;
		this.clientId = clientId;
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