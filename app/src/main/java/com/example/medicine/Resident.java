package com.example.medicine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Resident extends AppCompatActivity {
    Button back, newDay, prev, next;
    TextView spName, spSymp, spType;
    String  name, symp, type = " ", sCount;
    FirebaseAuth mAuth;
    int dayNumber = 1;
    int count = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resident);

        back = findViewById(R.id.resToBack);
        newDay = findViewById(R.id.toNewDay);
        prev = findViewById(R.id.previousPage);
        next = findViewById(R.id.nextPage);
        spName = findViewById(R.id.spName);
        spSymp = findViewById(R.id.spSymp);
        spType = findViewById(R.id.spType);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resident.this, Wards.class);
                startActivity(intent);
            }
        });
        newDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth = FirebaseAuth.getInstance();
                FirebaseUser cUser = mAuth.getCurrentUser();
                String id = cUser.getUid();

                final DatabaseReference ref;
                ref = FirebaseDatabase.getInstance().getReference();
                ref.child("User").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            dayNumber = snapshot.child("day").getValue(Integer.class);
                            dayNumber = dayNumber + 1;
                            ref.child("User").child(id).child("day").setValue(dayNumber);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
                Intent intent = new Intent(Resident.this, NewDay.class);
                startActivity(intent);
            }
        });

        sCount = String.valueOf(count);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Ill").child(sCount).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name = snapshot.child("name").getValue().toString();
                symp = snapshot.child("symp").getValue().toString();
                spName.setText(name);
                spSymp.setText(symp);
                spType.setText(" ");
            }
            @Override public void onCancelled(@NonNull DatabaseError error) {}});

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                if (count < 16) showIll();
                if (count > 15) showMed();
                if (count < 34) prev.setVisibility(View.VISIBLE);
                if (count == 34) next.setVisibility(View.INVISIBLE);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                if (count < 16) showIll();
                if (count > 15) showMed();
                if (count == 1) prev.setVisibility(View.INVISIBLE);
                if (count > 1) next.setVisibility(View.VISIBLE);
            }
        });
    }

    public void showIll(){
            sCount = String.valueOf(count);
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
            ref.child("Ill").child(sCount).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    name = snapshot.child("name").getValue().toString();
                    symp = snapshot.child("symp").getValue().toString();
                    spName.setText(name);
                    spSymp.setText(symp);
                    spType.setText(" ");
                }
                @Override public void onCancelled(@NonNull DatabaseError error) {}});
        }

    public void showMed(){
        sCount = String.valueOf(count-15);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Medicines").child(sCount).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name = snapshot.child("name").getValue().toString();
                symp = snapshot.child("symp").getValue().toString();
                type = snapshot.child("type").getValue().toString();
                spName.setText(name);
                spSymp.setText(symp);
                spType.setText(type);
            }
            @Override public void onCancelled(@NonNull DatabaseError error) {}});
    }
    @Override
    public void onBackPressed() {
    }
}
