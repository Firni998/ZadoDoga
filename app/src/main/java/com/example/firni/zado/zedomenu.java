package com.example.firni.zado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class zedomenu extends AppCompatActivity {

    Button btn_reg,btn_login,btn_exit,btn_quest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_zedomenu);
        btn_reg = (Button) findViewById(R.id.Menu_Register_button);
        btn_login = (Button) findViewById(R.id.Menu_Login_button);
        btn_exit = (Button) findViewById(R.id.Menu_Exit_button);
        btn_quest = (Button) findViewById(R.id.quest_button);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent login = new Intent(zedomenu.this, zadologin.class);
                startActivity(login);
                finish();
            }
        });

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reg = new Intent (zedomenu.this, zedoregister.class);
                startActivity(reg);
                finish();
            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_quest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quest = new Intent(zedomenu.this, zadojatekvalaszto.class);
                startActivity(quest);
                finish();
            }
        });





    }


}
