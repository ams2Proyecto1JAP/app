package com.ieti.duolingoproyect.ui.league;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LeagueViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LeagueViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Pestaña para la liga");
    }

    public LiveData<String> getText() {
        return mText;
    }
}