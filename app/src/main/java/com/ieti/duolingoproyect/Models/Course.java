package com.ieti.duolingoproyect.Models;

import java.util.ArrayList;

public class Course {
    private int courseId;
    private String language;
    private ArrayList<Category> categories;
    private ArrayList<Level> currentLevels;

    public Course(int courseId, String language, ArrayList<Category> categories) {
        this.courseId = courseId;
        this.language = language;
        this.categories = categories;
    }

    public Course(int courseId, String language) {
        this.courseId = courseId;
        this.language = language;
    }

    public Course() {

    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public ArrayList<Level> getCurrentLevels() {
        return currentLevels;
    }

    public void setCurrentLevels(ArrayList<Level> currentLevels) {
        this.currentLevels = currentLevels;
    }
}
