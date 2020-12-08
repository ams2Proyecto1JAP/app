package com.ieti.duolingoproyect.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExsModel implements Serializable {

    private int index;

    private LvlModel lvl;

    private List<UsersModel> usersRvd;

    public ExsModel(){}
    public ExsModel(LvlModel lvl, int index) {
        super();
        this.lvl = lvl;
        this.index = index;
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
    public LvlModel getLvl() {
        return lvl;
    }
    public void setLvl(LvlModel lvl) {
        this.lvl = lvl;
    }
    public List<UsersModel> getUsersRvd() {
        return usersRvd;
    }
    public void setUsersRvd(List<UsersModel> usersRvd) {
        this.usersRvd = usersRvd;
    }
}

