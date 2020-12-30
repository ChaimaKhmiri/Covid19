package com.mdwg2.covid19;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConnexionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView title = findViewById(R.id.toolbar_title);
        Button B = findViewById(R.id.connexion);
        Button B1 = findViewById(R.id.create);

//buton du connexion
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(ConnexionActivity.this, "connexion", Toast.LENGTH_SHORT).show();
                //Intent explicite pour passer a l'activité home
                Intent home =new Intent(getApplicationContext(),HomeActivity.class);




                startActivity(home);

            }
        });
        //buton create
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ConnexionActivity.this, "create", Toast.LENGTH_SHORT).show();
                //Intent pour passer a l'activite create
                Intent create=new Intent(getApplicationContext(),CreateActivity.class);
                startActivity(create);



            }
        });


    }
}
