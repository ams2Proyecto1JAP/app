package com.ieti.duolingoproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowGainsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_gains);

        int pointsEarned = getIntent().getIntExtra("pointsEarned", 0);
        int coinsEarned = getIntent().getIntExtra("coinsEarned", 0);

        TextView tvNumPoints = findViewById(R.id.tvNumPoints);
        TextView tvNumCoins = findViewById(R.id.tvNumCoins);
        tvNumPoints.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
        tvNumCoins.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
        tvNumPoints.setText(String.valueOf(pointsEarned));
        tvNumCoins.setText(String.valueOf(coinsEarned));

        final ImageView ivPoints = findViewById(R.id.ivPointsShowGains);
        final ImageView ivCoins = findViewById(R.id.ivCoinsShowGains);

        ivPoints.setImageDrawable(getResources().getDrawable(R.drawable.ic_lighting));
        ivCoins.setImageDrawable(getResources().getDrawable(R.drawable.ic_money));

        Button buttonReturn = findViewById(R.id.buttonReturn);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowGainsActivity.this.finish();
            }
        });

    }
}