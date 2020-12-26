package com.mdw31g5.covid19;


import androidx.appcompat.app.AppCompatActivity;

import java.awt.Button;

import javax.swing.text.View;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class QuizActivity extends AppCompatActivity implements View.OnClickListener  {
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.bouton);
        b.setOnClickListener(this);
    }
    public void onClick(View v) {
        if (v.getId() == R.id.bouton) {
            Toast.makeText(getApplicationContext(), "vous avez cliquer sur le bouton Suivant", Toast.LENGTH_SHORT).show();
            Intent sondage = new Intent(this, activity_sondage_main.Class);
            startActivity(sondage);
        }
    }
}