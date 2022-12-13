package MovieApp.App;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {

	private ArrayList<Movie> listOfMovies;
	private int clientId;
	private float price;
	private LocalDate returnDate;
	private Boolean isReturned;
	private int id;

	public ArrayList<Movie> getListOfMovies() {
		return this.listOfMovies;
	}

	public int getClientId() {
		return this.clientId;
	}

	public float getPrice() {
		return this.price;
	}

	public LocalDate getReturnDate() {
		return  this.returnDate;
	}

	public Boolean getIsReturned() {
		return this.isReturned;
	}

	public int getOrderId() {
		return this.id;
	}

	/**
	 * 
	 * @param listOfMovies
	 * @param clientId
	 * @param returnDate
	 * @param id
	 */
	public Order(ArrayList<Movie> listOfMovies, int clientId, LocalDate returnDate, int id) {
		this.listOfMovies = listOfMovies;
		this.clientId = clientId;
		this.price = 0;
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