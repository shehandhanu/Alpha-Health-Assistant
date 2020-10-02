package com.example.AlphaHealthAssistant.ui.wreminder;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.awt.font.TextAttribute;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class WaterSettingsFragment extends Fragment {

    TextView CurrentLimit;
    EditText AddLimit;
    Button AddLimitBtn;
    DatabaseReference myRef;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_water_settings, container, false);

        CurrentLimit = (TextView) view.findViewById(R.id.dailyLimitView);
        AddLimit = (EditText) view.findViewById(R.id.addDailyLimit);
        AddLimitBtn = (Button) view.findViewById(R.id.addDailyLimitBtn);

        myRef = FirebaseDatabase.getInstance().getReference().child("Added Water");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.child("Daily Limit").getValue().toString();
                Toast.makeText(getContext(), "Updateing Current Limit", Toast.LENGTH_SHORT).show();
                CurrentLimit.setText(value + " ml");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        AddLimitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int waterLimit = Integer.parseInt(AddLimit.getText().toString());

                myRef.child("Daily Limit").setValue(waterLimit);
                Toast.makeText(getContext(), "Database Updated", Toast.LENGTH_SHORT).show();
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String value = snapshot.child("Daily Limit").getValue().toString();
                        Toast.makeText(getContext(), "Updateing Current Limit", Toast.LENGTH_SHORT).show();
                        CurrentLimit.setText(value + " ml");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });




        return view;
    }
}