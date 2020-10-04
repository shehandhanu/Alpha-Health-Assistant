package com.example.AlphaHealthAssistant.ui.calorieburn.popUps;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Exercise07_popUp extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Spine Lumbar twist Stretch right")
                .setMessage("Lie on your back with your legs extended. Lift your right leg up and use" +
                        " your left hand to pull your right knee to the left, but keep your other arm " +
                        "extended to the side on the floor.     " +
                        "Hold this position for a few seconds")
                .setPositiveButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return builder.create();
    }
}
