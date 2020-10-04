/*package com.example.AlphaHealthAssistant.ui.bmi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.AlphaHealthAssistant.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BMITipsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
/*public class BMITipsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_BMIRES = "bmires";

    // TODO: Rename and change types of parameters
    private float bmi;

    public BMITipsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param bmires Parameter 1.
     * @return A new instance of fragment BMITipsFragment.
     */
    // TODO: Rename and change types and number of parameters
  /*  public static BMITipsFragment newInstance(float bmires) {
        BMITipsFragment fragment = new BMITipsFragment();
        Bundle args = new Bundle();
        args.putFloat(ARG_BMIRES, bmires);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            bmi = getArguments().getFloat(ARG_BMIRES);


            if(bmi >= 30){
                System.out.println("you are Obese");
            }
            else if(bmi < 30 && bmi > 25){
                System.out.println("you are Overweight");
            }
            else if(bmi <= 25 && bmi >= 18.5){
                System.out.println("you are Normal");
            }
            else if(bmi < 18.5 ){
                System.out.println("you are Underweight");
            }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b_m_i_tips, container, false);
    }
}*/


  //updated code

package com.example.AlphaHealthAssistant.ui.bmi;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.AlphaHealthAssistant.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BMITipsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BMITipsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_BMIRES = "bmires";
    private TextView tipsText,tips1,tips2,tips3,tips4;
    private View view;
    // TODO: Rename and change types of parameters
    private float bmi;

    public BMITipsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param bmires Parameter 1.
     * @return A new instance of fragment BMITipsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BMITipsFragment newInstance(Float bmires) {
        BMITipsFragment fragment = new BMITipsFragment();
        Bundle args = new Bundle();
        args.putFloat(ARG_BMIRES, bmires);
        fragment.setArguments(args);
        return fragment;
    }


    /**
     * Called when the Fragment is visible to the user.  This is generally
     * tied to  of the containing
     * Activity's lifecycle.
     */
    @Override
    public void onStart() {
        super.onStart();

        tipsText = view.findViewById(R.id.txtTips);
        tips1 = view.findViewById(R.id.tip1);
        tips2 = view.findViewById(R.id.tip2);
        tips3 = view.findViewById(R.id.tip3);
        tips4 = view.findViewById(R.id.tip4);

        if (getArguments() != null) {
            bmi = BMICalculatorFragment.getBmiRes();
            if(bmi >= 30){
                tipsText.setText("you are Obese");
                tips1.setText("Drink green tea  ");
                tips2.setText("Try intermittent fasting");
                tips3.setText("Do aerobic exercises");
                tips4.setText("Beat your junk food addiction");
            }
            else if(bmi < 30 && bmi > 25){
                tipsText.setText("you are Overweight");
                tips1.setText("Eat more fruit, vegetables, nuts, and whole grains");
                tips2.setText("Use vegetable-based oils rather than animal-based fats");
               tips3.setText("Try to reduce junk food addiction");
               tips4.setText("Drink coffee without suger");
            }
            else if(bmi <= 25 && bmi >= 18.5){
                tipsText.setText("you are Normal");
                tips1.setText("Drink water");
                tips2.setText("Do not skip your meals");
                tips3.setText("Eat moderate portions");
                tips4.setText("Be active");
            }
            else if(bmi < 18.5 ){
                tipsText.setText("you are Underweight");
                tips1.setText("Choose nutrient-rich foods");
                tips2.setText("Eat more calories than your body burns.");
                tips3.setText("Try smoothies and shakes.");
                tips4.setText("Don't try to gain weight by eating junk food");
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view =  inflater.inflate(R.layout.fragment_b_m_i_tips, container, false);

        return view;
    }


}