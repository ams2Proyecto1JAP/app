package com.ieti.duolingoproyect.DAO.Translate;

import java.lang.reflect.Array;

public class ExerciceTranslate {
    private String toTrans;
    private String[] translated;

    public ExerciceTranslate(String toTrans, String[] translated) {
        this.toTrans = toTrans;
        this.translated = translated;
    }

    public String getToTrans() {
        return toTrans;
    }

    public void setToTrans(String toTrans) {
        this.toTrans = toTrans;
    }

    public String[] getTranslated() {
        return translated;
    }

    public void setTranslated(String[] translated) {
        this.translated = translated;
    }
}
