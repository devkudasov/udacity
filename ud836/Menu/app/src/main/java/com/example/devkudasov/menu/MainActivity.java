package com.example.devkudasov.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.devkudasov.menu.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        TextView menuItem1 = findViewById(R.id.menu_item_1);
        Log.i("Menu Item 1", menuItem1.getText().toString());

        TextView menuItem2 = findViewById(R.id.menu_item_2);
        Log.i("Menu Item 2", menuItem2.getText().toString());

        TextView menuItem3 = findViewById(R.id.menu_item_3);
        Log.i("Menu Item 3", menuItem3.getText().toString());
    }
}