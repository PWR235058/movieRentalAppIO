package App.Resources;
import App.Enums.MovieCategories;
import App.Enums.MovieCategories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Movies {

	private static Movies instance;

	public static Movies getInstance(){
		if(instance == null){
			instance = new Movies();
		}
		return  instance;
	}


	private ArrayList<Movie> ListOfMovies;


	private Movies(){
		this.ListOfMovies = new ArrayList<>();

	}

	public ArrayList<Movie> getListOfMovies() {
		return this.ListOfMovies;
	}

	public ArrayList<Movie> searchMovies(String name, String director, int durationFrom, int durationTo, LocalDate releaseDateFrom, LocalDate releaseDateTo   , ArrayList<MovieCategories> categories) {
		List<Movie> filteredList = this.ListOfMovies.stream()
				.filter(movie -> movie.getName().contains(name)
						&& movie.getDirector().contains(director)
						&& movie.getDuration() > durationFrom && movie.getDuration() < durationTo
						&& movie.getReleaseDate().isAfter(releaseDateFrom) && movie.getReleaseDate().isBefore(releaseDateTo))
				.collect(Collectors.toList());

		return new ArrayList<>(filteredList);
	}

	public Movie getMovieById(int id) {
		return this.ListOfMovies.stream()
				.filter(movie -> movie.getId() == id)
				.collect(Collectors.toList()).get(0);
	}

	public void addMovie(String name, String description, String director, int duration, float price, LocalDate releaseDate, ArrayList<MovieCategories> categories) {
		this.ListOfMovies.add(new Movie(this.ListOfMovies.size()+1, name, description, director, duration, price, releaseDate, categories));
	}


	public void clearMovies(){
		this.ListOfMovies = new ArrayList<Movie>();
	}



	/**
	 * 
	 * @param name
	 * @param description
	 * @param director
	 * @param duration
	 * @param price
	 * @param releaseDate
	 * @param categories
	 */


}
