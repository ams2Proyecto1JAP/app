package com.ieti.duolingoproyect.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShopItemsModel implements Serializable {

    private int id;

    private int price;

    private String image;

    private String type;

    private String name;

    private String description;

    private List<UsersModel> usersAdquired;

    public ShopItemsModel(){}
    public ShopItemsModel(int price, String image, String type, String name, String description) {
        super();
        this.price = price;
        this.image = image;
        this.type = type;
        this.name = name;
        this.description = description;
        this.usersAdquired = new ArrayList<UsersModel>();
    }

    public void userBuy (UsersModel usr)
    {
        this.usersAdquired.add(usr);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<UsersModel> getUsersAdquired() {
        return usersAdquired;
    }
    public void setUsersAdquired(List<UsersModel> usersAdquired) {
        this.usersAdquired = usersAdquired;
    }
}

