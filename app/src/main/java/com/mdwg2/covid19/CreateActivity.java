package com.mdwg2.covid19;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;




public class CreateActivity extends AppCompatActivity implements View.OnClickListener {
    Button my_button;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        my_button = findViewById(R.id.my_button);
        my_button.setOnClickListener(this);
    }


    public void onClick (View v){
        if (v.getId() == R.id.my_button ) {
            Toast.makeText(getApplicationContext(), "You clicked on the save button", Toast.LENGTH_SHORT).show();
            Intent create = new Intent(this, activity_questioning.Class);
            startActivity(create);
        }
    }
}







