package com.example.pmiu_kartichki;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BirthdayCardFragment extends Fragment {
    private static final String ARG_BIRTHDAY_CARD = "birthday_card";

    private BirthdayCard mBirthdayCard;

    public BirthdayCard getBirthdayCard() {
        return this.mBirthdayCard;
    }

    public static BirthdayCardFragment newInstance(BirthdayCard birthdayCard) {
        BirthdayCardFragment fragment = new BirthdayCardFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_BIRTHDAY_CARD, birthdayCard);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_birthday_card, container, false);
        BirthdayCard bcard = getBirthdayCard();
        TextView content = rootView.findViewById(R.id.content);
        content.setText("Име: " + bcard.getName() + ", Възраст: " + bcard.getAge() + ", Текст: " + bcard.getText() + ", Цвят: " + bcard.getColor());
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mBirthdayCard = getArguments().getParcelable(ARG_BIRTHDAY_CARD, BirthdayCard.class);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        View view = getView();
        if(view != null) {
            Log.d("a", "notunlkl");
            FrameLayout.LayoutParams layourParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

            view.setLayoutParams(layourParams);
        }
    }



    // ...
}