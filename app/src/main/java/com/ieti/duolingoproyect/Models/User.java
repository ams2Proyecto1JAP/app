package com.ieti.duolingoproyect.Models;

public class User {
    private int id;
    private String username;
    private int points;
    private int coins;

    public User(int id, String username, int points, int coins) {
        this.id = id;
        this.username = username;
        this.points = points;
        this.coins = coins;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
