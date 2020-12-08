package com.ieti.duolingoproyect.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LangModel implements Serializable {

    public LangModel() {}
    public LangModel(String nombre, String locale) {
        super();
        this.nombre = nombre;
        this.locale = locale;
        users = new ArrayList<UsersModel>();
        crsLangOrigin = new ArrayList<CrsModel>();
        crsLangDestiny = new ArrayList<CrsModel>();
    }

    private int id;

    private String nombre;

    private String locale;

    private List<UsersModel> users;

    private List<CrsModel> crsLangOrigin;

    private List<CrsModel> crsLangDestiny;

    public void addUser(UsersModel usr)
    {
        this.users.add(usr);
    }
    public int getId()
    {
        return this.id;
    }

    public List<CrsModel> getCrsLangOrigin() {
        return crsLangOrigin;
    }

    public void setCrsLangOrigin(List<CrsModel> crsLangOrigin) {
        this.crsLangOrigin = crsLangOrigin;
    }

    public List<CrsModel> getCrsLangDestiny() {
        return crsLangDestiny;
    }

    public void setCrsLangDestiny(List<CrsModel> crsLangDestiny) {
        this.crsLangDestiny = crsLangDestiny;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getLocale() {
        return locale;
    }
    public void setLocale(String locale) {
        this.locale = locale;
    }
    public List<UsersModel> getUsers() {
        return users;
    }
    public void setUsers(List<UsersModel> users) {
        this.users = users;
    }
    public void setId(int id) {
        this.id = id;
    }
}

