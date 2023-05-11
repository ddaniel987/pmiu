package com.example.pmiu_kartichki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.pmiu_kartichki.BirthdayCardInterface;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BirthdayCardInterface {

    List<BirthdayCardFragment> addedCards = new ArrayList<BirthdayCardFragment>();

    @Override
    public void onBirthdayCardAdded(BirthdayCard birthdayCard) {
        BirthdayCardFragment bcf = BirthdayCardFragment.newInstance(birthdayCard);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, bcf).commit();
        addedCards.add(bcf);
        Snackbar.make(findViewById(R.id.layoutmain), "Картичката беше добавена успешно.", Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = findViewById(R.id.button2);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddCardDialog dialog = new AddCardDialog();
                dialog.show(getSupportFragmentManager(), "add_card_dialog");
            }
        });

        Button btnRemove = findViewById(R.id.button);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().remove(addedCards.get(addedCards.size() - 1)).commit();
                Snackbar.make(findViewById(R.id.layoutmain), "Картичката беше премахната.", Snackbar.LENGTH_LONG).show();
            }
        });
    }
}