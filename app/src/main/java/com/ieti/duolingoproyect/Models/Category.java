package com.ieti.duolingoproyect.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {
    private int categoryId;
    private String name;
    private ArrayList<Level> levels;

    public Category(int categoryId, String name, ArrayList<Level> levels) {
        this.categoryId = categoryId;
        this.name = name;
        this.levels = levels;
    }

    public Category(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public Category() {

    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    public void setLevels(ArrayList<Level> levels) {
        this.levels = levels;
    }
}
