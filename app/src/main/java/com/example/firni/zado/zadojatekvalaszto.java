package com.example.firni.zado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class zadojatekvalaszto extends AppCompatActivity {
Button quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zadojatekvalaszto);
        quiz = (Button) findViewById(R.id.Quiz_button);

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Quiz = new Intent(zadojatekvalaszto.this, Quiz.class);
                startActivity(Quiz);
                finish();
            }
        });
    }
}
