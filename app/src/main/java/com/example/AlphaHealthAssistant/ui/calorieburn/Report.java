package com.example.AlphaHealthAssistant.ui.calorieburn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.AlphaHealthAssistant.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Report extends AppCompatActivity {

    Button beginnerButton, currentWeight;
    EditText e1, e2, e3, e4, e5, e6, e7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        beginnerButton = findViewById(R.id.beginnerbutton);
        currentWeight = findViewById(R.id.currentWeight);

        e1 = findViewById(R.id.view1);
        e2 = findViewById(R.id.view2);
        e3 = findViewById(R.id.view3);
        e4 = findViewById(R.id.view4);
        e5 = findViewById(R.id.view5);
        e6 = findViewById(R.id.view6);
        e7 = findViewById(R.id.view7);

        currentWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference rep = FirebaseDatabase.getInstance().getReference().child("Weight").child("Beginning");
                rep.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.hasChildren()) {
                            e6.setText(snapshot.child("weight").getValue().toString());
                            e7.setText(snapshot.child("weight").getValue().toString());
                        } else {
                            Toast.makeText(getApplicationContext(), "No source to display....", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }

    public void setABS(View view) {
        try {
            beginnerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Beginner").child("abs");
                    readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChildren()) {
                                int val1 = Integer.parseInt(snapshot.child("exercise01").getValue().toString());
                                int val2 = Integer.parseInt(snapshot.child("exercise02").getValue().toString());
                                int val3 = Integer.parseInt(snapshot.child("exercise03").getValue().toString());
                                int val4 = Integer.parseInt(snapshot.child("exercise04").getValue().toString());
                                int val5 = Integer.parseInt(snapshot.child("exercise05").getValue().toString());
                                int val6 = Integer.parseInt(snapshot.child("exercise06").getValue().toString());
                                int val7 = Integer.parseInt(snapshot.child("exercise07").getValue().toString());

                                //int finalVal = val1 + val2 + val3 + val4 + val5 + val6 + val7;
                                int finalVal = ((val1 * 8) + (val2 * 6) + (val3 * 8) + (val4 * 15) + (val5 * 4) + (val6 * 4) + (val7 * 4));
                                e1.setText("" + finalVal);
                            } else {
                                Toast.makeText(getApplicationContext(), "No source to display....", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            });
        } catch (Exception e) {
            System.out.println("errorrr..." + e);
        }
    }

}
/*
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
        });*/
