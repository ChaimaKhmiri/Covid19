package com.mdwg2.covid19;

import androidx.appcompat.app.AppCompatActivity;

import java.awt.Button;
import android.content.Intent;
import android.widget.Toast;
import android.view.View;
import android.os.Bundle;

import javax.swing.text.View;

public class QuestioningActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questioning);
        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (v.getId() == R.id.button) {
                    Toast.makeText(getApplicationContext(), "you clicked the Next button", Toast.LENGTH_SHORT).show();
                    Intent survey = new Intent(this, activity_sondage_main.Class);
                    startActivity(survey);

                }}
        });}}