package co.edu.uptc.controller;

import java.util.ArrayList;
import co.edu.uptc.model.Administrator;
import co.edu.uptc.model.Multimedia;
import co.edu.uptc.model.User;
import java.util.LinkedHashSet;
import co.edu.uptc.model.Plan;

public class UserController {

    private User user;
    private Administrator administrator = new Administrator(null, null, null);
    private ArrayList<Multimedia> playMultimedias = new ArrayList<>();
    private LinkedHashSet<User> users = new LinkedHashSet<>();

    public boolean addListHistory(Multimedia multimedia) {
        if (multimedia.isReproduce()) {
            playMultimedias.add(multimedia);
            user.setPlaylist(playMultimedias);
            return true;
        }
        return false;
    }

    public ArrayList<Multimedia> showListHistory() {
        return user.getPlaylist();
    }

    public boolean addUser(String name, String email, String password, String userName, Plan plan) {
        User user = new User(name, email, password, userName, plan);
        int size = users.size();
        if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty() && !userName.isEmpty()) {
            if (users.isEmpty()) {
                users.add(user);
                administrator.setUsers(users);
                return true;
            } else {
                for (User user2 : users) {
                    if (user2.getUserName().equals(userName)) {
                        return false;
                    }
                }
                users.add(user);
                administrator.setUsers(users);
                if (users.size() != size) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean authentication(String email, String password) {

        User user = findUser(email);
        if (user != null) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public User findUser(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public String showUserList() {
        return users.toString();
    }
}
