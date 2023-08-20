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

public class Rast extends AppCompatActivity {

    Button b1, b2, b3, b4, b5, back;
    TextView t1,t2, t3, t4, t5, outoff;
    FirebaseAuth mAuth;
    String bool;
    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rast);
        t1 = findViewById(R.id.rast1);
        t2 = findViewById(R.id.rast2);
        t3 = findViewById(R.id.rast3);
        t4 = findViewById(R.id.rast4);
        t5 = findViewById(R.id.rast5);
        outoff = findViewById(R.id.end_of_rast);
        b1 = findViewById(R.id.button_rast1);
        b2 = findViewById(R.id.button_rast2);
        b3 = findViewById(R.id.button_rast3);
        b4 = findViewById(R.id.button_rast4);
        b5 = findViewById(R.id.button_rast5);
        back = findViewById(R.id.back_rast);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser cUser = mAuth.getCurrentUser();
        String id = cUser.getUid();

        final DatabaseReference ref;
        ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Inventory").child(id).child("rast").addListenerForSingleValueEvent(new ValueEventListener() {
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
                Intent intent = new Intent(Rast.this, Sklad.class);
                startActivity(intent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = x + 1;
                ref.child("Inventory").child(id).child("havenow").child("6").setValue(t1.getText().toString());
                ref.child("Inventory").child(id).child("rast").child("bool1").setValue("true");
                b1.setVisibility(View.INVISIBLE);
                if (x == 5) outoff.setVisibility(View.VISIBLE);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = x + 1;
                ref.child("Inventory").child(id).child("havenow").child("7").setValue(t2.getText().toString());
                ref.child("Inventory").child(id).child("rast").child("bool2").setValue("true");
                b2.setVisibility(View.INVISIBLE);
                if (x == 5) outoff.setVisibility(View.VISIBLE);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = x + 1;
                ref.child("Inventory").child(id).child("havenow").child("8").setValue(t3.getText().toString());
                ref.child("Inventory").child(id).child("rast").child("bool3").setValue("true");
                b3.setVisibility(View.INVISIBLE);
                if (x == 5)  outoff.setVisibility(View.VISIBLE);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = x + 1;
                ref.child("Inventory").child(id).child("havenow").child("9").setValue(t4.getText().toString());
                ref.child("Inventory").child(id).child("rast").child("bool4").setValue("true");
                b4.setVisibility(View.INVISIBLE);
                if (x == 5) outoff.setVisibility(View.VISIBLE);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = x + 1;
                ref.child("Inventory").child(id).child("havenow").child("10").setValue(t5.getText().toString());
                ref.child("Inventory").child(id).child("rast").child("bool5").setValue("true");
                b5.setVisibility(View.INVISIBLE);
                if (x == 5) outoff.setVisibility(View.VISIBLE);
            }
        });
    }
    @Override
    public void onBackPressed() {
    }
}