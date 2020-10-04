package com.example.AlphaHealthAssistant.ui.caloriecal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

import com.example.AlphaHealthAssistant.R;
import com.example.AlphaHealthAssistant.ui.caloriecal.database.Meal;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CaloriecalBreakfast extends AppCompatActivity {
    private boolean checkEmpty = false;
    int minteger = 0;
    int minteger1 = 0;
    int minteger2 = 0;
    int minteger3 = 0;
    int minteger4 = 0;

    Button save;

    int number01, num, number02, newNumber02, num_second, number03, num_third, number04,num_fourth;
    int number05, num_fifth;

    EditText txtmilkCofeeCount, txtOrangejuiceCount, txtAvocadojuiceCount, txtHoppersCount, txtStringHoppersCount;

    DatabaseReference dbRef;
    Meal meal;

    private void clearControls(){
        txtmilkCofeeCount.setText("");
        txtOrangejuiceCount.setText("");
        txtAvocadojuiceCount.setText("");
        txtHoppersCount.setText("");
        txtStringHoppersCount.setText("");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caloriecal_breakfast);

        Intent in = getIntent();
        Toast.makeText(this, in.getStringExtra("date"), Toast.LENGTH_SHORT).show();
        String date = in.getStringExtra("date");

        txtmilkCofeeCount = findViewById(R.id.milkcofeee);
        txtOrangejuiceCount = findViewById(R.id.OrangeJuice);
        txtAvocadojuiceCount = findViewById(R.id.avocadoJuice);
        txtStringHoppersCount = findViewById(R.id.stringHoppers);
        txtHoppersCount = findViewById(R.id.hoppers);

        save = findViewById(R.id.btnSave);
        final TextView tv_final = findViewById(R.id.CalorieTot);


        meal = new Meal();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //calculation part
                Editable num01 = txtmilkCofeeCount.getText();
                Editable num02 = txtOrangejuiceCount.getText();
                Editable num03 = txtAvocadojuiceCount.getText();
                Editable num04 = txtHoppersCount.getText();
                Editable num05 = txtStringHoppersCount.getText();


                if (num01.toString().isEmpty()){
                    checkEmpty = true;
                }else if (num02.toString().isEmpty()){
                    checkEmpty = true;
                }else if (num03.toString().isEmpty()){
                    checkEmpty = true;
                }else if (num04.toString().isEmpty()){
                    checkEmpty = true;
                }else if (num05.toString().isEmpty()){
                    checkEmpty = true;
                }else{
                    number01 = Integer.parseInt(txtmilkCofeeCount.getText().toString());

                    number02 = Integer.parseInt(txtOrangejuiceCount.getText().toString());

                    number03 = Integer.parseInt(txtAvocadojuiceCount.getText().toString());

                    number04 = Integer.parseInt(txtHoppersCount.getText().toString());

                    number05 = Integer.parseInt(txtStringHoppersCount.getText().toString());

                    checkEmpty  =false;
                }
                int finalValue = (number01 * 150) + (number02 * 45) + (number03 * 160) + (number04 * 160) + (number05 * 160);
                tv_final.setText(""+finalValue);

                //data adding to data base part
                dbRef = FirebaseDatabase.getInstance().getReference().child("breakfast");
                try{
                    if(TextUtils.isEmpty(txtmilkCofeeCount.getText().toString())){
                        meal.setCountmilkcofee (0) ;
                    }else if(TextUtils.isEmpty(txtOrangejuiceCount.getText().toString())){
                        meal.setCountorangeJuice(0);
                    }else if(TextUtils.isEmpty(txtAvocadojuiceCount.getText().toString())){
                        meal.setCountavocadoJuice(0);
                    }else if(TextUtils.isEmpty(txtHoppersCount.getText().toString())){
                        meal.setCounthoppers(0);
                    }else if(TextUtils.isEmpty(txtStringHoppersCount.getText().toString())){
                        meal.setCountStringHoppers(0);
                    }else {
                        meal.setCountmilkcofee(Integer.parseInt(txtmilkCofeeCount.getText().toString().trim()));
                        meal.setCountorangeJuice(Integer.parseInt(txtOrangejuiceCount.getText().toString().trim()));
                        meal.setCountavocadoJuice(Integer.parseInt(txtAvocadojuiceCount.getText().toString().trim()));
                        meal.setCounthoppers(Integer.parseInt(txtHoppersCount.getText().toString().trim()));
                        meal.setCountStringHoppers(Integer.parseInt(txtStringHoppersCount.getText().toString().trim()));
                        meal.setDate(date);

                        dbRef.child("today").setValue(meal);

                        Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
                        clearControls();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


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
    public void increaseIntegerFifth(View view){
        minteger4= minteger4 + 1;
        displayFifth(minteger4);
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
    public void decreaseIntegerFifth(View view){
        minteger4 = minteger4 -1;
        displayFifth(minteger4);
    }

    private void display(int number) {
        EditText displayInteger = (EditText) findViewById(
                R.id.milkcofeee);
        displayInteger.setText("" + number);
    }

    private void displaySecond(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.OrangeJuice);
        displayInteger.setText("" + number);
    }

    private void displayThird(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.avocadoJuice);
        displayInteger.setText("" + number);
    }
    private void displayFourth(int number){
        TextView displayInteger = (TextView) findViewById(R.id.hoppers);
        displayInteger.setText(""+number);
    }
    private void displayFifth(int number){
        TextView displayInteger = (TextView) findViewById(R.id.stringHoppers);
        displayInteger.setText(""+number);
    }



    public int calMilkCofeeCalorie(int mcount) {
        if (mcount == 0)
            return 0;
        else
            return mcount * 150;
    }



    public int calOrangeJuiceCalorie(int ocount) {
        if (ocount == 0)
            return 0;
        else
            return ocount * 45;
    }

    public int calAvocadoJuiceCalorie(int acount) {
        if (acount == 0)
            return 0;
        else
            return acount * 160;
    }
    public int getTotal(int mcount, int ocount, int acount){
        return calOrangeJuiceCalorie(ocount)+calMilkCofeeCalorie(mcount)+calAvocadoJuiceCalorie(acount);
    }








}









































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































