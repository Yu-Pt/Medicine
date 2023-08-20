package com.example.medicine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Wards extends AppCompatActivity {
    Button ward1, ward2, wardVIP, ambulance, resident, backWards;
    int dayNumber = 1, x = 1;
    FirebaseAuth mAuth;
    String bool2 = "false";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wards);

        ward1 = findViewById(R.id.wardsToW1);
        ward2 = findViewById(R.id.wardsToW2);
        wardVIP = findViewById(R.id.wardsToVip);
        ambulance = findViewById(R.id.wardsToAmb);
        resident = findViewById(R.id.wardsToRes);
        backWards = findViewById(R.id.wardsToHall);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser cUser = mAuth.getCurrentUser();

        String idUser = cUser.getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dayNumber = snapshot.child("User").child(idUser).child("day").getValue(Integer.class);
                if (snapshot.child("Wards").child(idUser).child("wardvip").child("name").getValue().toString().equals("empty")) x = 0;
                if (snapshot.child("Wards").child(idUser).child("ward1bed1").child("name").getValue().toString().equals("empty")) x = 0;
                if (snapshot.child("Wards").child(idUser).child("ward1bed2").child("name").getValue().toString().equals("empty")) x = 0;
                if (snapshot.child("Wards").child(idUser).child("ward1bed3").child("name").getValue().toString().equals("empty")) x = 0;
                if (snapshot.child("Wards").child(idUser).child("ward2bed1").child("name").getValue().toString().equals("empty")) x = 0;
                if (snapshot.child("Wards").child(idUser).child("ward2bed2").child("name").getValue().toString().equals("empty")) x = 0;
                if (snapshot.child("Wards").child(idUser).child("ward2bed3").child("name").getValue().toString().equals("empty")) x = 0;
                bool2 = snapshot.child("User").child(idUser).child("wards").child("bool2").getValue().toString();
              //  if (dayNumber > 1 && x == 0 && bool2.equals("false")) ambulance.setBackgroundColor(R.drawable.newday);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        ward1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wards.this, Ward1.class);
                startActivity(intent);
            }
        });
        ward2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wards.this, Ward2.class);
                startActivity(intent);
            }
        });
        wardVIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wards.this, WardVIP.class);
                startActivity(intent);
            }
        });
        ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wards.this, Ambulance.class);
                startActivity(intent);
            }
        });
        resident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wards.this, Resident.class);
                startActivity(intent);
            }
        });
        backWards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wards.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}