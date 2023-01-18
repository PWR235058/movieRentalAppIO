package App.test;


import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory({MovieTTest.class})
@Suite.SuiteClasses({
        MoviesTest.class,
        MovieTest.class
})
public class MovieTTestCategory {
}
