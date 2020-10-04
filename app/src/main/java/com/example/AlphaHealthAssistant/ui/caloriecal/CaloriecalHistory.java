package com.example.AlphaHealthAssistant.ui.caloriecal;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.example.AlphaHealthAssistant.R;
import com.example.AlphaHealthAssistant.ui.caloriecal.database.Dinner;
import com.example.AlphaHealthAssistant.ui.caloriecal.database.Lunch;
import com.example.AlphaHealthAssistant.ui.caloriecal.database.Meal;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.Toast;

public class CaloriecalHistory extends AppCompatActivity {
    EditText b1,b2,b3,b4,b5;
    EditText l1,l2,l3,l4,l5;
    EditText d1,d2,d3,d4,d5;

    private void clearControlsBreakfast() {
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
    }
    private void clearControlsLunch(){
        l1.setText("");
        l2.setText("");
        l3.setText("");
        l4.setText("");
    }

    private void clearControlsDinner(){
        d1.setText("");
        d2.setText("");
        d3.setText("");
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caloriecal_history);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);


        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        l3 = findViewById(R.id.l3);
        l4 = findViewById(R.id.l4);



        d1 = findViewById(R.id.d1);
        d2 = findViewById(R.id.d2);
        d3 = findViewById(R.id.d3);

        Button date = findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("breakfast").child("today");
                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChildren()) {
                            b1.setText(dataSnapshot.child("countmilkcofee").getValue().toString());
                            b2.setText(dataSnapshot.child("countorangeJuice").getValue().toString());
                            b3.setText(dataSnapshot.child("countavocadoJuice").getValue().toString());
                            b4.setText(dataSnapshot.child("counthoppers").getValue().toString());
                            b5.setText(dataSnapshot.child("countStringHoppers").getValue().toString());


                        }else{
                            Toast.makeText(getApplicationContext(), "No source to display", Toast.LENGTH_SHORT).show();
                        }
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                DatabaseReference dbReadlunch = FirebaseDatabase.getInstance().getReference().child("lunch").child("today");
                dbReadlunch.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChildren()){
                            l1.setText(dataSnapshot.child("redRiceCount").getValue().toString());
                            l2.setText(dataSnapshot.child("greenBeansCount").getValue().toString());
                            l3.setText(dataSnapshot.child("tomatoCount").getValue().toString());
                            l4.setText(dataSnapshot.child("mushroomCount").getValue().toString());
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "No source to display", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                DatabaseReference dbReadDinner = FirebaseDatabase.getInstance().getReference().child("dinner").child("today");
                dbReadDinner.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChildren()){
                            d1.setText(dataSnapshot.child("breadCount").getValue().toString());
                            d2.setText(dataSnapshot.child("noodlesCount").getValue().toString());
                            d3.setText(dataSnapshot.child("coconutRotiCount").getValue().toString());
                        }else{
                            Toast.makeText(getApplicationContext(), "No source to display", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        Meal meal = new Meal();
        Lunch lunch = new Lunch();
        Dinner dinner = new Dinner();

        Button update = findViewById(R.id.btnUpdate);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference upRef = FirebaseDatabase.getInstance().getReference().child("breakfast");
                upRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("today")){
                            try{
                                meal.setCountmilkcofee(Integer.parseInt(b1.getText().toString().trim()));
                                meal.setCountorangeJuice(Integer.parseInt(b2.getText().toString().trim()));
                                meal.setCountavocadoJuice(Integer.parseInt(b3.getText().toString().trim()));
                                meal.setCounthoppers(Integer.parseInt(b4.getText().toString().trim()));
                                meal.setCountStringHoppers(Integer.parseInt(b5.getText().toString().trim()));

                                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("breakfast").child("today");
                                dbRef.setValue(meal);
                                clearControlsBreakfast();
                                Toast.makeText(getApplicationContext(), "Data updated successfully", Toast.LENGTH_SHORT).show();

                            }catch (NumberFormatException e){
                                Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "No source to update", Toast.LENGTH_SHORT).show();
                        }
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                DatabaseReference dbupdateLunch = FirebaseDatabase.getInstance().getReference().child("lunch");
                dbupdateLunch.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("today")){
                            try{
                                lunch.setRedRiceCount(Integer.parseInt(l1.getText().toString().trim()));
                                lunch.setGreenBeansCount(Integer.parseInt(l2.getText().toString().trim()));
                                lunch.setTomatoCount(Integer.parseInt(l3.getText().toString().trim()));
                                lunch.setMushroomCount(Integer.parseInt(l4.getText().toString().trim()));

                                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("lunch").child("today");
                                dbRef.setValue(lunch);
                                clearControlsLunch();
                                Toast.makeText(getApplicationContext(), "Data updated lunch", Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(getApplicationContext(), "No source to update", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                DatabaseReference dbupdateDinner = FirebaseDatabase.getInstance().getReference().child("dinner");
                dbupdateDinner.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("today")){
                            try{
                                dinner.setBreadCount(Integer.parseInt(d1.getText().toString().trim()));
                                dinner.setNoodlesCount(Integer.parseInt(d2.getText().toString().trim()));
                                dinner.setCoconutRotiCount(Integer.parseInt(d3.getText().toString().trim()));

                                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("dinner").child("today");
                                dbRef.setValue(dinner);
                                clearControlsDinner();
                                Toast.makeText(getApplicationContext(), "Data updated dinner", Toast.LENGTH_SHORT).show();


                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "No source to update", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

        });
        Button delete = findViewById(R.id.deleteBtn);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("breakfast");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("today")){
                            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("breakfast").child("today");
                            dbRef.removeValue();
                            clearControlsBreakfast();
                            Toast.makeText(getApplicationContext(), "Data deleted Successfully", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "No source to delete", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                DatabaseReference dellunch = FirebaseDatabase.getInstance().getReference().child("lunch");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("today")){
                            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("lunch").child("today");
                            dbRef.removeValue();
                            clearControlsLunch();
                            Toast.makeText(getApplicationContext(), "Data deleted Successfully", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "No source to delete", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                DatabaseReference delDinner = FirebaseDatabase.getInstance().getReference().child("dinner");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("today")){
                            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("dinner").child("today");
                            dbRef.removeValue();
                            clearControlsDinner();
                            Toast.makeText(getApplicationContext(), "Data deleted Successfully", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "No source to delete", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            if(bundle.getString("some") != null){
                Toast.makeText(getApplicationContext(), "data"+bundle.getString("some"),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}