package com.ceniza.listviewapp;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private EditText inputEditText;
    private Button addButton;
    private CustomAdapter adapter;
    private List<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.itemListView);
        inputEditText = findViewById(R.id.inputEditText);
        addButton = findViewById(R.id.addButton);
        itemList = new ArrayList<>();

        adapter = new CustomAdapter(this, itemList);
        listView.setAdapter(adapter);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });
    }

    private void addItem() {
        String newItem = inputEditText.getText().toString().trim();
        if (!newItem.isEmpty()) {
            itemList.add(newItem);
            adapter.notifyDataSetChanged();
            inputEditText.setText("");
        }
    }
}