package com.ieti.duolingoproyect.DAO;

import org.json.JSONException;
import org.json.JSONObject;

public class ExerciceTestImplements implements ExerciceTestDao{
    @Override
    public ExerciceTest getExerciceTextByContent(String content) throws JSONException {
        String jsonString = content ;
        JSONObject obj = new JSONObject(jsonString);
        JSONObject testExs = obj.getJSONObject("testExercise");
        String toTrans = testExs.getString("phrToTranslate");
        String trans = testExs.getString("phrTranslated");
        String inc1 = testExs.getString("phrBadTranslated1");
        String inc2 = testExs.getString("phrBadTranslated2");

        ExerciceTest exs = new ExerciceTest(toTrans,trans,inc1,inc2);
        return exs;
    }
}
