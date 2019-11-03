package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        editText.setText(preferences.getString("text",""));
    }


    public void Save(View view){
        switch (view.getId()){
            case R.id.button:
                SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor objEditor = preferences.edit();
                objEditor.putString("text",editText.getText().toString());
                objEditor.commit();

                break;
            case R.id.button2:
                Intent miIntent=null;
                Toast.makeText(getApplicationContext(),"Entrando a activity 2",Toast.LENGTH_SHORT).show();
                miIntent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(miIntent);
                break;
            case R.id.button3:
                finish();
                break;

            default:
                break;
        }


    }
}
