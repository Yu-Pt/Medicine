package com.example.medicine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Menu extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button bStart, bReset, bOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser cUser = mAuth.getCurrentUser();
        if (cUser == null)
        {
            Intent intent = new Intent(Menu.this, RegOrSign.class);
            startActivity(intent);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mAuth = FirebaseAuth.getInstance();

        bStart = findViewById(R.id.button_playGame);
        bReset = findViewById(R.id.button_resetGame);
        bOut = findViewById(R.id.button_signOut);
        TextView text = findViewById(R.id.text_welcome);

        String idUser = cUser.getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        text.setText(cUser.getEmail());

        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, MainActivity.class);
                startActivity(intent);
            }
        });
        bReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth = FirebaseAuth.getInstance();
                FirebaseUser cUser = mAuth.getCurrentUser();
                String idUser = cUser.getUid();
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                ref.child("User").child(idUser).child("bool").setValue("false");
                ref.child("User").child(idUser).child("wards").child("bool2").setValue("false");
                ref.child("User").child(idUser).child("wards").child("ward1bed1").setValue("106");
                ref.child("User").child(idUser).child("wards").child("ward1bed2").setValue("0");
                ref.child("User").child(idUser).child("wards").child("ward1bed3").setValue("107");
                ref.child("User").child(idUser).child("wards").child("ward2bed1").setValue("0");
                ref.child("User").child(idUser).child("wards").child("ward2bed2").setValue("0");
                ref.child("User").child(idUser).child("wards").child("ward2bed3").setValue("0");
                ref.child("User").child(idUser).child("wards").child("wardvip").setValue("105");
                ref.child("User").child(idUser).child("day").setValue(1);

                ref.child("Inventory").child(idUser).child("tabl").child("1").setValue("Эстрапоистин");
                ref.child("Inventory").child(idUser).child("tabl").child("2").setValue("Кальцидол");
                ref.child("Inventory").child(idUser).child("tabl").child("3").setValue("Виратадин");
                ref.child("Inventory").child(idUser).child("tabl").child("4").setValue("Сомпристин");
                ref.child("Inventory").child(idUser).child("tabl").child("5").setValue("Экстракседин");
                ref.child("Inventory").child(idUser).child("tabl").child("bool1").setValue("false");
                ref.child("Inventory").child(idUser).child("tabl").child("bool2").setValue("false");
                ref.child("Inventory").child(idUser).child("tabl").child("bool3").setValue("false");
                ref.child("Inventory").child(idUser).child("tabl").child("bool4").setValue("false");
                ref.child("Inventory").child(idUser).child("tabl").child("bool5").setValue("false");

                ref.child("Inventory").child(idUser).child("rast").child("1").setValue("Налфентанил");
                ref.child("Inventory").child(idUser).child("rast").child("2").setValue("Салаплермин");
                ref.child("Inventory").child(idUser).child("rast").child("3").setValue("Гадоадан");
                ref.child("Inventory").child(idUser).child("rast").child("4").setValue("Болпрофен");
                ref.child("Inventory").child(idUser).child("rast").child("5").setValue("Фиргоарел");
                ref.child("Inventory").child(idUser).child("rast").child("bool1").setValue("false");
                ref.child("Inventory").child(idUser).child("rast").child("bool2").setValue("false");
                ref.child("Inventory").child(idUser).child("rast").child("bool3").setValue("false");
                ref.child("Inventory").child(idUser).child("rast").child("bool4").setValue("false");
                ref.child("Inventory").child(idUser).child("rast").child("bool5").setValue("false");

                ref.child("Inventory").child(idUser).child("maz").child("1").setValue("Пегадол");
                ref.child("Inventory").child(idUser).child("maz").child("2").setValue("Вибрифибан");
                ref.child("Inventory").child(idUser).child("maz").child("3").setValue("Набатант");
                ref.child("Inventory").child(idUser).child("maz").child("4").setValue("Кальцистерид");
                ref.child("Inventory").child(idUser).child("maz").child("5").setValue("Болинакалант");
                ref.child("Inventory").child(idUser).child("maz").child("bool1").setValue("false");
                ref.child("Inventory").child(idUser).child("maz").child("bool2").setValue("false");
                ref.child("Inventory").child(idUser).child("maz").child("bool3").setValue("false");
                ref.child("Inventory").child(idUser).child("maz").child("bool4").setValue("false");
                ref.child("Inventory").child(idUser).child("maz").child("bool5").setValue("false");

                ref.child("Inventory").child(idUser).child("aero").child("1").setValue("Цефтадин");
                ref.child("Inventory").child(idUser).child("aero").child("2").setValue("Вирисалафокон");
                ref.child("Inventory").child(idUser).child("aero").child("3").setValue("Нифуррпароид");
                ref.child("Inventory").child(idUser).child("aero").child("4").setValue("Нифуррпароид");
                ref.child("Inventory").child(idUser).child("aero").child("5").setValue("Лоитиром");
                ref.child("Inventory").child(idUser).child("aero").child("bool1").setValue("false");
                ref.child("Inventory").child(idUser).child("aero").child("bool2").setValue("false");
                ref.child("Inventory").child(idUser).child("aero").child("bool3").setValue("false");
                ref.child("Inventory").child(idUser).child("aero").child("bool4").setValue("false");
                ref.child("Inventory").child(idUser).child("aero").child("bool5").setValue("false");

                ref.child("Inventory").child(idUser).child("havenow").child("1").setValue("empty");
                ref.child("Inventory").child(idUser).child("havenow").child("2").setValue("empty");
                ref.child("Inventory").child(idUser).child("havenow").child("3").setValue("empty");
                ref.child("Inventory").child(idUser).child("havenow").child("4").setValue("empty");
                ref.child("Inventory").child(idUser).child("havenow").child("5").setValue("empty");
                ref.child("Inventory").child(idUser).child("havenow").child("6").setValue("empty");
                ref.child("Inventory").child(idUser).child("havenow").child("7").setValue("empty");
                ref.child("Inventory").child(idUser).child("havenow").child("8").setValue("empty");
                ref.child("Inventory").child(idUser).child("havenow").child("9").setValue("empty");
                ref.child("Inventory").child(idUser).child("havenow").child("10").setValue("empty");
                ref.child("Inventory").child(idUser).child("havenow").child("11").setValue("empty");
                ref.child("Inventory").child(idUser).child("havenow").child("12").setValue("empty");
                ref.child("Inventory").child(idUser).child("havenow").child("13").setValue("empty");
                ref.child("Inventory").child(idUser).child("havenow").child("14").setValue("empty");
                ref.child("Inventory").child(idUser).child("havenow").child("15").setValue("empty");
                ref.child("Inventory").child(idUser).child("havenow").child("16").setValue("empty");
                ref.child("Inventory").child(idUser).child("havenow").child("17").setValue("empty");
                ref.child("Inventory").child(idUser).child("havenow").child("18").setValue("empty");
                ref.child("Inventory").child(idUser).child("havenow").child("19").setValue("empty");
                ref.child("Inventory").child(idUser).child("havenow").child("20").setValue("empty");

                ref.child("Wards").child(idUser).child("wardvip").child("name").setValue("Русанов Александр");
                ref.child("Wards").child(idUser).child("wardvip").child("gender").setValue("мужской");
                ref.child("Wards").child(idUser).child("wardvip").child("adress").setValue("проспект Гусева, д.16. кв.3");
                ref.child("Wards").child(idUser).child("wardvip").child("symp").setValue("головная боль, тошнота");
                ref.child("Wards").child(idUser).child("wardvip").child("diag").setValue("неизвестен");
                ref.child("Wards").child(idUser).child("wardvip").child("vrach").setValue("неизвестен");
                ref.child("Wards").child(idUser).child("wardvip").child("hp").setValue(70);
                ref.child("Wards").child(idUser).child("wardvip").child("bool").setValue("false");
                ref.child("Wards").child(idUser).child("wardvip").child("image").setValue("https://firebasestorage.googleapis.com/v0/b/medicine-3d5bc.appspot.com/o/male3.png?alt=media&token=7163c964-84c7-41a1-aa22-e0c5063d883d");
                ref.child("Wards").child(idUser).child("wardvip").child("id").setValue("105");

                ref.child("Wards").child(idUser).child("ward1bed1").child("name").setValue("Иванов Тимофей");
                ref.child("Wards").child(idUser).child("ward1bed1").child("gender").setValue("мужской");
                ref.child("Wards").child(idUser).child("ward1bed1").child("adress").setValue("улица Тихонова, д.1");
                ref.child("Wards").child(idUser).child("ward1bed1").child("symp").setValue("слабость мышц");
                ref.child("Wards").child(idUser).child("ward1bed1").child("diag").setValue("Ревонз");
                ref.child("Wards").child(idUser).child("ward1bed1").child("vrach").setValue("Ревонз");
                ref.child("Wards").child(idUser).child("ward1bed1").child("hp").setValue(80);
                ref.child("Wards").child(idUser).child("ward1bed1").child("bool").setValue("false");
                ref.child("Wards").child(idUser).child("ward1bed1").child("image").setValue("https://firebasestorage.googleapis.com/v0/b/medicine-3d5bc.appspot.com/o/male1.png?alt=media&token=649768c2-9615-49ae-956e-d88bd5ac7ec2");
                ref.child("Wards").child(idUser).child("ward1bed1").child("id").setValue("106");

                ref.child("Wards").child(idUser).child("ward1bed2").child("name").setValue("empty");
                ref.child("Wards").child(idUser).child("ward1bed2").child("gender").setValue("empty");
                ref.child("Wards").child(idUser).child("ward1bed2").child("adress").setValue("empty");
                ref.child("Wards").child(idUser).child("ward1bed2").child("symp").setValue("empty");
                ref.child("Wards").child(idUser).child("ward1bed2").child("diag").setValue("empty");
                ref.child("Wards").child(idUser).child("ward1bed2").child("vrach").setValue("empty");
                ref.child("Wards").child(idUser).child("ward1bed2").child("hp").setValue(100);
                ref.child("Wards").child(idUser).child("ward1bed2").child("bool").setValue("false");
                ref.child("Wards").child(idUser).child("ward1bed2").child("image").setValue("out");
                ref.child("Wards").child(idUser).child("ward1bed2").child("id").setValue("empty");

                ref.child("Wards").child(idUser).child("ward1bed3").child("name").setValue("Волкова Серафима");
                ref.child("Wards").child(idUser).child("ward1bed3").child("gender").setValue("женский");
                ref.child("Wards").child(idUser).child("ward1bed3").child("adress").setValue("улица Мира, д.14, кв.6");
                ref.child("Wards").child(idUser).child("ward1bed3").child("symp").setValue("прерывистое дыхание, судороги");
                ref.child("Wards").child(idUser).child("ward1bed3").child("diag").setValue("Хлот");
                ref.child("Wards").child(idUser).child("ward1bed3").child("vrach").setValue("Хлот");
                ref.child("Wards").child(idUser).child("ward1bed3").child("hp").setValue(60);
                ref.child("Wards").child(idUser).child("ward1bed3").child("bool").setValue("false");
                ref.child("Wards").child(idUser).child("ward1bed3").child("image").setValue("https://firebasestorage.googleapis.com/v0/b/medicine-3d5bc.appspot.com/o/female3.png?alt=media&token=262d6b6e-fcbf-43f7-80d9-a4073838ae7f");
                ref.child("Wards").child(idUser).child("ward1bed3").child("id").setValue("107");

                ref.child("Wards").child(idUser).child("ward2bed1").child("name").setValue("empty");
                ref.child("Wards").child(idUser).child("ward2bed1").child("gender").setValue("empty");
                ref.child("Wards").child(idUser).child("ward2bed1").child("adress").setValue("empty");
                ref.child("Wards").child(idUser).child("ward2bed1").child("symp").setValue("empty");
                ref.child("Wards").child(idUser).child("ward2bed1").child("diag").setValue("empty");
                ref.child("Wards").child(idUser).child("ward2bed1").child("vrach").setValue("empty");
                ref.child("Wards").child(idUser).child("ward2bed1").child("hp").setValue(100);
                ref.child("Wards").child(idUser).child("ward2bed1").child("bool").setValue("false");
                ref.child("Wards").child(idUser).child("ward2bed1").child("image").setValue("out");
                ref.child("Wards").child(idUser).child("ward2bed1").child("id").setValue("empty");

                ref.child("Wards").child(idUser).child("ward2bed2").child("name").setValue("empty");
                ref.child("Wards").child(idUser).child("ward2bed2").child("gender").setValue("empty");
                ref.child("Wards").child(idUser).child("ward2bed2").child("adress").setValue("empty");
                ref.child("Wards").child(idUser).child("ward2bed2").child("symp").setValue("empty");
                ref.child("Wards").child(idUser).child("ward2bed2").child("diag").setValue("empty");
                ref.child("Wards").child(idUser).child("ward2bed2").child("vrach").setValue("empty");
                ref.child("Wards").child(idUser).child("ward2bed2").child("hp").setValue(100);
                ref.child("Wards").child(idUser).child("ward2bed2").child("bool").setValue("false");
                ref.child("Wards").child(idUser).child("ward2bed2").child("image").setValue("out");
                ref.child("Wards").child(idUser).child("ward2bed2").child("id").setValue("empty");

                ref.child("Wards").child(idUser).child("ward2bed3").child("name").setValue("empty");
                ref.child("Wards").child(idUser).child("ward2bed3").child("gender").setValue("empty");
                ref.child("Wards").child(idUser).child("ward2bed3").child("adress").setValue("empty");
                ref.child("Wards").child(idUser).child("ward2bed3").child("symp").setValue("empty");
                ref.child("Wards").child(idUser).child("ward2bed3").child("diag").setValue("empty");
                ref.child("Wards").child(idUser).child("ward2bed3").child("vrach").setValue("empty");
                ref.child("Wards").child(idUser).child("ward2bed3").child("hp").setValue(100);
                ref.child("Wards").child(idUser).child("ward2bed3").child("bool").setValue("false");
                ref.child("Wards").child(idUser).child("ward2bed3").child("image").setValue("out");
                ref.child("Wards").child(idUser).child("ward2bed3").child("id").setValue("empty");

                Toast.makeText(Menu.this, "Игра сброшена", Toast.LENGTH_SHORT).show();
            }
        });
        bOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Menu.this, RegOrSign.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
    }
}