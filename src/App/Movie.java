package App;

import Enums.MovieCategories;

import java.time.LocalDate;
import java.util.ArrayList;

public class Movie {

	private int id;
	private String name;
	private String description;
	private String director;
	private int duration;
	private float price;
	private LocalDate releaseDate;
	private ArrayList<MovieCategories> categories;

	public Movie(int id, String name, String description, String director, int duration, float price, LocalDate releaseDate, ArrayList<MovieCategories> categories) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.director = director;
		this.duration = duration;
		this.price = price;
		this.releaseDate = releaseDate;
		this.categories = categories;
	}

	public int getId(){
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public String getDirector() {
		return this.director;
	}

	public int getDuration() {
		return this.duration;
	}

	public float getPrice() {
		return this.price;

	}

	public LocalDate getReleaseDate() {
		return this.releaseDate;
	}

	public ArrayList<MovieCategories> getCategories() {
		return this.categories;
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