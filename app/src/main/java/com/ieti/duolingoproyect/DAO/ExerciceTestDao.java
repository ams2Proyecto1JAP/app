package com.ieti.duolingoproyect.DAO;

import com.ieti.duolingoproyect.Models.Exercice;

import org.json.JSONException;

public interface ExerciceTestDao {
    public ExerciceTest getExerciceTextByContent(String content) throws JSONException;
}
