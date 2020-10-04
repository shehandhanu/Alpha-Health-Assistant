package com.example.AlphaHealthAssistant.ui.caloriecal;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.widget.ImageButton;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.AlphaHealthAssistant.R;

import java.util.Calendar;

import static androidx.core.os.LocaleListCompat.create;

public class CaloriecalFragment extends Fragment {
    ImageButton breakfast, lunch, dinner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_caloriecal, container, false);
        final DatePickerDialog[] picker = new DatePickerDialog[1];

        {

            Button pickDateBtn =  (Button)root.findViewById(R.id.pickadayBtn);
            pickDateBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Calendar cldr = Calendar.getInstance();
                    int day = cldr.get(Calendar.DAY_OF_MONTH);
                    int month = cldr.get(Calendar.MONTH);
                    int year = cldr.get(Calendar.YEAR);

                    // date picker dialog
                    picker[0] = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            Intent in = new Intent(getActivity(), CaloriecalDailyMeal.class);
                            in.putExtra("date", String.valueOf(year + "/"+month+"/"+dayOfMonth));
                            startActivity(in);

                        }
                    }, year, month, day);
                    picker[0].show();
                }
            });



        }
        breakfast = (ImageButton)root.findViewById(R.id.breakfastBtn) ;
        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            displayAlert();
            }
        });
        lunch = (ImageButton)root.findViewById(R.id.lunchBtn);
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayAlert();
            }
        });
        dinner = (ImageButton)root.findViewById(R.id.DinnerBtn);
        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayAlert();
            }
        });



        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
       setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.caloriecal_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_history){
            Intent in = new Intent(getActivity(), CaloriecalHistory.class);
            in.putExtra("some", "History Page");
            startActivity(in);
        }
        if(id == R.id.action_report){
            Intent in = new Intent(getActivity(), CaloriecalDailyReport.class);
            in.putExtra("some", "Report Page");
            startActivity(in);
        }

        return super.onOptionsItemSelected(item);


    }
    public void displayAlert(){
        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        alert.setMessage("Pick a day first");
        alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "Good", Toast.LENGTH_SHORT).show();
            }
        });
        alert.show();
    }

}