package com.example.AlphaHealthAssistant.ui.calorieburn;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.AlphaHealthAssistant.R;

public class fragment_MainActivity_KalBurn extends Fragment {

    ImageButton imgBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment__main_activity__kal_burn, container, false);

        imgBtn = v.findViewById(R.id.Beginner_button);
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}