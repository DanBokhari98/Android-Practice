package com.example.danish.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void logIn(View view){
        EditText userName =  (EditText)findViewById(R.id.userName);
        //Create variable type EditText assign value, cast EditText to findViewByID then Use R for resources, by ID then name of textfield.
        EditText Password = (EditText)findViewById(R.id.Password);

        Log.i("Username", userName.getText().toString());
        Log.i("Password", Password.getText().toString());
        Toast.makeText(this, "Hi " + userName.getText().toString() + "!", Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
