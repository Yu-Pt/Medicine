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

public class Maz extends AppCompatActivity {

    Button b1, b2, b3, b4, b5, back;
    TextView t1,t2, t3, t4, t5, outoff;
    FirebaseAuth mAuth;
    String bool;
    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maz);
        t1 = findViewById(R.id.maz1);
        t2 = findViewById(R.id.maz2);
        t3 = findViewById(R.id.maz3);
        t4 = findViewById(R.id.maz4);
        t5 = findViewById(R.id.maz5);
        outoff = findViewById(R.id.end_of_maz);
        b1 = findViewById(R.id.button_maz1);
        b2 = findViewById(R.id.button_maz2);
        b3 = findViewById(R.id.button_maz3);
        b4 = findViewById(R.id.button_maz4);
        b5 = findViewById(R.id.button_maz5);
        back = findViewById(R.id.back_maz);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser cUser = mAuth.getCurrentUser();
        String id = cUser.getUid();

        final DatabaseReference ref;
        ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Inventory").child(id).child("maz").addListenerForSingleValueEvent(new ValueEventListener() {
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
                Intent intent = new Intent(Maz.this, Sklad.class);
                startActivity(intent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = x + 1;
                ref.child("Inventory").child(id).child("havenow").child("11").setValue(t1.getText().toString());
                ref.child("Inventory").child(id).child("maz").child("bool1").setValue("true");
                b1.setVisibility(View.INVISIBLE);
                if (x == 5) outoff.setVisibility(View.VISIBLE);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = x + 1;
                ref.child("Inventory").child(id).child("havenow").child("12").setValue(t2.getText().toString());
                ref.child("Inventory").child(id).child("maz").child("bool2").setValue("true");
                b2.setVisibility(View.INVISIBLE);
                if (x == 5) outoff.setVisibility(View.VISIBLE);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = x + 1;
                ref.child("Inventory").child(id).child("havenow").child("13").setValue(t3.getText().toString());
                ref.child("Inventory").child(id).child("maz").child("bool3").setValue("true");
                b3.setVisibility(View.INVISIBLE);
                if (x == 5)  outoff.setVisibility(View.VISIBLE);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = x + 1;
                ref.child("Inventory").child(id).child("havenow").child("14").setValue(t4.getText().toString());
                ref.child("Inventory").child(id).child("maz").child("bool4").setValue("true");
                b4.setVisibility(View.INVISIBLE);
                if (x == 5) outoff.setVisibility(View.VISIBLE);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = x + 1;
                ref.child("Inventory").child(id).child("havenow").child("15").setValue(t5.getText().toString());
                ref.child("Inventory").child(id).child("maz").child("bool5").setValue("true");
                b5.setVisibility(View.INVISIBLE);
                if (x == 5) outoff.setVisibility(View.VISIBLE);
            }
        });
    }
    @Override
    public void onBackPressed() {
    }
}