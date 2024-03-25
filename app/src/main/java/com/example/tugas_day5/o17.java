package com.example.tugas_day5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class o17 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o17);
    }

    public void bagikanKeEmail(View view) {

        StringBuilder deskripsiTransaksi = new StringBuilder();
        deskripsiTransaksi.append("Nama Barang: Oppo A17\n")
                .append(" melakukan transaksi sebesar: Rp.  7.352.937\n")
                .append("Pada AppMob Store");


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Deskripsi Transaksi");
        intent.putExtra(Intent.EXTRA_TEXT, deskripsiTransaksi.toString());

        try {
            startActivity(Intent.createChooser(intent, "Pilih aplikasi email"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "Tidak ada aplikasi email terpasang.", Toast.LENGTH_SHORT).show();
        }
    }
}
