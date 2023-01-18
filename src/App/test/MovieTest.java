package App.test;

import App.Enums.MovieCategories;
import App.Resources.Movie;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.util.ArrayList;

public class MovieTest {
    Movie movie;
    String name, description, director;
    LocalDate date;
    int duration;
    ArrayList<MovieCategories> listOfCategories;
    float price;


    @Before
    public void setUp(){
        name ="name";
        description = "description";
        director = "direcotr";
        date = LocalDate.now() ;
        duration =100;
        price = 42;
        listOfCategories = new ArrayList<>();
        listOfCategories.add(MovieCategories.ADVENTURE);

        movie = new Movie(1,name,description,director,duration,price,date,listOfCategories);
    }


    @Test
    public void shouldCreateComponent(){
        Assertions.assertTrue(movie != null);
    }

    @Test
    public void gttersShouldReturnPropperValues(){
        Assertions.assertEquals(director,movie.getDirector());
        Assertions.assertEquals(name,movie.getName());
        Assertions.assertEquals(price,movie.getPrice());
        Assertions.assertEquals(duration,movie.getDuration());
        Assertions.assertEquals(1,movie.getId());
        Assertions.assertEquals(date,movie.getReleaseDate());
        Assertions.assertEquals(listOfCategories.get(0), movie.getCategories().get(0));
    }
}
