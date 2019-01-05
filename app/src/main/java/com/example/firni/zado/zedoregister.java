package com.example.firni.zado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class zedoregister extends AppCompatActivity {

    Adatbazis db;
    EditText Nev,Jelszo,JelszoIsm;
    Button Reg,Vissza,Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zedoregister);
        init();
        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nev = Nev.getText().toString();
                String jelszo = Jelszo .getText().toString();
                String jelszoIsm = JelszoIsm.getText().toString();

                if(nev.equals("") || jelszo.equals("") || jelszoIsm.equals("")) {

                Toast.makeText(getApplicationContext(),"Üres mező",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(jelszo.equals(jelszoIsm)){
                        Boolean ellenorzes = db.ellenorzes(nev);
                        if(ellenorzes == true) {
                            Boolean beolvas = db.beolvas(nev,jelszo);
                            if(beolvas == true){

                                Toast.makeText(getApplicationContext(),"Sikeres regisztráció!",Toast.LENGTH_SHORT).show();
                                }
                            }

                        else {
                            Toast.makeText(getApplicationContext(),"A felhasználó név már foglalt!",Toast.LENGTH_SHORT).show();
                        }

                    }

                    else {
                        Toast.makeText(getApplicationContext(), "Jelszó nem egyezik",Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(zedoregister.this,zadologin.class);
                startActivity(intent);
                finish();
            }
        });
        Vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(zedoregister.this, zedomenu.class);
                startActivity(intent);
                finish();
            }
        });



    }














public void init(){
        Nev = (EditText) findViewById(R.id.edit_nev);
        Jelszo = (EditText) findViewById(R.id.edit_jelszo);
        JelszoIsm = (EditText) findViewById(R.id.edit_jelszoIsm);
        db = new Adatbazis(this);
        Reg = (Button) findViewById(R.id.btn_regisztracio);
        Vissza = (Button)findViewById(R.id.btn_vissza);
        Login =(Button) findViewById(R.id.btn_login);
}

}
