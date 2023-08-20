package com.example.medicine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sklad extends AppCompatActivity {
    Button tabl, rast, maz, aero, backSklad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sklad);

        tabl = findViewById(R.id.skladTabl);
        rast = findViewById(R.id.skladRast);
        maz = findViewById(R.id.skladMaz);
        aero = findViewById(R.id.skladAero);
        backSklad = findViewById(R.id.skladToBack);

        backSklad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sklad.this, MainActivity.class);
                startActivity(intent);
            }
        });
        tabl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sklad.this, Tabl.class);
                startActivity(intent);
            }
        });
        rast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sklad.this, Rast.class);
                startActivity(intent);
            }
        });
        maz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sklad.this, Maz.class);
                startActivity(intent);
            }
        });
        aero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sklad.this, Aero.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
    }
}