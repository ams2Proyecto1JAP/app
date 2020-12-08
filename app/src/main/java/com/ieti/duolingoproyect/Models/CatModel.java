package com.ieti.duolingoproyect.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CatModel implements Serializable {

    private int index;

    private CrsModel crs;

    private String name;

    private String image;

    private List<LvlModel> levels;

    private List<UsersModel> usersRvd;

    public CatModel(){}
    public CatModel(CrsModel crs, int index, String name, String image) {
        super();
        this.crs = crs;
        this.index = index;
        this.name = name;
        this.image = image;
        this.levels = new ArrayList<LvlModel>();
        this.usersRvd = new ArrayList<UsersModel>();
    }

    public CatModel(CrsModel crs, int index, String name) {
        super();
        this.crs = crs;
        this.index = index;
        this.name = name;
        this.levels = new ArrayList<LvlModel>();
        this.usersRvd = new ArrayList<UsersModel>();
    }

    public void addLevel(LvlModel lvl) {
        this.levels.add(lvl);
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
    public CrsModel getCrs() {
        return crs;
    }
    public void setCrs(CrsModel crs) {
        this.crs = crs;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public List<LvlModel> getLevels() {
        return levels;
    }
    public void setLevels(List<LvlModel> levels) {
        this.levels = levels;
    }
    public List<UsersModel> getUsersRvd() {
        return usersRvd;
    }
    public void setUsersRvd(List<UsersModel> usersRvd) {
        this.usersRvd = usersRvd;
    }
}

