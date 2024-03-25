package com.example.tugas_day5;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText kodeBarangEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kodeBarangEditText = findViewById(R.id.input_kode_barang);
    }

    public void onProcessButtonClick(View view) {

        String kodeBarang = kodeBarangEditText.getText().toString().trim();


        Intent intent = null;
        if (kodeBarang.equalsIgnoreCase("sgs")) {
            intent = new Intent(MainActivity.this, sgs.class);
        } else if (kodeBarang.equalsIgnoreCase("pco")) {
            intent = new Intent(MainActivity.this, pco.class);
        } else if (kodeBarang.equalsIgnoreCase("o17")) {
            intent = new Intent(MainActivity.this, o17.class);
        }

        if (intent != null) {
            intent.putExtra("KODE_BARANG", kodeBarang);
            startActivity(intent);
        } else {

        }
    }





    public void changeLanguage(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        Resources resources = getResources();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        recreate();
    }

    public void changeToIndonesian(View view) {
        changeLanguage("in");
    }

    public void changeToEnglish(View view) {
        changeLanguage("en");
    }

    public void changeToMalay(View view) {
        changeLanguage("ms");
    }

    public void changeToChinese(View view) {
        changeLanguage("zh");
    }
}


