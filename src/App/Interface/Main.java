package App.Interface;

public class Main {

	private static WorkerApp workerApp;
	private static ClientApp clientApp;

	public static void showWorkerApp() {
		workerApp = new WorkerApp();
	}

	public static void showClientApp() {
		clientApp = new ClientApp();
	}

	public static void main(String[] args) {

		showWorkerApp();
		showClientApp();

		workerApp.addMovie();
		workerApp.addMovie();
		workerApp.addMovie();
		workerApp.registerClient("user", "pwd", "Jan", "Kowalski");
		workerApp.showMovies();
		clientApp.addMovieToBasket();
		clientApp.createReservation();

	}

}