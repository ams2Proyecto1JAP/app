package com.ieti.duolingoproyect.Models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CrsModel implements Serializable {

    private int id;
    private LangModel langOrigin;
    private LangModel langDestiny;
    private List<CatModel> categories;
    private List<UsersModel> actualUsers;
    private List<UsersModel> registeredUsers;

    public CrsModel() {}
    public CrsModel(LangModel langOrigin, LangModel langDestiny) {
        super();
        this.langOrigin = langOrigin;
        this.langDestiny = langDestiny;
        this.categories = new ArrayList<CatModel>();
        this.actualUsers = new ArrayList<UsersModel>();
        this.registeredUsers = new ArrayList<UsersModel>();
    }

    public void addCategory(CatModel cat)
    {
        this.categories.add(cat);
    }

    public void registerUser(UsersModel usr)
    {
        this.registeredUsers.add(usr);
    }
    public LangModel getLangOrigin() {
        return langOrigin;
    }
    public void setLangOrigin(LangModel langOrigin) {
        this.langOrigin = langOrigin;
    }
    public LangModel getLangDestiny() {
        return langDestiny;
    }
    public void setLangDestiny(LangModel langDestiny) {
        this.langDestiny = langDestiny;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<CatModel> getCategories() {
        return categories;
    }
    public void setCategories(List<CatModel> categories) {
        this.categories = categories;
    }
    public List<UsersModel> getActualUsers() {
        return actualUsers;
    }
    public void setActualUsers(List<UsersModel> actualUsers) {
        this.actualUsers = actualUsers;
    }
    public List<UsersModel> getRegisteredUsers() {
        return registeredUsers;
    }
    public void setRegisteredUsers(List<UsersModel> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }
}
