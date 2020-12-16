package com.ieti.duolingoproyect.DAO.Translate;

import com.ieti.duolingoproyect.DAO.Test.ExerciceTest;

import org.json.JSONException;

public interface ExerciceTranslateDao {
 public ExerciceTranslate getExerciceTextByContent(String content) throws JSONException;
}
