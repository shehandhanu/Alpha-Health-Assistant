package com.example.AlphaHealthAssistant.ui.caloriecal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        addNumber();

        final EditText OrangeJuice = findViewById(R.id.OrangeJuice);
        final Button buttonAddOrange = findViewById(R.id.addOrangeJuice);
        final TextView tv_final = findViewById(R.id.CalorieTot);
        buttonAddOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number02 = Integer.parseInt(OrangeJuice.getText().toString());
                newNumber02 = Integer.parseInt(tv_final.getText().toString());
                num_second = (number02 * 45) + newNumber02;
                tv_final.setText(String.valueOf(num_second));
            }
        });

        final EditText AvacadoJuice = findViewById(R.id.avocadoJuice);
        final Button buttonAddAvacado = findViewById(R.id.addAvacadoJuice);

        buttonAddAvacado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number03 = Integer.parseInt(AvacadoJuice.getText().toString());
                newNumber02 = Integer.parseInt(tv_final.getText().toString());
                num_third = (number03 * 160) + newNumber02;
                tv_final.setText(String.valueOf(num_third));
            }
        });

        final EditText Hoppers = findViewById(R.id.hoppers);
        final Button buttonAddhoppers = findViewById(R.id.addHoppers);

        buttonAddhoppers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number04 = Integer.parseInt(Hoppers.getText().toString());
                newNumber02 = Integer.parseInt(tv_final.getText().toString());
                num_fourth = (number03 * 160) + newNumber02;
                tv_final.setText(String.valueOf(num_fourth));
            }
        });
        final EditText StringHoppers = findViewById(R.id.stringHoppers);
        final Button buttonAddStringhoppers = findViewById(R.id.addStringHoppers);

        buttonAddStringhoppers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number05 = Integer.parseInt(StringHoppers.getText().toString());
                newNumber02 = Integer.parseInt(tv_final.getText().toString());
                num_fifth = (number05 * 160) + newNumber02;
                tv_final.setText(String.valueOf(num_fifth));
            }
        });

        txtmilkCofeeCount = findViewById(R.id.milkcofeee);
        txtOrangejuiceCount = findViewById(R.id.OrangeJuice);
        txtAvocadojuiceCount = findViewById(R.id.avocadoJuice);
        txtStringHoppersCount = findViewById(R.id.stringHoppers);
        txtHoppersCount = findViewById(R.id.hoppers);

        save = findViewById(R.id.btnSave);

        meal = new Meal();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("breakfast");
                try{
                    meal.setCountmilkcofee(Integer.parseInt(txtmilkCofeeCount.getText().toString().trim()));
                    meal.setCountorangeJuice(Integer.parseInt(txtOrangejuiceCount.getText().toString().trim()));
                    meal.setCountavocadoJuice(Integer.parseInt(txtAvocadojuiceCount.getText().toString().trim()));
                    meal.setCounthoppers(Integer.parseInt(txtHoppersCount.getText().toString().trim()));
                    meal.setCountStringHoppers(Integer.parseInt(txtStringHoppersCount.getText().toString().trim()));

                    dbRef.push().setValue(meal);

                    Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
                    clearControls();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }
    public void addNumber(){

        final EditText milccofee = findViewById(R.id.milkcofeee);
        final Button buttonAddMilkCoffe = findViewById(R.id.AddMilkCofeeBtn);
        final TextView tv_final = findViewById(R.id.CalorieTot);
        buttonAddMilkCoffe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number01 = Integer.parseInt(milccofee.getText().toString());
                num = number01 * 150;
                tv_final.setText(String.valueOf(num));
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









































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































