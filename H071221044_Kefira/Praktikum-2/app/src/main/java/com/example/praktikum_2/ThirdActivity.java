package com.example.praktikum_2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {
    private TextView tvNama, tvUsername, tvTitle, tvContent;
    private ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Inisialisasi TextViews dan ImageView
        tvNama = findViewById(R.id.tvNama);
        tvUsername = findViewById(R.id.tvUsername);
        tvTitle = findViewById(R.id.tvTitle);
        tvContent = findViewById(R.id.tvContent);
        ivImage = findViewById(R.id.imageViewProfile);

        // Mendapatkan data yang dikirimkan dari SecondActivity
        Intent intent = getIntent();
        String nama = intent.getStringExtra("EXTRA_NAMA");
        String username = intent.getStringExtra("EXTRA_USERNAME");
        String title = intent.getStringExtra("EXTRA_TITLE");
        String content = intent.getStringExtra("EXTRA_CONTENT");
        Uri imageUri = intent.getParcelableExtra("EXTRA_IMAGE_URI");

        // Menampilkan data di dalam CardView
        tvNama.setText(nama);
        tvUsername.setText(username);
        tvTitle.setText(title);
        tvContent.setText(content);
        ivImage.setImageURI(imageUri);

    }
}