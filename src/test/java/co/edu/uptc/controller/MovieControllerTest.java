package co.edu.uptc.controller;

import static org.junit.Assert.assertNull;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;

import co.edu.uptc.model.Category;
import co.edu.uptc.model.Movie;
import co.edu.uptc.persistence.FilePersistence;

public class MovieControllerTest {
    public static MovieController movieController;
    // public static InMemoryPersistence<Movie> inMemoryPersistence;
    public static FilePersistence<Category> ifpc;
    public static FilePersistence<Movie> inFilePersistence;
    public static CategoryController categoryController;
    private Type type;
    private Type type2;

    public static ArrayList<Category> cat1 = new ArrayList<>();
    public static ArrayList<Category> cat2 = new ArrayList<>();
    public static ArrayList<Category> cat3 = new ArrayList<>();
    public static ArrayList<Category> cat4 = new ArrayList<>();
    public static Movie m1 = new Movie();
    public static Movie m2 = new Movie();
    public static Movie m3 = new Movie();

    @Before
    public void setUp() {
        type = new TypeToken<ArrayList<Movie>>() {
        }.getType();
        type2 = new TypeToken<ArrayList<Category>>() {
        }.getType();
        // inMemoryPersistence = new InMemoryPersistence<Movie>();
        ifpc = new FilePersistence<>(type2, "categories");

        categoryController = new CategoryController(ifpc);
        inFilePersistence = new FilePersistence<Movie>(type, "movies");
        movieController = new MovieController(inFilePersistence, categoryController);

        // Create files
        inFilePersistence.createFile();
        ifpc.createFile();

        Category c1 = new Category(122, "Romance");
        Category c2 = new Category(123, "Drama");
        Category c3 = new Category(124, "Terror");
        categoryController.add(c1);
        categoryController.add(c2);
        categoryController.add(c3);

        Category cp1 = new Category(0, null);
        Category cp2 = new Category(122, "Romance");
        Category cp3 = new Category(128, "Animada");
        Category cp4 = new Category(124, "Terror");

        cat1.add(cp1);
        cat1.add(cp2);

        cat2.add(cp3);
        cat2.add(cp1);

        cat3.add(cp4);
        cat3.add(cp2);

        cat4.add(cp2);
        cat4.add(cp3);

        m1 = new Movie(111, "Titanic", "Jack y Ross un amor imposible", LocalDate.parse("2004-05-04"), 10, cat3);
        m2 = new Movie(222, "Pinocho", "padre e hijo", LocalDate.parse("2019-04-05"), 10, cat3);
        m3 = new Movie(333, "It", "payaso asusta ninios", LocalDate.parse("2019-04-05"), 10, cat3);
        movieController.add(m1);
        movieController.add(m2);
    }

    @Test
    public void readFileTest() {
        assertFalse(inFilePersistence.readFile().toString().isEmpty());
    }

    @Test
    public void testCategoryExists() {

        assertEquals(false, movieController.categoriesExists(cat1));
        assertEquals(true, movieController.categoriesExists(cat3));
        assertEquals(false, movieController.categoriesExists(cat2));
        assertEquals(false, movieController.categoriesExists(cat4));

        assertEquals(false, movieController.categoriesExists(new ArrayList<>()));

    }

    @Test
    public void testAddMovie() {

        Movie movie = new Movie(333, "It", "payaso asusta ninios", LocalDate.parse("2019-04-05"), 10, cat3);

        assertEquals(true, movieController.add(m3));
        assertEquals(false, movieController.add(m3));
        assertEquals(false, movieController.add(movie));

    }

    @Test
    public void testDeleteMovie() {

        movieController.add(m3);

        assertEquals(false, movieController.delete(0));
        assertEquals(true, movieController.delete(333));
        assertEquals(false, movieController.delete(333));

    }

    @Test
    public void testGetMovie() {

        movieController.add(m3);
        assertEquals(333, movieController.get(333).getId());
        assertEquals(null, movieController.get(151));

    }

    @Test
    public void testGetAllMovie() {

        movieController.add(m3);
        assertEquals(111, movieController.getAll().get(0).getId());
        assertEquals(3, movieController.getAll().size());

    }

    @Test
    public void testUpdateMovie() {

        movieController.add(m3);
        assertEquals(true, movieController.update(333, m1));
        assertEquals(false, movieController.update(154, m1));
        assertEquals(true, movieController.update(111,
                new Movie(123, "Harry Potter", "trio de amigos", LocalDate.parse("2006-06-12"), 10, cat3)));

        assertEquals(false, movieController.update(333,
                new Movie(123, "Harry Potter", "trio de amigos", LocalDate.parse("2006-06-12"), 10, cat3)));
        assertEquals(null, movieController.get(333));

    }

    @Test
    public void testGroupByCategory() {
        movieController.add(m3);
        assertEquals(111, movieController.groupByCategory(124).get(0).getId());
        assertNull(movieController.groupByCategory(111));
        assertNull(movieController.groupByCategory(122));

    }

    @After
    public void tearDown() {
        inFilePersistence.deleteFile();
        ifpc.deleteFile();
    }
}
