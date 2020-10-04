/*package com.example.AlphaHealthAssistant.ui.bmi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.AlphaHealthAssistant.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BMICalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
/*public class BMICalculatorFragment extends Fragment {
    Button cal;
    EditText ag,wt,ht;
    TextView tva,tvw,tvh,bmi,bmiview,bodystatus;

    float wei, hei, bmires;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BMICalculatorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BMICalculatorFragment.
     */
    // TODO: Rename and change types and number of parameters
   /* public static BMICalculatorFragment newInstance(String param1, String param2) {
        BMICalculatorFragment fragment = new BMICalculatorFragment();
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
        //return inflater.inflate(R.layout.fragment_b_m_i_calculator, container, false);

        View view = inflater.inflate(R.layout.fragment_b_m_i_calculator, container, false);
        cal = view.findViewById(R.id.calbutton);
        //edit txt
        ag = view.findViewById(R.id.age);
        wt = view.findViewById(R.id.wei);
        ht = view.findViewById(R.id.hei);
        //text view
        tva = view.findViewById(R.id.agetv);
        tvh = view.findViewById(R.id.weitv);
        tvw = view.findViewById(R.id.heitv);
        bmi = view.findViewById(R.id.bmitv);
        //result
        bmiview = view.findViewById(R.id.bshtv);
        bodystatus = view.findViewById(R.id.bsttv);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wei = Float.parseFloat(wt.getText().toString());
                hei = Float.parseFloat(ht.getText().toString());

                bmires = wei/(hei*hei);
                bmiview.setText(String.valueOf(bmires));

                if(bmires >= 30){
                    bodystatus.setText("you are Obese");
                }
                else if(bmires < 30 && bmires > 25){
                    bodystatus.setText("you are Overweight");
                }
                else if(bmires <= 25 && bmires >= 18.5){
                    bodystatus.setText("you are Normal");
                }
                else if(bmires < 18.5 ){
                    bodystatus.setText("you are Underweight");
                }

            }
        });

        return view;


    }

    public float getBmiRes(){
        return bmires;
    }
    //private Button findViewById(int calbutton) {
    // }
}*/


 //updated code
package com.example.AlphaHealthAssistant.ui.bmi;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.AlphaHealthAssistant.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.sql.Time;
import java.time.ZoneId;
import java.util.Date;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BMICalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BMICalculatorFragment extends Fragment {
    Button cal;
    EditText ag,wt,ht;
    TextView tva,tvw,tvh,bmi,bmiview,bodystatus;

    float wei, hei;
    private static float bmires;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BMICalculatorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BMICalculatorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BMICalculatorFragment newInstance(String param1, String param2) {
        BMICalculatorFragment fragment = new BMICalculatorFragment();
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
        //return inflater.inflate(R.layout.fragment_b_m_i_calculator, container, false);

        View view = inflater.inflate(R.layout.fragment_b_m_i_calculator, container, false);
        cal = view.findViewById(R.id.calbutton);
        //edit txt
        ag = view.findViewById(R.id.age);
        wt = view.findViewById(R.id.wei);
        ht = view.findViewById(R.id.hei);
        //text view
        tva = view.findViewById(R.id.agetv);
        tvh = view.findViewById(R.id.weitv);
        tvw = view.findViewById(R.id.heitv);
        bmi = view.findViewById(R.id.bmitv);
        //result
        bmiview = view.findViewById(R.id.bshtv);
        bodystatus = view.findViewById(R.id.bsttv);

        cal.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                wei = Float.parseFloat(wt.getText().toString());
                hei = Float.parseFloat(ht.getText().toString());

                bmires = wei/(hei*hei);
                bmiview.setText(String.valueOf(bmires));

                saveDetails(Integer.parseInt(ag.getText().toString()), wei, hei, bmires);

                if(bmires >= 30){
                    bodystatus.setText("you are Obese");
                }
                else if(bmires < 30 && bmires > 25){
                    bodystatus.setText("you are Overweight");
                }
                else if(bmires <= 25 && bmires >= 18.5){
                    bodystatus.setText("you are Normal");
                }
                else if(bmires < 18.5 ){
                    bodystatus.setText("you are Underweight");
                }

            }
        });

        return view;


    }

    public static float getBmiRes(){
        return bmires;
    }
    //private Button findViewById(int calbutton) {
    // }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void saveDetails(int age, double height, double weight, double bmi){
        Timestamp date = new Timestamp(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        BMIModel model = new BMIModel(age, weight, height, bmi, date);
        db.collection("bmi-records")
                .add(model)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getContext(),"Record is stored!",Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(),"Record is not stored!",Toast.LENGTH_SHORT).show();
                    }
                });
    }
}








