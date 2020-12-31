package com.mdwg2.covid19;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class CreateActivity extends AppCompatActivity implements View.OnClickListener {
    Button my_button;
    EditText username, user_last_name, user_email, user_password;
    CheckBox mcheckbox;
    SharedPreferences Preferences;
    SharedPreferences.Editor mEditor;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        my_button = findViewById(R.id.my_button);
        my_button.setOnClickListener(this);

        username = findViewById(R.id.username);
        user_last_name = findViewById(R.id.user_last_name);
        user_email = findViewById(R.id.user_email);
        user_password = findViewById(R.id.user_password);

        Preferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = Preferences.edit();

        checkSharedPreferences();

        my_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mcheckbox.isChecked()) {

                    mEditor.putString(getString(R.string.checkbox), "True");
                    mEditor.commit();

                    String name = username.getText().toString();
                    mEditor.putString(getString(R.string.your_name), name);
                    mEditor.commit();

                    String last_name = user_last_name.getText().toString();
                    mEditor.putString(getString(R.string.your_last_name), last_name);
                    mEditor.commit();

                    String email = user_email.getText().toString();
                    mEditor.putString(getString(R.string.your_email), email);
                    mEditor.commit();

                    String password = user_password.getText().toString();
                    mEditor.putString(getString(R.string.your_password), password);
                    mEditor.commit();


                } else {
                    mEditor.putString(getString(R.string.checkbox), "False");
                    mEditor.commit();


                    mEditor.putString(getString(R.string.your_name), "");
                    mEditor.commit();

                    mEditor.putString(getString(R.string.your_last_name), "");
                    mEditor.commit();

                    mEditor.putString(getString(R.string.your_email), "");
                    mEditor.commit();

                    mEditor.putString(getString(R.string.your_password), "");
                    mEditor.commit();
                }
            }
        });
    }


    private void checkSharedPreferences() {
        String checkbox = Preferences.getString(getString(R.string.checkbox), "false");
        String name = Preferences.getString(getString(R.string.your_name), "");
        String password = Preferences.getString(getString(R.string.your_password), "");
        String last_name = Preferences.getString(getString(R.string.your_last_name), "");
        String email = Preferences.getString(getString(R.string.your_email), "");

        username.setText(name);
        user_last_name.setText(last_name);
        user_email.setText(email);
        user_password.setText(password);


        if (checkbox.equals("True")) {
            mcheckbox.setChecked(true);
        } else {
            mcheckbox.setChecked(false);
        }

    }


    public void onClick(View v) {
        if (v.getId() == R.id.my_button) {
            Toast.makeText(getApplicationContext(), "You clicked on the save button", Toast.LENGTH_SHORT).show();
            Intent create = new Intent(this, HomeActivity.class);
            startActivity(create);
        }


    }
}







