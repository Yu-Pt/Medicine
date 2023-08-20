package com.example.medicine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class SignIn extends AppCompatActivity {
    private EditText textEmail, textPassword;
    public Button bSign, bBack;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        textEmail = findViewById(R.id.text_sign_email);
        textPassword = findViewById(R.id.text_sign_password);
        bSign = findViewById(R.id.button_sign_accept);
        bBack = findViewById(R.id.button_sign_back);
        mAuth = FirebaseAuth.getInstance();

        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn.this, Menu.class);
                startActivity(intent);
            }
        });

        bSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(textEmail.getText().toString()) && !TextUtils.isEmpty(textPassword.getText().toString())) {
                    mAuth.signInWithEmailAndPassword(textEmail.getText().toString(), textPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (task.isSuccessful() && user.isEmailVerified()) {
                                Toast.makeText(getApplicationContext(), "Вы успешно вошли", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } else
                                Toast.makeText(getApplicationContext(), "Вход не произведен, подтвердите email и проверьте данные", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}