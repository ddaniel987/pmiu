package com.example.pmiu4_;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import java.util.regex.Pattern;

public class LengthValidator implements TextWatcher {
    private final int minLength;
    private final int maxLength;
    private final EditText editText;

    public LengthValidator(int minLength, int maxLength, EditText editText) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.editText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public final void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String text = s.toString();
        //ако е -1, не проверяваме за свойството
        editText.setError(null);

        if(this.minLength != -1)
            if(text.length() < this.minLength)
                editText.setError("Минимална дължина: " + this.minLength);

        if(this.maxLength != -1)
            if(text.length() > this.maxLength)
                editText.setError("Максимална дължина: " + this.maxLength);

        customValidation(s); //къстъм валидиране
    }

    public void customValidation(Editable s) {
        //незадължителен, използва се за допълнителна валидация (имейл, телефон тн)
    }
}