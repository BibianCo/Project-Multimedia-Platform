package co.edu.uptc.test;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import co.edu.uptc.controller.AdministratorController;
import co.edu.uptc.controller.UserController;
import co.edu.uptc.model.Category;
import co.edu.uptc.model.Plan;

public class UserControllerTest {

    AdministratorController administratorController = new AdministratorController();
    UserController userController = new UserController(administratorController);

    public void addMultimedia() {
        administratorController.addMovie("Movie1", "Description1", 2, LocalDate.of(2020, 2, 2), 0);

        administratorController.addMovie("Movie2", "Description2", 2, LocalDate.of(2222, 12, 22),
                0);

        administratorController.addSerie("Serie1", "Description1", 2, LocalDate.of(2020, 2, 2));
    }

    @Test
    void addWishList() {
        assertEquals(false, userController.addWishList("PruebaNull"));
        addMultimedia();
        assertEquals(true, userController.addWishList("Movie1"));
        assertEquals(true, userController.addWishList("Serie1"));
        assertEquals(false, userController.addWishList("NoExist"));
        assertEquals(true, userController.addWishList("Movie2"));
    }

    @Test
    void addUserTreeSet() {

        userController.addUser("Name1", "email1@gmail.com", "Aaaaa12", "UserName1", new Plan());
        // Same
        userController.addUser("Name1", "email1@gmail.com", "Aaaaa12", "UserName1", new Plan());
        // Diferent
        userController.addUser("Name7", "email7@gmail.com", "Aaaaa12", "UserName7", new Plan());
        // Same Name and Password
        userController.addUser("Name2", "email3@gmail.com", "Aaaaa12", "UserName3", new Plan());
        // Same email - No se añade
        userController.addUser("Name4", "email3@gmail.com", "Aaaaa4", "UserName4", new Plan());
        // Same userName - Se añade - Ya no
        userController.addUser("Name4", "email4@gmail.com", "Aaaaa4", "UserName3", new Plan());
        System.out.println(userController.showUser());
    }
}
