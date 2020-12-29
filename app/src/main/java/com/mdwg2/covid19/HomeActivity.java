package com.mdwg2.covid19;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

   public class HomeActivity extends AppCompatActivity implements View.OnClickListener   {
        Button button1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            button1 = findViewById(R.id.button1);
            button1.setOnClickListener(this);


        }

        public void onClick(View v) {
            if (v.getId() == R.id.button1) {
                Toast.makeText(getApplicationContext(), "start now", Toast.LENGTH_SHORT).show();
                Intent Start = new Intent(this,act_connexion1.Class);
                startActivity(Start);
            }
        }
    }












