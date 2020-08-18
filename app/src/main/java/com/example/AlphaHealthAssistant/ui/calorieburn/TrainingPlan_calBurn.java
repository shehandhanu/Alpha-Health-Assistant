package com.example.AlphaHealthAssistant.ui.calorieburn;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.AlphaHealthAssistant.R;

public class TrainingPlan_calBurn extends Fragment {

    ImageButton imgButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_training_plan_cal_burn, container, false);

        //imgButton = v.findViewById(R.id.)

        return v;

    }
}