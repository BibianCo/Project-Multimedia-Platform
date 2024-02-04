package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.Date;

public class Serie extends Multimedia {

    private ArrayList<Category> categories;

    public Serie() {
        super();
        this.categories = new ArrayList<>();
    }

    public Serie(int id, String title, String synopsis, Date releaseDate, ArrayList<Category> categories) {
        super(id, title, synopsis, releaseDate);
        this.categories = categories;

    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

}
