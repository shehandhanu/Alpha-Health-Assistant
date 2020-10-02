package com.example.AlphaHealthAssistant.ui.wreminder;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.AlphaHealthAssistant.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class WaterHistoryFragment extends Fragment {

    List<WaterReminder> historyData;
    RecyclerView recyclerView;
    HelperAdapter helperAdapter;
    DatabaseReference databaseReference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_water_history, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.waterHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        historyData = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("Added Water");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds: snapshot.getChildren()){
                    WaterReminder data = ds.getValue(WaterReminder.class);
                    historyData.add(data);
                }
                helperAdapter = new HelperAdapter(historyData);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return view;
    }

    /////////////////////////////////////////////////////////////
}