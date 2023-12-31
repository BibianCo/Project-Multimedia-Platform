package co.edu.uptc.model;

public class Serie extends Multimedia {
    private int numberSeasons;
    private Season season;

    public Serie(String title, String description, String category, int publication, boolean reproduce,
            int numberSeasons) {
        super(title, description, category, publication, reproduce);
        this.numberSeasons = numberSeasons;
        season = new Season(numberSeasons, description, category);
    }

    public int getNumberSeasons() {
        return numberSeasons;
    }

    public void setNumberSeasons(int numberSeasons) {
        this.numberSeasons = numberSeasons;
    }

}