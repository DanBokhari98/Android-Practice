package com.example.danish.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;

    public void makeToast(String string){
        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
    }

    public void guess(View view){
        EditText guessEditText = (EditText)findViewById(R.id.guessEditText);
        Integer guessInt = Integer.parseInt(guessEditText.getText().toString());
        if(guessInt > randomNumber){
          makeToast("Lower");
        }else if(guessInt < randomNumber){
            makeToast("Higher");
        } else if(guessInt == randomNumber) {
            makeToast("Correct! Creating new number");
            Random r = new Random();
            randomNumber = r.nextInt(20) + 1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Random r = new Random();
        randomNumber = r.nextInt(20) + 1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
