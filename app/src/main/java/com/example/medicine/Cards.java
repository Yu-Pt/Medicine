package com.example.medicine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Cards extends AppCompatActivity {
    ImageView image;
    TextView name, gender, adress, diag, symp, ward;
    Button backCards, next, prev;
    FirebaseAuth mAuth;
    int count = 0, x = 7, x0 = 0, x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0, x6 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        image = findViewById(R.id.card_avatar);
        name = findViewById(R.id.card_name);
        gender = findViewById(R.id.card_gender);
        adress = findViewById(R.id.card_adress);
        diag = findViewById(R.id.card_diag);
        symp = findViewById(R.id.card_symp);
        ward = findViewById(R.id.card_ward);
        prev = findViewById(R.id.cardsPrev);
        next = findViewById(R.id.cardsNext);
        backCards = findViewById(R.id.cardsToBack);

        backCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cards.this, MainActivity.class);
                startActivity(intent);
            }
        });
        if (count == 0) prev.setVisibility(View.INVISIBLE);
        else prev.setVisibility(View.VISIBLE);
        if (count == x) next.setVisibility(View.INVISIBLE);
        else next.setVisibility(View.VISIBLE);

        ward1bed1();
        ward1bed2();
        ward1bed3();
        ward2bed1();
        ward2bed2();
        ward2bed3();
        wardvip();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                if (count == 0){
                    if (x0 == 1) count++;
                    else wardvip();
                }
                if (count == 1) {
                    if (x1 == 1) count++;
                    else ward1bed1();
                }
                if (count == 2) {
                    if (x2 == 1) count++;
                    else ward1bed2();
                }
                if (count == 3) {
                    if (x3 == 1) count++;
                     else ward1bed3();
                }
                if (count == 4) {
                    if (x4 == 1) count++;
                    else ward2bed1();
                }
                if (count == 5) {
                    if (x5 == 1) count++;
                    else ward2bed2();
                }
                if (count == 6) {
                    if (x6 == 1) prev.performClick();
                    else ward2bed3();
                }
                if (count == 0) prev.setVisibility(View.INVISIBLE);
                else prev.setVisibility(View.VISIBLE);
                if (count == 6 || (count == 5 && x6 == 1) || (count == 4 && x5 == 1)
                        || (count == 3 && x5 == 1 && x4 == 1) || (count == 2 && x5 == 1 && x4 == 1 && x3 == 1)
                        || (count == 1 && x5 == 1 && x4 == 1 && x3 == 1 && x2 == 1)) next.setVisibility(View.INVISIBLE);
                else next.setVisibility(View.VISIBLE);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                if (count == 6) {
                    if (x6 == 1) count--;
                    else ward2bed3();
                }
                if (count == 5) {
                    if (x5 == 1) count--;
                    else ward2bed2();
                }
                if (count == 4) {
                    if (x4 == 1) count--;
                    else ward2bed1();
                }
                if (count == 3) {
                    if (x3 == 1) count--;
                    else ward1bed3();
                }
                if (count == 2) {
                    if (x2 == 1) count--;
                    else ward1bed2();
                }
                if (count == 1) {
                    if (x1 == 1) count--;
                    else ward1bed1();
                }
                if (count == 0){
                    if (x0 == 1) next.performClick();
                    else wardvip();
                }
                if (count == 0) prev.setVisibility(View.INVISIBLE);
                else prev.setVisibility(View.VISIBLE);
                if (count == 6 || (count == 5 && x6 == 1) || (count == 4 && x5 == 1)
                        || (count == 3 && x5 == 1 && x4 == 1) || (count == 2 && x5 == 1 && x4 == 1 && x3 == 1)
                        || (count == 1 && x5 == 1 && x4 == 1 && x3 == 1 && x2 == 1)) next.setVisibility(View.INVISIBLE);
                else next.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onBackPressed() {
    }

    public void wardvip() {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser cUser = mAuth.getCurrentUser();
        String id = cUser.getUid();
        final DatabaseReference ref;
        ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Wards").child(id).child("wardvip").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    if(snapshot.child("name").getValue().toString().equals("empty")) {
                        name.setText(snapshot.child("name").getValue().toString());
                        x0 = 1;
                    }
                    else
                    {
                        name.setText(snapshot.child("name").getValue().toString());
                        gender.setText(snapshot.child("gender").getValue().toString());
                        adress.setText(snapshot.child("adress").getValue().toString());
                        diag.setText(snapshot.child("vrach").getValue().toString());
                        symp.setText(snapshot.child("symp").getValue().toString());
                        String link = snapshot.child("image").getValue().toString();
                        Picasso.get().load(link).into(image);
                        ward.setText("Палата VIP");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void ward1bed1() {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser cUser = mAuth.getCurrentUser();
        String id = cUser.getUid();
        final DatabaseReference ref;
        ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Wards").child(id).child("ward1bed1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    if(snapshot.child("name").getValue().toString().equals("empty")) {
                        name.setText(snapshot.child("name").getValue().toString());
                        x1 = 1;
                    }
                    else
                    {
                        name.setText(snapshot.child("name").getValue().toString());
                        gender.setText(snapshot.child("gender").getValue().toString());
                        adress.setText(snapshot.child("adress").getValue().toString());
                        diag.setText(snapshot.child("vrach").getValue().toString());
                        symp.setText(snapshot.child("symp").getValue().toString());
                        String link = snapshot.child("image").getValue().toString();
                        Picasso.get().load(link).into(image);
                        ward.setText("Палата 1, кровать 1");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void ward1bed2() {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser cUser = mAuth.getCurrentUser();
        String id = cUser.getUid();
        final DatabaseReference ref;
        ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Wards").child(id).child("ward1bed2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    if(snapshot.child("name").getValue().toString().equals("empty")) {
                        name.setText(snapshot.child("name").getValue().toString());
                        x2 = 1;
                    }
                    else
                    {
                        name.setText(snapshot.child("name").getValue().toString());
                        gender.setText(snapshot.child("gender").getValue().toString());
                        adress.setText(snapshot.child("adress").getValue().toString());
                        diag.setText(snapshot.child("vrach").getValue().toString());
                        symp.setText(snapshot.child("symp").getValue().toString());
                        String link = snapshot.child("image").getValue().toString();
                        Picasso.get().load(link).into(image);
                        ward.setText("Палата 1, кровать 2");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void ward1bed3() {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser cUser = mAuth.getCurrentUser();
        String id = cUser.getUid();
        final DatabaseReference ref;
        ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Wards").child(id).child("ward1bed3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    if(snapshot.child("name").getValue().toString().equals("empty")) {
                        name.setText(snapshot.child("name").getValue().toString());
                        x3 = 1;
                    }
                    else
                    {
                        name.setText(snapshot.child("name").getValue().toString());
                        gender.setText(snapshot.child("gender").getValue().toString());
                        adress.setText(snapshot.child("adress").getValue().toString());
                        diag.setText(snapshot.child("vrach").getValue().toString());
                        symp.setText(snapshot.child("symp").getValue().toString());
                        String link = snapshot.child("image").getValue().toString();
                        Picasso.get().load(link).into(image);
                        ward.setText("Палата 1, кровать 3");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void ward2bed1() {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser cUser = mAuth.getCurrentUser();
        String id = cUser.getUid();
        final DatabaseReference ref;
        ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Wards").child(id).child("ward2bed1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    if(snapshot.child("name").getValue().toString().equals("empty")) {
                        name.setText(snapshot.child("name").getValue().toString());
                        x4 = 1;
                    }
                    else
                    {
                        name.setText(snapshot.child("name").getValue().toString());
                        gender.setText(snapshot.child("gender").getValue().toString());
                        adress.setText(snapshot.child("adress").getValue().toString());
                        diag.setText(snapshot.child("vrach").getValue().toString());
                        symp.setText(snapshot.child("symp").getValue().toString());
                        String link = snapshot.child("image").getValue().toString();
                        Picasso.get().load(link).into(image);
                        ward.setText("Палата 2, кровать 1");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void ward2bed2() {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser cUser = mAuth.getCurrentUser();
        String id = cUser.getUid();
        final DatabaseReference ref;
        ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Wards").child(id).child("ward2bed2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    if(snapshot.child("name").getValue().toString().equals("empty")) {
                        name.setText(snapshot.child("name").getValue().toString());
                        x5 = 1;
                    }
                    else
                    {
                        name.setText(snapshot.child("name").getValue().toString());
                        gender.setText(snapshot.child("gender").getValue().toString());
                        adress.setText(snapshot.child("adress").getValue().toString());
                        diag.setText(snapshot.child("vrach").getValue().toString());
                        symp.setText(snapshot.child("symp").getValue().toString());
                        String link = snapshot.child("image").getValue().toString();
                        Picasso.get().load(link).into(image);
                        ward.setText("Палата 2, кровать 2");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void ward2bed3() {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser cUser = mAuth.getCurrentUser();
        String id = cUser.getUid();
        final DatabaseReference ref;
        ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Wards").child(id).child("ward2bed3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    if(snapshot.child("name").getValue().toString().equals("empty")) {
                        name.setText(snapshot.child("name").getValue().toString());
                        x6 = 1;
                    }
                    else
                    {
                        name.setText(snapshot.child("name").getValue().toString());
                        gender.setText(snapshot.child("gender").getValue().toString());
                        adress.setText(snapshot.child("adress").getValue().toString());
                        diag.setText(snapshot.child("vrach").getValue().toString());
                        symp.setText(snapshot.child("symp").getValue().toString());
                        String link = snapshot.child("image").getValue().toString();
                        Picasso.get().load(link).into(image);
                        ward.setText("Палата 2, кровать 3");
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

}