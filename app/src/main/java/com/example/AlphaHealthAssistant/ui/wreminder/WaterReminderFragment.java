package com.example.AlphaHealthAssistant.ui.wreminder;

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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import com.example.AlphaHealthAssistant.AlphaHealthAssistant;
import com.example.AlphaHealthAssistant.MainActivity2;
import com.example.AlphaHealthAssistant.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WaterReminderFragment extends Fragment {

    private Button addWater;
    EditText waterAmount;
    TextView showWaterAmount;
    WaterReminder reminder;
    long maxID;
    Button plus, neg;
    ProgressBar progressBar;
    int progress=0;
    TextView CurrentLimit;

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    public WaterReminderFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_water_reminder, container, false);

        addWater = (Button) view.findViewById(R.id.wadd);
        waterAmount = (EditText) view.findViewById(R.id.waterAmount);
        showWaterAmount = (TextView) view.findViewById(R.id.showWSum);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        plus = (Button) view.findViewById(R.id.progress_plus);
        neg = (Button) view.findViewById(R.id.progress_neg);
        CurrentLimit = (TextView) view.findViewById(R.id.CurrentLimt);

        DatabaseReference myRef = database.getReference().child("Added Water");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    maxID = (snapshot.getChildrenCount());
                System.out.println(maxID);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        if(CurrentLimit.getText().toString().equals("")){
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Toast.makeText(getContext(), "Updateing Current Limit", Toast.LENGTH_SHORT).show();
                    String value = snapshot.child("Daily Limit").getValue().toString().trim();
                    CurrentLimit.setText( "/" +value+ "ml");
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }



        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(progress <= 90){
                    progress = 10 + progress;
                    progressBar.setProgress(progress);
                }
            }
        });

        neg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Undo");
                if(progress >= 10){
                    progress = progress - 10;
                    progressBar.setProgress(progress);
                }
            }
        });

        addWater.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference().child("Added Water");
                String currentTime,currentDate;

                int waterA = Integer.parseInt(waterAmount.getText().toString().trim());
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
                currentDate = dateFormat.format(calendar.getTime());

                SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
                currentTime = timeFormat.format(calendar.getTime());

                reminder = new WaterReminder();

                reminder.setwAmount(waterA);

                HashMap<String,Object> status = new HashMap<>();
                status.put("Date",currentDate);
                status.put("Time",currentTime);

                myRef.child(String.valueOf(maxID)).setValue(reminder);
                myRef.child(String.valueOf(maxID)).updateChildren(status);

                Toast.makeText(getContext(), "Your Water Amount is Added", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

}