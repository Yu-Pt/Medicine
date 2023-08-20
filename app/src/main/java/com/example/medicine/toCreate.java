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

public class toCreate extends AppCompatActivity {
    EditText id, name, symp, type;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_create);

        id = findViewById(R.id.textView);
        name = findViewById(R.id.textView1);
        symp = findViewById(R.id.textView2);
        type = findViewById(R.id.textView3);
        save = findViewById(R.id.buttonSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveIll();
            }
        });
    }

    public void saveIll(){
        String idill = id.getText().toString();
        String nameill = name.getText().toString();
        String sympill = symp.getText().toString();
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(!(snapshot.child("Ill").child(idill).exists())){
                    HashMap<String, Object> userDataMap = new HashMap<>();
                    userDataMap.put("id", idill);
                    userDataMap.put("name", nameill);
                    userDataMap.put("symp", sympill);

                    RootRef.child("Ill").child(idill).updateChildren(userDataMap);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(toCreate.this, "wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}