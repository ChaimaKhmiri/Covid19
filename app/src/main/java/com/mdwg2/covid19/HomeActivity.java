package com.mdwg2.covid19;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import javax.swing.text.html.ImageView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
       Button button1;
       public void onClickImage(View view){
           ImageView ImageView = (javax.swing.text.html.ImageView) findViewById(R.id.virus);
           ImageView.animate().alpha(0.4f).setDuration(2000);
           //ImageView.animate().translationX(1000).setDuration(2000);
           ImageView.animate().scaleX(5).setDuration(2000);
           // ImageView.animate().rotation(360).setDuration(2000);
       }


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
               Intent Start = new Intent(this, ConnexionActivity.class);
               startActivity(Start);
           }

       }
   }












