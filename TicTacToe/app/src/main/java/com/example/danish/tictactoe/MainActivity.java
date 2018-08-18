package com.example.danish.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void dropIn(View view){
        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1000f);

        counter.setImageResource(R.drawable.x);
        counter.animate().translationYBy(1000f).rotation(360).setDuration(500);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(android.R.menu.menu_main, menu);
//        return true;
//    }

}


