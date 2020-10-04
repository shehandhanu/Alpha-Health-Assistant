package com.example.AlphaHealthAssistant.ui.caloriecal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.AlphaHealthAssistant.R;
import com.example.AlphaHealthAssistant.ui.caloriecal.database.Dinner;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CaloriecalDinner extends AppCompatActivity {

    int minteger = 0;
    int minteger1 = 0;
    int minteger2 = 0;
    EditText breadCount, noodlesCount, coconutRotiCount;
    Button saveDinnerTotal;
    DatabaseReference dbRef;
    private boolean checkEmpty = false;
    int number01, number02, number03;
    Dinner dinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caloriecal_dinner);

        Intent in = getIntent();
        Toast.makeText(this, in.getStringExtra("date"), Toast.LENGTH_SHORT).show();
        String date = in.getStringExtra("date");



        breadCount = findViewById(R.id.bread);
        noodlesCount = findViewById(R.id.noodles);
        coconutRotiCount = findViewById(R.id.coconutRoti);

        final TextView totDinner = findViewById(R.id.totalDinner);
        saveDinnerTotal = findViewById(R.id.addDinnerBttn);
        dinner = new Dinner();


        saveDinnerTotal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Calculation part
                Editable num01 = breadCount.getText();
                Editable num02 = noodlesCount.getText();
                Editable num03 = coconutRotiCount.getText();



                if (num01.toString().isEmpty()){
                    checkEmpty = true;
                }else if (num02.toString().isEmpty()){
                    checkEmpty = true;
                }else if (num03.toString().isEmpty()){
                    checkEmpty = true;

                }else{
                    number01 = Integer.parseInt(breadCount.getText().toString());

                    number02 = Integer.parseInt(noodlesCount.getText().toString());

                    number03 = Integer.parseInt(coconutRotiCount.getText().toString());



                    checkEmpty  =false;
                }
                int DinnerTot = (number01 * 111) + (number02 * 31) + (number03 * 33)  ;
                totDinner.setText(""+DinnerTot);
                //Database part
                dbRef = FirebaseDatabase.getInstance().getReference().child("dinner");
                try{
                    if(TextUtils.isEmpty(breadCount.getText().toString())){
                        dinner.setBreadCount (0); ;
                    }else if(TextUtils.isEmpty(noodlesCount.getText().toString())){
                        dinner.setNoodlesCount(0);
                    }else if(TextUtils.isEmpty(coconutRotiCount.getText().toString())){
                        dinner.setCoconutRotiCount(0);

                    }else {
                        dinner.setBreadCount(Integer.parseInt(breadCount.getText().toString().trim()));
                        dinner.setNoodlesCount(Integer.parseInt(noodlesCount.getText().toString().trim()));
                        dinner.setCoconutRotiCount(Integer.parseInt(coconutRotiCount.getText().toString().trim()));
                        dinner.setDate(date);


                        dbRef.child("today").setValue(dinner);

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
        breadCount.setText("");
        noodlesCount.setText("");
        coconutRotiCount.setText("");



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
    private void display(int number) {
        EditText displayInteger = (EditText) findViewById(
                R.id.bread);
        displayInteger.setText("" + number);
    }

    private void displaySecond(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.noodles);
        displayInteger.setText("" + number);
    }

    private void displayThird(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.coconutRoti);
        displayInteger.setText("" + number);
    }
}