package co.edu.uptc.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Serie extends Multimedia {
    private int numberSeasons;
    private ArrayList<Season> seasons;

    public Serie(String title, String description, String category, LocalDate publication, boolean reproduce,
            int numberSeasons) {
        super(title, description, category, publication, reproduce);
        this.numberSeasons = numberSeasons;
        seasons = new ArrayList<>();
    }

    public void addSeason(Season season) {
        seasons.add(season);
    }

    public int getNumberSeasons() {
        return numberSeasons;
    }

    public void setNumberSeasons(int numberSeasons) {
        this.numberSeasons = numberSeasons;
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(ArrayList<Season> seasons) {
        this.seasons = seasons;
    }

    @Override
    public String toString() {
        return super.toString() + "Serie [numberSeasons=" + numberSeasons + ", seasons=" + seasons + "]";
    }

}