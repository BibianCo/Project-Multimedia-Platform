package co.edu.uptc.model;

import java.util.TreeSet;

public class Administrator extends Person {
    private int code;

    private TreeSet<User> users = new TreeSet<>();

    public Administrator(String name, String email, String password) {
        super(name, email, password);
        this.code = code;
    }

    public Administrator() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public TreeSet<User> getUsers() {
        return users;
    }

    public void setUsers(TreeSet<User> users) {
        this.users = users;
    }
}
