package com.mdwg2.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.os.Bundle;



public class QuestioningActivity extends AppCompatActivity {
    final String EXTRA_LOGIN ="login";
    final String EXTRA_PASSWORD="password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_connexion1);
        Intent home =getIntent();
        TextView login=findViewById(R.id.user_email);
        TextView password=findViewById(R.id.user_password);
        if (home !=null){
            login.setText(home.getStringExtra(EXTRA_LOGIN));
            password.setText(home.getStringExtra(EXTRA_PASSWORD));
        }
        setContentView(R.layout.activity_questioning);
         Button button = findViewById(R.id.bottom);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (v.getId() == R.id.button) {
                    Toast.makeText(getApplicationContext(), "you clicked the Next button", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),SurveyActivity.class);
                    startActivity(intent);


                }}
        });}}