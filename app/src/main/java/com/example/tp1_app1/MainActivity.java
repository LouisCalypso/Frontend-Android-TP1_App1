package com.example.tp1_app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Categorie";
    private Button refBtnOK;
    private EditText refEdtPseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"OnCreate");
        refBtnOK = findViewById(R.id.btnOK);
        refEdtPseudo = findViewById(R.id.etdPseudo);

        refBtnOK.setOnClickListener(this);
        refEdtPseudo.setOnClickListener(this);

        /*
        refBtnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerter("Click par écouteur spécifique");
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        // appeler lors du clic sur bouton OK et sur le bouton Edit Text
        String s =refEdtPseudo.getText().toString();
        Bundle b = new Bundle();
        b.putString("pseudo",s);
        switch (v.getId()){
            case R.id.btnOK :
                                alerter("Pseudo = " + b.getString("pseudo"));
                                Intent versSecondAct = new Intent(this,SecondActivity.class);
                                versSecondAct.putExtras(b);
                                startActivity(versSecondAct);
                                break;
            case R.id.etdPseudo :
                                alerter("Click par écouteur générique Edit Text");
                                break;
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"OnStart");
    }

    void alerter(String s){
        Log.i(TAG,s);
        Toast t = Toast.makeText(this,s,Toast.LENGTH_LONG);
        t.show();
    }

    //useless elle n'est plus appelé, remplacé par l'écouteur
    public void foo(View view) {
        alerter("Click sur OK");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id){
            case R.id.menu_compte : alerter("click sur compte");
                                    break;
            case R.id.menu_pref :   alerter("Click sur préference");
                                    break;
        }

        return super.onOptionsItemSelected(item);
    }


}
