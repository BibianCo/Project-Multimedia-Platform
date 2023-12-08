package co.edu.uptc.model;

import java.util.LinkedHashSet;

public class Administrator extends Person {
    private int code;

    private LinkedHashSet<User> users = new LinkedHashSet<>();

    public Administrator(String name, String email, String password) {
        super(name, email, password);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public LinkedHashSet<User> getUsers() {
        return users;
    }

    public void setUsers(LinkedHashSet<User> users) {
        this.users = users;
    }

}
