package com.mdwg2.covid19;

public class MainSondage {package com.mdwg2.covid19;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


    public class MainSondage<button> extends AppCompatActivity implements View.OnClickListener   {
        Button button;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            button = findViewById(R.id.bouton);
            button.setOnClickListener(this);


        }

        public void onClick(View v) {
            if (v.getId() == R.id.bouton) {
                Toast.makeText(getApplicationContext(), "start now", Toast.LENGTH_SHORT).show();
                Intent Survey = new Intent(this, act_connexion1.Class);
                startActivity(Survey);
            }
        }
    }
}
