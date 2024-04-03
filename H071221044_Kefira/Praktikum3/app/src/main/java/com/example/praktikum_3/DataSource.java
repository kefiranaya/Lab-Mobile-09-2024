package com.example.praktikum_3;

import java.util.ArrayList;import java.util.ArrayList;

//menyediakan sumber data dalam bentuk daftar model yang digunakan dalam aplikasi.
//Method generateDummyModel() digunakan untuk menghasilkan daftar model-model "dummy" yang kemudian disimpan dalam ArrayList models.
public class DataSource {
    public static ArrayList<Model> models = generateDummyModel();

    private static ArrayList<Model> generateDummyModel(){
        ArrayList<Model> models = new ArrayList<>();
        models.add(new Model(R.drawable.p1,R.drawable.f1, "bali", "2024",R.drawable.s1, "300", "10"));
        models.add(new Model(R.drawable.p2,R.drawable.f2, "sg", "2017",R.drawable.s2, "543", "200"));
        models.add(new Model(R.drawable.p3,R.drawable.f3, "jogja", "2023",R.drawable.s3, "5213", "12"));
        models.add(new Model(R.drawable.p4,R.drawable.f4, "atlanta", "2009",R.drawable.s4, "900", "0"));
        models.add(new Model(R.drawable.p5,R.drawable.f5, "solo", "2023",R.drawable.s5, "1000", "0"));
        models.add(new Model(R.drawable.p6,R.drawable.f6, "austria", "2009",R.drawable.s6, "300", "10"));
        models.add(new Model(R.drawable.p7,R.drawable.f7, "jkt", "2010",R.drawable.s7, "90", "2341"));
        models.add(new Model(R.drawable.p8,R.drawable.f8, "london", "2012",R.drawable.s8, "800", "800"));
        models.add(new Model(R.drawable.p9,R.drawable.f9, "sby", "2024",R.drawable.s9, "7625", "983"));
        models.add(new Model(R.drawable.p10,R.drawable.f10, "semarang", "2023",R.drawable.s10, "0", "901"));

        return models;
    }
}
