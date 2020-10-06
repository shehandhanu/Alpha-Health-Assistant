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
import com.example.AlphaHealthAssistant.ui.calorieburn.dbHelper.ABS;
import com.example.AlphaHealthAssistant.ui.calorieburn.popUps.ExerCise04_popUp;
import com.example.AlphaHealthAssistant.ui.calorieburn.popUps.Exercise02_popUp;
import com.example.AlphaHealthAssistant.ui.calorieburn.popUps.Exercise03_popUp;
import com.example.AlphaHealthAssistant.ui.calorieburn.popUps.Exercise05_popUp;
import com.example.AlphaHealthAssistant.ui.calorieburn.popUps.Exercise06_popUp;
import com.example.AlphaHealthAssistant.ui.calorieburn.popUps.Exercise07_popUp;
import com.example.AlphaHealthAssistant.ui.calorieburn.popUps.popDialog;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ABS_Exercise_List extends AppCompatActivity {
    public static final String EXTRA_NUMBER01 = "com.example.AlphaHealthAssistant.EXTRA_NUMBER01";
    public static final String EXTRA_NUMBER02 = "com.example.AlphaHealthAssistant.EXTRA_NUMBER02";

    Button buttonFinal, buttonDetails01;
    Button buttonDetails02, buttonDetails03, buttonDetails04, buttonDetails05, buttonDetails06, buttonDetails07;
    int number01, number02, number03, number04, number05, number06, number07;
    EditText editText01, editText02, editText03, editText04, editText05, editText06, editText07;

    DatabaseReference dbRef;
    ABS abs;

    private void clearControls() {
        editText01.setText("");
        editText02.setText("");
        editText03.setText("");
        editText04.setText("");
        editText05.setText("");
        editText06.setText("");
        editText07.setText("");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_b_s__exercise__list);

        editText01 = findViewById(R.id.et_01);
        editText02 = findViewById(R.id.et_02);
        editText03 = findViewById(R.id.et_03);
        editText04 = findViewById(R.id.et_04);
        editText05 = findViewById(R.id.et_05);
        editText06 = findViewById(R.id.et_06);
        editText07 = findViewById(R.id.et_07);

        buttonFinal = findViewById(R.id.buttonToFinalResult);

        abs = new ABS();
        buttonFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int count = 0;
                dbRef = FirebaseDatabase.getInstance().getReference().child("Beginner");

                try {
                    if (TextUtils.isEmpty(editText01.getText().toString())) {
                        abs.setExercise01(0);

                    } else if (TextUtils.isEmpty(editText02.getText().toString())) {
                        abs.setExercise02(0);

                    } else if (TextUtils.isEmpty(editText03.getText().toString())) {
                        abs.setExercise04(0);

                    } else if (TextUtils.isEmpty(editText04.getText().toString())) {
                        abs.setExercise05(0);

                    } else if (TextUtils.isEmpty(editText05.getText().toString())) {
                        abs.setExercise05(0);

                    } else if (TextUtils.isEmpty(editText06.getText().toString())) {
                        abs.setExercise06(0);

                    } else if (TextUtils.isEmpty(editText07.getText().toString())) {
                        abs.setExercise07(0);

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
                        number07 = Integer.parseInt(editText07.getText().toString());
                        if (number07 > 0) {
                            count++;
                        }

                        abs.setExercise01(Integer.parseInt(editText01.getText().toString().trim()));
                        abs.setExercise02(Integer.parseInt(editText02.getText().toString().trim()));
                        abs.setExercise03(Integer.parseInt(editText03.getText().toString().trim()));
                        abs.setExercise04(Integer.parseInt(editText04.getText().toString().trim()));
                        abs.setExercise05(Integer.parseInt(editText05.getText().toString().trim()));
                        abs.setExercise06(Integer.parseInt(editText06.getText().toString().trim()));
                        abs.setExercise07(Integer.parseInt(editText07.getText().toString().trim()));

                        //dbRef.push().setValue(abs);
                        dbRef.child("abs").setValue(abs);
                        //dbRef.setValue(abs);
                        Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                        clearControls();

                        //do the calculations
                        int sum = ((number01 * 8) + (number02 * 6) + (number03 * 8) + (number04 * 15) + (number05 * 4) + (number06 * 4) + (number07 * 4));

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


        //set pop-up 01
        buttonDetails01 = findViewById(R.id.detailsButton01);
        buttonDetails01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
        //set pop-up 02
        buttonDetails02 = findViewById(R.id.detailsButton2);
        buttonDetails02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog02();
            }
        });
        //set pop-up 03
        buttonDetails03 = findViewById(R.id.detailsButton3);
        buttonDetails03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog03();
            }
        });
        //set pop-up 04
        buttonDetails04 = findViewById(R.id.detailsButton4);
        buttonDetails04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog04();
            }
        });
        //set pop-up 05
        buttonDetails05 = findViewById(R.id.detailsButton5);
        buttonDetails05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog05();
            }
        });
        //set pop-up 06
        buttonDetails06 = findViewById(R.id.detailsButton6);
        buttonDetails06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog06();
            }
        });
        //set pop-up 07
        buttonDetails07 = findViewById(R.id.detailsButton7);
        buttonDetails07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog07();
            }
        });


    }

    //methods to open pop-ups
    public void openDialog() {
        popDialog popdialog = new popDialog();
        popdialog.show(getSupportFragmentManager(), "pop dialog");
    }

    public void openDialog02() {
        Exercise02_popUp exercise02_popUp = new Exercise02_popUp();
        exercise02_popUp.show(getSupportFragmentManager(), "pop dialog02");
    }

    public void openDialog03() {
        Exercise03_popUp exercise03_popUp = new Exercise03_popUp();
        exercise03_popUp.show(getSupportFragmentManager(), "pop dialog");
    }

    public void openDialog04() {
        ExerCise04_popUp exercise04_popUp = new ExerCise04_popUp();
        exercise04_popUp.show(getSupportFragmentManager(), "pop dialog");
    }

    public void openDialog05() {
        Exercise05_popUp exercise05_popUp = new Exercise05_popUp();
        exercise05_popUp.show(getSupportFragmentManager(), "pop dialog");
    }

    public void openDialog06() {
        Exercise06_popUp exercise06_popUp = new Exercise06_popUp();
        exercise06_popUp.show(getSupportFragmentManager(), "pop dialog");
    }

    public void openDialog07() {
        Exercise07_popUp exercise07_popUp = new Exercise07_popUp();
        exercise07_popUp.show(getSupportFragmentManager(), "pop dialog");
    }
}