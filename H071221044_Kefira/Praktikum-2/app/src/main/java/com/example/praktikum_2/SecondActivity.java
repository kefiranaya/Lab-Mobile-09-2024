package com.example.praktikum_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.net.Uri;


public class SecondActivity extends AppCompatActivity {
    private Button buttonsv;
    private EditText etTitle, etContent;
    private Uri imageUri;
    private String nama, username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        buttonsv = findViewById(R.id.buttonsv);
        etTitle = findViewById(R.id.title);
        etContent = findViewById(R.id.content);

        //Mendapatkan data yang dikirimkan dari MainActivity
        Intent intent = getIntent();
        imageUri = intent.getParcelableExtra("EXTRA_IMAGE_URI");
        nama = intent.getStringExtra("EXTRA_NAMA");
        username = intent.getStringExtra("EXTRA_USERNAME");

        buttonsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndContinue();
            }
        });
    }

    private void validateAndContinue() {
        String title = etTitle.getText().toString().trim();
        String content = etContent.getText().toString().trim();

        if (title.isEmpty()) {
            etTitle.setError("Field ini tidak boleh kosong");
            return;
        }


        if (content.isEmpty()) {
            etContent.setError("Field ini tidak boleh kosong");
            return;
        }

        //kirim data ke activity selanjutnya
        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
        intent.putExtra("EXTRA_NAMA", nama);
        intent.putExtra("EXTRA_USERNAME", username);
        intent.putExtra("EXTRA_TITLE", title);
        intent.putExtra("EXTRA_CONTENT", content);
        intent.putExtra("EXTRA_IMAGE_URI", imageUri);
        startActivity(intent);

    }
}