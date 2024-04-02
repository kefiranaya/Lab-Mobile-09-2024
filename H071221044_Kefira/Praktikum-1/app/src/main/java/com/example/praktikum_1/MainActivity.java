package com.example.praktikum_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText masukkanhalLainnya;
    Button button;

    ListView simpleList;
    ArrayList<String> dataList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        masukkanhalLainnya=findViewById(R.id.masukkanhallainnya);
        button=findViewById(R.id.button);
        simpleList=findViewById(R.id.hasilinputan);

        dataList=new ArrayList<>();
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);

        simpleList.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputan= masukkanhalLainnya.getText().toString().trim();
                if (!inputan.isEmpty()) {
                    dataList.add(inputan);
                    simpleList.setAdapter(adapter);
                    masukkanhalLainnya.getText().clear();
                }
            }
        });
    }
}