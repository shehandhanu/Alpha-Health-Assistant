package com.example.AlphaHealthAssistant.ui.calorieburn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.AlphaHealthAssistant.R;
import com.example.AlphaHealthAssistant.ui.calorieburn.dbHelper.BeginnerChest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class chest_beginner extends AppCompatActivity {

    public static final String EXTRA_NUMBER01 = "com.example.AlphaHealthAssistant.EXTRA_NUMBER01";
    public static final String EXTRA_NUMBER02 = "com.example.AlphaHealthAssistant.EXTRA_NUMBER02";

    Button buttonFinal;
    int number01, number02, number03, number04, number05;
    EditText editText01, editText02, editText03, editText04, editText05;
    DatabaseReference dbRef;
    BeginnerChest beginnerChest;

    private void clearControls() {
        editText01.setText("");
        editText02.setText("");
        editText03.setText("");
        editText04.setText("");
        editText05.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_beginner);

        editText01 = findViewById(R.id.chestExercise01);
        editText02 = findViewById(R.id.chestExercise02);
        editText03 = findViewById(R.id.chestExercise03);
        editText04 = findViewById(R.id.chestExercise04);
        editText05 = findViewById(R.id.chestExercise05);

        buttonFinal = findViewById(R.id.report_button);

        beginnerChest = new BeginnerChest();

        buttonFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = 0;
                dbRef = FirebaseDatabase.getInstance().getReference().child("Beginner");

                try {
                    if (TextUtils.isEmpty(editText01.getText().toString())) {
                        beginnerChest.setEx1(0);

                    } else if (TextUtils.isEmpty(editText02.getText().toString())) {
                        beginnerChest.setEx2(0);

                    } else if (TextUtils.isEmpty(editText03.getText().toString())) {
                        beginnerChest.setEx3(0);

                    } else if (TextUtils.isEmpty(editText04.getText().toString())) {
                        beginnerChest.setEx4(0);

                    } else if (TextUtils.isEmpty(editText05.getText().toString())) {
                        beginnerChest.setEx5(0);

                    } else {

                        number01 = Integer.parseInt(editText01.getText().toString());
                        if (number01 > 0) {
                            count++;
                        }
                        number02 = Integer.parseInt(editText02.getText().toString());
                        if (number02 > 0) {
                            count++;
                        }
                        number03 = Integer.parseInt(editText03.getText().toString());
                        if (number03 > 0) {
                            count++;
                        }
                        number04 = Integer.parseInt(editText04.getText().toString());
                        if (number04 > 0) {
                            count++;
                        }
                        number05 = Integer.parseInt(editText05.getText().toString());
                        if (number05 > 0) {
                            count++;
                        }

                        beginnerChest.setEx1(Integer.parseInt(editText01.getText().toString().trim()));
                        beginnerChest.setEx2(Integer.parseInt(editText02.getText().toString().trim()));
                        beginnerChest.setEx3(Integer.parseInt(editText03.getText().toString().trim()));
                        beginnerChest.setEx4(Integer.parseInt(editText04.getText().toString().trim()));
                        beginnerChest.setEx5(Integer.parseInt(editText05.getText().toString().trim()));

                        //dbRef.push().setValue(abs);
                        dbRef.child("chest").setValue(beginnerChest);
                        //dbRef.setValue(abs);
                        Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                        clearControls();

                        //do the calculations
                        int sum = ((number01 * 8) + (number02 * 6) + (number03 * 8) + (number04 * 15) + (number05 * 4));

                        //navigate to result page
                        Intent i = new Intent(getApplicationContext(), Final_result_view.class);
                        //pass the values to result page
                        i.putExtra(EXTRA_NUMBER01, sum);
                        i.putExtra(EXTRA_NUMBER02, count);
                        startActivity(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}