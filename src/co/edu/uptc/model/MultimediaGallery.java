package co.edu.uptc.model;

import java.io.Serial;
import java.util.ArrayList;

public class MultimediaGallery {
    private ArrayList<Serie> series = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<Plan> plans = new ArrayList<>();

    public ArrayList<Serie> getSeries() {
        return series;
    }

    public void setSeries(Serie series) {
        this.series.add(series);
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void setSeries(ArrayList<Serie> series) {
        this.series = series;
    }

    public ArrayList<Plan> getPlans() {
        return plans;
    }

    public void setPlans(Plan plans) {
        this.plans.add(plans);
    }

}
