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

public class Aero extends AppCompatActivity {

    Button b1, b2, b3, b4, b5, back;
    TextView t1,t2, t3, t4, t5, outoff;
    FirebaseAuth mAuth;
    String bool;
    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aero);
        t1 = findViewById(R.id.aero1);
        t2 = findViewById(R.id.aero2);
        t3 = findViewById(R.id.aero3);
        t4 = findViewById(R.id.aero4);
        t5 = findViewById(R.id.aero5);
        outoff = findViewById(R.id.end_of_aero);
        b1 = findViewById(R.id.button_aero1);
        b2 = findViewById(R.id.button_aero2);
        b3 = findViewById(R.id.button_aero3);
        b4 = findViewById(R.id.button_aero4);
        b5 = findViewById(R.id.button_aero5);
        back = findViewById(R.id.back_aero);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser cUser = mAuth.getCurrentUser();
        String id = cUser.getUid();

        final DatabaseReference ref;
        ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Inventory").child(id).child("aero").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    t1.setText(snapshot.child("1").getValue().toString());
                    t2.setText(snapshot.child("2").getValue().toString());
                    t3.setText(snapshot.child("3").getValue().toString());
                    t4.setText(snapshot.child("4").getValue().toString());
                    t5.setText(snapshot.child("5").getValue().toString());

                    bool = snapshot.child("bool1").getValue().toString();
                    if (bool.equals("true")) {
                        b1.setVisibility(View.INVISIBLE);
                        x++;
                    }
                    bool = snapshot.child("bool2").getValue().toString();
                    if (bool.equals("true")) {
                        b2.setVisibility(View.INVISIBLE);
                        x++;
                    }
                    bool = snapshot.child("bool3").getValue().toString();
                    if (bool.equals("true")) {
                        b3.setVisibility(View.INVISIBLE);
                        x++;
                    }
                    bool = snapshot.child("bool4").getValue().toString();
                    if (bool.equals("true")) {
                        b4.setVisibility(View.INVISIBLE);
                        x++;
                    }
                    bool = snapshot.child("bool5").getValue().toString();
                    if (bool.equals("true")) {
                        b5.setVisibility(View.INVISIBLE);
                        x++;
                    }

                    if (x==5) outoff.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Aero.this, Sklad.class);
                startActivity(intent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = x + 1;
                ref.child("Inventory").child(id).child("havenow").child("16").setValue(t1.getText().toString());
                ref.child("Inventory").child(id).child("aero").child("bool1").setValue("true");
                b1.setVisibility(View.INVISIBLE);
                if (x == 5) outoff.setVisibility(View.VISIBLE);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = x + 1;
                ref.child("Inventory").child(id).child("havenow").child("17").setValue(t2.getText().toString());
                ref.child("Inventory").child(id).child("aero").child("bool2").setValue("true");
                b2.setVisibility(View.INVISIBLE);
                if (x == 5) outoff.setVisibility(View.VISIBLE);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = x + 1;
                ref.child("Inventory").child(id).child("havenow").child("18").setValue(t3.getText().toString());
                ref.child("Inventory").child(id).child("aero").child("bool3").setValue("true");
                b3.setVisibility(View.INVISIBLE);
                if (x == 5)  outoff.setVisibility(View.VISIBLE);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = x + 1;
                ref.child("Inventory").child(id).child("havenow").child("19").setValue(t4.getText().toString());
                ref.child("Inventory").child(id).child("aero").child("bool4").setValue("true");
                b4.setVisibility(View.INVISIBLE);
                if (x == 5) outoff.setVisibility(View.VISIBLE);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = x + 1;
                ref.child("Inventory").child(id).child("havenow").child("20").setValue(t5.getText().toString());
                ref.child("Inventory").child(id).child("aero").child("bool5").setValue("true");
                b5.setVisibility(View.INVISIBLE);
                if (x == 5) outoff.setVisibility(View.VISIBLE);
            }
        });
    }
    @Override
    public void onBackPressed() {
    }
}