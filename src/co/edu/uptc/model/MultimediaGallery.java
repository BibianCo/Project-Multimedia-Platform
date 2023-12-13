package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.HashMap;

public class MultimediaGallery {

    private HashMap<Integer, Serie> series;
    private HashMap<Integer, Movie> movies;
    private ArrayList<Category> categories;

    public MultimediaGallery() {
        series = new HashMap<>();
        movies = new HashMap<>();
        categories = new ArrayList<>();
        categories.add(new Category("Action"));
        categories.add(new Category("Animated"));
        categories.add(new Category("Comedy"));
        categories.add(new Category("Romance"));
        categories.add(new Category("Terror"));
        movies.put(0, new Movie("cars", null, null, null, false, 0, 0));
        movies.put(1, new Movie("rio", null, null, null, false, 0, 0));
        series.put(0, new Serie("the 100", null, null, null, false, 0));
    }

    public HashMap<Integer, Serie> getSeries() {
        return series;
    }

    public void setSeries(Integer key, Serie value) {
        series.put(key, value);
    }

    public HashMap<Integer, Movie> getMovies() {
        return movies;
    }

    public void setMovies(Integer key, Movie value) {
        movies.put(key, value);
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories.add(categories);
    }
}
