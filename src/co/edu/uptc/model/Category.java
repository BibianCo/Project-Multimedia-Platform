package co.edu.uptc.model;

import java.util.ArrayList;

public class Category {

    private String category;
    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<Serie> series = new ArrayList<>();

    public Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Movie movie) {
        movies.add(movie);
    }

    public ArrayList<Serie> getSeries() {
        return series;
    }

    public void setSeries(Serie serie) {
        series.add(serie);
    }
}
