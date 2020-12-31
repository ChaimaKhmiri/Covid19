package com.mdwg2.covid19;


import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.CheckBox;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;

import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ConnexionActivity extends AppCompatActivity {
    EditText loginTxt, passTxt;
    Button B, B1;

    final String EXTRA_LOGIN = "login";
    final String EXTRA_PASSWORD = "password";
    CheckBox mcheckbox;
    SharedPreferences Preferences;
    SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_connexion1);
        B = findViewById(R.id.connexion);
        B1 = findViewById(R.id.create);
        final EditText login = findViewById(R.id.user_email);
        final EditText password = findViewById(R.id.user_password);
        //preferences
        Preferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = Preferences.edit();
        checkSharedPreferences();
        B.setOnClickListener(new View.OnClickListener() {
                                 public void onClick(View v) {
                                     mEditor.putString(getString(R.string.checkbox), "True");
                                     mEditor.commit();
                                     String login = loginTxt.getText().toString();
                                     mEditor.putString(getString(R.string.your_email), login);
                                     mEditor.commit();
                                     String password = passTxt.getText().toString();
                                     mEditor.putString(getString(R.string.your_password), password);
                                     mEditor.commit();

                                 }else

                                 {
                                     mEditor.putString(getString(R.string.checkbox), "False");
                                     mEditor.commit();

                                     mEditor.putString(getString(R.string.your_email), "");
                                     mEditor.commit();

                                     mEditor.putString(getString(R.string.your_password), "");
                                     mEditor.commit();


                                 }

                             }


//buton du connexion
                B.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String loginTxt = login.getText().toString();
                        final String passTxt = password.getText().toString();
                        // On vérifie que le login et le mot de passe ne sont pas vides
                        if (loginTxt.equals(" ") || passTxt.equals(" ")) {
                            Toast.makeText(ConnexionActivity.this, "l'adresse email et le mot de passe sont obligatoire",
                                    Toast.LENGTH_SHORT).show();
                            return;
                        }
                        //On declare le pattern que l'on doit vérifier
                        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                        //on declare un matcher , qui  comparera le pattern avec la string passée en argument
                        Matcher m = p.matcher(loginTxt);
                        // Si l’adresse mail saisie ne correspond pas au format d’une adresse mail,
                        // on affiche un message à l'utilisateur
                        if (!m.matches()) {
                            Toast.makeText(ConnexionActivity.this, "le champ email ne corespnd pas a une adresse ", Toast.LENGTH_SHORT).show();
                            return;
                        }


                        Toast.makeText(ConnexionActivity.this, "connexion", Toast.LENGTH_SHORT).show();
                        //Intent explicite pour passer a l'activité home
                        Intent intent = new Intent(getApplicationContext(), QuestioningActivity.class);
                        intent.putExtra(EXTRA_LOGIN, loginTxt);
                        intent.putExtra(EXTRA_PASSWORD, passTxt);
                        startActivity(intent);

                    }
                });
        //buton create
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ConnexionActivity.this, "create", Toast.LENGTH_SHORT).show();
                //Intent pour passer a l'activite create
                Intent create = new Intent(getApplicationContext(), CreateActivity.class);
                startActivity(create);


            }
        });


    }

    private void checkSharedPreferences() {
        String checkbox = Preferences.getString(getString(R.string.checkbox), "false");
        String login = Preferences.getString(getString(R.string.your_email), "");
        String password = Preferences.getString(getString(R.string.your_password), "");
        loginTxt.setText(login);
        passTxt.setText(password);
        if (checkbox.equals("True")) {
            mcheckbox.setChecked(true);
        } else {
            mcheckbox.setChecked(false);
        }


    }
}
