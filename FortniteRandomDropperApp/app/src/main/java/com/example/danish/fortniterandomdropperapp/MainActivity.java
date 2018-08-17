package com.example.danish.fortniterandomdropperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomInt;
    HashMap<Integer, String> map = new HashMap<>();
    public void dropLocation(View view){
//        ImageView image = (ImageView) findViewById(R.id.fortNiteMap);
//        image.setImageResource(R.drawable.fortnitemap);
        TextView dropLoc = (TextView)findViewById(R.id.dropLoc);
        dropLoc.setFocusable(false);
        dropLoc.setText(map.get(randomInt));
//        Toast.makeText(this, map.get(randomInt), Toast.LENGTH_SHORT).show();
        Random r = new Random();
        randomInt = r.nextInt(21) + 1;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        map.put(1, "Junk Junction");
        map.put(2, "Haunted Hills");
        map.put(3, "Anarchy Acres");
        map.put(4, "Risky Reels");
        map.put(5, "Wailing Woods");
        map.put(6, "Lonely Lodge");
        map.put(7, "Retail Row");
        map.put(8, "Moisty Mire");
        map.put(9,"Salty Springs");
        map.put(10, "Fatal Fields");
        map.put(11, "Lucky Landing");
        map.put(12, "Flushing Factory");
        map.put(13, "Shift Shafts");
        map.put(14, "Greacy Grove");
        map.put(15, "Snobby Shores");
        map.put(16, "Pleasent Park");
        map.put(17, "Loot Lake");
        map.put(18, "Shifty Shafts");
        map.put(19, "Fatal Fields");
        map.put(20, "Dusty Divot");
        map.put(21, "Tomato Town");
        Random r = new Random();
        randomInt = r.nextInt(22) + 1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
