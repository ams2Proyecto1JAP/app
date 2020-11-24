package com.ieti.duolingoproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ieti.duolingoproyect.Models.Data;
import com.ieti.duolingoproyect.Models.Exercice;
import com.ieti.duolingoproyect.Models.Level;

import java.util.ArrayList;

public class ExerciseActivity extends AppCompatActivity {

    int count;
    int index;
    TextView tv;
    ArrayList<Exercice> exs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);


        tv = findViewById(R.id.textView);
        Level lvl = (Level)getIntent().getSerializableExtra("lvl");


        exs = lvl.getExercices();
        count = exs.size();
        index = 0;
        nextExercise();



        Button bt = findViewById(R.id.button);
        bt.setText("Siguiente ejercicio");
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextExercise();
            }
        });



    }

    public void nextExercise(){
        //setContentView(R.layout.activity_exercise2);
        if (index >= count)
        {
            Toast.makeText(this, "No hay mas ejercicios en este nivel", Toast.LENGTH_LONG).show();
        }
        else
        {
            tv = findViewById(R.id.textView);
            tv.setText("Ejercicio " + String.valueOf(exs.get(index).getExerciceId()));
            index++;
        }

    }
}