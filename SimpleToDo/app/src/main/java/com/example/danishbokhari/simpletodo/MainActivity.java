package com.example.danishbokhari.simpletodo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView itemList;

    public void addItem(View v){
        EditText text = (EditText) findViewById(R.id.addNote);
        String itemText = text.getText().toString();
        itemsAdapter.add(itemText);
        text.setText("");
        writeToFile();
        Toast.makeText(getApplicationContext(), "Item added to the list", Toast.LENGTH_SHORT);
    }

    private File getDataFile(){
        return new File(getFilesDir(), "toDo.txt");
    }

    private void readToFile(){
        try {
            items = new ArrayList<>(FileUtils.readLines(getDataFile(), Charset.defaultCharset()));
        } catch(IOException e){
            Log.i("MainActivity", "Error reading files", e);
            items = new ArrayList<>();
        }
    }

    private void writeToFile(){
        try {
            FileUtils.writeLines(getDataFile(), items);
        }catch(IOException e){
            Log.i("MainActivity", "Error writing to non-existing files", e);
        }
    }

    public void viewListener(){

        itemList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long l) {
                final int itemToDelete = pos;
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete this note?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                items.remove(itemToDelete);
                                itemsAdapter.notifyDataSetChanged();
                                writeToFile();
                            }
                        }).show();
                return true;
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readToFile();
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        itemList = (ListView) findViewById(R.id.itemList);
        itemList.setAdapter(itemsAdapter);
        viewListener();
    }

}
