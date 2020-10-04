package com.example.AlphaHealthAssistant.ui.calorieburn;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.AlphaHealthAssistant.R;
import com.example.AlphaHealthAssistant.ui.calorieburn.dbHelper.Weightget;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CalorieburnFragment extends Fragment {

    Button repoButton, weightSavebutton;
    EditText e1;
    DatabaseReference dbRef;
    Weightget weightget;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calorieburn, container, false);

        ImageButton beginnerButton = v.findViewById(R.id.Beginner_button);
        repoButton = v.findViewById(R.id.repoButton);
        weightSavebutton = v.findViewById(R.id.weightSaveButton);
        e1 = v.findViewById(R.id.inputWeight);

        beginnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), CalorieBurnBeginner.class);
                startActivity(in);
            }
        });

        repoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Report.class);
                startActivity(in);
            }
        });

        //to save user's weight
        weightSavebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveWeight();
            }
        });

        /*repoButton = (Button) findViewById(R.id.repoButton);
        repoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Report.class);
                startActivity(i);
            }
        });*/

        return v;
    }

    private void saveWeight() {
        weightget = new Weightget();

        dbRef = FirebaseDatabase.getInstance().getReference().child("Weight");

        try {
            if (TextUtils.isEmpty(e1.getText().toString())) {
                weightget.setWeight(0.0);
            } else {
                //weightget.setWeight(Integer.parseInt(editText01.getText().toString().trim()));
                weightget.setWeight(Double.parseDouble(e1.getText().toString().trim()));

                dbRef.child("Beginning").setValue(weightget);
                System.out.println("Methana inneeeee");

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Dn Methanaaaa");
        }

    }
}