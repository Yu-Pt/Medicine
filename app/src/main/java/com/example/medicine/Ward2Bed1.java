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

public class Ward2Bed1 extends AppCompatActivity {
    FirebaseAuth mAuth;
    ImageView avatar;
    TextView name, hp, give1, give2, give3, great;
    Button back, give, tabl1, tabl2, tabl3, tabl4, tabl5;
    Button rast1, rast2, rast3, rast4, rast5, maz1, maz2, maz3, maz4, maz5;
    Button aero1, aero2, aero3, aero4, aero5;
    Button discharge;
    String huh, g1, g2, g3, f1, f2, f3;
    int newHP = 50, x = 0, x1, x2, x3, x4, x5, x6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ward2_bed1);

        avatar = findViewById(R.id.ward2bed1_avatar);
        name = findViewById(R.id.ward2bed1_name);
        hp = findViewById(R.id.ward2bed1_hp);
        give1 = findViewById(R.id.ward2bed1_give1);
        give2 = findViewById(R.id.ward2bed1_give2);
        give3 = findViewById(R.id.ward2bed1_give3);
        give = findViewById(R.id.ward2bed1_give);
        back = findViewById(R.id.ward2bed1_back);
        tabl1 = findViewById(R.id.ward2bed1_tabl1);
        tabl2 = findViewById(R.id.ward2bed1_tabl2);
        tabl3 = findViewById(R.id.ward2bed1_tabl3);
        tabl4 = findViewById(R.id.ward2bed1_tabl4);
        tabl5 = findViewById(R.id.ward2bed1_tabl5);
        rast1 = findViewById(R.id.ward2bed1_rast1);
        rast2 = findViewById(R.id.ward2bed1_rast2);
        rast3 = findViewById(R.id.ward2bed1_rast3);
        rast4 = findViewById(R.id.ward2bed1_rast4);
        rast5 = findViewById(R.id.ward2bed1_rast5);
        maz1 = findViewById(R.id.ward2bed1_maz1);
        maz2 = findViewById(R.id.ward2bed1_maz2);
        maz3 = findViewById(R.id.ward2bed1_maz3);
        maz4 = findViewById(R.id.ward2bed1_maz4);
        maz5 = findViewById(R.id.ward2bed1_maz5);
        aero1 = findViewById(R.id.ward2bed1_aero1);
        aero2 = findViewById(R.id.ward2bed1_aero2);
        aero3 = findViewById(R.id.ward2bed1_aero3);
        aero4 = findViewById(R.id.ward2bed1_aero4);
        aero5 = findViewById(R.id.ward2bed1_aero5);
        great = findViewById(R.id.ward2bed1_great);
        discharge = findViewById(R.id.ward2bed1_discharge);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ward2Bed1.this, Ward2.class);
                startActivity(intent);
            }
        });

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser cUser = mAuth.getCurrentUser();
        String id = cUser.getUid();
        final DatabaseReference ref;
        ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Wards").child(id).child("ward2bed1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    if(snapshot.child("bool").getValue().toString().equals("true")) give.setVisibility(View.INVISIBLE);
                    if(snapshot.child("name").getValue().toString().equals("empty"))
                    {
                        name.setText("Кровать свободна");
                        hp.setText(" ");
                        give.setVisibility(View.INVISIBLE);
                        avatar.setVisibility(View.INVISIBLE);
                    }
                    else
                    {
                        name.setText(snapshot.child("name").getValue().toString());
                        hp.setText(snapshot.child("hp").getValue().toString() + "%");
                        String link = snapshot.child("image").getValue().toString();
                        Picasso.get().load(link).into(avatar);
                        newHP = snapshot.child("hp").getValue(Integer.class);
                        if (newHP <= 0) hp0();
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        ref.child("Inventory").child(id).child("havenow").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    if(snapshot.child("1").getValue().toString().equals("empty")) tabl1.setVisibility(View.INVISIBLE);
                    else tabl1.setText(snapshot.child("1").getValue().toString());
                    if(snapshot.child("2").getValue().toString().equals("empty")) tabl2.setVisibility(View.INVISIBLE);
                    else tabl2.setText(snapshot.child("2").getValue().toString());
                    if(snapshot.child("3").getValue().toString().equals("empty")) tabl3.setVisibility(View.INVISIBLE);
                    else tabl3.setText(snapshot.child("3").getValue().toString());
                    if(snapshot.child("4").getValue().toString().equals("empty")) tabl4.setVisibility(View.INVISIBLE);
                    else tabl4.setText(snapshot.child("4").getValue().toString());
                    if(snapshot.child("5").getValue().toString().equals("empty")) tabl5.setVisibility(View.INVISIBLE);
                    else tabl5.setText(snapshot.child("5").getValue().toString());
                    if(snapshot.child("6").getValue().toString().equals("empty")) rast1.setVisibility(View.INVISIBLE);
                    else rast1.setText(snapshot.child("6").getValue().toString());
                    if(snapshot.child("7").getValue().toString().equals("empty")) rast2.setVisibility(View.INVISIBLE);
                    else rast2.setText(snapshot.child("7").getValue().toString());
                    if(snapshot.child("8").getValue().toString().equals("empty")) rast3.setVisibility(View.INVISIBLE);
                    else rast3.setText(snapshot.child("8").getValue().toString());
                    if(snapshot.child("9").getValue().toString().equals("empty")) rast4.setVisibility(View.INVISIBLE);
                    else rast4.setText(snapshot.child("9").getValue().toString());
                    if(snapshot.child("10").getValue().toString().equals("empty")) rast5.setVisibility(View.INVISIBLE);
                    else rast5.setText(snapshot.child("10").getValue().toString());
                    if(snapshot.child("11").getValue().toString().equals("empty")) maz1.setVisibility(View.INVISIBLE);
                    else maz1.setText(snapshot.child("11").getValue().toString());
                    if(snapshot.child("12").getValue().toString().equals("empty")) maz2.setVisibility(View.INVISIBLE);
                    else maz2.setText(snapshot.child("12").getValue().toString());
                    if(snapshot.child("13").getValue().toString().equals("empty")) maz3.setVisibility(View.INVISIBLE);
                    else maz3.setText(snapshot.child("13").getValue().toString());
                    if(snapshot.child("14").getValue().toString().equals("empty")) maz4.setVisibility(View.INVISIBLE);
                    else maz4.setText(snapshot.child("14").getValue().toString());
                    if(snapshot.child("15").getValue().toString().equals("empty")) maz5.setVisibility(View.INVISIBLE);
                    else maz5.setText(snapshot.child("15").getValue().toString());
                    if(snapshot.child("16").getValue().toString().equals("empty")) aero1.setVisibility(View.INVISIBLE);
                    else aero1.setText(snapshot.child("16").getValue().toString());
                    if(snapshot.child("17").getValue().toString().equals("empty")) aero2.setVisibility(View.INVISIBLE);
                    else aero2.setText(snapshot.child("17").getValue().toString());
                    if(snapshot.child("18").getValue().toString().equals("empty")) aero3.setVisibility(View.INVISIBLE);
                    else aero3.setText(snapshot.child("18").getValue().toString());
                    if(snapshot.child("19").getValue().toString().equals("empty")) aero4.setVisibility(View.INVISIBLE);
                    else aero4.setText(snapshot.child("19").getValue().toString());
                    if(snapshot.child("20").getValue().toString().equals("empty")) aero5.setVisibility(View.INVISIBLE);
                    else aero5.setText(snapshot.child("20").getValue().toString());
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        tabl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (give1.getText().toString().equals(" ")) { give1.setText(tabl1.getText()); tabl1.setVisibility(View.INVISIBLE);}
                else { if (give2.getText().toString().equals(" ")) { give2.setText(tabl1.getText()); tabl1.setVisibility(View.INVISIBLE);}
                else { if (give3.getText().toString().equals(" ")) { give3.setText(tabl1.getText()); tabl1.setVisibility(View.INVISIBLE);}}}}
        });
        tabl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (give1.getText().toString().equals(" ")) { give1.setText(tabl2.getText()); tabl2.setVisibility(View.INVISIBLE);}
                else { if (give2.getText().toString().equals(" ")) { give2.setText(tabl2.getText()); tabl2.setVisibility(View.INVISIBLE);}
                else { if (give3.getText().toString().equals(" ")) { give3.setText(tabl2.getText()); tabl2.setVisibility(View.INVISIBLE);}}}}
        });
        tabl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (give1.getText().toString().equals(" ")) { give1.setText(tabl3.getText()); tabl3.setVisibility(View.INVISIBLE);}
                else { if (give2.getText().toString().equals(" ")) { give2.setText(tabl3.getText()); tabl3.setVisibility(View.INVISIBLE);}
                else { if (give3.getText().toString().equals(" ")) { give3.setText(tabl3.getText()); tabl3.setVisibility(View.INVISIBLE);}}}}
        });
        tabl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (give1.getText().toString().equals(" ")) { give1.setText(tabl4.getText()); tabl4.setVisibility(View.INVISIBLE);}
                else { if (give2.getText().toString().equals(" ")) { give2.setText(tabl4.getText()); tabl4.setVisibility(View.INVISIBLE);}
                else { if (give3.getText().toString().equals(" ")) { give3.setText(tabl4.getText()); tabl4.setVisibility(View.INVISIBLE);}}}}
        });
        tabl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (give1.getText().toString().equals(" ")) { give1.setText(tabl5.getText()); tabl5.setVisibility(View.INVISIBLE);}
                else { if (give2.getText().toString().equals(" ")) { give2.setText(tabl5.getText()); tabl5.setVisibility(View.INVISIBLE);}
                else { if (give3.getText().toString().equals(" ")) { give3.setText(tabl5.getText()); tabl5.setVisibility(View.INVISIBLE);}}}}
        });
        rast1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (give1.getText().toString().equals(" ")) { give1.setText(rast1.getText()); rast1.setVisibility(View.INVISIBLE);}
                else { if (give2.getText().toString().equals(" ")) { give2.setText(rast1.getText()); rast1.setVisibility(View.INVISIBLE);}
                else { if (give3.getText().toString().equals(" ")) { give3.setText(rast1.getText()); rast1.setVisibility(View.INVISIBLE);}}}}
        });
        rast2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (give1.getText().toString().equals(" ")) { give1.setText(rast2.getText()); rast2.setVisibility(View.INVISIBLE);}
                else { if (give2.getText().toString().equals(" ")) { give2.setText(rast2.getText()); rast2.setVisibility(View.INVISIBLE);}
                else { if (give3.getText().toString().equals(" ")) { give3.setText(rast2.getText()); rast2.setVisibility(View.INVISIBLE);}}}}
        });
        rast3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (give1.getText().toString().equals(" ")) { give1.setText(rast3.getText()); rast3.setVisibility(View.INVISIBLE);}
                else { if (give2.getText().toString().equals(" ")) { give2.setText(rast3.getText()); rast3.setVisibility(View.INVISIBLE);}
                else { if (give3.getText().toString().equals(" ")) { give3.setText(rast3.getText()); rast3.setVisibility(View.INVISIBLE);}}}}
        });
        rast4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (give1.getText().toString().equals(" ")) { give1.setText(rast4.getText()); rast4.setVisibility(View.INVISIBLE);}
                else { if (give2.getText().toString().equals(" ")) { give2.setText(rast4.getText()); rast4.setVisibility(View.INVISIBLE);}
                else { if (give3.getText().toString().equals(" ")) { give3.setText(rast4.getText()); rast4.setVisibility(View.INVISIBLE);}}}}
        });
        rast5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (give1.getText().toString().equals(" ")) { give1.setText(rast5.getText()); rast5.setVisibility(View.INVISIBLE);}
                else { if (give2.getText().toString().equals(" ")) { give2.setText(rast5.getText()); rast5.setVisibility(View.INVISIBLE);}
                else { if (give3.getText().toString().equals(" ")) { give3.setText(rast5.getText()); rast5.setVisibility(View.INVISIBLE);}}}}
        });
        maz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (give1.getText().toString().equals(" ")) { give1.setText(maz1.getText()); maz1.setVisibility(View.INVISIBLE);}
                else { if (give2.getText().toString().equals(" ")) { give2.setText(maz1.getText()); maz1.setVisibility(View.INVISIBLE);}
                else { if (give3.getText().toString().equals(" ")) { give3.setText(maz1.getText()); maz1.setVisibility(View.INVISIBLE);}}}}
        });
        maz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (give1.getText().toString().equals(" ")) { give1.setText(maz2.getText()); maz2.setVisibility(View.INVISIBLE);}
                else { if (give2.getText().toString().equals(" ")) { give2.setText(maz2.getText()); maz2.setVisibility(View.INVISIBLE);}
                else { if (give3.getText().toString().equals(" ")) { give3.setText(maz2.getText()); maz2.setVisibility(View.INVISIBLE);}}}}
        });
        maz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (give1.getText().toString().equals(" ")) { give1.setText(maz3.getText()); maz3.setVisibility(View.INVISIBLE);}
                else { if (give2.getText().toString().equals(" ")) { give2.setText(maz3.getText()); maz3.setVisibility(View.INVISIBLE);}
                else { if (give3.getText().toString().equals(" ")) { give3.setText(maz3.getText()); maz3.setVisibility(View.INVISIBLE);}}}}
        });
        maz4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (give1.getText().toString().equals(" ")) { give1.setText(maz4.getText()); maz4.setVisibility(View.INVISIBLE);}
                else { if (give2.getText().toString().equals(" ")) { give2.setText(maz4.getText()); maz4.setVisibility(View.INVISIBLE);}
                else { if (give3.getText().toString().equals(" ")) { give3.setText(maz4.getText()); maz4.setVisibility(View.INVISIBLE);}}}}
        });
        maz5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (give1.getText().toString().equals(" ")) { give1.setText(maz5.getText()); maz5.setVisibility(View.INVISIBLE);}
                else { if (give2.getText().toString().equals(" ")) { give2.setText(maz5.getText()); maz5.setVisibility(View.INVISIBLE);}
                else { if (give3.getText().toString().equals(" ")) { give3.setText(maz5.getText()); maz5.setVisibility(View.INVISIBLE);}}}}
        });
        aero1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (give1.getText().toString().equals(" ")) { give1.setText(aero1.getText()); aero1.setVisibility(View.INVISIBLE);}
                else { if (give2.getText().toString().equals(" ")) { give2.setText(aero1.getText()); aero1.setVisibility(View.INVISIBLE);}
                else { if (give3.getText().toString().equals(" ")) { give3.setText(aero1.getText()); aero1.setVisibility(View.INVISIBLE);}}}}
        });
        aero2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (give1.getText().toString().equals(" ")) { give1.setText(aero2.getText()); aero2.setVisibility(View.INVISIBLE);}
                else { if (give2.getText().toString().equals(" ")) { give2.setText(aero2.getText()); aero2.setVisibility(View.INVISIBLE);}
                else { if (give3.getText().toString().equals(" ")) { give3.setText(aero2.getText()); aero2.setVisibility(View.INVISIBLE);}}}}
        });
        aero3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (give1.getText().toString().equals(" ")) { give1.setText(aero3.getText()); aero3.setVisibility(View.INVISIBLE);}
                else { if (give2.getText().toString().equals(" ")) { give2.setText(aero3.getText()); aero3.setVisibility(View.INVISIBLE);}
                else { if (give3.getText().toString().equals(" ")) { give3.setText(aero3.getText()); aero3.setVisibility(View.INVISIBLE);}}}}
        });
        aero4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (give1.getText().toString().equals(" ")) { give1.setText(aero4.getText()); aero4.setVisibility(View.INVISIBLE);}
                else { if (give2.getText().toString().equals(" ")) { give2.setText(aero4.getText()); aero4.setVisibility(View.INVISIBLE);}
                else { if (give3.getText().toString().equals(" ")) { give3.setText(aero4.getText()); aero4.setVisibility(View.INVISIBLE);}}}}
        });
        aero5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (give1.getText().toString().equals(" ")) { give1.setText(aero5.getText()); aero5.setVisibility(View.INVISIBLE);}
                else { if (give2.getText().toString().equals(" ")) { give2.setText(aero5.getText()); aero5.setVisibility(View.INVISIBLE);}
                else { if (give3.getText().toString().equals(" ")) { give3.setText(aero5.getText()); aero5.setVisibility(View.INVISIBLE);}}}}
        });

        give1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                huh = give1.getText().toString();
                if(tabl1.getText().toString().equals(huh) && tabl1.getVisibility() == View.INVISIBLE) tabl1.setVisibility(View.VISIBLE);
                if(tabl2.getText().toString().equals(huh) && tabl2.getVisibility() == View.INVISIBLE) tabl2.setVisibility(View.VISIBLE);
                if(tabl3.getText().toString().equals(huh) && tabl3.getVisibility() == View.INVISIBLE) tabl3.setVisibility(View.VISIBLE);
                if(tabl4.getText().toString().equals(huh) && tabl4.getVisibility() == View.INVISIBLE) tabl4.setVisibility(View.VISIBLE);
                if(tabl5.getText().toString().equals(huh) && tabl5.getVisibility() == View.INVISIBLE) tabl5.setVisibility(View.VISIBLE);
                if(rast1.getText().toString().equals(huh) && rast1.getVisibility() == View.INVISIBLE) rast1.setVisibility(View.VISIBLE);
                if(rast2.getText().toString().equals(huh) && rast2.getVisibility() == View.INVISIBLE) rast2.setVisibility(View.VISIBLE);
                if(rast3.getText().toString().equals(huh) && rast3.getVisibility() == View.INVISIBLE) rast3.setVisibility(View.VISIBLE);
                if(rast4.getText().toString().equals(huh) && rast4.getVisibility() == View.INVISIBLE) rast4.setVisibility(View.VISIBLE);
                if(rast5.getText().toString().equals(huh) && rast5.getVisibility() == View.INVISIBLE) rast5.setVisibility(View.VISIBLE);
                if(maz1.getText().toString().equals(huh) && maz1.getVisibility() == View.INVISIBLE) maz1.setVisibility(View.VISIBLE);
                if(maz2.getText().toString().equals(huh) && maz2.getVisibility() == View.INVISIBLE) maz2.setVisibility(View.VISIBLE);
                if(maz3.getText().toString().equals(huh) && maz3.getVisibility() == View.INVISIBLE) maz3.setVisibility(View.VISIBLE);
                if(maz4.getText().toString().equals(huh) && maz4.getVisibility() == View.INVISIBLE) maz4.setVisibility(View.VISIBLE);
                if(maz5.getText().toString().equals(huh) && maz5.getVisibility() == View.INVISIBLE) maz5.setVisibility(View.VISIBLE);
                if(aero1.getText().toString().equals(huh) && aero1.getVisibility() == View.INVISIBLE) aero1.setVisibility(View.VISIBLE);
                if(aero2.getText().toString().equals(huh) && aero2.getVisibility() == View.INVISIBLE) aero2.setVisibility(View.VISIBLE);
                if(aero3.getText().toString().equals(huh) && aero3.getVisibility() == View.INVISIBLE) aero3.setVisibility(View.VISIBLE);
                if(aero4.getText().toString().equals(huh) && aero4.getVisibility() == View.INVISIBLE) aero4.setVisibility(View.VISIBLE);
                if(aero5.getText().toString().equals(huh) && aero5.getVisibility() == View.INVISIBLE) aero5.setVisibility(View.VISIBLE);
                give1.setText(" ");
            }
        });
        give2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                huh = give2.getText().toString();
                if(tabl1.getText().toString().equals(huh) && tabl1.getVisibility() == View.INVISIBLE) tabl1.setVisibility(View.VISIBLE);
                if(tabl2.getText().toString().equals(huh) && tabl2.getVisibility() == View.INVISIBLE) tabl2.setVisibility(View.VISIBLE);
                if(tabl3.getText().toString().equals(huh) && tabl3.getVisibility() == View.INVISIBLE) tabl3.setVisibility(View.VISIBLE);
                if(tabl4.getText().toString().equals(huh) && tabl4.getVisibility() == View.INVISIBLE) tabl4.setVisibility(View.VISIBLE);
                if(tabl5.getText().toString().equals(huh) && tabl5.getVisibility() == View.INVISIBLE) tabl5.setVisibility(View.VISIBLE);
                if(rast1.getText().toString().equals(huh) && rast1.getVisibility() == View.INVISIBLE) rast1.setVisibility(View.VISIBLE);
                if(rast2.getText().toString().equals(huh) && rast2.getVisibility() == View.INVISIBLE) rast2.setVisibility(View.VISIBLE);
                if(rast3.getText().toString().equals(huh) && rast3.getVisibility() == View.INVISIBLE) rast3.setVisibility(View.VISIBLE);
                if(rast4.getText().toString().equals(huh) && rast4.getVisibility() == View.INVISIBLE) rast4.setVisibility(View.VISIBLE);
                if(rast5.getText().toString().equals(huh) && rast5.getVisibility() == View.INVISIBLE) rast5.setVisibility(View.VISIBLE);
                if(maz1.getText().toString().equals(huh) && maz1.getVisibility() == View.INVISIBLE) maz1.setVisibility(View.VISIBLE);
                if(maz2.getText().toString().equals(huh) && maz2.getVisibility() == View.INVISIBLE) maz2.setVisibility(View.VISIBLE);
                if(maz3.getText().toString().equals(huh) && maz3.getVisibility() == View.INVISIBLE) maz3.setVisibility(View.VISIBLE);
                if(maz4.getText().toString().equals(huh) && maz4.getVisibility() == View.INVISIBLE) maz4.setVisibility(View.VISIBLE);
                if(maz5.getText().toString().equals(huh) && maz5.getVisibility() == View.INVISIBLE) maz5.setVisibility(View.VISIBLE);
                if(aero1.getText().toString().equals(huh) && aero1.getVisibility() == View.INVISIBLE) aero1.setVisibility(View.VISIBLE);
                if(aero2.getText().toString().equals(huh) && aero2.getVisibility() == View.INVISIBLE) aero2.setVisibility(View.VISIBLE);
                if(aero3.getText().toString().equals(huh) && aero3.getVisibility() == View.INVISIBLE) aero3.setVisibility(View.VISIBLE);
                if(aero4.getText().toString().equals(huh) && aero4.getVisibility() == View.INVISIBLE) aero4.setVisibility(View.VISIBLE);
                if(aero5.getText().toString().equals(huh) && aero5.getVisibility() == View.INVISIBLE) aero5.setVisibility(View.VISIBLE);
                give2.setText(" ");
            }
        });
        give3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                huh = give3.getText().toString();
                if(tabl1.getText().toString().equals(huh) && tabl1.getVisibility() == View.INVISIBLE) tabl1.setVisibility(View.VISIBLE);
                if(tabl2.getText().toString().equals(huh) && tabl2.getVisibility() == View.INVISIBLE) tabl2.setVisibility(View.VISIBLE);
                if(tabl3.getText().toString().equals(huh) && tabl3.getVisibility() == View.INVISIBLE) tabl3.setVisibility(View.VISIBLE);
                if(tabl4.getText().toString().equals(huh) && tabl4.getVisibility() == View.INVISIBLE) tabl4.setVisibility(View.VISIBLE);
                if(tabl5.getText().toString().equals(huh) && tabl5.getVisibility() == View.INVISIBLE) tabl5.setVisibility(View.VISIBLE);
                if(rast1.getText().toString().equals(huh) && rast1.getVisibility() == View.INVISIBLE) rast1.setVisibility(View.VISIBLE);
                if(rast2.getText().toString().equals(huh) && rast2.getVisibility() == View.INVISIBLE) rast2.setVisibility(View.VISIBLE);
                if(rast3.getText().toString().equals(huh) && rast3.getVisibility() == View.INVISIBLE) rast3.setVisibility(View.VISIBLE);
                if(rast4.getText().toString().equals(huh) && rast4.getVisibility() == View.INVISIBLE) rast4.setVisibility(View.VISIBLE);
                if(rast5.getText().toString().equals(huh) && rast5.getVisibility() == View.INVISIBLE) rast5.setVisibility(View.VISIBLE);
                if(maz1.getText().toString().equals(huh) && maz1.getVisibility() == View.INVISIBLE) maz1.setVisibility(View.VISIBLE);
                if(maz2.getText().toString().equals(huh) && maz2.getVisibility() == View.INVISIBLE) maz2.setVisibility(View.VISIBLE);
                if(maz3.getText().toString().equals(huh) && maz3.getVisibility() == View.INVISIBLE) maz3.setVisibility(View.VISIBLE);
                if(maz4.getText().toString().equals(huh) && maz4.getVisibility() == View.INVISIBLE) maz4.setVisibility(View.VISIBLE);
                if(maz5.getText().toString().equals(huh) && maz5.getVisibility() == View.INVISIBLE) maz5.setVisibility(View.VISIBLE);
                if(aero1.getText().toString().equals(huh) && aero1.getVisibility() == View.INVISIBLE) aero1.setVisibility(View.VISIBLE);
                if(aero2.getText().toString().equals(huh) && aero2.getVisibility() == View.INVISIBLE) aero2.setVisibility(View.VISIBLE);
                if(aero3.getText().toString().equals(huh) && aero3.getVisibility() == View.INVISIBLE) aero3.setVisibility(View.VISIBLE);
                if(aero4.getText().toString().equals(huh) && aero4.getVisibility() == View.INVISIBLE) aero4.setVisibility(View.VISIBLE);
                if(aero5.getText().toString().equals(huh) && aero5.getVisibility() == View.INVISIBLE) aero5.setVisibility(View.VISIBLE);
                give3.setText(" ");
            }
        });

        give.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                g1 = give1.getText().toString();
                g2 = give2.getText().toString();
                g3 = give3.getText().toString();
                if((tabl1.getText().toString().equals(g1) || tabl1.getText().toString().equals(g2) || tabl1.getText().toString().equals(g3)) && tabl1.getVisibility() == View.INVISIBLE) ref.child("Inventory").child(id).child("havenow").child("1").setValue("empty");
                if((tabl2.getText().toString().equals(g1) || tabl2.getText().toString().equals(g2) || tabl2.getText().toString().equals(g3)) && tabl2.getVisibility() == View.INVISIBLE) ref.child("Inventory").child(id).child("havenow").child("2").setValue("empty");
                if((tabl3.getText().toString().equals(g1) || tabl3.getText().toString().equals(g2) || tabl3.getText().toString().equals(g3)) && tabl3.getVisibility() == View.INVISIBLE) ref.child("Inventory").child(id).child("havenow").child("3").setValue("empty");
                if((tabl4.getText().toString().equals(g1) || tabl4.getText().toString().equals(g2) || tabl4.getText().toString().equals(g3)) && tabl4.getVisibility() == View.INVISIBLE) ref.child("Inventory").child(id).child("havenow").child("4").setValue("empty");
                if((tabl5.getText().toString().equals(g1) || tabl5.getText().toString().equals(g2) || tabl5.getText().toString().equals(g3)) && tabl5.getVisibility() == View.INVISIBLE) ref.child("Inventory").child(id).child("havenow").child("5").setValue("empty");
                if((rast1.getText().toString().equals(g1) || rast1.getText().toString().equals(g2) || rast1.getText().toString().equals(g3)) && rast1.getVisibility() == View.INVISIBLE) ref.child("Inventory").child(id).child("havenow").child("6").setValue("empty");
                if((rast2.getText().toString().equals(g1) || rast2.getText().toString().equals(g2) || rast2.getText().toString().equals(g3)) && rast2.getVisibility() == View.INVISIBLE) ref.child("Inventory").child(id).child("havenow").child("7").setValue("empty");
                if((rast3.getText().toString().equals(g1) || rast3.getText().toString().equals(g2) || rast3.getText().toString().equals(g3)) && rast3.getVisibility() == View.INVISIBLE) ref.child("Inventory").child(id).child("havenow").child("8").setValue("empty");
                if((rast4.getText().toString().equals(g1) || rast4.getText().toString().equals(g2) || rast4.getText().toString().equals(g3)) && rast4.getVisibility() == View.INVISIBLE) ref.child("Inventory").child(id).child("havenow").child("9").setValue("empty");
                if((rast5.getText().toString().equals(g1) || rast5.getText().toString().equals(g2) || rast5.getText().toString().equals(g3)) && rast5.getVisibility() == View.INVISIBLE) ref.child("Inventory").child(id).child("havenow").child("10").setValue("empty");
                if((maz1.getText().toString().equals(g1) || maz1.getText().toString().equals(g2) || maz1.getText().toString().equals(g3)) && maz1.getVisibility() == View.INVISIBLE) ref.child("Inventory").child(id).child("havenow").child("11").setValue("empty");
                if((maz2.getText().toString().equals(g1) || maz2.getText().toString().equals(g2) || maz2.getText().toString().equals(g3)) && maz2.getVisibility() == View.INVISIBLE) ref.child("Inventory").child(id).child("havenow").child("12").setValue("empty");
                if((maz3.getText().toString().equals(g1) || maz3.getText().toString().equals(g2) || maz3.getText().toString().equals(g3)) && maz3.getVisibility() == View.INVISIBLE) ref.child("Inventory").child(id).child("havenow").child("13").setValue("empty");
                if((maz4.getText().toString().equals(g1) || maz4.getText().toString().equals(g2) || maz4.getText().toString().equals(g3)) && maz4.getVisibility() == View.INVISIBLE) ref.child("Inventory").child(id).child("havenow").child("14").setValue("empty");
                if((maz5.getText().toString().equals(g1) || maz5.getText().toString().equals(g2) || maz5.getText().toString().equals(g3)) && maz5.getVisibility() == View.INVISIBLE) ref.child("Inventory").child(id).child("havenow").child("15").setValue("empty");
                if((aero1.getText().toString().equals(g1) || aero1.getText().toString().equals(g2) || aero1.getText().toString().equals(g3)) && aero1.getVisibility() == View.INVISIBLE) ref.child("Inventory").child(id).child("havenow").child("16").setValue("empty");
                if((aero2.getText().toString().equals(g1) || aero2.getText().toString().equals(g2) || aero2.getText().toString().equals(g3)) && aero2.getVisibility() == View.INVISIBLE) ref.child("Inventory").child(id).child("havenow").child("17").setValue("empty");
                if((aero3.getText().toString().equals(g1) || aero3.getText().toString().equals(g2) || aero3.getText().toString().equals(g3)) && aero3.getVisibility() == View.INVISIBLE) ref.child("Inventory").child(id).child("havenow").child("18").setValue("empty");
                if((aero4.getText().toString().equals(g1) || aero4.getText().toString().equals(g2) || aero4.getText().toString().equals(g3)) && aero4.getVisibility() == View.INVISIBLE) ref.child("Inventory").child(id).child("havenow").child("19").setValue("empty");
                if((aero5.getText().toString().equals(g1) || aero5.getText().toString().equals(g2) || aero5.getText().toString().equals(g3)) && aero5.getVisibility() == View.INVISIBLE) ref.child("Inventory").child(id).child("havenow").child("20").setValue("empty");

                ref.child("Wards").child(id).child("ward2bed1").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            huh = snapshot.child("diag").getValue().toString();
                            if (huh.equals("Хлот")) { f1 = "Налфетанил"; f2 = "Салаплермин"; f3 = " "; }
                            if (huh.equals("Паридоя")) { f1 = "Цефтадин"; f2 = "Пегадол"; f3 = "Эстрапоистин"; }
                            if (huh.equals("Синтетическое отравление")) { f1 = "Эстрапоистин"; f2 = "Вибрифибан"; f3 = "Кальцидол"; }
                            if (huh.equals("Ревонз")) { f1 = "Кальцистерид"; f2 = " "; f3 = " "; }
                            if (huh.equals("Вофомоз")) { f1 = "Виратадин"; f2 = "Гадоадан"; f3 = "Сомпристин"; }
                            if (huh.equals("Нимблезия")) { f1 = "Экстракседин"; f2 = "Гадоадан"; f3 = " "; }
                            if (huh.equals("Коронохаос")) { f1 = "Эстрапоистин"; f2 = "Кальцидол"; f3 = "Виратадин"; }
                            if (huh.equals("Айсолепсия")) { f1 = "Болпрофен"; f2 = "Салаплермин"; f3 = " "; }
                            if (huh.equals("Желтотечь")) { f1 = "Фиргоарел"; f2 = "Сомпристин"; f3 = "Лоитиром"; }
                            if (huh.equals("Красная сыпуха")) { f1 = "Набатант"; f2 = "Пегадол"; f3 = " "; }
                            if (huh.equals("Пневмобластоз")) { f1 = "Нифуррпароид"; f2 = " "; f3 = " "; }
                            if (huh.equals("Гипертермия")) { f1 = "Болинакалант"; f2 = " "; f3 = " "; }
                            if (huh.equals("Синдром Рунголя")) { f1 = "Гадоадан"; f2 = "Экстракседин"; f3 = "Вибрифибан"; }
                            if (huh.equals("Менингоэнцефалит")) { f1 = "Болпрофен"; f2 = "Вирисалафокон"; f3 = "Виратадин"; }
                            if (huh.equals("Катастрофический лейкоцитоз")) { f1 = "Эстрапоистин"; f2 = "Лоитиром"; f3 = " "; }

                            if (g1.equals(f1) && x!=3) { x1 = 1;
                                if (g2.equals(f2)) { x1 = 2;
                                    if (g3.equals(f3)) x1 = 3; }}
                            if (g1.equals(f1)  && x!=3) { x1 = 1;
                                if (g2.equals(f3)) { x1 = 2;
                                    if (g3.equals(f2)) x1 = 3; }}
                            if (g1.equals(f2) && x!=3) { x1 = 1;
                                if (g2.equals(f1)) { x1 = 2;
                                    if (g3.equals(f3)) x1 = 3; }}
                            if (g1.equals(f2) && x!=3) { x1 = 1;
                                if (g2.equals(f3)) { x1 = 2;
                                    if (g3.equals(f1)) x1 = 3; }}
                            if (g1.equals(f3) && x!=3) { x1 = 1;
                                if (g2.equals(f1)) { x1 = 2;
                                    if (g3.equals(f2)) x1 = 3; }}
                            if (g1.equals(f3) && x!=3) { x1 = 1;
                                if (g2.equals(f2)) { x1 = 2;
                                    if (g3.equals(f1)) x1 = 3; }}

                            if (g1.equals(f1) && x!=3) { x2 = 1;
                                if (g3.equals(f2)) { x2 = 2;
                                    if (g2.equals(f3)) x2 = 3; }}
                            if (g1.equals(f1) && x!=3) { x2 = 1;
                                if (g3.equals(f3)) { x2 = 2;
                                    if (g2.equals(f2)) x2 = 3; }}
                            if (g1.equals(f2) && x!=3) { x2 = 1;
                                if (g3.equals(f1)) { x2 = 2;
                                    if (g2.equals(f3)) x2 = 3; }}
                            if (g1.equals(f2) && x!=3) { x2 = 1;
                                if (g3.equals(f3)) { x2 = 2;
                                    if (g2.equals(f1)) x2 = 3; }}
                            if (g1.equals(f3) && x!=3) { x2 = 1;
                                if (g3.equals(f1)) { x2 = 2;
                                    if (g2.equals(f2)) x2 = 3; }}
                            if (g1.equals(f3) && x!=3) { x2 = 1;
                                if (g3.equals(f2)) { x2 = 2;
                                    if (g2.equals(f1)) x2 = 3; }}

                            if (g2.equals(f1) && x!=3) { x3 = 1;
                                if (g1.equals(f2)) { x3 = 2;
                                    if (g3.equals(f3)) x3 = 3; }}
                            if (g2.equals(f1) && x!=3) { x3 = 1;
                                if (g1.equals(f3)) { x3 = 2;
                                    if (g3.equals(f2)) x3 = 3; }}
                            if (g2.equals(f2) && x!=3) { x3 = 1;
                                if (g1.equals(f1)) { x3 = 2;
                                    if (g3.equals(f3)) x3 = 3; }}
                            if (g2.equals(f2) && x!=3) { x3 = 1;
                                if (g1.equals(f3)) { x3 = 2;
                                    if (g3.equals(f1)) x3 = 3; }}
                            if (g2.equals(f3) && x!=3) { x3 = 1;
                                if (g1.equals(f1)) { x3 = 2;
                                    if (g3.equals(f2)) x3 = 3; }}
                            if (g2.equals(f3) && x!=3) { x3 = 1;
                                if (g1.equals(f2)) { x3 = 2;
                                    if (g3.equals(f1)) x3 = 3; }}

                            if (g2.equals(f1) && x!=3) { x4 = 1;
                                if (g3.equals(f2)) { x4 = 2;
                                    if (g1.equals(f3)) x4 = 3; }}
                            if (g2.equals(f1) && x!=3) { x4 = 1;
                                if (g3.equals(f3)) { x4 = 2;
                                    if (g1.equals(f2)) x4 = 3; }}
                            if (g2.equals(f2) && x!=3) { x4 = 1;
                                if (g3.equals(f1)) { x4 = 2;
                                    if (g1.equals(f3)) x4 = 3; }}
                            if (g2.equals(f2) && x!=3) { x4 = 1;
                                if (g3.equals(f3)) { x4 = 2;
                                    if (g1.equals(f1)) x4 = 3; }}
                            if (g2.equals(f3) && x!=3) { x4 = 1;
                                if (g3.equals(f1)) { x4 = 2;
                                    if (g1.equals(f2)) x4 = 3; }}
                            if (g2.equals(f3) && x!=3) { x4 = 1;
                                if (g3.equals(f2)) { x4 = 2;
                                    if (g1.equals(f1)) x4 = 3; }}

                            if (g3.equals(f1) && x!=3) { x5 = 1;
                                if (g1.equals(f2)) { x5 = 2;
                                    if (g2.equals(f3)) x5 = 3; }}
                            if (g3.equals(f1) && x!=3) { x5 = 1;
                                if (g1.equals(f3)) { x5 = 2;
                                    if (g2.equals(f2)) x5 = 3; }}
                            if (g3.equals(f2) && x!=3) { x5 = 1;
                                if (g1.equals(f1)) { x5 = 2;
                                    if (g2.equals(f3)) x5 = 3; }}
                            if (g3.equals(f2) && x!=3) { x5 = 1;
                                if (g1.equals(f3)) { x5 = 2;
                                    if (g2.equals(f1)) x5 = 3; }}
                            if (g3.equals(f3) && x!=3) { x5 = 1;
                                if (g1.equals(f1)) { x5 = 2;
                                    if (g2.equals(f2)) x5 = 3; }}
                            if (g3.equals(f3) && x!=3) { x5 = 1;
                                if (g1.equals(f2)) { x5 = 2;
                                    if (g2.equals(f1)) x5 = 3; }}

                            if (g3.equals(f1) && x!=3) { x6 = 1;
                                if (g2.equals(f2)) { x6 = 2;
                                    if (g1.equals(f3)) x6 = 3; }}
                            if (g3.equals(f1) && x!=3) { x6 = 1;
                                if (g2.equals(f3)) { x6 = 2;
                                    if (g1.equals(f2)) x6 = 3; }}
                            if (g3.equals(f2) && x!=3) { x6 = 1;
                                if (g2.equals(f1)) { x6 = 2;
                                    if (g1.equals(f3)) x6 = 3; }}
                            if (g3.equals(f2) && x!=3) { x6 = 1;
                                if (g2.equals(f3)) { x6 = 2;
                                    if (g1.equals(f1)) x6 = 3; }}
                            if (g3.equals(f3) && x!=3) { x6 = 1;
                                if (g2.equals(f1)) { x6 = 2;
                                    if (g1.equals(f2)) x6 = 3; }}
                            if (g3.equals(f3) && x!=3) { x6 = 1;
                                if (g2.equals(f2)) { x6 = 2;
                                    if (g1.equals(f1)) x6 = 3; }}

                            if (x1 == 3 || x2 == 3 || x3 == 3 || x4 == 3 || x5 == 3 || x6 == 3) x = 3;
                            else {
                                if (x1 == 2 || x2 == 2 || x3 == 2 || x4 == 2 || x5 == 2 || x6 == 2) x = 2;
                                else {
                                    if (x1 == 1 || x2 == 1 || x3 == 1 || x4 == 1 || x5 == 1 || x6 == 1) x = 1;
                                }
                            }

                            if (x == 3) newHP = newHP + 10;
                            if (x == 2) newHP = newHP + 5;
                            if (x == 0) newHP = newHP - 5;

                            if (newHP >=  100) newHP = 100;
                            if (newHP <= 0) newHP = 0;

                            hp.setText(newHP + "%");
                            ref.child("Wards").child(id).child("ward2bed1").child("hp").setValue(newHP);
                            ref.child("Wards").child(id).child("ward2bed1").child("bool").setValue("true");

                            if (newHP ==  100) hp100();
                            if (newHP == 0) hp0();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });

                give1.setVisibility(View.INVISIBLE);
                give2.setVisibility(View.INVISIBLE);
                give3.setVisibility(View.INVISIBLE);
                give.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void hp100() {
        give1.setVisibility(View.INVISIBLE);
        give2.setVisibility(View.INVISIBLE);
        give3.setVisibility(View.INVISIBLE);
        give.setVisibility(View.GONE);
        back.setVisibility(View.GONE);

        great.setVisibility(View.VISIBLE);
        discharge.setVisibility(View.VISIBLE);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser cUser = mAuth.getCurrentUser();
        String id = cUser.getUid();
        final DatabaseReference ref;
        ref = FirebaseDatabase.getInstance().getReference();
        discharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref.child("Wards").child(id).child("ward2bed1").child("adress").setValue("empty");
                ref.child("Wards").child(id).child("ward2bed1").child("bool").setValue("false");
                ref.child("Wards").child(id).child("ward2bed1").child("diag").setValue("empty");
                ref.child("Wards").child(id).child("ward2bed1").child("gender").setValue("empty");
                ref.child("Wards").child(id).child("ward2bed1").child("hp").setValue(100);
                ref.child("Wards").child(id).child("ward2bed1").child("image").setValue("out");
                ref.child("Wards").child(id).child("ward2bed1").child("name").setValue("empty");
                ref.child("Wards").child(id).child("ward2bed1").child("symp").setValue("empty");
                ref.child("Wards").child(id).child("ward2bed1").child("vrach").setValue("empty");
                ref.child("Wards").child(id).child("ward2bed1").child("id").setValue("empty");
                ref.child("User").child(id).child("wards").child("ward2bed1").setValue("0");

                give.setVisibility(View.INVISIBLE);
                back.setVisibility(View.VISIBLE);
                discharge.setVisibility(View.GONE);
                great.setVisibility(View.GONE);
                hp.setVisibility(View.GONE);
                name.setText("Кровать свободна");
            }
        });
    }

    public void hp0() {
        give1.setVisibility(View.INVISIBLE);
        give2.setVisibility(View.INVISIBLE);
        give3.setVisibility(View.INVISIBLE);
        give.setVisibility(View.GONE);
        back.setVisibility(View.GONE);

        great.setText("Пациент мёртв, приносим свои соболезнования");
        great.setVisibility(View.VISIBLE);
        discharge.setText("В морг");
        discharge.setVisibility(View.VISIBLE);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser cUser = mAuth.getCurrentUser();
        String id = cUser.getUid();
        final DatabaseReference ref;
        ref = FirebaseDatabase.getInstance().getReference();
        discharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref.child("Wards").child(id).child("ward2bed1").child("adress").setValue("empty");
                ref.child("Wards").child(id).child("ward2bed1").child("bool").setValue("false");
                ref.child("Wards").child(id).child("ward2bed1").child("diag").setValue("empty");
                ref.child("Wards").child(id).child("ward2bed1").child("gender").setValue("empty");
                ref.child("Wards").child(id).child("ward2bed1").child("hp").setValue(100);
                ref.child("Wards").child(id).child("ward2bed1").child("image").setValue("out");
                ref.child("Wards").child(id).child("ward2bed1").child("name").setValue("empty");
                ref.child("Wards").child(id).child("ward2bed1").child("symp").setValue("empty");
                ref.child("Wards").child(id).child("ward2bed1").child("vrach").setValue("empty");
                ref.child("Wards").child(id).child("ward2bed1").child("id").setValue("empty");
                ref.child("User").child(id).child("wards").child("ward2bed1").setValue("0");

                give.setVisibility(View.INVISIBLE);
                back.setVisibility(View.VISIBLE);
                discharge.setVisibility(View.GONE);
                great.setVisibility(View.GONE);
                hp.setVisibility(View.GONE);
                name.setText("Кровать свободна");
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}