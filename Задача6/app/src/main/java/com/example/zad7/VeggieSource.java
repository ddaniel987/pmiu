package com.example.zad7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VeggieSource {
    public static List<Veggie> generateItemsList(int count) {
        ArrayList<Veggie> items = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= count; i++) {
            double randomPrice = 1.0 + random.nextDouble() * 99.0;
            double randomWeight = 1.0 + random.nextDouble() * 99.0;
            double randomQuantity = 0.01 + random.nextDouble() * 9.99;

            items.add(new Veggie("Veggie " + i, randomPrice, randomWeight, randomQuantity));
        }

        return items;
    }
}
