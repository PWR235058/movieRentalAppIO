package App.test;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory({ClientTTest.class})
@Suite.SuiteClasses({
        ClientTest.class,
        ClientsTest.class
})
public class ClientTTestCategory {
}
