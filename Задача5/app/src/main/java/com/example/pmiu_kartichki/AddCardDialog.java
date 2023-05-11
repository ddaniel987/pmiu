package com.example.pmiu_kartichki;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddCardDialog extends DialogFragment {
    private BirthdayCardInterface mListener;

    public static AddCardDialog newInstance() {
        return new AddCardDialog();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_add_person, container, false);
        mListener = (BirthdayCardInterface) requireActivity();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText fullNameEditText = view.findViewById(R.id.edit_text_full_name);
        EditText ageEditText = view.findViewById(R.id.edit_text_age);
        EditText longTextEditText = view.findViewById(R.id.edit_text_long_text);
        Spinner colorSpinner = view.findViewById(R.id.color_spinner);


        Button addButton = view.findViewById(R.id.button_add);
        Button cancelButton = view.findViewById(R.id.button_cancel);

        addButton.setOnClickListener(v -> {
            String name = fullNameEditText.getText().toString();
            Integer age = Integer.parseInt(ageEditText.getText().toString());
            String text = longTextEditText.getText().toString();
            String color = colorSpinner.getSelectedItem().toString();

            BirthdayCard bdcard = new BirthdayCard(name, age, text, color);

            Log.d("AddCardDialog.java", "not null");
            mListener.onBirthdayCardAdded(bdcard);
            dismiss();
        });

        cancelButton.setOnClickListener(v -> {
            // Cancel button clicked, handle the event here
            dismiss(); // Close the dialog
        });
    }
}