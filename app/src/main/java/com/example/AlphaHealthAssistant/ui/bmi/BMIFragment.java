package com.example.AlphaHealthAssistant.ui.bmi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.AlphaHealthAssistant.R;

public class BMIFragment extends Fragment {

    TextView text;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_bmi,container,false);
        text = root.findViewById(R.id.text_dashboard);

        text.setText("BMI");

        return root;
    }

}
