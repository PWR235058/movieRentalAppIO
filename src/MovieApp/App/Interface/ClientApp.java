package App.Interface;

import App.Resources.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientApp {

	private ArrayList<Movie> basket;
	private Client client = null;

	public void findMovies() {
		Scanner input = new Scanner(System.in);
		Movies movies = Movies.getInstance();
		String name,director;
		System.out.println("Search criteria: \nName:");
		name = input.nextLine();
		System.out.println("Director: \n");
		director = input.nextLine();
		// etc
		basket = movies.searchMovies(name, director, 0, 9999, LocalDate.of(1999, 01, 01), LocalDate.now());
		createReservation();
	}

	public void createReservation() {
		if(client != null) Reservations.getInstance().addReservation(this.client, this.basket);
		else Reservations.getInstance().addReservation("Jan", "Kowalski", this.basket); // TODO
	}

	public void addMovieToBasket() {
		this.basket.add(Movies.getInstance().getMovieById(1));
	}

	public void removeMovieFromBasket() {
		this.basket.remove(Movies.getInstance().getMovieById(1));
	}


	public ClientApp() {
		this.basket = new ArrayList<Movie>();
		this.client = Clients.getInstance().getClientById(1); // TODO
	}

}
