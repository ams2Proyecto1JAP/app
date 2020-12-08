package com.ieti.duolingoproyect.Models;

import java.io.Serializable;
import java.util.List;

public class LeagueModel implements Serializable {

    private int id;

    private String name;

    private int maxPoints;

    private List<UsersModel> users;

    public LeagueModel(){}
    public LeagueModel (String name, int maxPoints)
    {
        this.name = name;
        this.maxPoints = maxPoints;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMaxPoints() {
        return maxPoints;
    }
    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }
    public List<UsersModel> getUsers() {
        return users;
    }
    public void setUsers(List<UsersModel> users) {
        this.users = users;
    }
}

