package com.ieti.duolingoproyect.Models;

import java.util.ArrayList;

public class Level {
    private int levelId;
    private int indexLevel;
    private ArrayList<Exercice> exercices;

    public Level(int levelId, ArrayList<Exercice> exercices) {
        this.levelId = levelId;
        this.exercices = exercices;
    }

    public Level(int levelId, int indexLevel) {
        this.levelId = levelId;
        this.indexLevel = indexLevel;
    }

    public Level() {

    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public ArrayList<Exercice> getExercices() {
        return exercices;
    }

    public void setExercices(ArrayList<Exercice> exercices) {
        this.exercices = exercices;
    }

    public int getIndexLevel() {
        return indexLevel;
    }

    public void setIndexLevel(int indexLevel) {
        this.indexLevel = indexLevel;
    }
}
