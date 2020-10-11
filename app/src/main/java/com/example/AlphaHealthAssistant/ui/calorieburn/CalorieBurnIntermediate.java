package com.example.AlphaHealthAssistant.ui.calorieburn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.AlphaHealthAssistant.R;
import com.example.AlphaHealthAssistant.ui.calorieburn.Intermediate.abs_Intermediate_exerciseList;
import com.example.AlphaHealthAssistant.ui.calorieburn.Intermediate.arm_Intermediate_exerciseList;
import com.example.AlphaHealthAssistant.ui.calorieburn.Intermediate.chest_Intermediate_exerciseList;
import com.example.AlphaHealthAssistant.ui.calorieburn.Intermediate.leg_Intermediate_exerciseList;
import com.example.AlphaHealthAssistant.ui.calorieburn.Intermediate.shoulder_Intermediate_exerciseList;

public class CalorieBurnIntermediate extends AppCompatActivity {

    ImageButton imgButtonABS, imgButtonCHEST, imgButtonLEG, imgButtonARM, imgButtonSHOULDER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_burn_intermediate);

        //make buttons usable
        imgButtonABS = findViewById(R.id.button_abs);
        imgButtonCHEST = findViewById(R.id.imageButton_chest);
        imgButtonLEG = findViewById(R.id.imageButton_leg);
        imgButtonARM = findViewById(R.id.imageButton_arm);
        imgButtonSHOULDER = findViewById(R.id.imageButton_shoulder);

        //using the buttons
        imgButtonABS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), abs_Intermediate_exerciseList.class);
                startActivity(i);
            }
        });
        imgButtonCHEST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), chest_Intermediate_exerciseList.class);
                startActivity(i);
            }
        });
        imgButtonLEG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), leg_Intermediate_exerciseList.class);
                startActivity(i);
            }
        });
        imgButtonARM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), arm_Intermediate_exerciseList.class);
                startActivity(i);
            }
        });
        imgButtonSHOULDER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), shoulder_Intermediate_exerciseList.class);
                startActivity(i);
            }
        });
    }
}