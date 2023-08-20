package com.example.medicine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.view.CancelEvent;
import com.squareup.picasso.Picasso;

import java.util.Random;

public class Ambulance extends AppCompatActivity {
    Button back, givediag;
    ImageView image;
    TextView name, adress, symp, idpt, gender, rightDiag, gender2, adress2, symp2, link;
    CheckBox op1, op2, op3;
    FirebaseAuth mAuth;
    int dayNumber = -100, x = 100, r1 = 100, r2 = 3, r3, r4 = 66, nn = 99;
    String y0, y1, y2, y3, y4, y5, y6;
    Random r;
    String b = "false", bool2 = "false", p1, diagChoose, sympChoose, q1, q2, q3, diagCh2, diagCh3, ward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance);

        back = findViewById(R.id.ambToBack);
        givediag = findViewById(R.id.ambGiveDiag);
        image = findViewById(R.id.amb_avatar);
        name = findViewById(R.id.amb_name);
        adress = findViewById(R.id.amb_adress);
        symp = findViewById(R.id.amb_symp);
        gender = findViewById(R.id.amb_gender);
        idpt = findViewById(R.id.amb_id);
        rightDiag = findViewById(R.id.amb_rightDiag);
        op1 = findViewById(R.id.option1);
        op2 = findViewById(R.id.option2);
        op3 = findViewById(R.id.option3);
        gender2 = findViewById(R.id.gender_to_gone);
        adress2 = findViewById(R.id.adres_to_gone);
        symp2 = findViewById(R.id.symp_to_gone);
        link = findViewById(R.id.amb_link);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ambulance.this, Wards.class);
                startActivity(intent);
            }
        });

        op1.setVisibility(View.VISIBLE);
        op2.setVisibility(View.VISIBLE);
        op3.setVisibility(View.VISIBLE);
        givediag.setVisibility(View.VISIBLE);
        back.setVisibility(View.INVISIBLE);
        choosePatient();
        chooseDiag();
        chooseWard();

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser cUser = mAuth.getCurrentUser();

        String idUser = cUser.getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("User").child(idUser).child("day").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dayNumber = snapshot.getValue(Integer.class);
                if (dayNumber == 1) {
                    name.setText("Новых пациентов нет");
                    image.setVisibility(View.GONE);
                    adress.setVisibility(View.GONE);
                    symp.setVisibility(View.GONE);
                    givediag.setVisibility(View.GONE);
                    gender.setVisibility(View.GONE);
                    back.setVisibility(View.VISIBLE);
                    op1.setVisibility(View.GONE);
                    op2.setVisibility(View.GONE);
                    op3.setVisibility(View.GONE);
                    adress2.setVisibility(View.INVISIBLE);
                    symp2.setVisibility(View.INVISIBLE);
                    gender2.setVisibility(View.INVISIBLE);
                }
                //if (dayNumber == 2) pat2();
                //if (dayNumber == 3) pat3();
                //if (dayNumber == 4) pat4();
                //if (dayNumber == 5) pat5();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });


    }


    public void choosePatient() {
        Random r = new Random();
        while (r1 == 100 || p1.equals(y0) || p1.equals(y1) || p1.equals(y2) || p1.equals(y3) || p1.equals(y4) || p1.equals(y5) || p1.equals(y6)) {
            r1 = r.nextInt(20 - 1 + 1) + 1;
            p1 = String.valueOf(r1);
        }
        mAuth = FirebaseAuth.getInstance();
        final DatabaseReference ref;
        ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Patients").child(p1).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    name.setText(snapshot.child("name").getValue().toString());
                    adress.setText(snapshot.child("adress").getValue().toString());
                    gender.setText(snapshot.child("gender").getValue().toString());
                    String link2 = snapshot.child("image").getValue().toString();
                    link.setText(link2);
                    Picasso.get().load(link2).into(image);
                    idpt.setText(snapshot.child("id").getValue().toString());
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
    }

    public void chooseDiag() {
        Random r = new Random();
        while (r2 == 3) {
            r2 = r.nextInt(15 - 1 + 1) + 1;
            q1 = String.valueOf(r2);
        }
        r2 = 3;
        while (r2 == 3 || String.valueOf(r2).equals(q1)) {
            r2 = r.nextInt(15 - 1 + 1) + 1;
            q2 = String.valueOf(r2);
        }
        r2 = 3;
        while (r2 == 3 || String.valueOf(r2).equals(q1) || String.valueOf(r2).equals(q2)) {
            r2 = r.nextInt(15 - 1 + 1) + 1;
            q3 = String.valueOf(r2);
        }
        r3 = r.nextInt(6 - 1 + 1) + 1;

        mAuth = FirebaseAuth.getInstance();
        final DatabaseReference ref;
        ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Ill").child(q1).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    diagChoose = snapshot.child("name").getValue().toString();
                    sympChoose = snapshot.child("symp").getValue().toString();
                    if (r3 == 1 || r3 == 2) op1.setText(diagChoose);
                    if (r3 == 3 || r3 == 5) op2.setText(diagChoose);
                    if (r3 == 4 || r3 == 6) op3.setText(diagChoose);
                    symp.setText(sympChoose);
                    rightDiag.setText(diagChoose);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        ref.child("Ill").child(q2).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    diagCh2 = snapshot.child("name").getValue().toString();
                    if (r3 == 3 || r3 == 4) op1.setText(diagCh2);
                    if (r3 == 1 || r3 == 6) op2.setText(diagCh2);
                    if (r3 == 2 || r3 == 5) op3.setText(diagCh2);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        ref.child("Ill").child(q3).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    diagCh3 = snapshot.child("name").getValue().toString();
                    if (r3 == 5 || r3 == 6) op1.setText(diagCh3);
                    if (r3 == 2 || r3 == 4) op2.setText(diagCh3);
                    if (r3 == 1 || r3 == 3) op3.setText(diagCh3);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
    }



    public void chooseWard() {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser cUser = mAuth.getCurrentUser();
        String id = cUser.getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("User").child(id).child("wards").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.child("bool2").getValue().toString().equals("false")) {
                    y0 = snapshot.child("wardvip").getValue().toString();
                    y1 = snapshot.child("ward1bed1").getValue().toString();
                    y2 = snapshot.child("ward1bed2").getValue().toString();
                    y3 = snapshot.child("ward1bed3").getValue().toString();
                    y4 = snapshot.child("ward2bed1").getValue().toString();
                    y5 = snapshot.child("ward2bed2").getValue().toString();
                    y6 = snapshot.child("ward2bed3").getValue().toString();

                    while (idpt.getText().toString().equals(y0) || idpt.getText().toString().equals(y1)
                            || idpt.getText().toString().equals(y2) || idpt.getText().toString().equals(y3) || idpt.getText().toString().equals(y4)
                            || idpt.getText().toString().equals(y5) || idpt.getText().toString().equals(y6))
                        choosePatient();

                    if (y0.equals("0")) ward = "wardvip";
                    else {
                        if (y1.equals("0")) ward = "ward1bed1";
                        else {
                            if (y2.equals("0")) ward = "ward1bed2";
                            else {
                                if (y3.equals("0")) ward = "ward1bed3";
                                else {
                                    if (y4.equals("0")) ward = "ward2bed1";
                                    else {
                                        if (y5.equals("0")) ward = "ward2bed2";
                                        else {
                                            if (y6.equals("0")) ward = "ward2bed3";
                                            else {
                                                op1.setVisibility(View.GONE);
                                                op2.setVisibility(View.GONE);
                                                op3.setVisibility(View.GONE);
                                                givediag.setVisibility(View.GONE);
                                                image.setVisibility(View.GONE);
                                                adress.setVisibility(View.GONE);
                                                gender.setVisibility(View.GONE);
                                                symp.setVisibility(View.GONE);
                                                back.setVisibility(View.VISIBLE);
                                                adress2.setVisibility(View.INVISIBLE);
                                                symp2.setVisibility(View.INVISIBLE);
                                                gender2.setVisibility(View.INVISIBLE);
                                                name.setText("Новых пациентов нет");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    givediag.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if ((op1.isChecked() && op2.isChecked() && op3.isChecked()) || (op1.isChecked() && op2.isChecked()) || (op1.isChecked()) && (op3.isChecked()) || (op1.isChecked()) && op2.isChecked() || (op2.isChecked()) && (op3.isChecked()))
                                Toast.makeText(getApplicationContext(), "Можно поставить только один диагноз", Toast.LENGTH_SHORT).show();
                            else {
                                if (!op1.isChecked() && !op2.isChecked() && !op3.isChecked())
                                    Toast.makeText(getApplicationContext(), "Выберете диагноз для постановления", Toast.LENGTH_SHORT).show();
                                else {
                                    ref.child("User").child(id).child("wards").child("bool2").setValue("true");
                                    ref.child("Wards").child(id).child(ward).child("name").setValue(name.getText().toString());
                                    ref.child("Wards").child(id).child(ward).child("adress").setValue(adress.getText().toString());
                                    ref.child("Wards").child(id).child(ward).child("symp").setValue(symp.getText().toString());
                                    ref.child("Wards").child(id).child(ward).child("diag").setValue(rightDiag.getText().toString());
                                    ref.child("Wards").child(id).child(ward).child("gender").setValue(gender.getText()).toString();
                                    ref.child("Wards").child(id).child(ward).child("image").setValue(link.getText()).toString();
                                    ref.child("Wards").child(id).child(ward).child("id").setValue(idpt.getText().toString());
                                    Random r = new Random();
                                    while (r4 % 5 != 0) {
                                        r4 = r.nextInt(80 - 20 + 1) + 20;
                                    }
                                    ref.child("Wards").child(id).child(ward).child("hp").setValue(r4);
                                    if (op1.isChecked())
                                        ref.child("Wards").child(id).child(ward).child("vrach").setValue(op1.getText());
                                    if (op2.isChecked())
                                        ref.child("Wards").child(id).child(ward).child("vrach").setValue(op2.getText());
                                    if (op3.isChecked())
                                        ref.child("Wards").child(id).child(ward).child("vrach").setValue(op3.getText());
                                    op1.setVisibility(View.GONE);
                                    op2.setVisibility(View.GONE);
                                    op3.setVisibility(View.GONE);
                                    givediag.setVisibility(View.GONE);
                                    image.setVisibility(View.GONE);
                                    adress.setVisibility(View.GONE);
                                    symp.setVisibility(View.GONE);
                                    gender.setVisibility(View.GONE);
                                    adress2.setVisibility(View.INVISIBLE);
                                    symp2.setVisibility(View.INVISIBLE);
                                    gender2.setVisibility(View.INVISIBLE);
                                    back.setVisibility(View.VISIBLE);
                                    name.setText("Больше пациентов нет");

                                    ref.child("User").child(id).child("wards").child(ward).setValue(idpt.getText().toString());
                                }
                            }
                        }
                    });
                }
                else {
                    op1.setVisibility(View.GONE);
                    op2.setVisibility(View.GONE);
                    op3.setVisibility(View.GONE);
                    givediag.setVisibility(View.GONE);
                    image.setVisibility(View.GONE);
                    adress.setVisibility(View.GONE);
                    symp.setVisibility(View.GONE);
                    gender.setVisibility(View.GONE);
                    back.setVisibility(View.VISIBLE);
                    adress2.setVisibility(View.INVISIBLE);
                    symp2.setVisibility(View.INVISIBLE);
                    gender2.setVisibility(View.INVISIBLE);
                    name.setText("Больше пациентов нет");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }

    public void pat2() {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser cUser = mAuth.getCurrentUser();
        String id = cUser.getUid();
        final DatabaseReference ref;
        ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Patients").child("101").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    name.setText(snapshot.child("name").getValue().toString());
                    adress.setText(snapshot.child("adress").getValue().toString());
                    gender.setText(snapshot.child("gender").getValue().toString());
                    idpt.setText(snapshot.child("id").getValue().toString());
                    symp.setText("Жар, мелкая сыпь, сухой кашель");
                    rightDiag.setText("Синтетическое отравление");
                    op1.setText("Синтетическое отравление");
                    op2.setText("Желтотечь");
                    op3.setText("Красная сыпуха");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}});
        givediag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((op1.isChecked() && op2.isChecked() && op3.isChecked()) || (op1.isChecked() && op2.isChecked()) || (op1.isChecked()) && (op3.isChecked()) || (op1.isChecked()) && op2.isChecked())
                    Toast.makeText(getApplicationContext(), "Можно поставить только один диагноз", Toast.LENGTH_SHORT).show();
                else {
                    if (!op1.isChecked() && !op2.isChecked() && !op3.isChecked())
                        Toast.makeText(getApplicationContext(), "Выберете диагноз для постановления", Toast.LENGTH_SHORT).show();
                    else {
                        ref.child("User").child(id).child("wards").child("bool2").setValue("true");
                        ref.child("Wards").child(id).child("ward2bed1").child("name").setValue(name.getText().toString());
                        ref.child("Wards").child(id).child("ward2bed1").child("adress").setValue(adress.getText().toString());
                        ref.child("Wards").child(id).child("ward2bed1").child("symp").setValue(symp.getText().toString());
                        ref.child("Wards").child(id).child("ward2bed1").child("diag").setValue(rightDiag.getText().toString());
                        ref.child("Wards").child(id).child("ward2bed1").child("gender").setValue(gender.getText()).toString();
                        ref.child("Wards").child(id).child("ward2bed1").child("id").setValue(idpt.getText().toString());
                        Random r = new Random();
                        while (r4 % 5 != 0) {
                            r4 = r.nextInt(80 - 20 + 1) + 20;
                        }
                        ref.child("Wards").child(id).child("ward2bed1").child("hp").setValue(r4);
                        if (op1.isChecked())
                            ref.child("Wards").child(id).child("ward2bed1").child("vrach").setValue(op1.getText());
                        if (op2.isChecked())
                            ref.child("Wards").child(id).child("ward2bed1").child("vrach").setValue(op2.getText());
                        if (op3.isChecked())
                            ref.child("Wards").child(id).child("ward2bed1").child("vrach").setValue(op3.getText());
                        op1.setVisibility(View.GONE);
                        op2.setVisibility(View.GONE);
                        op3.setVisibility(View.GONE);
                        givediag.setVisibility(View.GONE);
                        image.setVisibility(View.GONE);
                        adress.setVisibility(View.GONE);
                        symp.setVisibility(View.GONE);
                        gender.setVisibility(View.GONE);
                        adress2.setVisibility(View.INVISIBLE);
                        symp2.setVisibility(View.INVISIBLE);
                        gender2.setVisibility(View.INVISIBLE);
                        back.setVisibility(View.VISIBLE);
                        name.setText("Больше пациентов нет");

                        ref.child("User").child(id).child("wards").child("ward2bed1").setValue(idpt.getText().toString());
                    }
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
    }
}