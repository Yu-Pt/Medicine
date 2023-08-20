package com.example.medicine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    int x = 0;
    int dayNumber = 1;
    String bool = "true";
    TextView textGreeting;
    LinearLayout layout;
    FirebaseAuth mAuth;

    Button toWards, toCards, toSklad, telephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.mainlayout);
        textGreeting = findViewById(R.id.text_greeting);

        toWards = findViewById(R.id.hallToWards);
        toCards = findViewById(R.id.hallToCards);
        toSklad = findViewById(R.id.hallToSklad);
        telephone = findViewById(R.id.telephone);

        toWards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Wards.class);
                startActivity(intent);
            }
        });
        toCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cards.class);
                startActivity(intent);
            }
        });
        toSklad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sklad.class);
                startActivity(intent);
            }
        });


        mAuth = FirebaseAuth.getInstance();
        FirebaseUser cUser = mAuth.getCurrentUser();

        String idUser = cUser.getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        ref.child("User").child(idUser).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                    dayNumber = snapshot.child("day").getValue(Integer.class);
                    bool = snapshot.child("bool").getValue().toString();
                    if (dayNumber == 1 && bool.equals("false")) day1();
                    else {
                        if (dayNumber == 2 && bool.equals("false")) day2();
                        else {
                            toSklad.setVisibility(View.VISIBLE);
                            toCards.setVisibility(View.VISIBLE);
                            toWards.setVisibility(View.VISIBLE);
                        }
                    }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }

    public void day1(){
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = x + 1;
                if(x == 1) textGreeting.setText("Доброе утро, вы же наш новый доктор?");
                if(x == 2) textGreeting.setText("Смотрите, медицинские карты ваших пациентов на полке, а лекарства на складе за дверью.");
                if(x == 3) textGreeting.setText("Удачного дня!");
                if(x == 4) {
                    textGreeting.setText(" ");
                    toSklad.setVisibility(View.VISIBLE);
                    toCards.setVisibility(View.VISIBLE);
                    toWards.setVisibility(View.VISIBLE);

                    mAuth = FirebaseAuth.getInstance();
                    FirebaseUser cUser = mAuth.getCurrentUser();
                    String idUser = cUser.getUid();
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                    ref.child("User").child(idUser).child("bool").setValue("true");
                }
            }
        });
    }

    public void day2(){
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = x + 1;
                if(x == 1) textGreeting.setText("Доброе утро, доктор! Иногда в больницу приходят новые пациенты.");
                if(x == 2) textGreeting.setText("Не забываете принимать их в приемной прямо по коридору.");
                if(x == 3) textGreeting.setText("Удачного дня!");
                if(x == 4) {
                    textGreeting.setText(" ");
                    toSklad.setVisibility(View.VISIBLE);
                    toCards.setVisibility(View.VISIBLE);
                    toWards.setVisibility(View.VISIBLE);

                    mAuth = FirebaseAuth.getInstance();
                    FirebaseUser cUser = mAuth.getCurrentUser();
                    String idUser = cUser.getUid();
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                    ref.child("User").child(idUser).child("bool").setValue("true");
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
    }
}