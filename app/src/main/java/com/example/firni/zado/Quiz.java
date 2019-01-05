package com.example.firni.zado;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Quiz extends AppCompatActivity {

    Button valasz1,valasz2,valasz3,valasz4;

    TextView pont,kerdes;

    private Kerdesek kKerdesek = new Kerdesek();

    public String kValaszok;
    public int Pontok;
    private int kKerdesekLenght = kKerdesek.kKerdesek.length;

    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        r = new Random();

        valasz1 = (Button) findViewById(R.id.valasz1);
        valasz2 = (Button) findViewById(R.id.valasz2);
        valasz3 = (Button) findViewById(R.id.valasz3);
        valasz4 = (Button) findViewById(R.id.valasz4);

        pont = (TextView) findViewById(R.id.pont);
        kerdes = (TextView) findViewById(R.id.kerdes);

        pont.setText("Pontok: " + Pontok);

        updateKerdes(r.nextInt(kKerdesekLenght));

        valasz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valasz1.getText() == kValaszok){
                    Pontok++;
                    pont.setText("Pontok: " + Pontok);
                    updateKerdes(r.nextInt(kKerdesekLenght));
                }else {
                    JatekVege();
                }
            }
        });
        valasz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valasz2.getText() == kValaszok){
                    Pontok++;
                    pont.setText("Pontok: " + Pontok);
                    updateKerdes(r.nextInt(kKerdesekLenght));
                }else {
                    JatekVege();
                }
            }
        });
        valasz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valasz3.getText() == kValaszok){
                    Pontok++;
                    pont.setText("Pontok: " + Pontok);
                    updateKerdes(r.nextInt(kKerdesekLenght));
                }else {
                    JatekVege();
                }
            }
        });
        valasz4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valasz4.getText() == kValaszok){
                    Pontok++;
                    pont.setText("Pontok: " + Pontok);
                    updateKerdes(r.nextInt(kKerdesekLenght));
                }else {
                    JatekVege();
                }
            }
        });
    }
    private void updateKerdes(int szam){
        kerdes.setText(kKerdesek.getKerdes(szam));

        valasz1.setText(kKerdesek.getValasz1(szam));
        valasz2.setText(kKerdesek.getValasz2(szam));
        valasz3.setText(kKerdesek.getValasz3(szam));
        valasz4.setText(kKerdesek.getValasz4(szam));

        kValaszok  = kKerdesek.getHelyesValasz(szam);

    }

    private void  JatekVege() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Quiz.this);
        alertDialogBuilder
                .setMessage("Vesztettél!  Elért pontszám : " + Pontok)
                .setCancelable(false)
                .setPositiveButton("Új játék!",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), Quiz.class));
                            }
                        })
                .setNegativeButton("Vissza  a menübe!",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), zadojatekvalaszto.class));
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
