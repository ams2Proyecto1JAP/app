package com.ieti.duolingoproyect.Models;

public class Exercice {
    private int exerciceId;
    private String content;

    public Exercice(int exerciceId, String content) {
        this.exerciceId = exerciceId;
        this.content = content;
    }

    public Exercice() {

    }

    public int getExerciceId() {
        return exerciceId;
    }

    public void setExerciceId(int exerciceId) {
        this.exerciceId = exerciceId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
