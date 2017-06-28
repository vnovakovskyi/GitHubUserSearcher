package com.dev.nova.githubusersearcher.API;


import java.util.ArrayList;

public class GithubUser {

    ArrayList<UserItems> items = new ArrayList<>();

    public String getLogin(int i) {
        return items.get(i).login;
    }

    public String getAvatar_url(int i) {
        return items.get(i).avatar_url;
    }

    public String getScore(int i) {
        return items.get(i).score;
    }

    public ArrayList<UserItems> getItems() {
        return items;
    }
}

class UserItems {

    String login;
    String avatar_url;
    String score;

    public UserItems(String login, String avatar_url, String score) {
        this.login = login;
        this.avatar_url = avatar_url;
        this.score = score;
    }
}