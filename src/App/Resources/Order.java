package App.Resources;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {

	private Client client;
	private ArrayList<Movie> listOfMovies;
	private float price = 0;
	private LocalDate returnDate;
	private Boolean isReturned;
	private int id;

	public ArrayList<Movie> getListOfMovies() {
		return this.listOfMovies;
	}

	public Client getClient() {
		return this.client;
	}

	public int getClientId() {
		return this.client.getId();
	}

	public float getPrice() {
		return this.price;
	}

	public LocalDate getReturnDate() {
		return this.returnDate;
	}

	public Boolean getIsReturned() {
		return this.isReturned;
	}

	public int getOrderId() {
		return this.id;
	}

	/**
	 * 
	 * @param client
	 * @param listOfMovies
	 * @param returnDate
	 * @param id
	 */
	public Order(Client client, ArrayList<Movie> listOfMovies, LocalDate returnDate, int id) {
		this.client = client;
		this.listOfMovies = listOfMovies;
		this.listOfMovies.forEach(movie -> this.price += movie.getPrice());
		this.returnDate = returnDate;
		this.isReturned = false;
		this.id = id;

	}

	public Order(Client client, Reservation reservation, LocalDate returnDate, int id) {
		this.client = client;
		this.listOfMovies = reservation.getMovies();
		this.listOfMovies.forEach(movie -> this.price += movie.getPrice());
		this.returnDate = returnDate;
		this.isReturned = false;
		this.id = id;

	}

	public void returnOrder() {
		this.isReturned = true;
	}

	/**
	 * 
	 * @param movieId
	 */
	public void addMovieToOrder(int movieId) {
		Movie movieToAdd = Movies.getInstance().getMovieById(movieId);
		this.listOfMovies.add(movieToAdd);
		this.price += movieToAdd.getPrice();
	}

	/**
	 * 
	 * @param movieId
	 */
	public void removeMovieFromOrder(int movieId) {
		Movie movieToRemove = Movies.getInstance().getMovieById(movieId);
		this.listOfMovies.remove(movieToRemove);
		this.price -= movieToRemove.getPrice();
	}

}
