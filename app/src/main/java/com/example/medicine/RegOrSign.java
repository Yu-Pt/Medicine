package com.example.medicine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegOrSign extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button bSignIn, bReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_or_sign);
        mAuth = FirebaseAuth.getInstance();
        bSignIn = findViewById(R.id.toSign);
        bReg = findViewById(R.id.toReg);

        FirebaseUser cUser = mAuth.getCurrentUser();
        if (cUser != null) {
            Intent intent = new Intent(RegOrSign.this, Menu.class);
            startActivity(intent);
        }

        bReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegOrSign.this, Registration.class);
                startActivity(intent);
            }
        });
        bSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegOrSign.this, SignIn.class);
                startActivity(intent);
            }
        });
    }
}