package com.example.AlphaHealthAssistant.ui.caloriecal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.AlphaHealthAssistant.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CaloriecalBreakfast#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CaloriecalBreakfast extends Fragment {
    int minteger = 0;
    int minteger1 = 0;
    int minteger2 = 0;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CaloriecalBreakfast() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CaloriecalBreakfast.
     */
    // TODO: Rename and change types and number of parameters
    public static CaloriecalBreakfast newInstance(String param1, String param2) {
        CaloriecalBreakfast fragment = new CaloriecalBreakfast();
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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_caloriecal_breakfast, container, false);
    }
    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }
    public void increaseIntegerSecond(View view) {
        minteger1 = minteger1 + 1;
        displaySecond(minteger1);

    }
    public void increaseIntegerThird(View view) {
        minteger2 = minteger2 + 1;
        displayThird(minteger2);

    }

    public void decreaseInteger(View view) {
        minteger = minteger - 1;
        display(minteger);
    }
    public void decreaseIntegerSecond(View view) {
        minteger1 = minteger1 - 1;
        displaySecond(minteger1);
    }
    public void decreaseIntegerThird(View view) {
        minteger2 = minteger2 - 1;
        displayThird(minteger2);
    }
    private void display(int number) {
        TextView displayInteger = (TextView) getView().findViewById(
                R.id.textView7);
        displayInteger.setText("" + number);
    }
    private void displaySecond(int number) {
        TextView displayInteger = (TextView) getView().findViewById(
                R.id.textView8);
        displayInteger.setText("" + number);
    }
    private void displayThird(int number) {
        TextView displayInteger = (TextView) getView().findViewById(
                R.id.textView10);
        displayInteger.setText("" + number);
    }
}