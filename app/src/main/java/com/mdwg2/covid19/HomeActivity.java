package com.mdwg2.covid19;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button1;
import android.widget.Toast;

   public class HomeActivity extends AppCompatActivity implements View.OnClickListener   {
        Button button1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            button1 = findViewById(R.id.bouton1);
            button1.setOnClickListener(this);


        }

        public void onClick(View v) {
            if (v.getId() == R.id.bouton1) {
                Toast.makeText(getApplicationContext(), "start now", Toast.LENGTH_SHORT).show();
                Intent Start = new Intent(this, act_connexion1.Class);
                startActivity(Start);
            }
        }
    }












