package com.example.AlphaHealthAssistant.ui.caloriecal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.AlphaHealthAssistant.R;
import com.example.AlphaHealthAssistant.ui.caloriecal.database.Lunch;
import com.example.AlphaHealthAssistant.ui.caloriecal.database.Meal;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.widget.Button;
import android.widget.Toast;

public class CalorieCalLunch extends AppCompatActivity {

    int minteger = 0;
    int minteger1 = 0;
    int minteger2 = 0;
    int minteger3 = 0;
    EditText redRiceCt, greenBeansCt, tomatoCurryCt, mushroomCurryCt;
    Button saveLunchTot;
    DatabaseReference dbRef;
    Lunch lunch;
    private boolean checkEmpty = false;
    int number01, number02, number03, number04;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_cal_lunch);

        Intent in = getIntent();
        Toast.makeText(this, in.getStringExtra("date"), Toast.LENGTH_SHORT).show();
        String date = in.getStringExtra("date");


        redRiceCt = findViewById(R.id.redrice);
        greenBeansCt = findViewById(R.id.greenBeans);
        tomatoCurryCt = findViewById(R.id.tomato);
        mushroomCurryCt = findViewById(R.id.mushroom);
       final TextView totalLunch = findViewById(R.id.lunchTot);
        saveLunchTot = findViewById(R.id.btnsave);
        lunch = new Lunch();

        saveLunchTot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Calculation part
                Editable num01 = redRiceCt.getText();
                Editable num02 = greenBeansCt.getText();
                Editable num03 = tomatoCurryCt.getText();
                Editable num04 = mushroomCurryCt.getText();


                if (num01.toString().isEmpty()){
                    checkEmpty = true;
                }else if (num02.toString().isEmpty()){
                    checkEmpty = true;
                }else if (num03.toString().isEmpty()){
                    checkEmpty = true;
                }else if (num04.toString().isEmpty()){
                    checkEmpty = true;

                }else{
                    number01 = Integer.parseInt(redRiceCt.getText().toString());

                    number02 = Integer.parseInt(greenBeansCt.getText().toString());

                    number03 = Integer.parseInt(tomatoCurryCt.getText().toString());

                    number04 = Integer.parseInt(mushroomCurryCt.getText().toString());

                    checkEmpty  =false;
                }
                int LunchTot = (number01 * 111) + (number02 * 31) + (number03 * 33) + (number04 * 50) ;
                totalLunch.setText(""+LunchTot);
                //Database part
                dbRef = FirebaseDatabase.getInstance().getReference().child("lunch");
                try{
                    if(TextUtils.isEmpty(redRiceCt.getText().toString())){
                        lunch.setRedRiceCount (0); ;
                    }else if(TextUtils.isEmpty(greenBeansCt.getText().toString())){
                        lunch.setGreenBeansCount(0);
                    }else if(TextUtils.isEmpty(tomatoCurryCt.getText().toString())){
                        lunch.setTomatoCount(0);
                    }else if(TextUtils.isEmpty(mushroomCurryCt.getText().toString())) {
                        lunch.setMushroomCount(0);

                    }else {
                        lunch.setRedRiceCount(Integer.parseInt(redRiceCt.getText().toString().trim()));
                        lunch.setGreenBeansCount(Integer.parseInt(greenBeansCt.getText().toString().trim()));
                        lunch.setTomatoCount(Integer.parseInt(tomatoCurryCt.getText().toString().trim()));
                        lunch.setMushroomCount(Integer.parseInt(mushroomCurryCt.getText().toString().trim()));
                        lunch.setDate(date);


                        dbRef.child("today").setValue(lunch);

                        Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
                        clearControlls();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });



    }

    public void clearControlls(){
        redRiceCt.setText("");
        greenBeansCt.setText("");
        tomatoCurryCt.setText("");
        mushroomCurryCt.setText("");


    }
    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }

    public void increaseIntegerSecond(View view) {
        minteger1 = minteger1 + 1;
        displaySecond(minteger1);

    }

    public void increaseIntegerThird(View view) {
        minteger2 = minteger2 + 1;
        displayThird(minteger2);

    }
    public void increaseIntegerFourth(View view){
        minteger3= minteger3 + 1;
        displayFourth(minteger3);
    }
    public void decreaseInteger(View view) {
        minteger = minteger - 1;
        display(minteger);
    }

    public void decreaseIntegerSecond(View view) {
        minteger1 = minteger1 - 1;
        displaySecond(minteger1);
    }

    public void decreaseIntegerThird(View view) {
        minteger2 = minteger2 - 1;
        displayThird(minteger2);
    }
    public void decreaseIntegerFourth(View view){
        minteger3 = minteger3 -1;
        displayFourth(minteger3);
    }
    private void display(int number) {
        EditText displayInteger = (EditText) findViewById(
                R.id.redrice);
        displayInteger.setText("" + number);
    }

    private void displaySecond(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.greenBeans);
        displayInteger.setText("" + number);
    }

    private void displayThird(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.tomato);
        displayInteger.setText("" + number);
    }
    private void displayFourth(int number){
        TextView displayInteger = (TextView) findViewById(R.id.mushroom);
        displayInteger.setText(""+number);
    }
}