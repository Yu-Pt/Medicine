package com.example.medicine;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class toCreatePatients extends AppCompatActivity {

    EditText id, name, gender, adress;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_create_patients);

        id = findViewById(R.id.textView);
        name = findViewById(R.id.textView1);
        gender = findViewById(R.id.textView2);
        adress = findViewById(R.id.textView3);
        save = findViewById(R.id.buttonSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveIll();
            }
        });
    }

    public void saveIll() {
        String idp = id.getText().toString();
        String namep = name.getText().toString();
        String genderp = gender.getText().toString();
        String adressp = adress.getText().toString();
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!(snapshot.child("Patients").child(idp).exists())) {
                    HashMap<String, Object> userDataMap = new HashMap<>();
                    userDataMap.put("id", idp);
                    userDataMap.put("name", namep);
                    userDataMap.put("gender", genderp);
                    userDataMap.put("adress", adressp);
                    userDataMap.put("image", "out");

                    RootRef.child("Patients").child(idp).updateChildren(userDataMap);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(toCreatePatients.this, "wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}