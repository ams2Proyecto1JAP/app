package com.ieti.duolingoproyect.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LvlModel implements Serializable {

    private int index;

    private CatModel cat;

    private String name;

    private List<ExsModel> exercices;

    private List<UsersModel> usersRvd;

    public LvlModel(){}
    public LvlModel(CatModel cat, int index, String name) {
        super();
        this.cat = cat;
        this.index = index;
        this.name = name;
        this.exercices = new ArrayList<ExsModel>();
        this.usersRvd = new ArrayList<UsersModel>();

    }

    public void addUserRvd(UsersModel usr)
    {
        this.usersRvd.add(usr);
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public CatModel getCat() {
        return cat;
    }
    public void setCat(CatModel cat) {
        this.cat = cat;
    }
    public List<ExsModel> getExercices() {
        return exercices;
    }
    public void setExercices(List<ExsModel> exercices) {
        this.exercices = exercices;
    }
    public List<UsersModel> getUsersRvd() {
        return usersRvd;
    }
    public void setUsersRvd(List<UsersModel> usersRvd) {
        this.usersRvd = usersRvd;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

