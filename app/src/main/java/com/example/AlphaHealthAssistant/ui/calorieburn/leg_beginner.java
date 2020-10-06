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
import com.example.AlphaHealthAssistant.ui.calorieburn.dbHelper.BeginnerLeg;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class leg_beginner extends AppCompatActivity {
    public static final String EXTRA_NUMBER01 = "com.example.AlphaHealthAssistant.EXTRA_NUMBER01";
    public static final String EXTRA_NUMBER02 = "com.example.AlphaHealthAssistant.EXTRA_NUMBER02";

    Button repoButton;
    EditText et1, et2, et3, et4, et5, et6;
    int number01, number02, number03, number04, number05, number06;
    DatabaseReference repLeg;
    BeginnerLeg beginnerLeg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leg_beginner);

        repoButton = findViewById(R.id.report_button);
        et1 = findViewById(R.id.leg1);
        et2 = findViewById(R.id.leg2);
        et3 = findViewById(R.id.leg3);
        et4 = findViewById(R.id.leg4);
        et5 = findViewById(R.id.leg5);
        et6 = findViewById(R.id.leg6);

        beginnerLeg = new BeginnerLeg();

        repoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = 0;
                repLeg = FirebaseDatabase.getInstance().getReference().child("Beginner");

                try {
                    if (TextUtils.isEmpty(et1.getText().toString())) {
                        beginnerLeg.setExercise01(0);

                    } else if (TextUtils.isEmpty(et2.getText().toString())) {
                        beginnerLeg.setExercise02(0);

                    } else if (TextUtils.isEmpty(et3.getText().toString())) {
                        beginnerLeg.setExercise03(0);

                    } else if (TextUtils.isEmpty(et4.getText().toString())) {
                        beginnerLeg.setExercise04(0);

                    } else if (TextUtils.isEmpty(et5.getText().toString())) {
                        beginnerLeg.setExercise05(0);

                    } else if (TextUtils.isEmpty(et6.getText().toString())) {
                        beginnerLeg.setExercise06(0);

                    } else {

                        number01 = Integer.parseInt(et1.getText().toString());
                        if (number01 > 0) {
                            count++;
                        }
                        number02 = Integer.parseInt(et2.getText().toString());
                        if (number02 > 0) {
                            count++;
                        }
                        number03 = Integer.parseInt(et3.getText().toString());
                        if (number03 > 0) {
                            count++;
                        }
                        number04 = Integer.parseInt(et4.getText().toString());
                        if (number04 > 0) {
                            count++;
                        }
                        number05 = Integer.parseInt(et5.getText().toString());
                        if (number05 > 0) {
                            count++;
                        }
                        number06 = Integer.parseInt(et6.getText().toString());
                        if (number06 > 0) {
                            count++;
                        }

                        beginnerLeg.setExercise01(Integer.parseInt(et1.getText().toString().trim()));
                        beginnerLeg.setExercise02(Integer.parseInt(et2.getText().toString().trim()));
                        beginnerLeg.setExercise03(Integer.parseInt(et3.getText().toString().trim()));
                        beginnerLeg.setExercise04(Integer.parseInt(et4.getText().toString().trim()));
                        beginnerLeg.setExercise05(Integer.parseInt(et5.getText().toString().trim()));
                        beginnerLeg.setExercise06(Integer.parseInt(et6.getText().toString().trim()));

                        //dbRef.push().setValue(abs);
                        repLeg.child("leg").setValue(beginnerLeg);
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
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        et5.setText("");
        et6.setText("");
    }
}