package com.example.AlphaHealthAssistant.ui.bmi;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.AlphaHealthAssistant.R;


class BMIviewHolder extends RecyclerView.ViewHolder {
    TextView bmiindex, date, age;
    Button btnUpdate, btnDelete;

    public BMIviewHolder(@NonNull View itemView) {
        super(itemView);

        bmiindex = itemView.findViewById(R.id.bmiindex);
        date = itemView.findViewById(R.id.date);
        age = itemView.findViewById(R.id.age);

        btnDelete = itemView.findViewById(R.id.btnDelete);
        btnUpdate = itemView.findViewById(R.id.btnUpdate);
    }
}

