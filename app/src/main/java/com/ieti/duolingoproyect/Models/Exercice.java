package com.ieti.duolingoproyect.Models;

import java.io.Serializable;

public class Exercice implements Serializable {
    private int exerciceId;
    private String content;
    private String type;

    public Exercice(int exerciceId, String content, String type) {
        this.exerciceId = exerciceId;
        this.content = content;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
