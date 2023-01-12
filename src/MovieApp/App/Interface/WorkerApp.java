package App.Interface;

import App.Resources.*;
import App.Enums.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class WorkerApp {

	private ArrayList<Movie> ListOfMovies;

	public void registerClient() {
		Clients.getInstance().addClient("userName","password","Jakub", "Mordalski");
	}

	public void showMovies(){
		Movies.getInstance().getListOfMovies().forEach(item -> {
			System.out.println(item.getName()+" "+item.getDirector()+" "+item.getPrice()+" "+item.getCategories());
		});
	}

	public void addMovie() {
		Scanner input = new Scanner(System.in);

		LocalDate releaseDate = LocalDate.now();

		ArrayList<MovieCategories> categories = new ArrayList<MovieCategories>();

		int userValue = 6;
		int index = 1;

		do{
			index = 1;
			for (MovieCategories movieCategory : MovieCategories.values()) {
				index ++;
			}
			userValue ++;
			if(userValue >= MovieCategories.values().length)
				break;
			categories.add(MovieCategories.values()[userValue-1]);

		}while(userValue != index+1);

		Movies.getInstance().addMovie("Avatar","movie about avatar","", 1,70 , releaseDate, categories);
	}

	public void createOrder() {
		Orders.getInstance().addOrder(Clients.getInstance().getClientById(1),this.ListOfMovies,LocalDate.now(),1);
	}

	public void addMovieToList(){
		this.ListOfMovies.add(Movies.getInstance().getMovieById(1));
	}

	public void removeMovie() {
		this.ListOfMovies.remove(Movies.getInstance().getMovieById(1));
	}

	public void takeReturnOfOrder() {
		ArrayList<Orders> clientOrders = Orders.getInstance().searchOrders(1, 10.0, false, LocalDate.now());
		if(clientOrders != null) clientOrders.get(0).returnOrder(); // TODO
	}

	public void createOrderFromReservation() {
		Orders.getInstance().addOrder(Clients.getInstance().getClientById(1), Reservations.getInstance().getReservationById(1).getMovies(),LocalDate.now(), 1 );
	}

	public WorkerApp() {
		this.ListOfMovies = new ArrayList<Movie>();
	}

}
