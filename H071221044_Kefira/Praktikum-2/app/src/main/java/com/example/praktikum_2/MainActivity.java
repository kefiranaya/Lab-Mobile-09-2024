package com.example.praktikum_2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ImageView imageView;
    private EditText etNama, etUsername;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        imageView = findViewById(R.id.iv);
        etNama = findViewById(R.id.nama);
        etUsername = findViewById(R.id.username);

        //memulai activity untuk mendapatkan hasil, yaitu memilih sebuah gambar dari galeri
        ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    // memeriksa apakah pengguna sdh memilih sebuah gambar
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        //Mengambil data intent yang dikembalikan oleh aktivitas yang selesai.
                        Intent data = result.getData();
                        //Mendapatkan URI dari gambar yang dipilih pengguna dari data intent.
                        imageUri = data.getData();
                        // Menampilkan gambar yang dipilih
                        imageView.setImageURI(imageUri);
                    }
                }
        );

        //kode ini berfungsi sebagai tombol untuk
        // membuka galeri dan memilih gambar. Setelah gambar dipilih,
        // proses selanjutnya akan ditangani oleh ActivityResultLauncher

        imageView.setOnClickListener(view -> {
            Intent openGallery = new Intent(Intent.ACTION_PICK);
            openGallery.setType("image/*");
            launcherIntentGallery.launch(openGallery);
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        // Memeriksa apakah gambar profil telah dipilih
        if (imageUri == null) {
            // Menampilkan pesan dengan Toast
            Toast.makeText(this, "Please pick a profile image first!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Memeriksa apakah Nama kosong
        String nama = etNama.getText().toString().trim();
        if (nama.isEmpty()) {
            // Menampilkan pesan peringatan untuk Nama
            etNama.setError("Field ini tidak boleh kosong");
            return;
        }

        // Memeriksa apakah Username kosong
        String username = etUsername.getText().toString().trim();
        if (username.isEmpty()) {
            // Menampilkan pesan peringatan untuk Username
            etUsername.setError("Field ini tidak boleh kosong");
            return;
        }

        // Jika semua validasi berhasil, lanjutkan ke SecondActivity
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("EXTRA_NAMA", nama);
        intent.putExtra("EXTRA_USERNAME", username);
        //imageUri adalah variabel yang menyimpan URI dari sebuah gambar yang ingin dikirimkan.
        intent.putExtra("EXTRA_IMAGE_URI", imageUri);
        startActivity(intent);
    }
}