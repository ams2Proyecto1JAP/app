package com.ieti.duolingoproyect.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Level implements Serializable {
    private int levelId;
    private ArrayList<Exercice> exercices;

    public Level(int levelId, ArrayList<Exercice> exercices) {
        this.levelId = levelId;
        this.exercices = exercices;
    }

    public Level(int levelId) {
        this.levelId = levelId;
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

}
