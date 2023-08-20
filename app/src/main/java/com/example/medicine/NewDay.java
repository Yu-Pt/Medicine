package com.example.medicine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class NewDay extends AppCompatActivity {
    LinearLayout newDayLayout;
    FirebaseAuth mAuth;
    String p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;
    String p11, p12, p13, p14, p15, p16, p17, p18, p19, p20;
    int r1, r2, r3, r4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_day);

        Random r = new Random();

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser cUser = mAuth.getCurrentUser();
        String id = cUser.getUid();

        final DatabaseReference ref;
        ref = FirebaseDatabase.getInstance().getReference();

        r1 = r.nextInt(5 - 1 + 1) + 1;
        p1 = String.valueOf(r1);
        ref.child("Medicines").child(p1).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    p1 = snapshot.child("name").getValue().toString();
                    ref.child("Inventory").child(id).child("tabl").child("1").setValue(p1);
                    ref.child("Inventory").child(id).child("tabl").child("bool1").setValue("false");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        r1 = r.nextInt(5 - 1 + 1) + 1;
        p2 = String.valueOf(r1);
        ref.child("Medicines").child(p2).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    p2 = snapshot.child("name").getValue().toString();
                    ref.child("Inventory").child(id).child("tabl").child("2").setValue(p2);
                    ref.child("Inventory").child(id).child("tabl").child("bool2").setValue("false");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        r1 = r.nextInt(5 - 1 + 1) + 1;
        p3 = String.valueOf(r1);
        ref.child("Medicines").child(p3).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    p3 = snapshot.child("name").getValue().toString();
                    ref.child("Inventory").child(id).child("tabl").child("3").setValue(p3);
                    ref.child("Inventory").child(id).child("tabl").child("bool3").setValue("false");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        r1 = r.nextInt(5 - 1 + 1) + 1;
        p4 = String.valueOf(r1);
        ref.child("Medicines").child(p4).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    p4 = snapshot.child("name").getValue().toString();
                    ref.child("Inventory").child(id).child("tabl").child("4").setValue(p4);
                    ref.child("Inventory").child(id).child("tabl").child("bool4").setValue("false");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        r1 = r.nextInt(5 - 1 + 1) + 1;
        p5 = String.valueOf(r1);
        ref.child("Medicines").child(p5).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    p5 = snapshot.child("name").getValue().toString();
                    ref.child("Inventory").child(id).child("tabl").child("5").setValue(p5);
                    ref.child("Inventory").child(id).child("tabl").child("bool5").setValue("false");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});

        r2 = r.nextInt(10 - 6 + 1) + 6;
        p6 = String.valueOf(r2);
        ref.child("Medicines").child(p6).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    p6 = snapshot.child("name").getValue().toString();
                    ref.child("Inventory").child(id).child("rast").child("1").setValue(p6);
                    ref.child("Inventory").child(id).child("rast").child("bool1").setValue("false");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        r2 = r.nextInt(10 - 6 + 1) + 6;
        p7 = String.valueOf(r2);
        ref.child("Medicines").child(p7).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    p7 = snapshot.child("name").getValue().toString();
                    ref.child("Inventory").child(id).child("rast").child("2").setValue(p7);
                    ref.child("Inventory").child(id).child("rast").child("bool2").setValue("false");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        r2 = r.nextInt(10 - 6 + 1) + 6;
        p8 = String.valueOf(r2);
        ref.child("Medicines").child(p8).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    p8 = snapshot.child("name").getValue().toString();
                    ref.child("Inventory").child(id).child("rast").child("3").setValue(p8);
                    ref.child("Inventory").child(id).child("rast").child("bool3").setValue("false");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        r2 = r.nextInt(10 - 6 + 1) + 6;
        p9 = String.valueOf(r2);
        ref.child("Medicines").child(p9).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    p9 = snapshot.child("name").getValue().toString();
                    ref.child("Inventory").child(id).child("rast").child("4").setValue(p9);
                    ref.child("Inventory").child(id).child("rast").child("bool4").setValue("false");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        r2 = r.nextInt(10 - 6 + 1) + 6;
        p10 = String.valueOf(r2);
        ref.child("Medicines").child(p10).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    p10 = snapshot.child("name").getValue().toString();
                    ref.child("Inventory").child(id).child("rast").child("5").setValue(p10);
                    ref.child("Inventory").child(id).child("rast").child("bool5").setValue("false");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        r3 = r.nextInt(15 - 11 + 1) + 11;
        p11 = String.valueOf(r3);
        ref.child("Medicines").child(p11).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    p11 = snapshot.child("name").getValue().toString();
                    ref.child("Inventory").child(id).child("maz").child("1").setValue(p11);
                    ref.child("Inventory").child(id).child("maz").child("bool1").setValue("false");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        r3 = r.nextInt(15 - 11 + 1) + 11;
        p12 = String.valueOf(r3);
        ref.child("Medicines").child(p12).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    p12 = snapshot.child("name").getValue().toString();
                    ref.child("Inventory").child(id).child("maz").child("2").setValue(p12);
                    ref.child("Inventory").child(id).child("maz").child("bool2").setValue("false");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        r3 = r.nextInt(15 - 11 + 1) + 11;
        p13 = String.valueOf(r3);
        ref.child("Medicines").child(p13).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    p13 = snapshot.child("name").getValue().toString();
                    ref.child("Inventory").child(id).child("maz").child("3").setValue(p13);
                    ref.child("Inventory").child(id).child("maz").child("bool3").setValue("false");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        r3 = r.nextInt(15 - 11 + 1) + 11;
        p14 = String.valueOf(r3);
        ref.child("Medicines").child(p14).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    p14 = snapshot.child("name").getValue().toString();
                    ref.child("Inventory").child(id).child("maz").child("4").setValue(p14);
                    ref.child("Inventory").child(id).child("maz").child("bool4").setValue("false");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        r3 = r.nextInt(15 - 11 + 1) + 11;
        p15 = String.valueOf(r3);
        ref.child("Medicines").child(p15).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    p15 = snapshot.child("name").getValue().toString();
                    ref.child("Inventory").child(id).child("maz").child("5").setValue(p15);
                    ref.child("Inventory").child(id).child("maz").child("bool5").setValue("false");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        r4 = r.nextInt(19 - 16 + 1) + 16;
        p16 = String.valueOf(r4);
        ref.child("Medicines").child(p16).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    p16 = snapshot.child("name").getValue().toString();
                    ref.child("Inventory").child(id).child("aero").child("1").setValue(p16);
                    ref.child("Inventory").child(id).child("aero").child("bool1").setValue("false");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        r4 = r.nextInt(19 - 16 + 1) + 16;
        p17 = String.valueOf(r4);
        ref.child("Medicines").child(p17).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    p17 = snapshot.child("name").getValue().toString();
                    ref.child("Inventory").child(id).child("aero").child("2").setValue(p17);
                    ref.child("Inventory").child(id).child("aero").child("bool2").setValue("false");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        r4 = r.nextInt(19 - 16 + 1) + 16;
        p18 = String.valueOf(r4);
        ref.child("Medicines").child(p18).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    p18 = snapshot.child("name").getValue().toString();
                    ref.child("Inventory").child(id).child("aero").child("3").setValue(p18);
                    ref.child("Inventory").child(id).child("aero").child("bool3").setValue("false");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        r4 = r.nextInt(19 - 16 + 1) + 16;
        p19 = String.valueOf(r4);
        ref.child("Medicines").child(p19).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    p19 = snapshot.child("name").getValue().toString();
                    ref.child("Inventory").child(id).child("aero").child("4").setValue(p19);
                    ref.child("Inventory").child(id).child("aero").child("bool4").setValue("false");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        r4 = r.nextInt(19 - 16 + 1) + 16;
        p20 = String.valueOf(r4);
        ref.child("Medicines").child(p20).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    p20 = snapshot.child("name").getValue().toString();
                    ref.child("Inventory").child(id).child("aero").child("5").setValue(p20);
                    ref.child("Inventory").child(id).child("aero").child("bool5").setValue("false");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});

        ref.child("Wards").child(id).child("ward1bed1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    if (snapshot.child("bool").getValue().toString().equals("false") && !snapshot.child("name").getValue().toString().equals("empty")) {
                        int nHP = snapshot.child("hp").getValue(Integer.class);
                        nHP = nHP - 5;
                        ref.child("Wards").child(id).child("ward1bed1").child("hp").setValue(nHP);
                    }}
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        ref.child("Wards").child(id).child("ward1bed2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    if (snapshot.child("bool").getValue().toString().equals("false") && !snapshot.child("name").getValue().toString().equals("empty")) {
                        int nHP = snapshot.child("hp").getValue(Integer.class);
                        nHP = nHP - 5;
                        ref.child("Wards").child(id).child("ward1bed2").child("hp").setValue(nHP);
                    }}
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        ref.child("Wards").child(id).child("ward1bed3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    if (snapshot.child("bool").getValue().toString().equals("false") && !snapshot.child("name").getValue().toString().equals("empty")) {
                        int nHP = snapshot.child("hp").getValue(Integer.class);
                        nHP = nHP - 5;
                        ref.child("Wards").child(id).child("ward1bed3").child("hp").setValue(nHP);
                    }}
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        ref.child("Wards").child(id).child("ward2bed1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    if (snapshot.child("bool").getValue().toString().equals("false") && !snapshot.child("name").getValue().toString().equals("empty")) {
                        int nHP = snapshot.child("hp").getValue(Integer.class);
                        nHP = nHP - 5;
                        ref.child("Wards").child(id).child("ward2bed1").child("hp").setValue(nHP);
                    }}
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        ref.child("Wards").child(id).child("ward2bed2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    if (snapshot.child("bool").getValue().toString().equals("false") && !snapshot.child("name").getValue().toString().equals("empty")) {
                        int nHP = snapshot.child("hp").getValue(Integer.class);
                        nHP = nHP - 5;
                        ref.child("Wards").child(id).child("ward2bed2").child("hp").setValue(nHP);
                    }}
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        ref.child("Wards").child(id).child("ward2bed3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    if (snapshot.child("bool").getValue().toString().equals("false") && !snapshot.child("name").getValue().toString().equals("empty")) {
                        int nHP = snapshot.child("hp").getValue(Integer.class);
                        nHP = nHP - 5;
                        ref.child("Wards").child(id).child("ward2bed3").child("hp").setValue(nHP);
                    }}
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});//vip-палата не уменьшает здоровье, если ничего не давать

        ref.child("Inventory").child(id).child("havenow").child("1").setValue("empty");
        ref.child("Inventory").child(id).child("havenow").child("2").setValue("empty");
        ref.child("Inventory").child(id).child("havenow").child("3").setValue("empty");
        ref.child("Inventory").child(id).child("havenow").child("4").setValue("empty");
        ref.child("Inventory").child(id).child("havenow").child("5").setValue("empty");
        ref.child("Inventory").child(id).child("havenow").child("6").setValue("empty");
        ref.child("Inventory").child(id).child("havenow").child("7").setValue("empty");
        ref.child("Inventory").child(id).child("havenow").child("8").setValue("empty");
        ref.child("Inventory").child(id).child("havenow").child("9").setValue("empty");
        ref.child("Inventory").child(id).child("havenow").child("10").setValue("empty");
        ref.child("Inventory").child(id).child("havenow").child("11").setValue("empty");
        ref.child("Inventory").child(id).child("havenow").child("12").setValue("empty");
        ref.child("Inventory").child(id).child("havenow").child("13").setValue("empty");
        ref.child("Inventory").child(id).child("havenow").child("14").setValue("empty");
        ref.child("Inventory").child(id).child("havenow").child("15").setValue("empty");
        ref.child("Inventory").child(id).child("havenow").child("16").setValue("empty");
        ref.child("Inventory").child(id).child("havenow").child("17").setValue("empty");
        ref.child("Inventory").child(id).child("havenow").child("18").setValue("empty");
        ref.child("Inventory").child(id).child("havenow").child("19").setValue("empty");
        ref.child("Inventory").child(id).child("havenow").child("20").setValue("empty");


        ref.child("User").child(id).child("bool").setValue("false");
        ref.child("User").child(id).child("wards").child("bool2").setValue("false");

        newDayLayout = findViewById(R.id.newDayLayout);
        newDayLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref.child("Wards").child(id).child("wardvip").child("bool").setValue("false");
                ref.child("Wards").child(id).child("ward1bed1").child("bool").setValue("false");
                ref.child("Wards").child(id).child("ward1bed2").child("bool").setValue("false");
                ref.child("Wards").child(id).child("ward1bed3").child("bool").setValue("false");
                ref.child("Wards").child(id).child("ward2bed1").child("bool").setValue("false");
                ref.child("Wards").child(id).child("ward2bed2").child("bool").setValue("false");
                ref.child("Wards").child(id).child("ward2bed3").child("bool").setValue("false");

                Intent intent = new Intent(NewDay.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}