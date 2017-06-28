package com.dev.nova.githubusersearcher.API;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GithubRepo {

    ArrayList<RepoItems> items = new ArrayList<>();

    public String getName(int i) {
        return items.get(i).name;
    }

    public String getDescription(int i) {
        return items.get(i).description;
    }

    public String getForks(int i) {
        return items.get(i).forks;
    }

    public ArrayList<RepoItems> getItems() {
        return items;
    }

    public void setItems(int i, GithubRepo repo){
        RepoItems newItems = new RepoItems(repo.getName(0), getDescription(0), getForks(0), repo.getLogin(0), getAvatar(0));
        items.add(i, newItems);
    }


    public String getLogin(int i) {
        return items.get(i).ownerItems.login;
    }

    public String getAvatar(int i) {
        return items.get(i).ownerItems.avatar;
    }
}


class RepoItems {

    String name;
    String description;
    String forks;

    @SerializedName("owner")
    RepoOwnerItems ownerItems = new RepoOwnerItems();

    public RepoItems(String name, String description, String forks) {
        this.name = name;
        this.description = description;
        this.forks = forks;
    }

    public RepoItems(String name, String description, String forks, String login, String avatar) {
        this.name = name;
        this.description = description;
        this.forks = forks;
        this.ownerItems.login = login;
        this.ownerItems.avatar = avatar;
    }
}


class RepoOwnerItems {

    String login;

    @SerializedName("avatar_url")
    String avatar;
}
