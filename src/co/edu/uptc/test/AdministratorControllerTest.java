package co.edu.uptc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import co.edu.uptc.controller.AdministratorController;
import co.edu.uptc.model.Chapter;
import co.edu.uptc.model.MultimediaGallery;
import co.edu.uptc.model.Season;
import co.edu.uptc.model.Serie;

public class AdministratorControllerTest {

    AdministratorController administrator;
    MultimediaGallery multimediaGallery = new MultimediaGallery();

    @Before
    public void setOne() {
        administrator = new AdministratorController();
        administrator.addSerie("Prueba1", "Description1", "Category1", LocalDate.of(2020, 12, 12), 1);
        administrator.addSeason("Prueba1", "SeasonDescription", LocalDate.of(1010, 10, 10), 1);
    }

    @Test
    public void addSeason() {
        assertEquals(
                "[Multimedia [title=Prueba1, description=Description1, category=Category1, publication=2020-12-12, reproduce=false]Serie [numberSeasons=1, seasons=[Season [numberOfChapters=[], description=SeasonDescription, publicationSeason=1010-10-10, numberSeason=1]]]]",
                administrator.showSeries());

        administrator.addSeason("Prueba1", "SeasonDescription2", LocalDate.of(2020, 02, 02), 2);

        assertEquals(
                "[Multimedia [title=Prueba1, description=Description1, category=Category1, publication=2020-12-12, reproduce=false]Serie [numberSeasons=1, seasons=[Season [numberOfChapters=[], description=SeasonDescription, publicationSeason=1010-10-10, numberSeason=1], Season [numberOfChapters=[], description=SeasonDescription2, publicationSeason=2020-02-02, numberSeason=2]]]]",
                administrator.showSeries());
    }

    @Test
    public void addChapter() {

        administrator.addChapter("Prueba1", 1, 100, "Chapter Desciption 1", "Chapter prueba 1");

        assertEquals(
                "[Multimedia [title=Prueba1, description=Description1, category=Category1, publication=2020-12-12, reproduce=false]Serie [numberSeasons=1, seasons=[Season [numberOfChapters=[Chapter [duration=100, description=Chapter Desciption 1, title=Chapter prueba 1]], description=SeasonDescription, publicationSeason=1010-10-10, numberSeason=1]]]]",
                administrator.showSeries());

        administrator.addChapter("Prueba1", 1, 200, "Chapter Desciption 2", "Chapter prueba 2");

        assertEquals(
                "[Multimedia [title=Prueba1, description=Description1, category=Category1, publication=2020-12-12, reproduce=false]Serie [numberSeasons=1, seasons=[Season [numberOfChapters=[Chapter [duration=100, description=Chapter Desciption 1, title=Chapter prueba 1], Chapter [duration=200, description=Chapter Desciption 2, title=Chapter prueba 2]], description=SeasonDescription, publicationSeason=1010-10-10, numberSeason=1]]]]",
                administrator.showSeries());

        administrator.addSeason("Prueba1", "SeasonDescription2", LocalDate.of(2020, 02, 02), 2);
        administrator.addChapter("Prueba1", 2, 300, "Chapter Desciption 3", "Chapter prueba 3");

        assertEquals(
                "[Multimedia [title=Prueba1, description=Description1, category=Category1, publication=2020-12-12, reproduce=false]Serie [numberSeasons=1, seasons=[Season [numberOfChapters=[Chapter [duration=100, description=Chapter Desciption 1, title=Chapter prueba 1], Chapter [duration=200, description=Chapter Desciption 2, title=Chapter prueba 2]], description=SeasonDescription, publicationSeason=1010-10-10, numberSeason=1], Season [numberOfChapters=[Chapter [duration=300, description=Chapter Desciption 3, title=Chapter prueba 3]], description=SeasonDescription2, publicationSeason=2020-02-02, numberSeason=2]]]]",
                administrator.showSeries());
    }

    /*
     * @Before
     * public void setTwo() {
     * setOne();
     * administrator.addSerie("merlina", "s sdsdsd", "asdads", 2019);
     * 
     * }
     * 
     * @Test
     * public void addSerie() {
     * assertTrue(administrator.addSerie("merlina", "s sdsdsd", "asdads", 2019));
     * }
     * 
     * @Test
     * public void findSerie() {
     * setTwo();
     * 
     * Serie serie = administrator.findSerie("merlina");
     * assertEquals("merlina", serie.getTitle());
     * }
     * 
     * @Test
     * public void UpdateSerie() {
     * addSerie();
     * Serie serie = administrator.UpdateSerie("merlina", "asdasd", "romantica",
     * 2000);
     * assertEquals(2000, serie.getPublication());
     * }
     * 
     * @Test
     * public void deleteSerie() {
     * setTwo();
     * Serie serie = administrator.findSerie("merlina");
     * Serie serie2 = administrator.deleteSerie("merlina");
     * assertEquals(serie, serie2);
     * }
     */
}
