package com.ieti.duolingoproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity_Exercice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__exercice);
    }

    public  void createExercice(){
        Intent intent = new Intent(this, MainActivity_Exercice.class);
        startActivity(intent);
    }
}