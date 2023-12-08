package co.edu.uptc.controller;

import java.util.LinkedHashSet;
import co.edu.uptc.model.Plan;
import co.edu.uptc.model.User;

public class UserController {

    LinkedHashSet<User> user = new LinkedHashSet<>();

    public boolean addUser(String name, String email, String pasword, String userName, String description, int value,
            int numberUsers, String invitationCode) {

        int size = user.size();
        if (!name.isEmpty() && !email.isEmpty() && !pasword.isEmpty() && !userName.isEmpty()
                && !description.isEmpty()) {

            if (user.isEmpty()) {
                user.add(new User(name, email, pasword, userName, new Plan(pasword, 0, 0, invitationCode)));
                return true;
            } else {
                for (User user2 : user) {
                    System.out.println("userName 1: " + user2.getUserName());
                    System.out.println("userName 2: " + userName + "\n");
                    if (user2.getUserName().equals(userName)) {
                        return false;
                    }
                }
                user.add(new User(name, email, pasword, userName, new Plan(pasword, 0, 0, invitationCode)));
                if (user.size() != size) {
                    return true;
                }
            }
        }
        return false;
    }

    public String showUser() {
        return user.toString();
    }
}
