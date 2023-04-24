package com.example.pmiuprojects;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.pmiuprojects.databinding.FragmentFirstBinding;
import com.google.android.material.snackbar.Snackbar;

import android.util.Patterns;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    private boolean validateFields() {
        String name = binding.editTextTextPersonName.getText().toString();
        String email = binding.editTextTextEmailAddress.getText().toString();
        String phone = binding.editTextPhone.getText().toString();
        String date = binding.editTextDate.getText().toString();
        String height = binding.editTextNumberDecimal.getText().toString();

        boolean isvalid = true;

        if(TextUtils.isEmpty(name) || name.split(" ").length != 2 || name.length() < 5) {
            binding.editTextTextPersonName.setError("Моля, въведи пълното си име.");
            isvalid = false;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.editTextTextEmailAddress.setError("Моля, въведи валиден имейл адрес");
            isvalid = false;
        }

        if(phone.length() == 0) {
            binding.editTextPhone.setError("Моля, въведи твоя номер");
            isvalid = false;
        }

        if(date.length() == 0) {
            binding.editTextDate.setError("Моля, въведи твоята дата на раждане");
            isvalid = false;
        }

        if(height.length() == 0) {
            binding.editTextNumberDecimal.setError("Моля, въведи твоята височина");
            isvalid = false;
        }

        return isvalid;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean valid = validateFields();
                if(valid) {
                    Snackbar.make(view, getString(R.string.success), Snackbar.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(view, getString(R.string.error), Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}