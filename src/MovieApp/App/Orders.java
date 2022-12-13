package MovieApp.App;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Orders {

	private ArrayList<Order> listOfOrders;
	private static Orders instance;

	public ArrayList<Order> getOrders() {
		return this.listOfOrders;
	}

	/**
	 * 
	 * @param id
	 */
	public Order getOrderById(int id) {
		return this.listOfOrders.stream()
				.filter(order -> order.getOrderId() == id)
				.collect(Collectors.toList()).get(0);
	}

	/**
	 * 
	 * @param clientId
	 * @param price
	 * @param returned
	 * @param returnDate
	 */
	public ArrayList<Order> searchOrders(int clientId, float price, Boolean returned, LocalDate returnDate) {
		List<Order> filteredList= this.listOfOrders.stream().filter(
				order -> order.getClientId()==clientId || order.getPrice() == price || order.getIsReturned() == returned || order.getReturnDate().equals(returnDate)
		).collect(Collectors.toList());

		return new ArrayList<>(filteredList);
	}

	/**
	 * 
	 * @param listOfMovies
	 * @param clientId
	 * @param returnDate
	 * @param id
	 */
	public void addOrder(ArrayList<Movie> listOfMovies,int clientId,LocalDate returnDate ,int id) {
		this.listOfOrders.add(new Order(listOfMovies,clientId,returnDate,this.listOfOrders.size()+1));
	}

	public static Orders getInstance() {
		if(instance == null){
			instance = new Orders();
		}
		return instance;
	}

	private Orders() {
		this.listOfOrders = new ArrayList<>();
	}

}