package com.example.AlphaHealthAssistant.ui.caloriecal;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.ImageButton;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;

import com.example.AlphaHealthAssistant.R;

public class CaloriecalDailyMeal extends AppCompatActivity {
    ImageButton BreakfastBtn, lunchBtn, DinnerBtn;
    TextView txt1Date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caloriecal_daily_meal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        BreakfastBtn = findViewById(R.id.breakfastBtn);
        lunchBtn = findViewById(R.id.lunchBtn);
        DinnerBtn = findViewById(R.id.DinnerBtn);
        txt1Date = findViewById(R.id.dateTxt);

        BreakfastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CaloriecalDailyMeal.this, CaloriecalBreakfast.class));
            }
        });
        lunchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CaloriecalDailyMeal.this, CalorieCalLunch.class));
            }
        });
        DinnerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Intent newInt = getIntent();
        Toast.makeText(this, newInt.getStringExtra("date"), Toast.LENGTH_LONG).show();
         txt1Date.setText(newInt.getStringExtra("date"));

    }
}