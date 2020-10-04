package com.example.AlphaHealthAssistant.ui.calorieburn;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.AlphaHealthAssistant.R;

public class CalorieBurnBeginner extends AppCompatActivity {

    ImageButton imageButton;
    ImageButton imageButton_arm;
    ImageButton imageButton_chest;
    ImageButton imageButton_leg;
    ImageButton imageButton_shoulder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_burn_beginner);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();

        imageButton = (ImageButton) findViewById(R.id.button_abs);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ABS_Exercise_List.class);
                startActivity(i);
            }
        });
        imageButton_chest = (ImageButton) findViewById(R.id.imageButton_chest);
        imageButton_chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), chest_beginner.class);
                startActivity(i);
            }
        });
        imageButton_leg = (ImageButton) findViewById(R.id.imageButton_leg);
        imageButton_leg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), leg_beginner.class);
                startActivity(i);
            }
        });
        imageButton_arm = (ImageButton) findViewById(R.id.imageButton_arm);
        imageButton_arm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), arm_beginner.class);
                startActivity(i);
            }
        });
        imageButton_shoulder = (ImageButton) findViewById(R.id.imageButton_shoulder);
        imageButton_shoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), shoulder_beginner.class);
                startActivity(i);
            }
        });

    }
}