package com.example.firni.zado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class zadologin extends AppCompatActivity {
Button btn_login,btn_vissza;
EditText Nev,Jelszo;
Adatbazis db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zadologin);
        btn_login = (Button) findViewById(R.id.Button_login);
        btn_vissza = (Button) findViewById(R.id.Button_back);
        Nev = (EditText) findViewById(R.id.Login_edit_nev);
        Jelszo = (EditText) findViewById(R.id.Login_edit_jelszo);

        db = new Adatbazis(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nev = Nev.getText().toString();
                String jelszo = Jelszo.getText().toString();
                Boolean adatok = db.felhasznaloesjelszo(nev, jelszo);

                if (nev.equals("") || jelszo.equals("")) {

                    Toast.makeText(getApplicationContext(), "Üres mező!", Toast.LENGTH_SHORT).show();
                } else
                    {
                     if (adatok == true) {

                        Toast.makeText(getApplicationContext(), "Sikeres belépés!", Toast.LENGTH_SHORT).show();


                    } else {
                        Toast.makeText(getApplicationContext(), "Rossz felhasználó vagy jelszó!", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        btn_vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(zadologin.this, zedomenu.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
