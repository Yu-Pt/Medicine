package com.example.medicine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WardVIP extends AppCompatActivity {
    Button bed, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ward_vip);

        bed = findViewById(R.id.wardVbed);
        back = findViewById(R.id.wardVback);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WardVIP.this, Wards.class);
                startActivity(intent);
            }
        });
        bed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WardVIP.this, BedVip.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
    }
}