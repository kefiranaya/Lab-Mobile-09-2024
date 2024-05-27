package com.example.praktikum_5;

import android.net.Uri;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Model> models = generateDummyModel();
    public static Model user = new Model("Kefira", "kefiranaya", R.drawable.p1);

    public static ArrayList<Model> generateDummyModel() {
        ArrayList<Model> models = new ArrayList<>();
        models.add(new Model("Paw Patrol", "pawpatrol", R.drawable.p1,Uri.parse("android.resource://com.example.praktikum_5/drawable/" + "p1"), "post 1"));
        models.add(new Model("Pororo", "pororowww", R.drawable.p2,Uri.parse("android.resource://com.example.praktikum_5/drawable/" + "p2"), "post 2"));
        models.add(new Model("The Larva", "2Larva", R.drawable.p3,Uri.parse("android.resource://com.example.praktikum_5/drawable/" + "p3"), "post 3 "));
        models.add(new Model("The Simpsons", "simpsonsfamily", R.drawable.p4,Uri.parse("android.resource://com.example.praktikum_5/drawable/" + "p4"), "post 4"));
        models.add(new Model("Squidward", "asquid", R.drawable.p5,Uri.parse("android.resource://com.example.praktikum_5/drawable/" + "p5"), "post 5"));
        models.add(new Model("Paw Patrol2", "pawpatrol2", R.drawable.p6,Uri.parse("android.resource://com.example.praktikum_5/drawable/" + "p6"), "post 6"));
        return models;
    }
}
