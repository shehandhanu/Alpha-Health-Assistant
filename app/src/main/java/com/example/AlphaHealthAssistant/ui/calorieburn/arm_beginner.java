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
import com.example.AlphaHealthAssistant.ui.calorieburn.dbHelper.ArmBeginner;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class arm_beginner extends AppCompatActivity {


    public static final String EXTRA_NUMBER01 = "com.example.AlphaHealthAssistant.EXTRA_NUMBER01";
    public static final String EXTRA_NUMBER02 = "com.example.AlphaHealthAssistant.EXTRA_NUMBER02";

    Button repoButton;
    int number01, number02, number03, number04, number05, number06;
    EditText editText01, editText02, editText03, editText04, editText05, editText06;

    DatabaseReference dbRef;
    ArmBeginner armBeginner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_beginner);

        repoButton = findViewById(R.id.report_button);
        editText01 = findViewById(R.id.et1);
        editText02 = findViewById(R.id.et2);
        editText03 = findViewById(R.id.et3);
        editText04 = findViewById(R.id.et4);
        editText05 = findViewById(R.id.et5);
        editText06 = findViewById(R.id.et6);

        armBeginner = new ArmBeginner();

        repoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = 0;
                dbRef = FirebaseDatabase.getInstance().getReference().child("Beginner");

                try {
                    if (TextUtils.isEmpty(editText01.getText().toString())) {
                        armBeginner.setExercise01(0);

                    } else if (TextUtils.isEmpty(editText02.getText().toString())) {
                        armBeginner.setExercise02(0);

                    } else if (TextUtils.isEmpty(editText03.getText().toString())) {
                        armBeginner.setExercise04(0);

                    } else if (TextUtils.isEmpty(editText04.getText().toString())) {
                        armBeginner.setExercise05(0);

                    } else if (TextUtils.isEmpty(editText05.getText().toString())) {
                        armBeginner.setExercise05(0);

                    } else if (TextUtils.isEmpty(editText06.getText().toString())) {
                        armBeginner.setExercise06(0);

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
                        number06 = Integer.parseInt(editText06.getText().toString());
                        if (number06 > 0) {
                            count++;
                        }

                        armBeginner.setExercise01(Integer.parseInt(editText01.getText().toString().trim()));
                        armBeginner.setExercise02(Integer.parseInt(editText02.getText().toString().trim()));
                        armBeginner.setExercise03(Integer.parseInt(editText03.getText().toString().trim()));
                        armBeginner.setExercise04(Integer.parseInt(editText04.getText().toString().trim()));
                        armBeginner.setExercise05(Integer.parseInt(editText05.getText().toString().trim()));
                        armBeginner.setExercise06(Integer.parseInt(editText06.getText().toString().trim()));

                        //dbRef.push().setValue(abs);
                        dbRef.child("arm").setValue(armBeginner);
                        //dbRef.setValue(abs);
                        Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                        clearControls();

                        //do the calculations
                        int sum = ((number01 * 8) + (number02 * 6) + (number03 * 8) + (number04 * 15) + (number05 * 4) + (number06 * 4));

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

    private void clearControls() {
        editText01.setText("");
        editText02.setText("");
        editText03.setText("");
        editText04.setText("");
        editText05.setText("");
        editText06.setText("");
    }
}