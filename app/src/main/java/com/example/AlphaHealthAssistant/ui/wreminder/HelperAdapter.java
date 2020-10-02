package com.example.AlphaHealthAssistant.ui.wreminder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.AlphaHealthAssistant.R;

import java.util.List;

public class HelperAdapter extends RecyclerView.Adapter {

        List<WaterReminder> historyData;

    public HelperAdapter(List<WaterReminder> historyData) {

    }

    @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_water_history_icon,parent,false);

            ViewHolderClass viewHolderClass = new ViewHolderClass(view);

            return viewHolderClass;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            ViewHolderClass viewHolderClass = (ViewHolderClass)holder;

            WaterReminder waterReminder = historyData.get(position);

            viewHolderClass.amount.setText(waterReminder.getwAmount());
            viewHolderClass.date.setText(waterReminder.getAddDate().toString());
            viewHolderClass.time.setText(waterReminder.getAddTime().toString());
        }

        @Override
        public int getItemCount() {
            return historyData.size();
        }

    /* //////////////////////////////////////////// */

        public class ViewHolderClass extends RecyclerView.ViewHolder{

            TextView amount, date,time;

            public ViewHolderClass(@NonNull View itemView) {
                super(itemView);

                amount = itemView.findViewById(R.id.historyIconAmount);
                date = itemView.findViewById(R.id.historyIconDate);
                time = itemView.findViewById(R.id.historyIconTime);

            }
        }

}
