package co.edu.uptc.model;

import java.util.ArrayList;

public class User extends Person {

    private String userName;
    private ArrayList<Multimedia> wishList = new ArrayList<>();
    private ArrayList<Multimedia> playlist = new ArrayList<>();
    private Plan plan;

    public User(String name, String email, String password, String userName, Plan plan) {
        super(name, email, password);
        this.userName = userName;
        this.plan = plan;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<Multimedia> getWishList() {
        return wishList;
    }

    public void setWishList(ArrayList<Multimedia> wishList) {
        this.wishList = wishList;
    }

    public ArrayList<Multimedia> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(ArrayList<Multimedia> playlist) {
        this.playlist = playlist;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return super.toString() + "User [userName=" + userName + ", wishList=" + wishList + ", playlist=" + playlist
                + ", plan=" + plan
                + "]";
    }

    public boolean equals(User user) {
        if (user.getUserName().equals(userName)) {
            return true;
        }
        return false;
    }

    public int compareTo(User user) {
        int result = -1;

        if (this.userName == user.getUserName()) {
            result = 0;
        } else if (this.userName.compareTo(user.getUserName()) > 0) {
            result = 1;
        }
        return result;
    }
}
