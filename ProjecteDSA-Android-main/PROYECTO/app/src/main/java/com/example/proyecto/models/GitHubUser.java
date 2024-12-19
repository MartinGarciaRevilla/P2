package com.example.proyecto.models;

public class GitHubUser {
    private String login;
    private String avatar_url;
    private int followers;
    private int following;

    // Getters and setters
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }
    public void setFollowing(int following) {
        this.following = following;
    }


}




