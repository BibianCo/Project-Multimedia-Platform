package co.edu.uptc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import co.edu.uptc.controller.UserController;

public class UserControllerTest {

        @Test
        void testAddUser() {

                UserController userController = new UserController();

                assertEquals(true,
                                userController.addUser("name1", "email1.gmail.com", "cC1234", "userName1", null));
                assertEquals(true,
                                userController.addUser("name2", "email2.gmail.com", "cC1234", "userName2", null));

                // Comprobation with the same email
                assertEquals(false,
                                userController.addUser("name3", "email1.gmail.com", "cC1234", "userName3", null));

                // Comprobation with the same userName
                assertEquals(false,
                                userController.addUser("name4", "email4.gmail.com", "cC1234", "userName1", null));
                assertEquals(true,
                                userController.addUser("name3", "email3.gmail.com", "cC1234", "userName3", null));
        }
}
