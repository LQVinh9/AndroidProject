package com.example.listviewandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.mylistview);

        String[] arWords = new String[] {
                "Phần Tử 1", "Phần Tử 2", "Phần Tử 3", "Phần Tử 4",
                "Phần Tử 5", "Phần Tử 6", "Phần Tử 7",
                "Phần Tử 8", "Phần Tử 9", "Phần Tử 10", "Phần Tử 11",
                "Phần Tử 12", "Phần Tử 13", "Phần Tử 14",
                "Phần Tử 15", "Phần Tử 16", "Phần Tử 17", "Phần Tử 18",
                "Phần Tử 19", "Phần Tử 20", "Phần Tử 21",
                "Phần Tử 22", "Phần Tử 23", "Phần Tử 24", "Phần Tử 25"};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arWords);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,"Click: " + selectedItem+", position: "+position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}