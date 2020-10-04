package com.example.AlphaHealthAssistant.ui.bmi;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputType;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.AlphaHealthAssistant.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BMIHistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BMIHistoryFragment extends Fragment {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "DocSnippets";
    private EditText txtDate;
    private DatePickerDialog picker;

    private RecyclerView recyclerView;
    FirestoreRecyclerAdapter adapter;
    FirestoreRecyclerOptions<BMIModel> options;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BMIHistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BMIHistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BMIHistoryFragment newInstance(String param1, String param2) {
        BMIHistoryFragment fragment = new BMIHistoryFragment();
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

        View view = inflater.inflate(R.layout.fragment_b_m_i_history, container, false);
        recyclerView = view.findViewById(R.id.recycler1);
        txtDate = view.findViewById((R.id.editTextDate));
        txtDate.setInputType(InputType.TYPE_NULL);
        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                final int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                Timestamp time = new Timestamp(Date.from(LocalDate.of(year, (monthOfYear + 1), dayOfMonth).atStartOfDay(ZoneId.systemDefault()).toInstant()));
                                txtDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                Query query = db.collection("bmi-records").whereEqualTo("date", time);
                                options = new FirestoreRecyclerOptions.Builder<BMIModel>()
                                        .setQuery(query, BMIModel.class)
                                        .build();
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));


        Query query = db.collection("bmi-records");
        options = new FirestoreRecyclerOptions.Builder<BMIModel>()
                .setQuery(query, BMIModel.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<BMIModel,BMIviewHolder>(options) {
            @Override
            public void onBindViewHolder(BMIviewHolder holder, final int position, final BMIModel model) {
                holder.bmiindex.setText(String.valueOf(model.getBmi()));
                holder.age.setText(String.valueOf(model.getAge()));
                holder.date.setText(formatDate(model.getDate()));
                final DocumentSnapshot doc = (DocumentSnapshot) adapter.getSnapshots().getSnapshot(position);
                holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Dialog dialog = new Dialog(getContext());
                        dialog.setContentView(R.layout.dialog_update);
                        dialog.setTitle("Update");
                        final EditText age = dialog.findViewById(R.id.age);
                        final EditText height = dialog.findViewById(R.id.height);
                        final EditText weight = dialog.findViewById(R.id.weight);

                        Button update = dialog.findViewById(R.id.update);
                        update.setOnClickListener(new View.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void onClick(View v) {
                                int _age = Integer.parseInt(age.getText().toString());
                                double _height = Double.parseDouble(height.getText().toString());
                                double _weight = Double.parseDouble(weight.getText().toString());
                                double bmi = _weight / (_height * _height);
                                String docId = doc.getId();
                                updateDetails(_age, _height, _weight, bmi, docId);
                                dialog.dismiss();
                            }
                        });
                        dialog.show();
                    }
                });
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Dialog dialog = new Dialog(getContext());
                        dialog.setContentView(R.layout.dialog_delete);
                        dialog.setTitle("Delete");

                        Button yes = dialog.findViewById(R.id.yes);
                        yes.setOnClickListener(new View.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void onClick(View v) {
                                db.collection("bmi-records").document(doc.getId())
                                        .delete()
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Toast.makeText(getContext(), "Record is deleted.", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(getContext(), "Record is not deleted.", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                dialog.dismiss();
                            }
                        });
                        Button no = dialog.findViewById(R.id.no);
                        no.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                        dialog.show();
                    }
                });
            }

            @Override
            public BMIviewHolder onCreateViewHolder(ViewGroup group, int i) {
                View view = LayoutInflater.from(group.getContext())
                        .inflate(R.layout.bmi_record, group, false);

                return new BMIviewHolder(view);
            }
        };
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(adapter);
        return view;
    }

    /**
     * Called when the Fragment is visible to the user.  This is generally
     * tied to  of the containing
     * Activity's lifecycle.
     */
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    /**
     * Called when the Fragment is no longer started.  This is generally
     * tied to  of the containing
     * Activity's lifecycle.
     */
    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    private String formatDate(Timestamp timestamp) {
        long time = timestamp.getSeconds();
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(time * 1000L);
        String date = DateFormat.format("dd-MM-yyyy", cal).toString();
        return date;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void updateDetails(int age, double height, double weight, double bmi, String id) {
        Timestamp date = new Timestamp(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        BMIModel model = new BMIModel(age, weight, height, bmi, date);
        db.collection("bmi-records").document(id)
                .update("age", age,
                        "height", height,
                        "weight", weight,
                        "bmi", bmi,
                        "date", date)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getContext(), "Record is updated.", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(), "Record is not updated.", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}