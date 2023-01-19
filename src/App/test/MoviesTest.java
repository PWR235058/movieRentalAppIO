package App.test;

import App.Enums.MovieCategories;
import App.Interface.WorkerApp;
import App.Resources.Movie;
import App.Resources.Movies;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import java.util.ArrayList;

public class MoviesTest {
    ArrayList<MovieCategories> movieCategories;
    WorkerApp workerApp;

    @Rule
    public ExpectedException expection = ExpectedException.none();

    @Before
    public void setUp(){
        Movies.getInstance().clearMovies();
        movieCategories = new ArrayList<>();
        workerApp = new WorkerApp();
    }

    @Category({MovieTTest.class})
    @Test
    public void atInitListOfMoviesShouldBeEmpty(){
        Assertions.assertEquals(0, Movies.getInstance().getListOfMovies().size());
    }


    @Category({MovieTTest.class})
    @Test
    public void shouldAddMovieToList(){
        movieCategories.add(MovieCategories.SCI_FI);
        Movies.getInstance().addMovie("name","description", "director", 100,20,LocalDate.now(),movieCategories);
        Assertions.assertEquals(1, Movies.getInstance().getListOfMovies().size());
    }


    @Category({MovieTTest.class})
    @Test
    public void gettingMovieByIdShouldReturnProperValue(){

        movieCategories.add(MovieCategories.SCI_FI);
        Movies.getInstance().addMovie("name1","description1", "director1", 100,23,LocalDate.now(),movieCategories);
        movieCategories.add(MovieCategories.ADVENTURE);
        Movies.getInstance().addMovie("name2","description2", "director2", 120,22,LocalDate.now(),movieCategories);
        movieCategories.add(MovieCategories.ANIMATION);
        Movies.getInstance().addMovie("name3","description3", "director3", 130,21,LocalDate.now(),movieCategories);

        Movie movie = Movies.getInstance().getMovieById(1);

        Assertions.assertEquals("name1", movie.getName());
        Assertions.assertEquals("description1", movie.getDescription());
        Assertions.assertEquals("director1", movie.getDirector());

    }

    @Category({MovieTTest.class})
    @Test
    public void checkAddingMovie(){
        Assertions.assertNotNull(workerApp);
        workerApp.addMovie();
        // etc
    }

}
