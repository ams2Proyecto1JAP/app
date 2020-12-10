package com.ieti.duolingoproyect.Models;

import java.util.ArrayList;

public class Course {
    private int courseId;
    private String langSrc;
    private String langDst;
    private ArrayList<Category> categories;

    public Course(int courseId, String langSrc, String langDst, ArrayList<Category> categories) {
        this.courseId = courseId;
        this.langSrc = langSrc;
        this.langDst = langDst;
        this.categories = categories;
    }

    public Course(int courseId,String langSrc, String langDst) {
        this.courseId = courseId;
        this.langSrc = langSrc;
        this.langDst = langDst;
    }

    public Course() {

    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getLangSrc() {
        return langSrc;
    }

    public void setLangSrc(String langSrc) {
        this.langSrc = langSrc;
    }

    public String getLangDst() {
        return langDst;
    }

    public void setLangDst(String langDst) {
        this.langDst = langDst;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }


}
