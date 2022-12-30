package App.Interface;

import App.Resources.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientApp {

	private ArrayList<Movie> basket;

	public void findMovies() {
		Scanner input = new Scanner(System.in);
		Movies movies = Movies.getInstance();
		String name,director;
		System.out.println("Search criteria: \nName:");
		name = input.nextLine();
		System.out.println("Director: \n");
		director = input.nextLine();

	}

	public void createReservation() {
		Reservations.getInstance().addReservation(Clients.getInstance().getClientById(1),this.basket );
	}

	public void addMovieToBasket() {
		this.basket.add(Movies.getInstance().getMovieById(1));
	}

	public void removeMovieFromBasket() {
		this.basket.remove(Movies.getInstance().getMovieById(1));
	}


	public ClientApp() {
		this.basket = new ArrayList<Movie>();
	}

}