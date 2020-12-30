package com.mdwg2.covid19;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ConnexionActivity extends AppCompatActivity {

    final String EXTRA_LOGIN ="login";
    final String EXTRA_PASSWORD="password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button B = findViewById(R.id.connexion);
        Button B1 = findViewById(R.id.create);
         final EditText login=findViewById(R.id.user_email);
         final EditText password=findViewById(R.id.user_password);
//buton du connexion
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final String loginTxt= login.getText().toString();
              final   String passTxt=password.getText().toString();
                // On vérifie que le login et le mot de passe ne sont pas vides
                if(loginTxt.equals(" ") || passTxt.equals(" ")){
                    Toast.makeText(ConnexionActivity. this , "l'adresse email et le mot de passe sont obligatoire",
                            Toast . LENGTH_SHORT ) . show();
                    return;
                }
                //On declare le pattern que l'on doit vérifier
                Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                //on declare un matcher , qui  comparera le pattern avec la string passée en argument
                Matcher m=p.matcher(loginTxt);
                // Si l’adresse mail saisie ne correspond pas au format d’une adresse mail,
                // on affiche un message à l'utilisateur
                if (!m.matches()){
                    Toast.makeText(ConnexionActivity.this,"le champ email ne corespnd pas a une adresse ",Toast.LENGTH_SHORT).show();
                    return;
                }





                Toast.makeText(ConnexionActivity.this, "connexion", Toast.LENGTH_SHORT).show();
                //Intent explicite pour passer a l'activité home
                Intent intent =new Intent(getApplicationContext(),QuestioningActivity.class);
                intent.putExtra(EXTRA_LOGIN,loginTxt);
                intent.putExtra(EXTRA_PASSWORD,passTxt);
                startActivity(intent);

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
