package com.example.medicine;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Registration extends AppCompatActivity {
    private EditText EmailBDreg, PasswordBDreg;
    private DatabaseReference mDataBase;
    private String USER_KEY = "User";
    private String idtable;
    private FirebaseAuth mAuth;
    Button bBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();
        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration.this, Menu.class);
                startActivity(intent);
            }
        });
    }
    public void init(){
        EmailBDreg = findViewById(R.id.text_reg_email);
        PasswordBDreg = findViewById(R.id.text_reg_password);
        bBack = findViewById(R.id.button_reg_back);
        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);
        mAuth = FirebaseAuth.getInstance();
    }

    public void onClickRegister(View view) {
        String email = EmailBDreg.getText().toString();
        String password = PasswordBDreg.getText().toString();
        int day = 1;
        String bool = "false";
        if(!TextUtils.isEmpty(EmailBDreg.getText().toString()) && !TextUtils.isEmpty(PasswordBDreg.getText().toString())) {
            mAuth.createUserWithEmailAndPassword(EmailBDreg.getText().toString(), PasswordBDreg.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        sendEmailVer();
                        FirebaseUser cUser = mAuth.getCurrentUser();
                        idtable = cUser.getUid();
                        saveBD(idtable, email, password, day, bool);
                    } else
                        Toast.makeText(getApplicationContext(), "Регистрация не удалась, проверьте данные и попробуйте еще раз", Toast.LENGTH_SHORT).show();
                }
            });

        }
        else Toast.makeText(this, "Заполните пустые поля", Toast.LENGTH_SHORT).show();
    }

    private void saveBD(String idtable, String email, String password, int day, String bool){
        final DatabaseReference RootRef;

        RootRef = FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(!(snapshot.child("User").child(idtable).exists())){
                    HashMap<String, Object> userDataMap = new HashMap<>();
                    HashMap<String, Object> userWardDataMap = new HashMap<>();
                    HashMap<String, Object> invDataMap = new HashMap<>();
                    HashMap<String, Object> haveDataMap = new HashMap<>();
                    HashMap<String, Object> wardsDataMap = new HashMap<>();
                    HashMap<String, Object> ambDataMap = new HashMap<>();
                    userDataMap.put("id", idtable);
                    userDataMap.put("Email", email);
                    userDataMap.put("Password", password);
                    userDataMap.put("day", day);
                    userDataMap.put("bool", bool);
                    userWardDataMap.put("bool2", bool);
                    userWardDataMap.put("ward1bed1", "106");
                    userWardDataMap.put("ward1bed2", "0");
                    userWardDataMap.put("ward1bed3", "107");
                    userWardDataMap.put("ward2bed1", "0");
                    userWardDataMap.put("ward2bed2", "0");
                    userWardDataMap.put("ward2bed3", "0");
                    userWardDataMap.put("wardvip", "105");
                    RootRef.child("User").child(idtable).updateChildren(userDataMap);
                    RootRef.child("User").child(idtable).child("wards").updateChildren(userWardDataMap);

                    invDataMap.put("1", "Эстрапоистин");
                    invDataMap.put("2", "Кальцидол");
                    invDataMap.put("3", "Виратадин");
                    invDataMap.put("4", "Сомпристин");
                    invDataMap.put("5", "Экстракседин");
                    invDataMap.put("bool1", "false");
                    invDataMap.put("bool2", "false");
                    invDataMap.put("bool3", "false");
                    invDataMap.put("bool4", "false");
                    invDataMap.put("bool5", "false");
                    RootRef.child("Inventory").child(idtable).child("tabl").updateChildren(invDataMap);

                    invDataMap.put("1", "Налфентанил");
                    invDataMap.put("2", "Салаплермин");
                    invDataMap.put("3", "Гадоадан");
                    invDataMap.put("4", "Болпрофен");
                    invDataMap.put("5", "Фиргоарел");
                    RootRef.child("Inventory").child(idtable).child("rast").updateChildren(invDataMap);

                    invDataMap.put("1", "Пегадол");
                    invDataMap.put("2", "Вибрифибан");
                    invDataMap.put("3", "Набатант");
                    invDataMap.put("4", "Кальцистерид");
                    invDataMap.put("5", "Болинакалант");
                    RootRef.child("Inventory").child(idtable).child("maz").updateChildren(invDataMap);

                    invDataMap.put("1", "Цефтадин");
                    invDataMap.put("2", "Вирисалафокон");
                    invDataMap.put("3", "Нифуррпароид");
                    invDataMap.put("4", "Нифуррпароид");
                    invDataMap.put("5", "Лоитиром");
                    RootRef.child("Inventory").child(idtable).child("aero").updateChildren(invDataMap);

                    haveDataMap.put("1", "empty"); haveDataMap.put("2", "empty"); haveDataMap.put("3", "empty"); haveDataMap.put("4", "empty"); haveDataMap.put("5", "empty");
                    haveDataMap.put("6", "empty"); haveDataMap.put("7", "empty"); haveDataMap.put("8", "empty"); haveDataMap.put("9", "empty"); haveDataMap.put("10", "empty");
                    haveDataMap.put("11", "empty"); haveDataMap.put("12", "empty"); haveDataMap.put("13", "empty"); haveDataMap.put("14", "empty"); haveDataMap.put("15", "empty");
                    haveDataMap.put("16", "empty"); haveDataMap.put("17", "empty"); haveDataMap.put("18", "empty"); haveDataMap.put("19", "empty"); haveDataMap.put("20", "empty");
                    RootRef.child("Inventory").child(idtable).child("havenow").updateChildren(haveDataMap);

                    wardsDataMap.put("name", "Русанов Александр");
                    wardsDataMap.put("gender", "мужской");
                    wardsDataMap.put("adress", "проспект Гусева, д.16. кв.3");
                    wardsDataMap.put("symp", "головная боль, тошнота");
                    wardsDataMap.put("diag", "неизвестен");
                    wardsDataMap.put("vrach", "неизвестен");
                    wardsDataMap.put("hp", 70);
                    wardsDataMap.put("bool", "false");
                    wardsDataMap.put("image", "https://firebasestorage.googleapis.com/v0/b/medicine-3d5bc.appspot.com/o/male3.png?alt=media&token=7163c964-84c7-41a1-aa22-e0c5063d883d");
                    wardsDataMap.put("id", "105");
                    RootRef.child("Wards").child(idtable).child("wardvip").updateChildren(wardsDataMap);

                    wardsDataMap.put("name", "Иванов Тимофей");
                    wardsDataMap.put("gender", "мужской");
                    wardsDataMap.put("adress", "улица Тихонова, д.1");
                    wardsDataMap.put("symp", "слабость мышц");
                    wardsDataMap.put("diag", "Ревонз");
                    wardsDataMap.put("vrach", "Ревонз");
                    wardsDataMap.put("hp", 80);
                    wardsDataMap.put("bool", "false");
                    wardsDataMap.put("image", "https://firebasestorage.googleapis.com/v0/b/medicine-3d5bc.appspot.com/o/male1.png?alt=media&token=649768c2-9615-49ae-956e-d88bd5ac7ec2");
                    wardsDataMap.put("id", "106");
                    RootRef.child("Wards").child(idtable).child("ward1bed1").updateChildren(wardsDataMap);

                    wardsDataMap.put("name", "empty");
                    wardsDataMap.put("gender", "empty");
                    wardsDataMap.put("adress", "empty");
                    wardsDataMap.put("symp", "empty");
                    wardsDataMap.put("diag", "empty");
                    wardsDataMap.put("vrach", "empty");
                    wardsDataMap.put("hp", 100);
                    wardsDataMap.put("bool", "false");
                    wardsDataMap.put("image", "out");
                    wardsDataMap.put("id", "empty");
                    RootRef.child("Wards").child(idtable).child("ward1bed2").updateChildren(wardsDataMap);

                    wardsDataMap.put("name", "Волкова Серафима");
                    wardsDataMap.put("gender", "женский");
                    wardsDataMap.put("adress", "улица Мира, д.14, кв.6");
                    wardsDataMap.put("symp", "прерывистое дыхание, судороги");
                    wardsDataMap.put("diag", "Хлот");
                    wardsDataMap.put("vrach", "Хлот");
                    wardsDataMap.put("hp", 60);
                    wardsDataMap.put("bool", "false");
                    wardsDataMap.put("image", "https://firebasestorage.googleapis.com/v0/b/medicine-3d5bc.appspot.com/o/female3.png?alt=media&token=262d6b6e-fcbf-43f7-80d9-a4073838ae7f");
                    wardsDataMap.put("id", "107");
                    RootRef.child("Wards").child(idtable).child("ward1bed3").updateChildren(wardsDataMap);

                    wardsDataMap.put("name", "empty");
                    wardsDataMap.put("gender", "empty");
                    wardsDataMap.put("adress", "empty");
                    wardsDataMap.put("symp", "empty");
                    wardsDataMap.put("diag", "empty");
                    wardsDataMap.put("vrach", "empty");
                    wardsDataMap.put("hp", 100);
                    wardsDataMap.put("bool", "false");
                    wardsDataMap.put("image", "out");
                    wardsDataMap.put("id", "empty");
                    RootRef.child("Wards").child(idtable).child("ward2bed1").updateChildren(wardsDataMap);

                    wardsDataMap.put("name", "empty");
                    wardsDataMap.put("gender", "empty");
                    wardsDataMap.put("adress", "empty");
                    wardsDataMap.put("symp", "empty");
                    wardsDataMap.put("diag", "empty");
                    wardsDataMap.put("vrach", "empty");
                    wardsDataMap.put("hp", 100);
                    wardsDataMap.put("bool", "false");
                    wardsDataMap.put("image", "out");
                    wardsDataMap.put("id", "empty");
                    RootRef.child("Wards").child(idtable).child("ward2bed2").updateChildren(wardsDataMap);

                    wardsDataMap.put("name", "empty");
                    wardsDataMap.put("gender", "empty");
                    wardsDataMap.put("adress", "empty");
                    wardsDataMap.put("symp", "empty");
                    wardsDataMap.put("diag", "empty");
                    wardsDataMap.put("vrach", "empty");
                    wardsDataMap.put("hp", 100);
                    wardsDataMap.put("bool", "false");
                    wardsDataMap.put("image", "out");
                    wardsDataMap.put("id", "empty");
                    RootRef.child("Wards").child(idtable).child("ward2bed3").updateChildren(wardsDataMap);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Registration.this, "E-mail" + email +"зарегистрирован", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendEmailVer(){
        FirebaseUser user = mAuth.getCurrentUser();
        assert user != null;
        user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Проверьте ваш почтовый ящик, подтвердите email и выполните вход", Toast.LENGTH_SHORT).show();
                } else Toast.makeText(getApplicationContext(), "Отправка сообщения провалилась, проверьте данные", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
