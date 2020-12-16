package com.ieti.duolingoproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.ieti.duolingoproyect.DAO.ExerciceTest;
import com.ieti.duolingoproyect.DAO.ExerciceTestDao;
import com.ieti.duolingoproyect.DAO.ExerciceTestImplements;
import com.ieti.duolingoproyect.Models.Data;
import com.ieti.duolingoproyect.Models.Exercice;
import com.ieti.duolingoproyect.Models.Level;

import java.util.AbstractMap;
import java.util.ArrayList;

import org.json.JSONException;

public class ExerciseActivity extends AppCompatActivity {

    int count;
    int index;
    ArrayList<Exercice> exs;
    //DAO
    private ExerciceTestDao ETDAO = new ExerciceTestImplements();
    private ExerciceTest et = null;
    private boolean noMistakes = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Level lvl = (Level) getIntent().getSerializableExtra("lvl");
        exs = lvl.getExercices();
        count = exs.size();
        index = 0;
        nextExercise();
    }

    public void nextExercise() {
        if (index >= count) {
            int coinsEarned = 0;
            addPointsLevelDone();
            coinsEarned = calculateCoinsEarned();
            coinsEarned = coinsEarned + calculateBonusCoins();
            callShowGains(10, coinsEarned);
            this.finish();
            //Toast.makeText(this, "No hay mas ejercicios en este nivel", Toast.LENGTH_LONG).show();
        } else {
            Exercice ex = exs.get(index);
            if (ex.getType().equals(Data.EXS_TYPE_TEST)) {
                loadExTest(ex.getContent());
            }
            index++;
        }
    }

    public void addPointsLevelDone(){
        Data.appUser.setPoints(Data.appUser.getPoints()+10);
    }

    public int calculateCoinsEarned(){
        int earnedSessionPoints = Data.appUser.getPoints() - Data.initialSessionPoints;
        if(earnedSessionPoints%50 == 0){
            Data.appUser.setCoins(Data.appUser.getCoins()+10);
            return 10;
        }else{
            return 0;
        }
    }

    public int calculateBonusCoins(){
        if(this.noMistakes){
            Data.appUser.setCoins(Data.appUser.getCoins()+150);
            return 150;
        }else{
            return 0;
        }
    }

    public void loadExTest(String content) {
        setContentView(R.layout.exercice_test);
        try {
            et = ETDAO.getExerciceTextByContent(content);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        int x = (int) (Math.random() * 99);
        String inc1 = et.getInc1();
        String inc2 = et.getInc2();
        String correct = et.getTrans();

        final String[] sentence = {null};
        String trueSent = "Lo has logrado!";
        String falseSent = "Has fallado, tienes que mejorar...";

        //TextView from exercice_test
        TextView tv_SentenceToTranslate = findViewById(R.id.tv_sentenceToTranslate);
        tv_SentenceToTranslate.setText(et.getToTrans());

        //Buttons from exercice_test
        Button btn_sentence1 = findViewById(R.id.btn_sentence1);
        Button btn_sentence2 = findViewById(R.id.btn_sentence2);
        Button btn_sentence3 = findViewById(R.id.btn_sentence3);
        Button btn_check = findViewById(R.id.btn_check);

        btn_check.setEnabled(false);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String snackSent = null;
                if (sentence[0].equals(correct)) {
                    snackSent = trueSent;
                } else {
                    noMistakes = false;
                    snackSent = falseSent;
                }

                Snackbar.make(v, snackSent, Snackbar.LENGTH_LONG)
                        .setActionTextColor(Color.CYAN)
                        .setAction("Siguiente Ejercicio", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("Snackbar", "Pulsada acción snackbar!");
                                nextExercise();
                            }
                        })
                        .show();
            }
        });

        btn_sentence1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_sentence1.setBackgroundColor(btn_sentence1.getContext().getResources().getColor(R.color.purple_200));
                btn_sentence2.setBackgroundColor(btn_sentence2.getContext().getResources().getColor(R.color.purple_500));
                btn_sentence3.setBackgroundColor(btn_sentence3.getContext().getResources().getColor(R.color.purple_500));
                btn_check.setEnabled(true);
                Button b = (Button) v;
                String buttonText = b.getText().toString();
                sentence[0] = buttonText;
            }
        });

        btn_sentence2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_sentence1.setBackgroundColor(btn_sentence1.getContext().getResources().getColor(R.color.purple_500));
                btn_sentence2.setBackgroundColor(btn_sentence2.getContext().getResources().getColor(R.color.purple_200));
                btn_sentence3.setBackgroundColor(btn_sentence3.getContext().getResources().getColor(R.color.purple_500));
                btn_check.setEnabled(true);
                Button b2 = (Button) v;
                String buttonText2 = b2.getText().toString();
                sentence[0] = buttonText2;
            }
        });

        btn_sentence3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_sentence1.setBackgroundColor(btn_sentence1.getContext().getResources().getColor(R.color.purple_500));
                btn_sentence2.setBackgroundColor(btn_sentence2.getContext().getResources().getColor(R.color.purple_500));
                btn_sentence3.setBackgroundColor(btn_sentence3.getContext().getResources().getColor(R.color.purple_200));
                btn_check.setEnabled(true);
                Button b3 = (Button) v;
                String buttonText3 = b3.getText().toString();
                sentence[0] = buttonText3;
            }
        });

        if (x < 33) {
            btn_sentence1.setText(inc1);
            btn_sentence2.setText(inc2);
            btn_sentence3.setText(correct);
        } else if (x > 66) {
            btn_sentence1.setText(inc2);
            btn_sentence2.setText(inc1);
            btn_sentence3.setText(correct);
        } else {
            btn_sentence1.setText(correct);
            btn_sentence2.setText(inc2);
            btn_sentence3.setText(inc1);
        }
    }

    public void callShowGains(int pointsEarned, int coinsEarned){
        Intent intent = new Intent(this, ShowGainsActivity.class);
        intent.putExtra("pointsEarned", pointsEarned);
        intent.putExtra("coinsEarned", coinsEarned);
        startActivity(intent);
    }
}