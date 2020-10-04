package com.example.AlphaHealthAssistant.ui.calorieburn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.AlphaHealthAssistant.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Final_result_view extends AppCompatActivity {

    Button buttonNext;
    //EditText e1,e2,e3,e4,e5,e6,e7;
    //Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result_view);

        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), leg_beginner.class);
                startActivity(i);
            }
        });

        Intent i = getIntent();
        int number = i.getIntExtra(ABS_Exercise_List.EXTRA_NUMBER01, 0);
        int number_count = i.getIntExtra(ABS_Exercise_List.EXTRA_NUMBER02, 0);

        //get saved values
        TextView editText = findViewById(R.id.et_Kcal_chest);
        editText.setText("" + number);

        //get saved values
        TextView editText1 = findViewById(R.id.et_numberOfExercises);
        editText1.setText("" + number_count);

        /*e1 = findViewById(R.id.getValue1);
        e2 = findViewById(R.id.getValue2);
        e3 = findViewById(R.id.getValue3);
        e4 = findViewById(R.id.getValue4);
        e5 = findViewById(R.id.getValue5);
        e6 = findViewById(R.id.getValue6);
        e7 = findViewById(R.id.getValue7); */

        //b1 = findViewById(R.id.bbb);

        /*b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Beginner").child("abs");
                readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.hasChildren()){
                            e1.setText(snapshot.child("exercise01").getValue().toString());
                            e2.setText(snapshot.child("exercise02").getValue().toString());
                            e3.setText(snapshot.child("exercise03").getValue().toString());
                            e4.setText(snapshot.child("exercise04").getValue().toString());
                            e5.setText(snapshot.child("exercise05").getValue().toString());
                            e6.setText(snapshot.child("exercise06").getValue().toString());
                            e7.setText(snapshot.child("exercise07").getValue().toString());
                        }else{
                            Toast.makeText(getApplicationContext(), "No source to display....", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        }); */

    }
}