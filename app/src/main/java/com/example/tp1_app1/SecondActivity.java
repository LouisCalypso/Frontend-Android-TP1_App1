package com.example.tp1_app1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Categorie";
    private LinearLayout refLayoutBody;
    private String pseudo = "";
    int idBtn1 = View.generateViewId();
    int idBtn2 = View.generateViewId();
    int idBtn3 = View.generateViewId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle b = this.getIntent().getExtras();
        pseudo = b.getString("pseudo");
        alerter("Pseudo saisi : " + pseudo);



        refLayoutBody = findViewById(R.id.layoutBody);

        // Création d'un bouton et paramètrage
        Button btnRechercheWeb = new Button(this);
        btnRechercheWeb.setText("Rechercher " + pseudo);
        btnRechercheWeb.setId(idBtn1);
        btnRechercheWeb.setOnClickListener(this);

        // Création d'un bouton et paramètrage
        Button btnSMS = new Button(this);
        btnSMS.setText("SMS");
        btnSMS.setId(idBtn2);
        btnSMS.setOnClickListener(this);

        // Création d'un bouton et paramètrage
        Button btnDial = new Button(this);
        btnDial.setText("Dial");
        btnDial.setId(idBtn3);
        btnDial.setOnClickListener(this);

        // Insérer le Bouton dans le layout
        refLayoutBody.addView(btnRechercheWeb);
        refLayoutBody.addView(btnSMS);
        refLayoutBody.addView(btnDial);

    }

    void alerter(String s){
        Log.i(TAG,s);
        Toast t = Toast.makeText(this,s,Toast.LENGTH_LONG);
        t.show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == idBtn1){
            alerter("Bouton 1");
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, pseudo);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
        else if (v.getId() == idBtn2){
            alerter("Bouton 2");
            Intent intent = new Intent(Intent.ACTION_SEND);
            String phoneNumber = "0695240526";
            intent.setData(Uri.parse("smsto:" + phoneNumber));
            // This ensures only SMS apps respond
            intent.putExtra("sms_body", "Pseudo saisi : " + pseudo);
            // intent.putExtra(Intent.EXTRA_STREAM, attachment);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }
        else if (v.getId() == idBtn3){
            alerter("Bouton 3");
            Intent intent = new Intent(Intent.ACTION_DIAL);
            String phoneNumber = "0695240526";
            intent.setData(Uri.parse("tel:" + phoneNumber));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }
;    }
}
