package com.example.medicine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ward2 extends AppCompatActivity {
    Button bed1, bed2, bed3, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ward2);

        bed1 = findViewById(R.id.ward2bed1);
        bed2 = findViewById(R.id.ward2bed2);
        bed3 = findViewById(R.id.ward2bed3);
        back = findViewById(R.id.ward2back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ward2.this, Wards.class);
                startActivity(intent);
            }
        });
        bed1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ward2.this, Ward2Bed1.class);
                startActivity(intent);
            }
        });
        bed2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ward2.this, Ward2Bed2.class);
                startActivity(intent);
            }
        });
        bed3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ward2.this, Ward2Bed3.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
    }
}