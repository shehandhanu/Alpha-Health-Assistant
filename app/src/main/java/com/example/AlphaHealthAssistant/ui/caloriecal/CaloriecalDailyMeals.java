package com.example.AlphaHealthAssistant.ui.caloriecal;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.AlphaHealthAssistant.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CaloriecalDailyMeals#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CaloriecalDailyMeals extends Fragment {
    ImageButton breakfast;
    Button pickday;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CaloriecalDailyMeals() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CaloriecalDailyMeals.
     */
    // TODO: Rename and change types and number of parameters
    public static CaloriecalDailyMeals newInstance(String param1, String param2) {
        CaloriecalDailyMeals fragment = new CaloriecalDailyMeals();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        breakfast = (ImageButton) getView().findViewById((R.id.breakfast);
        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        pickday = (Button) getView().findViewById(R.id.button);
        pickday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), CaloriecalDatePicker.class);
                startActivity(i);

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_caloriecal_daily_meals, container, false);
    }
    public void openDialog(){
        CaloriecalAlert alert = new CaloriecalAlert();
        alert.show(getActivity().getSupportFragmentManager(), "example dialog");
    }
}